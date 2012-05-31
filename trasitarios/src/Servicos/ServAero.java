/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Cargas.Indiferenciada;
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

    private Indiferenciada[] carga;

    public ServAero() {
        super();
        this.carga = new Indiferenciada[3];
    }

    public ServAero(Indiferenciada[] Indiferenciada, GregorianCalendar inicio, SVeiculos veiculos) {
        super(inicio, veiculos);
        this.carga = Indiferenciada;
    }

    public ServAero(ServAero s) {
        super(s);
        this.carga = s.getIndiferenciada();
    }

    
    public static double getCusto() {
        return custo;
    }
    
    public static void setCusto(double custo) {
        ServAero.custo = custo;
    }
    
    
    public Indiferenciada[] getIndiferenciada() {
        
        Indiferenciada[] aux = new Indiferenciada[3];
        for(int i = 0; i<this.carga.length;i++)
            aux[i] = this.carga[i].clone();
        return aux;
    }

    public void setIndiferenciada(Indiferenciada[] Indiferenciada) {
        this.carga = Indiferenciada;
    }
    
   private boolean contemIndiferenciada(Indiferenciada c)
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
       
       ServAero s = (ServAero) o;
       if(s.getIndiferenciada().length != this.carga.length)
           return false;
       for(int i = 0; i<this.carga.length;i++)
       {
           if(!(s.contemIndiferenciada(this.carga[i])))
               return false;
       }
       return true;
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
        return this.carga.length * getCusto();     
    }
        
    
}
