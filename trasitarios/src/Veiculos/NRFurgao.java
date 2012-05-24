
package Veiculos;

import Cargas.Carga;
import java.util.ArrayList;




public class NRFurgao {
    
    public NRFurgao()
    {
        super();
    }
    
    public NRFurgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double desgaste, double carga){
        super(marca, matricula, combustivel, autonomia, custoKm, desgaste, carga);
    
    public Furgao(String marca, String matricula, String combustivel, double autonomia, double custoKm, double desgaste, double carga, boolean refrigerado, ArrayList<Carga> mercadoria){
        super(marca,matricula,custoKm,desgaste,carga, refrigerado, mercadoria);
        construtor_auxiliar(combustivel, autonomia);
    }
    
    public Furgao(Furgao c){
        super(c);
        construtor_auxiliar(c.getCombustivel(), c.getAutonomia());
    }
    
    
}
