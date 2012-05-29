package Veiculos;

import Cargas.Carga;
import java.io.Serializable;
import java.util.ArrayList;

public class Camiao extends Veiculo implements Serializable{
    
    //Variaveis de Classe
    private static double pbase = 60;
    
    
    //Variaveis de instancia
    private String condutor;
    private boolean atrelado;
    private double altura;
    
    //Construtores
    
    public Camiao(){
        super();
        construtor_auxiliar("", false, 0);
    }
    
    public Camiao(String marca, String matricula, String condutor, double altura, double custoKm, double carga,boolean atrelado){
        super(marca,matricula,custoKm,carga);
        construtor_auxiliar(condutor, atrelado, altura);
    }
    
    public Camiao(String marca, String matricula, String condutor, double altura, double custoKm, double carga,boolean atrelado, double total, ArrayList<Carga> mercadoria){
        super(marca,matricula,custoKm,carga,total, mercadoria);
        construtor_auxiliar(condutor, atrelado, altura);
    }
    
    public Camiao(Camiao c){
        super(c);
        construtor_auxiliar(c.getCondutor(), c.getAtrelado(), c.getAltura());
    }
    
    
    //Metodos de Classe
    public static double getPBase(){return Camiao.pbase;}
    public static void setPBase(double pbase){Camiao.pbase = pbase;}
    
    
    //Metodos de instancia
    private void construtor_auxiliar(String condutor, boolean atrelado, double altura)
    {
        this.condutor = condutor;
        this.atrelado = atrelado;
        this.altura = altura;
    }
    
    public double getAltura(){return this.altura;}
    public boolean getAtrelado(){return this.atrelado;}
    public String getCondutor(){return this.condutor;}
    
    public void setAtrelado(boolean atrelado){this.atrelado = atrelado;}
    public void setCondutor(String condutor){this.condutor = condutor;}
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Condutor: ").append(this.condutor).append("\n");
        sb.append("Atrelado: ").append(this.atrelado).append("\n");
        sb.append("Altura: ").append(this.altura).append("\n");
        sb.append("NÃO REFRIGERADO\n");
        
        return sb.toString();      
    }
    
    @Override
    public Camiao clone(){return new Camiao(this);}
    
    public double preco(){return  (this.getCargaActual() * getPBase() + this.getCapacidade() * (this.getCapacidade()-this.getCargaActual()));}   

}
