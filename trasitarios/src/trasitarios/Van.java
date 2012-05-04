/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trasitarios;

/**
 *
 * @author Bruno Alves
 * @author Daniel Carvalho
 * @author Ricardo Branco
 */
public class Van extends Veiculo{
   
    
    public Van()
    {
        super();
        super.set_Refrigerado(true);
    }
    
    public Van(String marca, String matricula, String gasolina, float autonomia, float custoKm, float desgaste, float carga,boolean refrigerado)
    {
        super(marca,matricula,custoKm,desgaste,carga);
        super.set_Refrigerado(true);
    }
    
    public Van(Van c)
    {
        super(c);
        super.set_Refrigerado(true);
    }
    
    @Override
    public String get_Marca(){return super.get_Marca();}
    @Override
    public String get_Matricula(){return super.get_Matricula();}
    @Override
    public float get_Desgaste(){return super.get_Desgaste();}
    @Override
    public float get_CustoKm(){return super.get_CustoKm();}
    @Override
    public float get_Carga(){return super.get_Carga();}
    @Override
    public boolean get_Refrigerado(){return super.get_Refrigerado();}
       
    
    @Override
    public void set_Marca(String marca){super.set_Marca(marca);}
    @Override
    public void set_Matricula(String matricula){super.set_Matricula(matricula);}
    @Override
    public void set_CustoKm(float custoKm){super.set_CustoKm(custoKm);}
    @Override
    public void set_Desgaste(float desgaste){super.set_Desgaste(desgaste);}
    @Override
    public void set_Carga(float carga){super.set_Carga(carga);}
    @Override
    public void set_Refrigerado(boolean refrigeracao){super.set_Refrigerado(true);}  
    
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();      
    }
    
    @Override
    public Van clone(){return new Van(this);}
    

    @Override
    public boolean equals(Object o){return super.equals(o);}
    
    @Override
    public int hashCode(){return super.hashCode();}
    
    @Override
    public int compareTo(Veiculo v){return super.compareTo(v);}

    
    
   
    
    
    
    
    
    
    
            
    
    

}
    
    
            
    
    
    
    
   

   