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
public class ServSimples extends Servico implements Serializable{

    private static double custo = 10; 
    private static final int size = 1;        
    
    
    
    public ServSimples() {
        super();
    }

    public ServSimples(GregorianCalendar inicio, SVeiculos veiculos, List<Carga> cargas) {
        super(inicio, veiculos, cargas);
    }

    public ServSimples(ServSimples s) {
        super(s);
    }

    public static double getCusto() {
        return custo;
    }

    public static void setCusto(double custo) {
        ServSimples.custo = custo;
    }

    public static int getSize() {
        return size;
    }
    
    public  ServSimples clone() {return new ServSimples(this);}

    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SERVIÇO SIMPLES\n").append(super.toString());
        return sb.toString();
    }
    
    public double preco() {
        double res = 0;
        for(Veiculo v : super.getVeiculos().getCVeiculos())
            res+=v.preco();
        return res+getCusto()*pesoTotal();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
