package Clientes;

import Servicos.Servico;
import java.util.LinkedList;

public class Individual extends Cliente {
    public Individual(String nome, String morada, String nif, LinkedList<Servico> servicos) {
        super(nome, morada, nif, servicos);
    }

    public Individual(String nome, String morada, String nif) {
        super(nome, morada, nif);
    }

    public Individual() {
    }
    
}
