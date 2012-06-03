package Cargas;

import java.io.Serializable;

public abstract class Carga implements Comparable<Carga>,Serializable {
    public static final int REFRIGERACAO_INDIFERENTE = 0;
    public static final int REFRIGERACAO_SIM = 1;
    public static final int REFRIGERACAO_NAO = 2;
    
    private double carga;
    private String descricao;
    
    public Carga(){
        this.carga = 0;
        this.descricao = "";
    }
    
    public Carga(double carga, String descricao){
        this.carga = carga;
        this.descricao = descricao;
    }
    
    public Carga(Carga c){
        this.carga = c.getCarga();
        this.descricao = c.getDescricao();
    }
    
    public double getCarga(){return this.carga;}
    public String getDescricao(){return this.descricao;}
    
    public void setCarga(double carga){this.carga = carga;}
    
    @Override
    public boolean equals(Object o)
    {
        if(o==this)
            return true;
        if((o==null)||(o.getClass() != this.getClass()))
            return false;
        
        Carga c = (Carga) o;
        return c.getCarga() == this.carga;
    }
    
    @Override
    public abstract Carga clone();
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Carga: ").append(this.carga).append("\n");
        return sb.toString();
    }
    
    @Override
    public int hashCode(){ return (int) this.carga;}

    public int compareTo(Carga c){
        Double f1 = new Double(this.carga);
        Double f2 = new Double(c.getCarga());
        if (f1.compareTo(f2)>0) return 1; else return -1;
    }
    
    public boolean tipo( String nomeClasse ){
        return this.getClass().getName().equals("transitarios.Cargas." + nomeClasse);
    }
}