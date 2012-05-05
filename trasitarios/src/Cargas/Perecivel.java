/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cargas;

/**
 *
 * @author Ricardo Branco
 */
public class Perecivel extends Carga{
    
    
    public Perecivel()
    {
        super();
        super.set_Refrigerada(true);
    }
    
    public Perecivel(float carga, boolean refrigerada)
    {
        super(carga);
        super.set_Refrigerada(true);
    }
    
    public Perecivel(Perecivel p)
    {
        super(p);
        super.set_Refrigerada(true);
        
    }

    
    @Override
    public float get_Carga(){return super.get_Carga();}
    @Override
    public boolean get_Refrigerada(){return super.get_Refrigerada();}
    
    
    @Override
    public void set_Carga(float carga){super.set_Carga(carga);}
    @Override
    public void set_Refrigerada(boolean refrigerada){super.set_Refrigerada(true);}
    
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
    public Perecivel clone(){return new Perecivel(this);}
    
    
    
    
    
}
