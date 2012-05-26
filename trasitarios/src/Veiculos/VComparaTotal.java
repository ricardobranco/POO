
package Veiculos;

import java.util.Comparator;

public class VComparaTotal implements Comparator<Veiculo> {

   
    public int compare(Veiculo o1, Veiculo o2) {
        Double d1 = new Double(o1.getTotal());
        Double d2 = new Double(o2.getTotal());
        if(o1.equals(o2)) return 0;
        else if (d1.compareTo(d2) > 0)
            return 1;
        else return -1;
    }
}