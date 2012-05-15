package Cargas;

public class Perecivel extends Carga{
    
    
    public Perecivel()
    {
        super();
    }
    
    public Perecivel(double carga, boolean refrigerada)
    {
        super(carga);
    }
    
    public Perecivel(Perecivel p)
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
    public Perecivel clone(){return new Perecivel(this);}
    
    
    
    
    
}
