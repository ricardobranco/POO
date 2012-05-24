
package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;




public class NRFurgao extends Furgao{
    
    public NRFurgao()
    {
        super();
    }
    
    public NRFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double desgaste, double carga){
        super(marca, matricula, combustivel, autonomia, custoKm, desgaste, carga);
    }
    
    public NRFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double desgaste, double carga, ArrayList<Carga> mercadoria){
        super(marca, matricula, combustivel, autonomia, custoKm, desgaste,carga,mercadoria);
    }
    
    public NRFurgao(Furgao c){
        super(c);
    }

    @Override
    public NRFurgao clone() {return new NRFurgao(this);} 
    
    
}
