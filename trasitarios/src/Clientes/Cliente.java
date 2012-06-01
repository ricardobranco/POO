package Clientes;

import Servicos.Servico;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Cliente implements Serializable,Comparable<Cliente> {
    String nome;
    String morada;
    long nif; //numero de contribuinte
    LinkedList<Servico> servicos; //serviços, adicionar sempre à cabeça
    
    public Cliente() {
    }

    public Cliente(String nome, String morada, long nif) {
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.servicos = new LinkedList<Servico>();
    }

    public Cliente(String nome, String morada, long nif, List<Servico> servicos) {
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.setServicos(servicos);
    }
    
    public Cliente(Cliente c)
    {
        this.nome = c.getNome();
        this.nif = c.getNif();
        this.morada = c.getMorada();
        this.setServicos(c.getServicos());
    }

    public String getMorada() {
        return morada;
    }

    public long getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public List<Servico> getServicos() {
        LinkedList<Servico> ret = new LinkedList<Servico>();
        Servico srv;
        for( Iterator i = this.servicos.descendingIterator(); i.hasNext(); ){
            srv = (Servico)i.next();
            ret.push(srv.clone());
        }
        return ret;
    }
    
    public void setNif(long nif){this.nif = nif;}
    public void setNome(String nome){this.nome = nome;}
    public void setMorada(String morada){this.morada = morada;}
    
    
    private void setServicos(List<Servico> servicos) {
        this.servicos = new LinkedList<Servico>();
        for( Iterator i = ((LinkedList<Servico>) servicos).descendingIterator(); i.hasNext(); ){
            Servico srv = (Servico) i.next();
            this.servicos.push(srv);
        }
    }
    
    public void addServico( Servico s ){
        this.servicos.push(s);
    }
    
    
    
    
    public String toStringServicos(){
        StringBuilder str = new StringBuilder();
        for( Servico s : this.servicos ){
            str.append(s.toString()).append("\n");
        }
        return str.toString();
    }
    
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("NIF: ").append(this.nif).append("\n");
        sb.append("NOME: ").append(this.nome).append("\n");
        sb.append("MORADA: ").append(this.morada).append("\n");
        sb.append("TIPO: ").append(this.getClass().getName()).append("\n");
        sb.append("PEDIDOS: ").append(this.toStringServicos()).append("\n");
    
        return sb.toString();
    }
    
    
    @Override
    public boolean equals(Object o){
        if(o==this)
            return true;
        if((o==null)||(o.getClass() != this.getClass()))
            return false;
        
        Cliente c = (Cliente) o;
        return this.nif == c.getNif();
    }
    
    
    @Override
    public int compareTo(Cliente c)
    {
        if (this.nif == c.getNif())
            return 0;
        if (this.nif > c.getNif())
            return 1;
        else
            return -1;       
    }
    
    public abstract Cliente clone();

    
    
}
