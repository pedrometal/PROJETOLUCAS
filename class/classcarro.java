class Carro {
    private String modelo;
    private int quantidade;
    private double preco;

    public Carro(String modelo, int quantidade, double preco) {
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
