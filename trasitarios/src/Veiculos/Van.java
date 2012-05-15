package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;

public class Van extends Veiculo{
    public Van(){
        super();
    }
    
    public Van(String marca, String matricula, double custoKm, double desgaste, double carga){
        super(marca,matricula,custoKm,desgaste,carga, true);
    }
    
    public Van(String marca, String matricula, double custoKm, double desgaste, double carga, ArrayList<Carga> mercadoria){
        super(marca,matricula,custoKm,desgaste,carga, true, mercadoria);
    }
    
    public Van(Van c){
        super(c);
    }
    
    @Override
    public Van clone(){ return new Van(this); }
    
    @Override
    public int compareTo(Veiculo v){ return super.compareTo(v); }
}
