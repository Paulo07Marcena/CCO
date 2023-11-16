package pkg;

import java.util.ArrayList;
import java.util.List;

public class Carrinho  {

    private List<Vendavel> cart;

    public Carrinho() {
        this.cart = new ArrayList<>();
    }

    public void adicionarVendavel(Vendavel t){
        cart.add(t);
    }

    public double calculaTotalVenda(){
        Double valor = 0.0;

        for (int i = 0; i < cart.size(); i++) {
            valor = valor + cart.get(i).getValorVenda();
        }

        return valor;
    }

    public void exibirItensCarrinho(){
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).toString());
            System.out.println("\n");
        }
    }
}
