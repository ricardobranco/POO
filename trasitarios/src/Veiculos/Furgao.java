/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculos;

import Cargas.*;
import java.util.List;

/**
 *
 * @author Bruno Ferreira
 * @author Daniel Carvalho
 * @author Ricardo Branco
 */
public class Furgao extends Veiculo{
    
    
    private String gasolina;
    private double autonomia;
    
    
    public Furgao()
    {
        super();
        super.set_Refrigerado(false);
        this.gasolina = "";
        this.autonomia = 0;
     }
    
    public Furgao(String marca, String matricula, String gasolina, double autonomia, double custoKm,double carga, boolean refrigerado)
    {
        super(marca,matricula,custoKm,carga);
        super.set_Refrigerado(refrigerado);
        this.gasolina = gasolina;
        this.autonomia = autonomia;
    }
    
   
    
    
    
    public Furgao(Furgao c)
    {
        super(c);
        this.autonomia = c.get_Autonomia();
        this.gasolina = c.get_Gasolina();
    }
    
    public double get_Autonomia(){return this.autonomia;}
    public String get_Gasolina(){return this.gasolina;}
    
    
    
    
    
    
    
    public void set_Alura(double autonomia){this.autonomia = autonomia;}
    public void set_gasolina(String gasolina){this.gasolina = gasolina;}
    
    
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Gasolina ").append(this.gasolina).append("\n");
        sb.append("Autonomia ").append(this.autonomia).append("\n");
        return sb.toString();      
    }
    
    @Override
    public Furgao clone(){return new Furgao(this);}
    

    @Override
    public boolean equals(Object o){return super.equals(o);}
    
    @Override
    public int hashCode(){return super.hashCode();}
    
    @Override
    public int compareTo(Veiculo v){return super.compareTo(v);}

    @Override
     public double totalCarga(){return super.totalCarga();}
    
    @Override
    public boolean mais60(){return super.mais60();}
    
    @Override
    public boolean addCarga(Carga c){return super.addCarga(c);}
    
    
   // public void addCargas(List<Carga> c);

    

}
    
    
            
    
    
    
    
   

   