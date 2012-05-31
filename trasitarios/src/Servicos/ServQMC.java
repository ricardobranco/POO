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
public class ServQMC extends Servico{

    private static double custo = 15;

    private Carga[] carga;

    public ServQMC() {
        super();
        this.carga = new Carga[10];
    }

    public ServQMC(Carga[] carga, GregorianCalendar inicio, SVeiculos veiculos) {
        super(inicio, veiculos);
        this.carga = carga;
    }

    public ServQMC(ServQMC s) {
        super(s);
        this.carga = s.getCarga();
    }

    
    public static double getCusto() {
        return custo;
    }
    
    public static void setCusto(double custo) {
        ServQMC.custo = custo;
    }
    
    
    public Carga[] getCarga() {
        
        Carga[] aux = new Carga[3];
        for(int i = 0; i<this.carga.length;i++)
            aux[i] = this.carga[i].clone();
        return aux;
    }

    public void setCarga(Carga[] carga) {
        this.carga = carga;
    }
    
   private boolean contemCarga(Carga c)
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
       
       ServQMC s = (ServQMC) o;
       if(s.getCarga().length != this.carga.length)
           return false;
       for(int i = 0; i<this.carga.length;i++)
       {
           if(!(s.contemCarga(this.carga[i])))
               return false;
       }
       return true;
   }
    
    
   
    public ServQMC clone(){return new ServQMC(this);}
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("PARA QUERIDO MUDEI A CASA\n").append(super.toString());
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
