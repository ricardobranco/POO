
package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;




public class NRFurgao extends Furgao{
    
    public NRFurgao()
    {
        super();
    }
    
    public NRFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double carga){
        super(marca, matricula, combustivel, autonomia, custoKm, carga);
    }
    
    public NRFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double carga, double total, ArrayList<Carga> mercadoria){
        super(marca, matricula, combustivel, autonomia, custoKm,carga,total,mercadoria);
    }
    
    public NRFurgao(Furgao c){
        super(c);
    }

    @Override
    public NRFurgao clone() {return new NRFurgao(this);}
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("NÃO REFRIGERADO\n");
        return sb.toString();
        
    }
    
    
}
