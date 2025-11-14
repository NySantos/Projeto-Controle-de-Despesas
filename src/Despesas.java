public class Despesas {
    private String descricao;
    private String categoria;
    private double valor;

    public Despesas(String descricao, String categoria, double valor){
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;

    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return getDescricao() + ", " + getCategoria() +", " + String.format("%.2f", getValor());
    }
}
