
package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;




public class RFurgao extends Furgao implements Refrigerado{
    
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
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("REFRIGERADO\n");
        return sb.toString();
        
    }
    
}
