package Servicos;

import Cargas.Carga;
import Veiculos.SVeiculos;
import Veiculos.Veiculo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Servico implements Serializable{
    
    
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

    public void setCargas(List<Carga> cargas) {
        this.cargas = cargas;
    }

    public void setInicio(GregorianCalendar inicio) {
        this.inicio = inicio;
    }

    public void setVeiculos(SVeiculos veiculos) {
        this.veiculos = veiculos;
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
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("PREÇO:").append(this.preco()).append("\n");
        return sb.toString();
    }
    
    
    public boolean addVeiculo(Veiculo v)
    {
        return this.veiculos.addVeiculo(v);
    }
    
    public void addCarga(Carga c)
    {
        this.cargas.add(c);
    }
    
    
    public abstract double preco();
    
}
