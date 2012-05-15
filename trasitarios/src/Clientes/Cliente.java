package Clientes;

import Servicos.Servico;
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
}
