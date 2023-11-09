public abstract class Produto {

    private String id;
    private  String nome;
    private  Double precoBase;

    public abstract  Double calcularImposto();

    public Produto(){}
    public Produto(String id, String nome, Double precoBase) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    @Override
    public String toString() {
        return "Produto:\n" +
                "ID: " + id +
                "\nNome: " + nome +
                "\nPreço Base: " + precoBase +
                "\nCalcular imposto: " + calcularImposto()
                ;
    }
}
