package Servicos;

import java.util.GregorianCalendar;

public class Servico {
    GregorianCalendar data;
    String matricula;
    String tipoTransporte; //daqueles dos produtos comerciais
    double custo;
    
    Servico(){
        this.data = new GregorianCalendar();
        this.matricula = "";
        this.tipoTransporte = "";
        this.custo = 0;
    }
    
    public Servico(String maricula, String tipoTransporte, double custo) {
        this.data = new GregorianCalendar();
        this.matricula = maricula;
        this.tipoTransporte = tipoTransporte;
        this.custo = custo;
    }
    
    public Servico(Servico outroServico){
        this.data = (GregorianCalendar) outroServico.getData().clone();
        this.matricula = outroServico.getMaricula();
        this.tipoTransporte = outroServico.getTipoTransporte();
        this.custo = outroServico.getCusto();
    }

    public double getCusto() {
        return custo;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public String getMaricula() {
        return matricula;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }
    
    @Override
    public Servico clone(){
        return new Servico(this);
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Data: ")
                .append(this.getData().get(GregorianCalendar.YEAR))
                .append("/")
                .append(this.getData().get(GregorianCalendar.MONTH))
                .append("/")
                .append(this.getData().get(GregorianCalendar.DAY_OF_MONTH))
                .append(" ")
                .append(this.getData().get(GregorianCalendar.HOUR_OF_DAY))
                .append(":")
                .append(this.getData().get(GregorianCalendar.MINUTE))
                .append(":")
                .append(this.getData().get(GregorianCalendar.SECOND))
                .append("; Tipo de Transporte: ")
                .append(this.tipoTransporte)
                .append("; Matrícula: ")
                .append(this.matricula)
                .append("; Custo: ")
                .append(this.custo);
        
        return str.toString();
    }
}
