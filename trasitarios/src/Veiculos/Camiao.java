package Veiculos;

public class Camiao extends Veiculo{
    private String condutor;
    private boolean atrelado;
    private double altura;
    
    private void construtor_auxiliar(String condutor, boolean atrelado, double altura){
        this.condutor = condutor;
        this.atrelado = atrelado;
        this.altura = altura;
    }
    
    public Camiao(){
        super();
        construtor_auxiliar("", false, 0);
    }
    
    public Camiao(String marca, String matricula, String condutor, double altura, double custoKm, double desgaste, double carga,boolean atrelado){
        super(marca,matricula,custoKm,desgaste,carga,false);
        construtor_auxiliar(condutor, atrelado, altura);
    }
    
    public Camiao(Camiao c){
        super(c);
        construtor_auxiliar(c.getCondutor(), c.getAtrelado(), c.getAltura());
    }
    
    public double getAltura(){return this.altura;}
    public boolean getAtrelado(){return this.atrelado;}
    public String getCondutor(){return this.condutor;}
    
    public void setAtrelado(boolean atrelado){this.atrelado = atrelado;}
    public void setCondutor(String condutor){this.condutor = condutor;}
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Condutor: ").append(this.condutor).append("\n");
        sb.append("Atrelado: ").append(this.atrelado).append("\n");
        sb.append("Altura: ").append(this.altura).append("\n");
        return sb.toString();      
    }
    
    @Override
    public Camiao clone(){return new Camiao(this);}
}