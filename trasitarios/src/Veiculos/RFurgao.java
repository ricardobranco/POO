
package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;




public class RFurgao extends Furgao{
    
    public RFurgao()
    {
        super();
    }
    
    public RFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double desgaste, double carga){
        super(marca, matricula, combustivel, autonomia, custoKm, desgaste, carga);
    }
    
    public RFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double desgaste, double carga, ArrayList<Carga> mercadoria){
        super(marca, matricula, combustivel, autonomia, custoKm, desgaste,carga,mercadoria);
    }
    
    public RFurgao(Furgao c){
        super(c);
    }

    @Override
    public RFurgao clone() {return new RFurgao(this);} 
    
    
}
