package Clientes;

import Servicos.Servico;
import java.util.LinkedList;

public class Empresarial extends Cliente {
    String nomeEmpresa;
    
    private void construtor_auxiliar(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;
    }
    
    public Empresarial(String nome, String morada, String nif, String nomeEmpresa, LinkedList<Servico> servicos) {
        super(nome, morada, nif, servicos);
        construtor_auxiliar(nomeEmpresa);
    }

    public Empresarial(String nome, String morada, String nif, String nomeEmpresa) {
        super(nome, morada, nif);
    }

    public Empresarial() {
    }
    
    
}
