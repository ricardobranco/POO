package Veiculos;

import java.io.*;
import java.util.*;

public class SVeiculos extends Observable implements Serializable{
    public static final int MATRIX_PARADOS = 0;
    public static final int MATRIX_SERVICO = 1;
    public static final int MATRIX_AMBOS = 2;
   
    
    private Map<String,Veiculo> veiculos;
    
    
    
    //Construtores
    
    public SVeiculos()
    {
        this.veiculos = new HashMap<String,Veiculo>();
    }
    
    public SVeiculos(Observer o){
        this.veiculos = new HashMap<String,Veiculo>();
        addObserver(o);
    }
    public SVeiculos(Map<String,Veiculo> veiculos)
    {
       this.setveiculos(veiculos);
    }
    
    
    public SVeiculos(Collection<Veiculo> veiculos)
    {
       this.setCVeiculos(veiculos);
    }
    
    public SVeiculos(SVeiculos veiculos)
    {
        this.setveiculos(veiculos.getveiculos());
    }
    
    
    
    //Metodos de instancia
    public Map<String,Veiculo> getveiculos()
    {
        Map<String,Veiculo> clientes =  new HashMap<String,Veiculo>();
        for(Veiculo v : this.veiculos.values())
        {
            clientes.put(v.getMatricula(),v.clone());
        }
        
        return clientes;
    }
    
     public Collection<Veiculo> getCVeiculos()
    {
        Collection<Veiculo> clientes =  new HashSet<Veiculo>();
        for(Veiculo v : this.veiculos.values())
        {
            clientes.add(v.clone());
        }
        
        return clientes;
    }
     
     
    public void setveiculos(Map<String,Veiculo> veiculos)
    {
        this.veiculos = new HashMap<String,Veiculo>((int) 1.4*veiculos.size());
        for(Veiculo v : veiculos.values())
        {
            this.veiculos.put(v.getMatricula(),v);
        }
    }
    
     public void setCVeiculos(Collection<Veiculo> veiculos)
    {
        this.veiculos = new HashMap<String,Veiculo>((int) 1.4*veiculos.size());
        for(Veiculo v : veiculos)
        {
            this.veiculos.put(v.getMatricula(),v);
        }
    }
     
     public boolean equals(Object o)
     {
         if(o == this)
             return true;
         if((o==null)||(o.getClass() != this.getClass()))
             return false;
         
         SVeiculos veiculos = (SVeiculos) o;
         
         return this.veiculos.equals(veiculos.getveiculos());
     }
     
     
     public String toString()
     {
         StringBuilder sb = new StringBuilder();
         for(Veiculo v :  this.veiculos.values())
             sb.append(v.toString());
         
         return sb.toString();
     }
     
     public SVeiculos clone(){return new SVeiculos(this.getCVeiculos());}
     
     
     public boolean addVeiculo(Veiculo veiculo){
         if (this.veiculos.containsKey(veiculo.getMatricula()))
             return false;
        
         this.veiculos.put(veiculo.getMatricula(),veiculo);
         return true;
     }
     
     
     public void remove(Collection<Veiculo> veiculos)
     {
         for(Veiculo v : veiculos)
         {
             this.veiculos.remove(v.getMatricula());
         }
     }
     
     public void remove(Veiculo v)
     {
         this.veiculos.remove(v.getMatricula());
     }
     
     public Collection<Veiculo> refrigerados()
     {
         Collection<Veiculo> ref = new ArrayList<Veiculo>();
              
         for(Veiculo v : this.veiculos.values())
         {
             Class[] interfaces = v.getClass().getInterfaces();
             boolean flag = true;
             for(int i = 0; i<interfaces.length && flag; i++)
             {
                 if(interfaces[i].getSimpleName().equals("Refrigerado"))
                 {
                     ref.add(v.clone());
                     flag = false;
                 }
             }
         }
         return ref;
     }
     
     
      public Collection<Veiculo> naoRefrigerados()
     {
         Collection<Veiculo> ref = new ArrayList<Veiculo>();
              
         for(Veiculo v : this.veiculos.values())
         {
             Class[] interfaces = v.getClass().getInterfaces();
             boolean flag = true;
             for(int i = 0; i<interfaces.length && flag; i++)
             {
                 if(!(interfaces[i].getSimpleName().equals("Refrigerado")))
                 {
                     ref.add(v.clone());
                     flag = false;
                 }
             }
         }
         return ref;
     }
     
     
     public Collection<Veiculo> parados()
     {
         Collection<Veiculo> ref = new ArrayList<Veiculo>();
         
         for(Veiculo v : this.veiculos.values())
         {
             if(v.getParado())
                 ref.add(v.clone());
         }
         
         return ref;
         
     }
     
      public Collection<Veiculo> emServico()
     {
         Collection<Veiculo> ref = new ArrayList<Veiculo>();
         
         for(Veiculo v : this.veiculos.values())
         {
             if(!(v.getParado()))
                 ref.add(v.clone());
         }
         
         return ref;
         
     }
      
      public Iterator<Veiculo> sortTransportado()
      {
          TreeSet<Veiculo> res = new TreeSet<Veiculo>(new VComparaTotal());
          for(Veiculo v : this.veiculos.values())
          {
              res.add(v.clone());
          }
          return res.iterator();
      }
      
      public Iterator<Veiculo> sortLivre()
      {
          TreeSet<Veiculo> res = new TreeSet<Veiculo>(new VComparaLivre());
          for(Veiculo v : this.veiculos.values())
          {
              res.add(v.clone());
          }
          return res.iterator();
      }
      
      public Iterator<Veiculo> sortMatricula()
      { 
          TreeSet<Veiculo> res = new TreeSet<Veiculo>();
          for(Veiculo v : this.veiculos.values())
          {
              res.add(v.clone());
          }
          return res.iterator();
          
      }
      
      public void alteraEstado(Veiculo c)
      {
          Veiculo aux = this.veiculos.get(c.getMatricula());
          aux.setParado(!(aux.getParado()));
      }
      
      
      
      
     
      
      public Object[][] getMatrix(String pesquisa, boolean filtrarMatricula, int filtrarTipo){
	  Collection<Veiculo> col;
	  
	  if( filtrarTipo == SVeiculos.MATRIX_PARADOS )
	      col = this.parados();
	  else if( filtrarTipo == SVeiculos.MATRIX_SERVICO )
	      col = this.emServico();
	  else
	      col = this.veiculos.values();
	  
	  ArrayList<Veiculo> arr = new ArrayList<Veiculo>(col.size());
	  
	  if( !pesquisa.isEmpty() ){
	    if( filtrarMatricula ){
		for( Veiculo v : col ){
		    if( v.getMatricula().contains(pesquisa) )
			arr.add(v);
		}
	    }else{
		for( Veiculo v : col ){
		    if( v.getMarca().contains(pesquisa) )
			arr.add(v);
		}
	    }
	  }else
	      arr.addAll(col);
	  
	  Object[][] res = new Object[ col.size() ][7];
	  
	  Collections.sort(arr, new VComparaTotal());
	  
	  for( int i=0; i<arr.size(); i++ ){
	      res[i][0] = arr.get(i).getClass().getSimpleName();
	      res[i][1] = arr.get(i).getMatricula();
	      res[i][2] = arr.get(i).getMarca();
	      res[i][3] = new Double(arr.get(i).getCapacidade());
	      res[i][4] = new Double(arr.get(i).getCargaActual());
	      res[i][5] = new Double(arr.get(i).getTotal());
	      res[i][6] = arr.get(i).getParado() ? "Parado" : "Movimento";
	  }
	  
	  return res;
      }
      
}
