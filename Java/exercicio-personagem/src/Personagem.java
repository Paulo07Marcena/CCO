import java.util.ArrayList;
import java.util.List;

public abstract class Personagem{

    private String nome;
    private String codinome;
    private List<SuperPoder> poderes;

    public Personagem(String nome, String codinome) {
        this.nome = nome;
        this.codinome = codinome;
        this.poderes = new ArrayList<>();
    }

    public Personagem(String nome) {
        this.nome = nome;
        this.poderes = new ArrayList<>();
    }

    public void adicionarPoder(String nome, Integer  categoria){
        SuperPoder novoPoder = new SuperPoder(nome, categoria);
        poderes.add(novoPoder);
    }

    public abstract Double getForcaTotal();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodinome() {
        return codinome;
    }

    public void setCodinome(String codinome) {
        this.codinome = codinome;
    }

    public List<SuperPoder> getPoderes() {
        return poderes;
    }

    public void setPoderes(List<SuperPoder> poderes) {
        this.poderes = poderes;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", codinome='" + codinome + '\'' +
                ", poderes=" + poderes +
                '}';
    }
}
