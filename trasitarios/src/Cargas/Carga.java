package Cargas;

public abstract class Carga {

    private double carga;
    
    public Carga()
    {
        this.carga = 0;
    }
    
    public Carga(double carga)
    {
        this.carga = carga;
    }
    
    public Carga(Carga c)
    {
        this.carga = c.get_Carga();
    }
    
    
    
    public double get_Carga(){return this.carga;}
    
    public void set_Carga(double carga){this.carga = carga;}
    
    @Override
    public boolean equals(Object o)
    {
        if(o==this)
            return true;
        if((o==null)||(o.getClass() != this.getClass()))
            return false;
        
        Carga c = (Carga) o;
        return c.get_Carga() == this.carga;
    }
    
    @Override
    public abstract Carga clone();
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Carga: ").append(this.carga).append("\n");
        return sb.toString();
    }
    
    @Override
    public int hashCode(){ return (int) this.carga;}

    public int compareTo(Carga c)
    {
        Double f1 = new Double(this.carga);
        Double f2 = new Double(c.get_Carga());
        return f1.compareTo(f2);
    }
    
    
    
    
    
    
    
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    
    
            
    
    
    
    
    
    
    
    
    
}
