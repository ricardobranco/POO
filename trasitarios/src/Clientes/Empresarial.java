package Clientes;

import Servicos.Servico;
import java.util.LinkedList;

public class Empresarial extends Cliente {
    String nomeEmpresa;
    
    
    
    public Empresarial() {
    }
    
    public Empresarial(String nome, String morada, long nif, String nomeEmpresa, LinkedList<Servico> servicos) {
        super(nome, morada, nif, servicos);
        construtor_auxiliar(nomeEmpresa);
    }

    public Empresarial(String nome, String morada, long nif, String nomeEmpresa) {
        super(nome, morada, nif);
        construtor_auxiliar(nomeEmpresa);
    }
    
    public Empresarial(Empresarial e)
    {
        super(e);
        this.nomeEmpresa = e.getEmpresa();
    }

    private void construtor_auxiliar(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;
    }
    
    public String getEmpresa(){return this.nomeEmpresa;}
    
    @Override
    public Empresarial clone(){return new Empresarial(this);}
    
    
}
