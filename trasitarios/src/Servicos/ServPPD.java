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
public class ServPPD extends Servico implements Serializable{

    private static double custo = 10; 
    private static final int size = 10;        
    
    
    
    public ServPPD() {
        super();
    }

    public ServPPD(Carga carga, GregorianCalendar inicio, SVeiculos veiculos, List<Carga> cargas) {
        super(inicio, veiculos, cargas);
    }

    public ServPPD(ServPPD s) {
        super(s);
    }

    public static int getSize() {
        return size;
    }
    
    public static double getCusto() {
        return custo;
    }

    public static void setCusto(double custo) {
        ServPPD.custo = custo;
    }

    
    public  ServPPD clone() {return new ServPPD(this);}

    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("PARA PROFISSIONAIS DA DISTRIBUIÇÃO\n").append(super.toString());
        return sb.toString();
    }
    
    public double preco() {
        double res = 0;
        for(Veiculo v : super.getVeiculos().getCVeiculos())
            res+=v.preco();
        return res+getCusto()*super.getCargas().size()*pesoTotal();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
