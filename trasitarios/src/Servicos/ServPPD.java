/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Cargas.Perecivel;
import Cargas.Perecivel;
import Veiculos.SVeiculos;
import Veiculos.Veiculo;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Ricardo Branco
 */
public class ServPPD extends Servico{

    private static double custo = 20;

    private Perecivel[] carga;

    public ServPPD() {
        super();
        this.carga = new Perecivel[10];
    }

    public ServPPD(Perecivel[] carga, GregorianCalendar inicio, SVeiculos veiculos) {
        super(inicio, veiculos);
        this.carga = carga;
    }

    public ServPPD(ServPPD s) {
        super(s);
        this.carga = s.getPerecivel();
    }

    
    public static double getCusto() {
        return custo;
    }
    
    public static void setCusto(double custo) {
        ServPPD.custo = custo;
    }
    
    
    public Perecivel[] getPerecivel() {
        
        Perecivel[] aux = new Perecivel[3];
        for(int i = 0; i<this.carga.length;i++)
            aux[i] = this.carga[i].clone();
        return aux;
    }

    public void setPerecivel(Perecivel[] carga) {
        this.carga = carga;
    }
    
   private boolean contemPerecivel(Perecivel c)
   {
       for(int i = 0; i<this.carga.length;i++ )
       {
           if(this.carga[i].equals(c))
               return true;
       }
       return false;
   }
   
   
   public boolean equals(Object o)
   {
       if(this==o)
           return true;
       if((o==null) || (o.getClass() != this.getClass()))
           return false;
       
       ServPPD s = (ServPPD) o;
       if(s.getPerecivel().length != this.carga.length)
           return false;
       for(int i = 0; i<this.carga.length;i++)
       {
           if(!(s.contemPerecivel(this.carga[i])))
               return false;
       }
       return true;
   }
    
    
   
    public ServPPD clone(){return new ServPPD(this);}
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("PARA PROFISSIONAIS DA DISTRIBUIÇÃO\n").append(super.toString());
        return sb.toString();
    }
    
    public double preco()
    {
        double res = 0;
        for(Veiculo v : super.getVeiculos().getCVeiculos())
            res+=v.preco();
        return this.carga.length * getCusto();     
    }
        
    
}
