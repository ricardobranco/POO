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
public class ServSimples extends Servico{

    private static double custo = 25; 
    
    private Carga carga;

    
    
    public ServSimples() {
        super();
        this.carga = new Indiferenciada();
    }

    public ServSimples(Carga carga, GregorianCalendar inicio, SVeiculos veiculos) {
        super(inicio, veiculos);
        this.carga = carga;
    }

    public ServSimples(ServSimples s) {
        super(s);
        this.carga = s.getCarga();
    }

    
    
    public static double getCusto() {
        return custo;
    }

    public static void setCusto(double custo) {
        ServSimples.custo = custo;
    }

    
    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
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
        return res+getCusto();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
