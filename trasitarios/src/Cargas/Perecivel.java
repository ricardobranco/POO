package Cargas;

public class Perecivel extends Carga{
    
    
    public Perecivel(){
        super();
    }

    public Perecivel(double carga, String descricao) {
        super(carga, descricao);
    }
    
    public Perecivel(Perecivel p){
        super(p);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CARGA PERECÍVEL");
        sb.append(super.toString());
        return sb.toString();
    }
    
    @Override
    public Perecivel clone(){ return new Perecivel(this); }

    
}