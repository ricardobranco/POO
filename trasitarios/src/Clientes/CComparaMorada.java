
package Clientes;

import java.util.Comparator;

public class CComparaMorada implements Comparator<Cliente> {

   
    public int compare(Cliente o1, Cliente o2) {
        if(o1.equals(o2)) return 0;
        else if (o1.getMorada().compareTo(o2.getMorada()) > 0)
            return 1;
        else return -1;
    }
}