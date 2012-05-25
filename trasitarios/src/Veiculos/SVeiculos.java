package Veiculos;

import java.io.*;
import java.util.*;

public class SVeiculos implements Serializable{
    
   
    
    private Map<String,Veiculo> veiculos;
    
    
    //Construtores
    
    public SVeiculos()
    {
        this.veiculos = new HashMap<String,Veiculo>();
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
        Collection<Veiculo> clientes =  new TreeSet<Veiculo>();
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
     
     public Collection<Veiculo> refrigerados()
     {
         Collection<Veiculo> ref = new ArrayList<Veiculo>();
              
         for(Veiculo v : this.veiculos.values())
         {
             Class[] interfaces = v.getClass().getInterfaces();
             boolean flag = true;
             for(int i = 0; i<interfaces.length && flag; i++)
             {
                 if(interfaces[i].getName().equals("Refrigerado"))
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
                 ref.add(v);
         }
         
         return ref;
         
     }
     
      public Collection<Veiculo> emServico()
     {
         Collection<Veiculo> ref = new ArrayList<Veiculo>();
         
         for(Veiculo v : this.veiculos.values())
         {
             if(!(v.getParado()))
                 ref.add(v);
         }
         
         return ref;
         
     }
      
      public Iterator<Veiculo> sortTransportado()
      {
          TreeMap<Double,Veiculo> res = new TreeMap<Double,Veiculo>();
          for(Veiculo v : this.veiculos.values())
          {
              Double d = new Double(v.getTotal()); 
              res.put(d,v);
          }
          return res.values().iterator();
          
          
      }
      
      
      public void save(String path)throws FileNotFoundException, IOException 
      {
         FileOutputStream fos = new FileOutputStream(path);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(this.veiculos);
         oos.close();
         fos.close();
      }
      
      public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException 
      {
          FileInputStream fis = new FileInputStream(fileName);
          ObjectInputStream ois = new ObjectInputStream(fis);
          this.veiculos = (HashMap<String,Veiculo>) ois.readObject();
          ois.close();
          fis.close();
      }
      
      
      
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
     
     
    
    
}
