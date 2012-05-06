package Veiculos;

/**
 *
 * @author Bruno Ferreira
 * @author Daniel Carvalho
 * @author Ricardo Branco
 */
import Cargas.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Veiculo {

    private String marca;
    private String matricula;
    private double custoKm;
    private double desgaste;
    private double carga;
    private boolean refrigerado;
    private List<Carga> mercadoria;
    
    
    
    public Veiculo()
    {
        this.marca = "";
        this.matricula = "";
        this.custoKm = 0;
        this.desgaste = 0;
        this.carga = 0;
        this.mercadoria = new ArrayList<Carga>();
    }
    
    public Veiculo(String marca, String matricula, double custoKm, double desgaste, double carga, List<Carga> mercadoria)
    {
        this.marca = marca;
        this.matricula = matricula;
        this.desgaste = desgaste;
        this.custoKm = custoKm;
        this.carga = carga;
        this.mercadoria = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = mercadoria.iterator(); it.hasNext();) {
            Carga c = it.next();
            this.mercadoria.add(c);
        }
        
    }
    
    public Veiculo(String marca, String matricula, double custoKm, double desgaste, double carga)
    {
        this.marca = marca;
        this.matricula = matricula;
        this.desgaste = desgaste;
        this.custoKm = custoKm;
        this.carga = carga;
        this.mercadoria = new ArrayList<Carga>();
        
    }
    
    
    public Veiculo(Veiculo v)
    {
        this.marca = v.get_Marca();
        this.matricula = v.get_Matricula();
        this.desgaste = v.get_Desgaste();
        this.custoKm = v.get_CustoKm();
        this.carga = v.get_Carga();
        this.mercadoria = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = v.get_Mercadoria().iterator(); it.hasNext();) {
            Carga c = it.next();
            this.mercadoria.add(c);
        }
        
    }
    
    
    public String get_Marca(){return this.marca;}
    public String get_Matricula(){return this.matricula;}
    public double get_Desgaste(){return this.desgaste;}
    public double get_CustoKm(){return this.custoKm;}
    public double get_Carga(){return this.carga;}
    public boolean get_Refrigerado(){return this.refrigerado;}
    public List<Carga> get_Mercadoria()
    {
        List<Carga> res = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = this.mercadoria.iterator(); it.hasNext();) 
        {
            Carga c = it.next();
            res.add(c.clone());
        }
          
            return res;
    }
    
    
    public void set_Marca(String marca){this.marca = marca;}
    public void set_Matricula(String matricula){this.matricula = matricula;}
    public void set_CustoKm(double custoKm){this.custoKm = custoKm;}
    public void set_Desgaste(double desgaste){this.desgaste = desgaste;}
    public void set_Carga(double carga){this.carga = carga;}
    public void set_Refrigerado(boolean refrigerado){this.refrigerado = refrigerado;}
    public void set_Mercadoria(List<Carga> mercadoria)
    {
        this.mercadoria = new ArrayList<Carga>((int)(1.4*mercadoria.size()));
        for (Iterator<Carga> it = mercadoria.iterator(); it.hasNext();) 
        {
            Carga c = it.next();
            this.mercadoria.add(c);
        }
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(this.marca).append("\n");
        sb.append("Matricula: ").append(this.matricula).append("\n");
        sb.append("Custo Km: ").append(this.custoKm).append("\n");
        sb.append("Desgate: ").append(this.desgaste).append("\n");
        sb.append("Capacidade: ").append(this.carga).append("\n");
        return sb.toString();
    }
    
    @Override
    public abstract Veiculo clone(); 
    
    @Override
    public boolean equals(Object o)
    {
      if(this == o)
          return true;
      if((o==null) || (this.getClass() != o.getClass()))
          return false;
      
      Veiculo v = (Veiculo) o;
      return this.matricula.equals(v.get_Matricula());
    }
    
    @Override
    public int hashCode(){ return this.matricula.hashCode();}
    
    public int compareTo(Veiculo v){return this.matricula.compareTo(v.get_Matricula());}
 
    
    public double totalCarga()
    {
        double res = 0;
        for(Carga c : this.mercadoria)
            res+=c.get_Carga();
        return res;
    }
    public boolean addCarga(Carga c)
    {
        return c.get_Carga()+this.totalCarga() <= this.get_Carga() && this.mercadoria.add(c);
    }
    
    
    public abstract void addCargas(List<Carga> c);
    public boolean mais60()
    {
        return this.totalCarga()/(this.carga) >= 0.6;
    }
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
