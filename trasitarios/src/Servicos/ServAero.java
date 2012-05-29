/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Cargas.Carga;
import Veiculos.SVeiculos;
import Veiculos.Veiculo;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Ricardo Branco
 */
public class ServAero extends Servico{

    private static double custo = 20;

    
    
    public ServAero(Servico s) {
        super(s);
    }

    public ServAero(GregorianCalendar inicio, GregorianCalendar duracao, SVeiculos veiculos, List<Carga> carga) {
        super(inicio, duracao, veiculos, carga);
    }

    public ServAero() {
    }

    
    public static double getCusto() {
        return custo;
    }
    
    public static void setCusto(double custo) {
        ServAero.custo = custo;
    }
    
    public ServAero clone(){return new ServAero(this);}
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("PARA AEROPORTO\n").append(super.toString());
        return sb.toString();
    }
    
    public double preco()
    {
        double res = 0;
        for(Veiculo v : super.getVeiculos().getCVeiculos())
            res+=v.preco();
        for(Carga c : super.getCargas())
            res+=(c.getCarga()*getCusto());
        return res;
    }
        
    
}
