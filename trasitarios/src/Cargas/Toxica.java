package Cargas;

public class Toxica extends Carga{
    public Toxica(){
        super();
    }

    public Toxica(double carga, String descricao) {
        super(carga, descricao);
    }
    
    public Toxica(Toxica p){
        super(p);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CARGA TÓXICA");
        sb.append(super.toString());
        return sb.toString();
    }
    
    @Override
    public Toxica clone(){return new Toxica(this);}

    @Override
    public int precisaRefrigeracao() {
        return Carga.REFRIGERACAO_NAO;
    }
}