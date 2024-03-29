package Sistema;

import Cargas.Carga;
import Cargas.NaoRefrigerados;
import Clientes.Cliente;
import Clientes.Empresarial;
import Clientes.Individual;
import Clientes.SClientes;
import Servicos.Servico;
import Veiculos.*;
import java.io.*;
import java.util.*;
import Veiculos.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sistema extends Observable implements Serializable {

    private SClientes clientes;
    private SVeiculos veiculos;

    public Sistema() {
        this.clientes = new SClientes();
        this.veiculos = new SVeiculos();
    }

    public Sistema(Observer o) {
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
        oos.writeObject(new Double(Furgao.getPBase()));
        oos.writeObject(new Double(Camiao.getPBase()));
        oos.writeObject(new Double(Van.getPBase()));


        oos.close();
        fos.close();
    }

    public void load(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        this.veiculos = (SVeiculos) ois.readObject();
        this.clientes = (SClientes) ois.readObject();
        Furgao.setPBase(((Double) ois.readObject()).doubleValue());
        Camiao.setPBase(((Double) ois.readObject()).doubleValue());
        Van.setPBase(((Double) ois.readObject()).doubleValue());


        ois.close();
        fis.close();
    }

    private void criaaux(Carga c, Veiculo v) {

        v.incTotal(c.getCarga());
        this.veiculos.remove(v);
        this.veiculos.addVeiculo(v);

        if (v.mais60()) {
            this.veiculos.alteraEstado(v);
        }

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
                        boolean mkbreak = true;
                        while (ivec.hasNext()) {
                            boolean flag2 = true;
                            for (Veiculo v : s.getVeiculos().getCVeiculos()) {
                                if (v.addCarga(c)) {
                                    this.criaaux(c, v);
                                    mkbreak = false;
                                    flag2 = false;
                                    break;
                                }
                            }

                            if (flag2) //nenhum dos veiculos aconcelhados para o serviço podem levar a carga
                            {
                                Veiculo v = ivec.next();
                                s.addVeiculo(v);
                                if (v.addCarga(c)) {
                                    mkbreak = false;
                                    this.criaaux(c, v);
                                    s.addVeiculo(v);
                                    break;
                                }

                            }

                        }
                        if (mkbreak) {
                            return false;
                        }

                    } else {

                        SVeiculos svec1 = new SVeiculos(this.veiculos.parados());
                        Iterator<Veiculo> ivec = svec1.sortLivre();
                        boolean mkbreak = true;
                        while (ivec.hasNext()) {
                            boolean flag2 = true;

                            for (Veiculo v : s.getVeiculos().getCVeiculos()) {
                                if (v.addCarga(c)) {
                                    flag2 = false;
                                    mkbreak = false;
                                    this.criaaux(c, v);
                                    break;
                                }

                            }

                            if (flag2) //nenhum dos veiculos aconcelhados para o serviço podem levar a carga
                            {
                                Veiculo v = ivec.next();
                                s.addVeiculo(v);
                                if (v.addCarga(c)) {

                                    this.criaaux(c, v);
                                    mkbreak = false;
                                    mkbreak = false;
                                    break;
                                }

                            }
                        }

                        if (mkbreak) {
                            return false;
                        }
                    }
                    break;
                }
            }

            if (flag) //NAO DESCOBRIU A INTERFACE PRETENDIDA LOGO É UMA CARGA REFRIGERADA
            {
                SVeiculos svec1 = new SVeiculos(this.veiculos.refrigerados());
                SVeiculos svec2 = new SVeiculos(svec1.parados());
                Iterator<Veiculo> ivec = svec2.sortLivre();
                boolean mkbreak = true;
                while (ivec.hasNext()) {

                    boolean flag2 = true;
                    for (Veiculo v : s.getVeiculos().getCVeiculos()) {
                        if (v.addCarga(c)) {
                            this.criaaux(c, v);

                            mkbreak = false;
                            flag2 = false;
                            break;
                        }

                    }

                    if (flag2) //nenhum dos veiculos aconcelhados para o serviço podem levar a carga
                    {
                        Veiculo v = ivec.next();
                        s.addVeiculo(v);
                        if (v.addCarga(c)) {

                            mkbreak = false;
                            s.addVeiculo(v);
                            this.criaaux(c, v);
                            break;
                        }

                    }
                }
                if (mkbreak) {
                    return false;
                }

            }
        }

        s.setCargas(lcarga);
        return true;
    }

    public void leFileClientesa(String filepath) {

        try {
            FileInputStream fstream = new FileInputStream(filepath);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            String delimiter = ":";

            while ((strLine = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(strLine, delimiter);
                while (tokens.hasMoreTokens()) {
                    Long nif = Long.parseLong(tokens.nextToken());
                    String nome = new String(tokens.nextToken());
                    String morada = new String(tokens.nextToken());
                    Cliente c = new Individual(nome, morada, nif);
                    this.clientes.addCliente(c);

                    // Meter metodo de inserçao no TreeMap 
                }
            }

            in.close();


        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void leFileClientesb(String filepath) {

        try {
            FileInputStream fstream = new FileInputStream(filepath);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            String delimiter = ";";

            while ((strLine = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(strLine, delimiter);
                while (tokens.hasMoreTokens()) {
                    Long nif = Long.parseLong(tokens.nextToken());
                    String nome = new String(tokens.nextToken());
                    String morada = new String(tokens.nextToken());
                    String emp = new String(tokens.nextToken());
                    Cliente c = new Empresarial(nome, morada, nif, emp);
                    this.clientes.addCliente(c);

                    // Meter metodo de inserçao no TreeMap 
                }
            }


            in.close();
        } catch (Exception e) {
            System.err.println("Error: "
                    + e.getMessage());
        }
    }

    public void leVan(String filepath) {
        try {
            FileInputStream fstream = new FileInputStream(filepath);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            String delimiter = ":";

            while ((strLine = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(strLine, delimiter);
                while (tokens.hasMoreTokens()) {
                    String marca = new String(tokens.nextToken());
                    String matricula = new String(tokens.nextToken());
                    Double custoKm =
                            Double.parseDouble(tokens.nextToken());
                    Double capacidade =
                            Double.parseDouble(tokens.nextToken());
                    Van inserirVan = new Van(marca, matricula, custoKm, capacidade);
                    this.veiculos.addVeiculo(inserirVan);
                }
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: "
                    + e.getMessage());
        }
    }

    public void leNRFurgao(String filepath) {
        try {
            FileInputStream fstream =
                    new FileInputStream(filepath);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            String delimiter = ":";

            while ((strLine = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(strLine, delimiter);
                while (tokens.hasMoreTokens()) {
                    String marca = new String(tokens.nextToken());
                    String matricula = new String(tokens.nextToken());
                    Double custoKm =
                            Double.parseDouble(tokens.nextToken());
                    Double capacidade =
                            Double.parseDouble(tokens.nextToken());
                    String combustivel = new String(tokens.nextToken());
                    Double autonomia =
                            Double.parseDouble(tokens.nextToken());
                    Veiculo inserirNRFurgao = new NRFurgao(marca, matricula, combustivel, autonomia, custoKm, capacidade);

                    this.veiculos.addVeiculo(inserirNRFurgao);
                }
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: "
                    + e.getMessage());
        }
    }

    public void leRFurgao(String filepath) {
        try {
            FileInputStream fstream =
                    new FileInputStream(filepath);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            String delimiter = ":";

            while ((strLine = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(strLine, delimiter);
                while (tokens.hasMoreTokens()) {
                    String marca = new String(tokens.nextToken());
                    String matricula = new String(tokens.nextToken());
                    Double custoKm =
                            Double.parseDouble(tokens.nextToken());
                    Double capacidade =
                            Double.parseDouble(tokens.nextToken());
                    String combustivel = new String(tokens.nextToken());
                    Double autonomia =
                            Double.parseDouble(tokens.nextToken());
                    Veiculo inserirRFurgao = new RFurgao(marca, matricula, combustivel, autonomia, custoKm, capacidade);
                    // Meter metodo de inserÃ§ao no TreeMap
                    this.veiculos.addVeiculo(inserirRFurgao);
                }
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: "
                    + e.getMessage());
        }
    }

    public void leCamiao(String filepath) {
        try {
            FileInputStream fstream =
                    new FileInputStream(filepath);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            String delimiter = ":";
            Camiao inserirCamiao;

            while ((strLine = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(strLine, delimiter);
                while (tokens.hasMoreTokens()) {
                    String marca = new String(tokens.nextToken());
                    String matricula = new String(tokens.nextToken());
                    Double custoKm =
                            Double.parseDouble(tokens.nextToken());
                    Double capacidade =
                            Double.parseDouble(tokens.nextToken());
                    String condutor = new String(tokens.nextToken());
                    String atrelado = new String(tokens.nextToken());
                    Double altura =
                            Double.parseDouble(tokens.nextToken());

                    if (atrelado.equals("v")) {
                        inserirCamiao = new Camiao(marca, matricula, condutor, altura, custoKm, capacidade, true);
                    } else {
                        inserirCamiao = new Camiao(marca, matricula, condutor, altura, custoKm,
                                capacidade, false); // Meter metodo de inserÃ§ao no TreeMap
                    }
                    this.veiculos.addVeiculo(inserirCamiao);
                }
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: "
                    + e.getMessage());
        }
    }
}
