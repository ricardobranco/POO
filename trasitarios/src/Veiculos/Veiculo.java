package Veiculos;

/**
 *
 * @author Bruno Alves
 * @author Daniel Carvalho
 * @author Ricardo Branco
 */
public abstract class Veiculo {

    private String marca;
    private String matricula;
    private double custoKm;
    private double desgaste;
    private double carga;
    private boolean refrigerado;
    
    public Veiculo()
    {
        this.marca = "";
        this.matricula = "";
        this.custoKm = 0;
        this.desgaste = 0;
        this.carga = 0;
    }
    
    public Veiculo(String marca, String matricula, double custoKm, double desgaste, double carga)
    {
        this.marca = marca;
        this.matricula = matricula;
        this.desgaste = desgaste;
        this.custoKm = custoKm;
        this.carga = carga;
    }
    
    public Veiculo(Veiculo v)
    {
        this.marca = v.get_Marca();
        this.matricula = v.get_Matricula();
        this.desgaste = v.get_Desgaste();
        this.custoKm = v.get_CustoKm();
        this.carga = v.get_Carga();
    }
    
    
    public String get_Marca(){return this.marca;}
    public String get_Matricula(){return this.matricula;}
    public double get_Desgaste(){return this.desgaste;}
    public double get_CustoKm(){return this.custoKm;}
    public double get_Carga(){return this.carga;}
    public boolean get_Refrigerado(){return this.refrigerado;}
    
    public void set_Marca(String marca){this.marca = marca;}
    public void set_Matricula(String matricula){this.matricula = matricula;}
    public void set_CustoKm(double custoKm){this.custoKm = custoKm;}
    public void set_Desgaste(double desgaste){this.desgaste = desgaste;}
    public void set_Carga(double carga){this.carga = carga;}
    public void set_Refrigerado(boolean refrigerado){this.refrigerado = refrigerado;}
    
    
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
 
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
