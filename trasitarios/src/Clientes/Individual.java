package Clientes;

import Servicos.Servico;
import java.util.LinkedList;

public class Individual extends Cliente {
    
    
    public Individual() {
        super();
    }
    
    public Individual(String nome, String morada, long nif, LinkedList<Servico> servicos) {
        super(nome, morada, nif, servicos);
    }

    public Individual(String nome, String morada, long nif) {
        super(nome, morada, nif);
    }
    
    public Individual(Individual i) {
        super(i);
    }

    @Override
    public Individual clone() {return new Individual(this);}

    
    
}
