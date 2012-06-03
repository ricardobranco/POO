/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JTransitarios;

import javax.swing.JTable;

public class JCustomTable extends JTable{
    @Override
    public boolean isCellEditable(int row, int column) {
	/*
	 * isto faz com que nunca se possa alterar as células de uma CustomJTable
	 */
	return false;
    }
}
