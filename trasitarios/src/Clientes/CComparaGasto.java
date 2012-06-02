
package Clientes;

import java.util.Comparator;


public class CComparaGasto implements Comparator<Cliente> {
    @Override
     public int compare(Cliente o1, Cliente o2) {
        if(o1.equals(o2)) return 0;
        
        
        Double l1 = new Double(o1.totalGasto());
        Double l2 = new Double(o2.totalGasto());
        
        if (l1.compareTo(l2) > 0)
            return 1;
        else return -1;
    }
}
 