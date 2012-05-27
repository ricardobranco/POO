
package Clientes;

import java.io.*;
import java.util.*;


public class SClientes extends Observable implements Serializable{
    
    private Map<Long,Cliente> clientes;
    
    
    public SClientes()
    {
        this.clientes = new TreeMap<Long,Cliente>();
    }
    
    public SClientes(Map<Long,Cliente> clientes)
    {
        this.setMClientes(clientes);
    }
    
    public SClientes(Observer o){
        this.clientes = new TreeMap<Long,Cliente>();
        addObserver(o);
    }
    
    
    public SClientes(Collection<Cliente> clientes)
    {
        this.setCClientes(clientes);
    }
    
    public SClientes(SClientes s)
    {
        this.setCClientes(s.getCClientes());
    }
    
    
    
    //Metodos de instancia
    public Map<Long,Cliente> getMClientes()
    {
        Map<Long,Cliente> clientes =  new TreeMap<Long,Cliente>();
        for(Cliente c : this.clientes.values())
        {
            clientes.put(new Long(c.getNif()),c.clone());
        }
        
        return clientes;
    }
    
     public Collection<Cliente> getCClientes()
    {
        Collection<Cliente> clientes =  new TreeSet<Cliente>();
        for(Cliente c : this.clientes.values())
        {
            clientes.add(c.clone());
        }
        
        return clientes;
    }
     
     
    public void setMClientes(Map<Long,Cliente> Clientes)
    {
        this.clientes = new TreeMap<Long,Cliente>();
        for(Cliente c : Clientes.values())
        {
            this.clientes.put(new Long(c.getNif()),c);
        }
    }
    
     public void setCClientes(Collection<Cliente> Clientes)
    {
        this.clientes = new TreeMap<Long,Cliente>();
        for(Cliente c : Clientes)
        {
            this.clientes.put(new Long(c.getNif()),c);
        }
    }
     
     
    @Override
     public boolean equals(Object o)
     {
         if(o == this)
             return true;
         if((o==null)||(o.getClass() != this.getClass()))
             return false;
         
         SClientes clientes = (SClientes) o;
         
         return this.clientes.equals(clientes.getMClientes());
     }
    
    
    @Override
    public SClientes clone(){return new SClientes(this);}
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
         for(Cliente c :  this.clientes.values())
             sb.append(c.toString());
         
         return sb.toString();
    }
    
    
    public boolean addCliente(Cliente c)
    {
        if(this.clientes.containsValue(c)) return false;
        this.clientes.put(new Long(c.getNif()),c);
        return true;
    }
    
    public void remove(Collection<Cliente> clientes)
    {
        for(Cliente c : clientes)
            this.clientes.remove(new Long(c.getNif()));
    }
    
    
    public Collection<Cliente> clienteTipo(String s)
    {
        Collection<Cliente> res = new ArrayList<Cliente>(); 
        for(Cliente c : this.clientes.values())
        {
            if(c.getClass().getName().equals(s));
            res.add(c.clone());
        }
        return res;
            
    }
    
    
    public Iterator<Cliente> sortNif()
    {
        TreeSet<Cliente> res = new TreeSet<Cliente>();
          for(Cliente c : this.clientes.values())
          {
              res.add(c.clone());
          }
          return res.iterator();
    }
    
    public Iterator<Cliente> sortNome()
    {
        TreeSet<Cliente> res = new TreeSet<Cliente>(new CComparaNome());
          for(Cliente c : this.clientes.values())
          {
              res.add(c.clone());
          }
          return res.iterator();
    }
    
    public Iterator<Cliente> sortMorada()
    {
        TreeSet<Cliente> res = new TreeSet<Cliente>(new CComparaMorada());
          for(Cliente c : this.clientes.values())
          {
              res.add(c.clone());
          }
          return res.iterator();
    }
    
    
    
     public void save(String path)throws FileNotFoundException, IOException 
      {
         FileOutputStream fos = new FileOutputStream(path);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(this.clientes);
         oos.close();
         fos.close();
      }
      
      public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException 
      {
          FileInputStream fis = new FileInputStream(fileName);
          ObjectInputStream ois = new ObjectInputStream(fis);
          this.clientes = (TreeMap<Long,Cliente>) ois.readObject();
          ois.close();
          fis.close();
      }
    
    
    
    
}
