/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Clientes.SClientes;
import Veiculos.SVeiculos;
import Veiculos.Veiculo;
import java.io.Serializable;

/**
 *
 * @author Ricardo
 */
public class Sistema implements Serializable{
    
    private SClientes clientes;
    private SVeiculos veiculos;
    
    
    
    public Sistema()
    {
        this.clientes = new SClientes();
        this.veiculos = new SVeiculos();
    }

    public Sistema(SClientes clientes, SVeiculos veiculos) {
        this.clientes = clientes;
        this.veiculos = veiculos;
    }
    
    public Sistema(Sistema s)
    {
        this.clientes = s.getClientes();
        this.veiculos = s.getVeiculos();
    }

    public SClientes getClientes() {
        return clientes.clone();
    }

    public SVeiculos getVeiculos() {
        return veiculos.clone();
    }

    public void setClientes(SClientes clientes) {
        this.clientes = clientes;
    }

    public void setVeiculos(SVeiculos veiculos) {
        this.veiculos = veiculos;
    }
    
    public boolean equals(Object o)
    {
        if(o==this)
            return true;
        if((o==null)||(o.getClass()!=this.getClass()))
            return false;
        Sistema s = (Sistema) o;
        return s.getClientes().equals(this.clientes) && s.getVeiculos().equals(this.veiculos);
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.clientes.toString()).append("\n");
        sb.append(this.veiculos.toString()).append("\n");
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    
}
