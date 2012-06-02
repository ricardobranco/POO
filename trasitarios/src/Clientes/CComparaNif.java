
package Clientes;

import java.util.Comparator;


public class CComparaNif implements Comparator<Cliente> {
    @Override
    public int compare(Cliente o1, Cliente o2) {
        if(o1.equals(o2)) return 0;
        
        Long l1 = new Long(o1.getNif());
        Long l2 = new Long(o2.getNif());
        
        if (l1.compareTo(l2) > 0)
            return 1;
        else return -1;
        
        }
}
 