package Servicos;

import java.util.GregorianCalendar;

public class Servico {
    GregorianCalendar data;
    String maricula;
    String tipoTransporte; //daqueles dos produtos comerciais
    double custo;
    
    Servico(){
        this.data = new GregorianCalendar();
        this.maricula = "";
        this.tipoTransporte = "";
        this.custo = 0;
    }
    
    public Servico(String maricula, String tipoTransporte, double custo) {
        this.data = new GregorianCalendar();
        this.maricula = maricula;
        this.tipoTransporte = tipoTransporte;
        this.custo = custo;
    }

    public double getCusto() {
        return custo;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public String getMaricula() {
        return maricula;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }
}
