package Cargas;

public class Indiferenciada extends Carga implements NaoRefrigerados{
    public Indiferenciada(){
        super();
    }

    public Indiferenciada(double carga, String descricao) {
        super(carga, descricao);
    }
    
    public Indiferenciada(Indiferenciada p){
        super(p);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CARGA INDIFERENCIADA");
        sb.append(super.toString());
        return sb.toString();
    }
    
    @Override
    public Indiferenciada clone(){ return new Indiferenciada(this); }

    @Override
    public boolean eObrigatorio() {
        return false;
    }

}