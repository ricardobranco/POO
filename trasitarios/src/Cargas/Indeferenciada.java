/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cargas;

/**
 *
 * @author Ricardo Branco
 */
public class Indeferenciada extends Carga{
    
    
    public Indeferenciada()
    {
        super();
    }
    
    public Indeferenciada(double carga, boolean refrigerada)
    {
        super(carga);
    }
    
    public Indeferenciada(Indeferenciada p)
    {
        super(p);
    }

    
    @Override
    public double get_Carga(){return super.get_Carga();}
    
    
    @Override
    public void set_Carga(double carga){super.set_Carga(carga);}
    
    @Override
    public boolean equals(Object o){return super.equals(o);}
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("CARGA PERECEVIVEL");
        sb.append(super.toString());
        return sb.toString();
    }
    
    @Override
    public int hashCode(){ return super.hashCode();}

    @Override
    public int compareTo(Carga c){return super.compareTo(c);}
    
    
    @Override
    public Indeferenciada clone(){return new Indeferenciada(this);}
    
    
    
    
    
}
