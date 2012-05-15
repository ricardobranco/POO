package Clientes;

import Servicos.Servico;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class Cliente {
    String nome;
    String morada;
    String nif; //numero de contribuinte
    LinkedList<Servico> servicos; //serviços, adicionar sempre à cabeça
    

    public Cliente() {
    }

    public Cliente(String nome, String morada, String nif) {
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
    }

    public Cliente(String nome, String morada, String nif, LinkedList<Servico> servicos) {
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.servicos = new LinkedList<>();
    }

    public String getMorada() {
        return morada;
    }

    public String getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<Servico> getServicos() {
        LinkedList<Servico> ret = new LinkedList<Servico>();
        Servico srv;
        for( Iterator i = ret.descendingIterator(); i.hasNext(); ){
            srv = (Servico)i.next();
            ret.push(srv.clone());
        }
        return ret;
    }
    
    public void addServico( Servico s ){
        this.servicos.push(s.clone());
    }
    
    public String toStringServicos(){
        StringBuilder str = new StringBuilder();
        for( Servico s : this.servicos ){
            str.append(s.toString()).append("\n");
        }
        return str.toString();
    }
}
