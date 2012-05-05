/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cargas;

/**
 *
 * @author Ricardo Branco
 */
public class Toxica extends Carga{
    
    
    public Toxica()
    {
        super();
        super.set_Refrigerada(false);
    }
    
    public Toxica(float carga, boolean refrigerada)
    {
        super(carga);
        super.set_Refrigerada(false);
    }
    
    public Toxica(Toxica p)
    {
        super(p);
        super.set_Refrigerada(false);
        
    }

    
    @Override
    public float get_Carga(){return super.get_Carga();}
    @Override
    public boolean get_Refrigerada(){return super.get_Refrigerada();}
    
    
    @Override
    public void set_Carga(float carga){super.set_Carga(carga);}
    @Override
    public void set_Refrigerada(boolean refrigerada){super.set_Refrigerada(false);}
    
    @Override
    public boolean equals(Object o){return super.equals(o);}
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("CARGA TÓXICA");
        sb.append(super.toString());
        return sb.toString();
    }
    
    @Override
    public int hashCode(){ return super.hashCode();}

    @Override
    public int compareTo(Carga c){return super.compareTo(c);}
    
    
    @Override
    public Toxica clone(){return new Toxica(this);}
    
    
    
    
    
}
