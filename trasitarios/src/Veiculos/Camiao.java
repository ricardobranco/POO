/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculos;

/**
 *
 * @author Bruno Ferreira
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
    
    public Camiao(String marca, String matricula, String condutor, double altura, double custoKm,double carga,boolean atrelado,boolean refrigerado)
    {
        super(marca,matricula,custoKm,carga);
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
    
    public double get_Altura(){return this.altura;}
    public boolean get_Atrelado(){return this.atrelado;}
    public String get_Condutor(){return this.condutor;}
    
    
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
    

    
    
    //public double custoEcomenda(double coefx, double coefy, double pbase)
    
    
   
    
    
    
    
    
    
    
            
    
    

}
    
    
            
    
    
    
    
   

   