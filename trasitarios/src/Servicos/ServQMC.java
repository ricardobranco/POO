/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Cargas.Carga;
import Cargas.Indiferenciada;
import Veiculos.SVeiculos;
import Veiculos.Veiculo;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Ricardo Branco
 */
public class ServQMC extends Servico implements Serializable{

    private static double custo = 25; 
    private static final int size = 1;        
    
    
    
    public ServQMC() {
        super();
    }

    public ServQMC(GregorianCalendar inicio, SVeiculos veiculos, List<Carga> cargas) {
        super(inicio, veiculos, cargas);
    }

    public ServQMC(ServQMC s) {
        super(s);
    }

    public static double getCusto() {
        return custo;
    }

    public static void setCusto(double custo) {
        ServQMC.custo = custo;
    }

    
    public  ServQMC clone() {return new ServQMC(this);}

    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("PARA QUERIDO MUDEI A CASA\n").append(super.toString());
        return sb.toString();
    }
    
    public double preco() {
        double res = 0;
        for(Veiculo v : super.getVeiculos().getCVeiculos())
            res+=v.preco();
        return res+getCusto();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
