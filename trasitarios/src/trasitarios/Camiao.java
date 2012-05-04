/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trasitarios;

/**
 *
 * @author Ricardo Branco
 */
public class Camiao extends Veiculo{
    private String condutor;
    private boolean atrelado;
    private float altura;
    
    
    public Camiao()
    {
        super();
        super.set_Refrigerado(false);
        this.condutor = "";
        this.atrelado = false;
        this.altura = 0;
    }
    
    public Camiao(String marca, String matricula, String condutor, float altura, float custoKm, float desgaste, float carga,boolean atrelado)
    {
        super(marca,matricula,custoKm,desgaste,carga);
        this.condutor = condutor;
        this.altura = altura;
        this.atrelado = atrelado;
    }
    
    public Camiao(Camiao c)
    {
        super(c);
        this.altura = c.get_Altura();
        this.atrelado = c.get_Atrelado();
        this.condutor = c.get_Condutor();
    }
    
    public float get_Altura(){return this.altura;}
    public boolean get_Atrelado(){return this.atrelado;}
    public String get_Condutor(){return this.condutor;}
    
    public void set_Alura(float altura){this.altura = altura;}
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
    
    public int compareTo(Camiao c){return super.compareTo(c);}

   
    
    
    
    
    
    
    
            
    
    

}
    
    
            
    
    
    
    
   

   