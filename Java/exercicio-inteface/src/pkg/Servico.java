package pkg;

public class Servico implements  Vendavel{

    private String descricao;
    private int codigo;
    private int quantHoras;
    private Double valorHora;

    public Servico(String descricao, int codigo, int quantHoras, Double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantHoras = quantHoras;
        this.valorHora = valorHora;
    }

    public Double getValorVenda(){
        return getValorHora() * getQuantHoras();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantHoras() {
        return quantHoras;
    }

    public void setQuantHoras(int quantHoras) {
        this.quantHoras = quantHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "Servico: \n" +
                "Descrição: " + descricao + '\n' +
                "Código: " + codigo + '\n' +
                "Quantidade de horas: " + quantHoras + "\n" +
                "Valor por hora: " + valorHora +
                "Valor de venda: " + getValorVenda();
    }
}
