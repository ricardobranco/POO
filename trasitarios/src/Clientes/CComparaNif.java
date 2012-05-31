
package Clientes;

import java.util.Comparator;


public class CComparaNome implements Comparator<Cliente> {

    
 
    public int compare(Cliente o1, Cliente o2) {
        if(o1.equals(o2)) return 0;
        else if (o1.getNome().compareTo(o2.getNome()) > 0)
            return 1;
        else return -1;
    }
}
 