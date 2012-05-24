
package Veiculos;

import java.util.HashMap;
import java.util.Map;

public class SVeiculos {
    
    private Map<String,Veiculo> veiculos;
    
    public SVeiculos()
    {
        this.veiculos = new HashMap<String,Veiculo>();
    }
    
    public SVeiculos(Map<String,Veiculo> veiculos)
    {
       this.setMVeiculos(veiculos);
    }
    
    
    
    public void setMVeiculos(Map<String,Veiculo> veiculos)
    {
        this.veiculos = new HashMap<String,Veiculo>((int) 1.4*veiculos.size());
        for(Veiculo v : veiculos.values())
        {
            this.veiculos.put(v.getMatricula(),v);
        }
    }
    
    
    
}
