package pkg;

public class Livro extends Produto {

    private String nome;
    private String autor;
    private String isbn;

    public Livro(int codigo, Double precoCusto, String nome, String autor, String isbn) {
        super(codigo, precoCusto);
        this.nome = nome;
        this.autor = autor;
        this.isbn = isbn;
    }

    public Double getValorVenda(){
        return getPrecoCusto() * 1.10;
    }

    @Override
    public String toString() {
        return "Livro: \n" +
                "Nome: " + nome + '\n' +
                "Autor: " + autor + '\n' +
                "Is bn: " + isbn + '\n' +
                super.toString();
    }
}
