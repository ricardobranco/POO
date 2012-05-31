
package Clientes;

import java.util.Comparator;


public class CComparaNif implements Comparator<Cliente> {
    @Override
    public int compare(Cliente o1, Cliente o2) {
        if(o1.equals(o2)) return 0;
        else return (int)(o1.getNif() - o2.getNif());
    }
}
 