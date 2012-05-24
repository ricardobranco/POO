package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Veiculo 
{
    //Variaveis de instancia
    private String marca;
    private String matricula;
    private double custoKm;
    private double desgaste;
    private double capacidade;
    private boolean parado; 
    private List<Carga> mercadoria;
    
    
    //Construtores
    public Veiculo(){
        this.marca = "";
        this.matricula = "";
        this.custoKm = 0;
        this.desgaste = 0;
        this.capacidade = 0;
        this.mercadoria = new ArrayList<Carga>();
        this.parado = true;
    }
    
    public Veiculo(String marca, String matricula, double custoKm, double desgaste, double capacidade){
        this.marca = marca;
        this.matricula = matricula;
        this.custoKm = custoKm;
        this.capacidade = capacidade;
        this.mercadoria = new ArrayList<Carga>();
        this.parado = true;
    }
    
    public Veiculo(String marca, String matricula, double custoKm, double desgaste, double capacidade, ArrayList<Carga> mercadoria){
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
    }
    
    public Veiculo(Veiculo v){
        this.marca = v.getMarca();
        this.matricula = v.getMatricula();
        this.desgaste = v.getDesgaste();
        this.custoKm = v.getCustoKm();
        this.capacidade = v.getCapacidade();
        this.mercadoria = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = v.getMercadoria().iterator(); it.hasNext();) {
            Carga c = it.next();
            this.mercadoria.add(c);
        }
        this.parado = v.getParado();
    }
    
    
    //Metodos de instancia
    
    public String getMarca(){return this.marca;}
    public String getMatricula(){return this.matricula;}
    public double getDesgaste(){return this.desgaste;}
    public double getCustoKm(){return this.custoKm;}
    public double getCapacidade(){return this.capacidade;}
    
    public List<Carga> getMercadoria(){
        List<Carga> res = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = this.mercadoria.iterator(); it.hasNext(); )
            res.add(it.next().clone());
        
        return res;
    }
    
    public boolean getParado(){ return this.parado;}
    public void setParado( boolean valor ){ this.parado = valor; }
    
    public void setCustoKm(double custoKm){this.custoKm = custoKm;}
    public void setDesgaste(double desgaste){this.desgaste = desgaste;}
    public void setMercadoria(List<Carga> mercadoria){
        this.mercadoria = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = mercadoria.iterator(); it.hasNext(); ){
            this.mercadoria.add(it.next().clone());
        }
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(this.marca).append("\n");
        sb.append("Matricula: ").append(this.matricula).append("\n");
        sb.append("Custo Km: ").append(this.custoKm).append("\n");
        sb.append("Desgate: ").append(this.desgaste).append("\n");
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
