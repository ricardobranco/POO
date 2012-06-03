
package Veiculos;

import Cargas.Carga;
import java.io.Serializable;
import java.util.ArrayList;




public class RFurgao extends Furgao implements Refrigeravel,Serializable{
    
    public RFurgao()
    {
        super();
    }
    
    public RFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double carga){
        super(marca, matricula, combustivel, autonomia, custoKm, carga);
    }
    
    public RFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double carga,double total, ArrayList<Carga> mercadoria){
        super(marca, matricula, combustivel, autonomia, custoKm,carga,total,mercadoria);
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
        
        sb.append("FURGAO\n");
        sb.append(super.toString());
        sb.append("REFRIGERADO\n");
        return sb.toString();
        
    }
    
}
