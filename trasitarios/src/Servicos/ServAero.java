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
public class ServAero extends Servico implements Serializable{

    private static double custo = 25; 
    private static final int size = 3;        
    
    
    
    public ServAero() {
        super();
    }

    public ServAero(GregorianCalendar inicio, SVeiculos veiculos, List<Carga> cargas) {
        super(inicio, veiculos, cargas);
    }

    public ServAero(ServAero s) {
        super(s);
    }

    
    public static int getSize() {
        return size;
    }
    
    public static double getCusto() {
        return custo;
    }

    public static void setCusto(double custo) {
        ServAero.custo = custo;
    }

    
    public  ServAero clone() {return new ServAero(this);}

    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("PARA AEROPORTO\n").append(super.toString());
        return sb.toString();
    }
    
    public double preco() {
        double res = 0;
        for(Veiculo v : super.getVeiculos().getCVeiculos())
            res+=v.preco();
        return res+getCusto()*pesoTotal();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
