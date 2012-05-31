/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Cargas.Carga;
import Cargas.Indiferenciada;
import Veiculos.SVeiculos;
import Veiculos.Veiculo;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Ricardo Branco
 */
public class ServTox extends Servico{

    private static double custo = 20; 
    private static final int size = 1;        
    
    
    
    public ServTox() {
        super();
    }

    public ServTox(GregorianCalendar inicio, SVeiculos veiculos, List<Carga> cargas) {
        super(inicio, veiculos, cargas);
    }

    public ServTox(ServTox s) {
        super(s);
    }

    public static double getCusto() {
        return custo;
    }

    public static void setCusto(double custo) {
        ServTox.custo = custo;
    }

    
    public  ServTox clone() {return new ServTox(this);}

    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("PARA SERVIÇOS SECRETOS\n").append(super.toString());
        return sb.toString();
    }
    
    public double preco() {
        double res = 0;
        for(Veiculo v : super.getVeiculos().getCVeiculos())
            res+=v.preco();
        return res+getCusto();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
