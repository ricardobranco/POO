/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Cargas.Carga;
import Cargas.NaoRefrigerados;
import Clientes.SClientes;
import Servicos.Servico;
import Veiculos.SVeiculos;
import Veiculos.Veiculo;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

/**
 *
 * @author Ricardo
 */
public class Sistema extends Observable implements Serializable {

    private SClientes clientes;
    private SVeiculos veiculos;

    public Sistema() {
        this.clientes = new SClientes();
        this.veiculos = new SVeiculos();
    }

    public Sistema(Observer o)
    {
        this.clientes = new SClientes();
        this.veiculos = new SVeiculos();
        addObserver(o);
    }
    public Sistema(SClientes clientes, SVeiculos veiculos) {
        this.clientes = clientes;
        this.veiculos = veiculos;
    }

    public Sistema(Sistema s) {
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

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        Sistema s = (Sistema) o;
        return s.getClientes().equals(this.clientes) && s.getVeiculos().equals(this.veiculos);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.clientes.toString()).append("\n");
        sb.append(this.veiculos.toString()).append("\n");
        return sb.toString();
    }

    public void save(String path) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.veiculos);
        oos.writeObject(this.clientes);

        oos.close();
        fos.close();
    }

    public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        this.veiculos = (SVeiculos) ois.readObject();
        this.clientes = (SClientes) ois.readObject();

        ois.close();
        fis.close();
    }

    public boolean criaPedido(Servico s, List<Carga> lcarga) { //O SERVIÇO E A LISTA DE CARGAS SÃO COMPATIVEIS

        //ORDENAR CARGA
        TreeSet<Carga> scarga = new TreeSet<Carga>();
        for (Carga c : lcarga) {
            scarga.add(c);
        }

        Iterator<Carga> icarga = scarga.iterator();

        //ENQUANTO HOUVER CARGA

        while (icarga.hasNext()) {

            Carga c = icarga.next();



            Class[] interfaces = c.getClass().getInterfaces();

            boolean flag = true;
            for (int i = 0; i < interfaces.length && flag; i++) {

                if (interfaces[i].getSimpleName().equals("NaoRefrigerados")) {
                    flag = false;


                    NaoRefrigerados nr = (NaoRefrigerados) c;


                    if (nr.eObrigatorio()) //POR EXEMPLO ESTAMOS PERANTE UMA CARGA PERECIVEL OU SEMELHANTE
                    {
                        SVeiculos svec1 = new SVeiculos(this.veiculos.naoRefrigerados());
                        SVeiculos svec2 = new SVeiculos(svec1.parados());
                        Iterator<Veiculo> ivec = svec2.sortLivre();

                        while (ivec.hasNext()) {
                            boolean flag2 = true;
                            for (Veiculo v : s.getVeiculos().getCVeiculos()) {
                                if (v.addCarga(c)) {
                                    this.veiculos.remove(v);
                                    this.veiculos.addVeiculo(v);

                                    if (v.mais60()) {
                                        this.veiculos.alteraEstado(v);
                                    }

                                    flag2 = false;
                                    break;
                                }

                            }
                            if (flag2) //nenhum dos veiculos aconcelhados para o serviço podem levar a carga
                            {
                                Veiculo v = ivec.next();
                                if (v.addCarga(c)) {
                                    s.addVeiculo(v);
                                    this.veiculos.remove(v);
                                    this.veiculos.addVeiculo(v);

                                    if (v.mais60()) {
                                        this.veiculos.alteraEstado(v);
                                    }
                                }
                            }


                            break;
                        }
                    } else {
                        SVeiculos svec1 = new SVeiculos(this.veiculos.parados());
                        Iterator<Veiculo> ivec = svec1.sortLivre();

                        while (ivec.hasNext()) {
                            boolean flag2 = true;

                            for (Veiculo v : s.getVeiculos().getCVeiculos()) {
                                if (v.addCarga(c)) {
                                    this.veiculos.remove(v);
                                    this.veiculos.addVeiculo(v);

                                    if (v.mais60()) {
                                        this.veiculos.alteraEstado(v);
                                    }
                                    flag2 = true;
                                    break;
                                }

                            }

                            if (flag2) //nenhum dos veiculos aconcelhados para o serviço podem levar a carga
                            {
                                Veiculo v = ivec.next();
                                if (v.addCarga(c)) {
                                    s.addVeiculo(v);
                                    this.veiculos.remove(v);
                                    this.veiculos.addVeiculo(v);

                                    if (v.mais60()) {
                                        this.veiculos.alteraEstado(v);
                                    }
                                }
                            }


                            break;
                        }
                    }
                }
            }
            if (flag) //NAO DESCOBRIU A INTERFACE PRETENDIDA LOGO É UMA CARGA REFRIGERADA
            {
                SVeiculos svec1 = new SVeiculos(this.veiculos.refrigerados());
                SVeiculos svec2 = new SVeiculos(svec1.parados());
                Iterator<Veiculo> ivec = svec2.sortLivre();

                while (ivec.hasNext()) {

                    boolean flag2 = true;
                    for (Veiculo v : s.getVeiculos().getCVeiculos()) {
                        if (v.addCarga(c)) {
                            this.veiculos.remove(v);
                            this.veiculos.addVeiculo(v);

                            if (v.mais60()) {
                                this.veiculos.alteraEstado(v);
                            }
                            flag2 = false;
                            break;
                        }
                    }



                    break;
                }
            } else {
                return false; //A CARGA NAO PODE SER TRANSPORTADA
            }
        }

        return true;
    }
}
