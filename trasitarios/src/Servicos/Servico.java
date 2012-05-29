package Servicos;

import Cargas.Carga;
import Veiculos.SVeiculos;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Servico {
    
    
    private GregorianCalendar inicio;
    private SVeiculos veiculos;
    
    
    public Servico() {
        this.inicio = new GregorianCalendar();
        this.veiculos = new SVeiculos();
    }
    
    
    public Servico(GregorianCalendar inicio,SVeiculos veiculos) {
        this.inicio = inicio;
        this.veiculos = veiculos;
    }
    
    public Servico(Servico s)
    {
        this.inicio = s.getInicio();
        this.veiculos = s.getVeiculos();
    }
    
    
    public GregorianCalendar getInicio() {
        return inicio;
    }

    public SVeiculos getVeiculos() {
        return veiculos.clone();
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
    public abstract double preco();
}
