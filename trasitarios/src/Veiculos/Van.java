package Veiculos;

import Cargas.Carga;
import java.io.Serializable;
import java.util.ArrayList;

public class Van extends Veiculo implements Refrigeravel,Serializable{
    
    //Variaveis de Classe
    private static double pbase = 28;
    
    
    
    //Construtores
    public Van(){
        super();
    }
    
    public Van(String marca, String matricula, double custoKm, double carga){
        super(marca,matricula,custoKm,carga);
    }
    
    public Van(String marca, String matricula, double custoKm, double carga, double total,ArrayList<Carga> mercadoria){
        super(marca,matricula,custoKm,carga,total,mercadoria);
    }
    
    public Van(Van c){
        super(c);
    }
    
    //Metodos de Classe
    public static double getPBase(){return Van.pbase;}
    public static void setPBase(double pbase){Van.pbase = pbase;}
    
    
    //Metodos de instancia
    
    
    @Override
    public Van clone(){ return new Van(this); }
    
    @Override
    public int compareTo(Veiculo v){ return super.compareTo(v); }
    
    @Override
    public double preco(){return getPBase();}
    
     @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("REFRIGERADO\n");
        return sb.toString();
    }
    
}

