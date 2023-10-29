public class Heroi extends Personagem {

    public Heroi(String nome, String codinome) {
        super(nome, codinome);
    }

    public Heroi(String nome) {
        super(nome);
    }

    @Override
    public Double getForcaTotal() {
        Double forcaTotal = 0.0;

        for (int i = 0; i < getPoderes().size(); i++) {
            forcaTotal = forcaTotal + getPoderes().get(i).getCategoria();

        }

        return forcaTotal * 1.15;
    }

}
