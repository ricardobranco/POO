package Servicos;

import Cargas.Carga;
import Veiculos.SVeiculos;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Servico{
    
    
    private GregorianCalendar inicio;
    private SVeiculos veiculos;
    private List<Carga> cargas; 
    
    public Servico() {
        this.inicio = new GregorianCalendar();
        this.veiculos = new SVeiculos();
        this.cargas = new ArrayList<Carga>();
    }
    
    
    public Servico(GregorianCalendar inicio,SVeiculos veiculos,List<Carga> cargas) {
        this.inicio = inicio;
        this.veiculos = veiculos;
        this.cargas = cargas;
    }
    
    public Servico(Servico s)
    {
        this.inicio = s.getInicio();
        this.veiculos = s.getVeiculos();
        this.cargas = s.getCargas();
    }
    
    
    public GregorianCalendar getInicio() {
        return inicio;
    }

    public SVeiculos getVeiculos() {
        return veiculos.clone();
    }
    
    public List<Carga> getCargas(){
        List<Carga> res = new ArrayList<Carga>();
        for(Carga c : this.cargas)
            res.add(c.clone());
        return res;
    }     
    

    @Override
    public boolean equals(Object obj){
        
        if(obj == this)
            return true;
        
        if ((obj == null)|| (this.getClass() != obj.getClass())) 
            return false;
        
        Servico s = (Servico) obj;
        return s.getVeiculos().equals(this.veiculos) &&
               s.getInicio().equals(this.inicio);
    }
    
    public abstract Servico clone();
    
    public double pesoTotal()
    {
        double res = 0;
        
        for(Carga c : this.cargas)
            res+=c.getCarga();
     return res;   
    }
    
    
    public abstract double preco();
}
