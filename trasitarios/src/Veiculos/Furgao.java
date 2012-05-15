package Veiculos;

import Cargas.*;
import java.util.List;

/**
 *
 * @author Bruno Ferreira
 * @author Daniel Carvalho
 * @author Ricardo Branco
 */
public class Furgao extends Veiculo{
    
    
    private String gasolina;
    private double autonomia;
    
    
    public Furgao()
    {
        super();
        super.set_Refrigerado(false);
        this.gasolina = "";
        this.autonomia = 0;
     }
    
    public Furgao(String marca, String matricula, String gasolina, double autonomia, double custoKm, double desgaste, double carga, boolean refrigerado)
    {
        super(marca,matricula,custoKm,desgaste,carga);
        super.set_Refrigerado(refrigerado);
        this.gasolina = gasolina;
        this.autonomia = autonomia;
    }
    
    public Furgao(String marca, String matricula, String gasolina, double autonomia, double custoKm, double desgaste, double carga, boolean refrigerado,List<Carga> mercadoria)
    {
        super(marca,matricula,custoKm,desgaste,carga,mercadoria);
        super.set_Refrigerado(refrigerado);
        this.gasolina = gasolina;
        this.autonomia = autonomia;
    }
    
    
    
    public Furgao(Furgao c)
    {
        super(c);
        this.autonomia = c.get_Autonomia();
        this.gasolina = c.get_Gasolina();
    }
    
    @Override
    public String get_Marca(){return super.get_Marca();}
    @Override
    public String get_Matricula(){return super.get_Matricula();}
    @Override
    public double get_Desgaste(){return super.get_Desgaste();}
    @Override
    public double get_CustoKm(){return super.get_CustoKm();}
    @Override
    public double get_Carga(){return super.get_Carga();}
    @Override
    public boolean get_Refrigerado(){return super.get_Refrigerado();}
    @Override
    public List<Carga> get_Mercadoria(){return super.get_Mercadoria();}
    public double get_Autonomia(){return this.autonomia;}
    public String get_Gasolina(){return this.gasolina;}
    
    
    
    
    
    
    
    @Override
    public void set_Marca(String marca){super.set_Marca(marca);}
    @Override
    public void set_Matricula(String matricula){super.set_Matricula(matricula);}
    @Override
    public void set_CustoKm(double custoKm){super.set_CustoKm(custoKm);}
    @Override
    public void set_Desgaste(double desgaste){super.set_Desgaste(desgaste);}
    @Override
    public void set_Carga(double carga){super.set_Carga(carga);}
    public void set_Alura(double autonomia){this.autonomia = autonomia;}
    public void set_gasolina(String gasolina){this.gasolina = gasolina;}
    @Override
    public void set_Refrigerado(boolean refrigeracao){super.set_Refrigerado(refrigeracao);}  
    public void set_Mercardorias(List<Carga> mercadoria){super.set_Mercadoria(mercadoria);}
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Gasolina ").append(this.gasolina).append("\n");
        sb.append("Autonomia ").append(this.autonomia).append("\n");
        return sb.toString();      
    }
    
    @Override
    public Furgao clone(){return new Furgao(this);}
    

    @Override
    public boolean equals(Object o){return super.equals(o);}
    
    @Override
    public int hashCode(){return super.hashCode();}
    
    @Override
    public int compareTo(Veiculo v){return super.compareTo(v);}

    @Override
     public double totalCarga(){return super.totalCarga();}
    
    @Override
    public boolean mais60(){return super.mais60();}
    
    @Override
    public boolean addCarga(Carga c){return super.addCarga(c);}
    
    
   // public void addCargas(List<Carga> c);

    @Override
    public void addCargas(List<Carga> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    

}
    
    
            
    
    
    
    
   

   