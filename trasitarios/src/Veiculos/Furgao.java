package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;

public class Furgao extends Veiculo{
    private String combustivel;
    private double autonomia;
    
    private void construtor_auxiliar(String combustivel, double autonomia){
        this.combustivel = combustivel;
        this.autonomia = autonomia;
    }
    
    public Furgao(){
        super();
        construtor_auxiliar("", 0);
    }
    
    public Furgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double desgaste, double carga, boolean refrigerado){
        super(marca,matricula,custoKm,desgaste,carga, refrigerado);
        construtor_auxiliar(combustivel, autonomia);
    }
    
    public Furgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double desgaste, double carga, boolean refrigerado, ArrayList<Carga> mercadoria){
        super(marca,matricula,custoKm,desgaste,carga, refrigerado, mercadoria);
        construtor_auxiliar(combustivel, autonomia);
    }
    
    public Furgao(Furgao c){
        super(c);
        construtor_auxiliar(c.getCombustivel(), c.getAutonomia());
    }
    
    public double getAutonomia(){return this.autonomia;}
    public String getCombustivel(){return this.combustivel;}
    
    public void setAutonomia(double autonomia){this.autonomia = autonomia;}
    public void setCombustivel(String gasolina){this.combustivel = gasolina;}
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Gasolina: ").append(this.combustivel).append("\n");
        sb.append("Autonomia: ").append(this.autonomia).append("\n");
        return sb.toString();      
    }
    
    @Override
    public Furgao clone(){return new Furgao(this);}
}
