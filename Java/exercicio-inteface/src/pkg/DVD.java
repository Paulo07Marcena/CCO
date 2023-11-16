package pkg;

public class DVD extends Produto{

    private String nome;
    private String gravadora;

    public DVD(int codigo, Double precoCusto, String nome, String gravadora) {
        super(codigo, precoCusto);
        this.nome = nome;
        this.gravadora = gravadora;
    }

    public Double getValorVenda(){
        return getPrecoCusto() * 1.20;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    @Override
    public String toString() {
        return "DVD:\n" +
                "Nome:" + nome + '\n' +
                "Gravadora:" + gravadora + '\n' +
                super.toString();
    }
}
