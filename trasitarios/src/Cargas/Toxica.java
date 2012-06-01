package Cargas;

import java.io.Serializable;

public class Toxica extends Carga implements NaoRefrigerados, Serializable{
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
    public boolean eObrigatorio() {
        return true;
    }
}