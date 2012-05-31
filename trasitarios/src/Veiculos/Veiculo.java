package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class Veiculo implements Comparable<Veiculo>
{
    //Variaveis de instancia
    private String marca;
    private String matricula;
    private double custoKm;
    private double capacidade;
    private boolean parado;
    private double total;
    private List<Carga> mercadoria;
    
    
    //Construtores
    public Veiculo(){
        this.marca = "";
        this.matricula = "";
        this.custoKm = 0;
        this.capacidade = 0;
        this.mercadoria = new ArrayList<Carga>();
        this.parado = true;
        this.total = 0;
    }
    
    public Veiculo(String marca, String matricula, double custoKm, double capacidade){
        this.marca = marca;
        this.matricula = matricula;
        this.custoKm = custoKm;
        this.capacidade = capacidade;
        this.mercadoria = new ArrayList<Carga>();
        this.parado = true;
        this.total = 0;
    }
    
    public Veiculo(String marca, String matricula, double custoKm, double capacidade, double total, ArrayList<Carga> mercadoria){
        this.marca = marca;
        this.matricula = matricula;
        this.custoKm = custoKm;
        this.capacidade = capacidade;
        this.mercadoria = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = mercadoria.iterator(); it.hasNext();) {
            Carga c = it.next();
            this.mercadoria.add(c);
        }
        this.parado = true;
        this.total = total;
    }
    
    public Veiculo(Veiculo v){
        this.marca = v.getMarca();
        this.matricula = v.getMatricula();
        this.custoKm = v.getCustoKm();
        this.capacidade = v.getCapacidade();
        this.mercadoria = new ArrayList<Carga>();
        for (Iterator<Carga> it = v.getMercadoria().iterator(); it.hasNext();) {
            Carga c = it.next();
            this.mercadoria.add(c);
        }
        this.parado = v.getParado();
        this.total = getTotal();
    }
    
    
    //Metodos de instancia
    
    public String getMarca(){return this.marca;}
    public String getMatricula(){return this.matricula;}
    public double getCustoKm(){return this.custoKm;}
    public double getCapacidade(){return this.capacidade;}
    public double getTotal(){return this.total;}
    
    
    public Collection<Carga> getMercadoria(){
        Collection<Carga> res = new ArrayList<Carga>();
        for (Carga c : this.mercadoria)
            res.add(c.clone());
        
        return res;
    }
    
    public boolean getParado(){ return this.parado;}
    public void setParado( boolean valor ){ this.parado = valor; }
    public void setTotal(double total){this.total = total;}
    public void setCustoKm(double custoKm){this.custoKm = custoKm;}
    public void setMercadoria(List<Carga> mercadoria){
        this.mercadoria = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = mercadoria.iterator(); it.hasNext(); ){
            this.mercadoria.add(it.next().clone());
        }
    }
    
    
    public void incTotal(double inc){this.total+=inc;}
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(this.marca).append("\n");
        sb.append("Matricula: ").append(this.matricula).append("\n");
        sb.append("Custo Km: ").append(this.custoKm).append("\n");
        sb.append("Capacidade: ").append(this.capacidade).append("\n");
        return sb.toString();
    }
    
    @Override
    public abstract Veiculo clone(); 
    
    @Override
    public boolean equals(Object o){
      if(this == o)
          return true;
      if((o==null) || !(o instanceof Veiculo))  //INTERESSA NOS COMPARAR OS 2 VEICULOS A NIVEL DA SUPER CLASSE
          return false;
      
      Veiculo v = (Veiculo) o;
      return this.matricula.equals(v.getMatricula());
    }
    
    @Override
    public int hashCode(){ return this.matricula.hashCode(); }
    
    
    public int compareTo(Veiculo v){ return this.matricula.compareTo(v.getMatricula()); }
    
    public double getCargaActual(){
        double res = 0;
        for(Carga c : this.mercadoria)
            res+=c.getCarga();
        return res;
    }
    
    
    public boolean mais60(){return (this.getCargaActual()/this.capacidade) >= 0.6;}  
    
    public boolean addCarga(Carga c){
        return c.getCarga()+this.getCargaActual() <= this.getCapacidade() && this.mercadoria.add(c);
    }
    
    public boolean addCarga(List<Carga> c){
        double cargaTotal = 0;
        for( Carga valor : c )
            cargaTotal += valor.getCarga(); //conta o tamanho total da carga a ser adicionada
        
        if( cargaTotal + this.getCargaActual() <= this.capacidade ){ //verifica se cabe tudo
            for( Carga valor : c )
                this.mercadoria.add(valor); //como a carga cabe toda, mete tudo sem mais verificações
            return true;
        }
        
        return false;
    }
    
    public abstract double preco();
    
    //FALTA METODO QUE ESVAZIA UM VEICULO
    //VAI SER TRATADO QUANDO COMEÇAR A TRABALHAR NO AMBIENTE GRAFICO
    //public void esvazia(List<Carga>)

    }
