/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculos;

/**
 *
 * @author Bruno Alves
 * @author Daniel Carvalho
 * @author Ricardo Branco
 */
public class Camiao extends Veiculo{
    private String condutor;
    private boolean atrelado;
    private double altura;
    
    
    public Camiao()
    {
        super();
        super.set_Refrigerado(false);
        this.condutor = "";
        this.atrelado = false;
        this.altura = 0;
    }
    
    public Camiao(String marca, String matricula, String condutor, double altura, double custoKm, double desgaste, double carga,boolean atrelado,boolean refrigerado)
    {
        super(marca,matricula,custoKm,desgaste,carga);
        super.set_Refrigerado(false);
        this.condutor = condutor;
        this.altura = altura;
        this.atrelado = atrelado;
    }
    
    public Camiao(Camiao c)
    {
        super(c);
        super.set_Refrigerado(false);
        this.altura = c.get_Altura();
        this.atrelado = c.get_Atrelado();
        this.condutor = c.get_Condutor();
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
    public double get_Altura(){return this.altura;}
    public boolean get_Atrelado(){return this.atrelado;}
    public String get_Condutor(){return this.condutor;}
    
    
    
    
    
    
    
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
    public void set_Alura(double altura){this.altura = altura;}
    public void set_Atrelado(boolean atrelado){this.atrelado = atrelado;}
    public void set_Condutor(String condutor){this.condutor = condutor;}
    @Override
    public void set_Refrigerado(boolean refrigeracao){super.set_Refrigerado(false);}  
    
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Condutor ").append(this.condutor).append("\n");
        sb.append("Atrelado: ").append(this.atrelado).append("\n");
        sb.append("Altura ").append(this.altura).append("\n");
        return sb.toString();      
    }
    
    @Override
    public Camiao clone(){return new Camiao(this);}
    

    @Override
    public boolean equals(Object o){return super.equals(o);}
    
    @Override
    public int hashCode(){return super.hashCode();}
    
    @Override
    public int compareTo(Veiculo v){return super.compareTo(v);}

    
    //public double custoEcomenda(double coefx, double coefy, double pbase)
    
    
   
    
    
    
    
    
    
    
            
    
    

}
    
    
            
    
    
    
    
   

   