/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculos;

/**
 *
 * @author Bruno Ferreira
 * @author Daniel Carvalho
 * @author Ricardo Branco
 */
public class Van extends Veiculo{
   
    
    public Van()
    {
        super();
        super.set_Refrigerado(true);
    }
    
    public Van(String marca, String matricula, String gasolina, double autonomia, double custoKm, double carga,boolean refrigerado)
    {
        super(marca,matricula,custoKm,carga);
        super.set_Refrigerado(true);
    }
    
    public Van(Van c)
    {
        super(c);
        super.set_Refrigerado(true);
    }
    
   
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();      
    }
    
    @Override
    public Van clone(){return new Van(this);}
    

    @Override
    public boolean equals(Object o){return super.equals(o);}
    
    @Override
    public int hashCode(){return super.hashCode();}
    
    @Override
    public int compareTo(Veiculo v){return super.compareTo(v);}

    
    
   
    
    
    
    
    
    
    
            
    
    

}
    
    
            
    
    
    
    
   

   