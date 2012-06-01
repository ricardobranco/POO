
package Clientes;

import Veiculos.VComparaTotal;
import Veiculos.Veiculo;
import java.io.*;
import java.util.*;


public class SClientes extends Observable implements  Serializable{
    
    private Map<Long,Cliente> clientes;
    
    
    public SClientes()
    {
        this.clientes = new TreeMap<Long,Cliente>();
    }
    
    public SClientes(Map<Long,? extends Cliente> clientes)
    {
        this.setMClientes(clientes);
    }
    
    public SClientes(Observer o){
        this.clientes = new TreeMap<Long,Cliente>();
        addObserver(o);
    }
    
    
    public SClientes(Collection<? extends Cliente> clientes)
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
     
     
    public void setMClientes(Map<Long,? extends Cliente> Clientes)
    {
        this.clientes = new TreeMap<Long,Cliente>();
        for(Cliente c : Clientes.values())
        {
            this.clientes.put(new Long(c.getNif()),c);
        }
    }
    
     public void setCClientes(Collection<? extends Cliente> Clientes)
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
        if(this.clientes.containsValue(c)) 
            return false;
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
    
    
      
      public String[][] getMatrix(String pesquisa, boolean filtrarNome){
	  Collection<Cliente> col = this.clientes.values();
	  ArrayList<Cliente> arr = new ArrayList<Cliente>(col.size());
	  
	  if( filtrarNome ){
	    for( Cliente c : col ){
		if( c.getNome().contains(pesquisa) )
		    arr.add(c);
	    }
	  }else{
	    for( Cliente c : col ){
		if( Long.toString( c.getNif() ).toString().contains(pesquisa) )
		    arr.add(c);
	    }
	  }
	  
	  
	  String[][] res = new String[ col.size() ][7];
	  
	  if( filtrarNome )
	    Collections.sort(arr, new CComparaNome());
	  else
	    Collections.sort(arr, new CComparaNif());
	  
	  for( int i=0; i<arr.size(); i++ ){
	      res[i][0] = arr.get(i).getClass().getSimpleName();
	      res[i][1] = arr.get(i).getNome();
	      res[i][2] = Long.toString(arr.get(i).getNif());
	      res[i][3] = arr.get(i).getMorada();
	  }
	  
	  return res;
      }
}
