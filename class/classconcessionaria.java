class Concessionaria {
    private ArrayList<Carro> carros;

    public Concessionaria() {
        this.carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    public boolean removerCarro(String modelo) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getModelo().equalsIgnoreCase(modelo)) {
                carros.remove(i);
                return true;
            }
        }
        return false;
    }

    public Carro consultarCarro(String modelo) {
        for (Carro carro : carros) {
            if (carro.getModelo().equalsIgnoreCase(modelo)) {
                return carro;
            }
        }
        return null;
    }

    public boolean atualizarCarro(String modelo, int quantidade, double preco) {
        for (Carro carro : carros) {
            if (carro.getModelo().equalsIgnoreCase(modelo)) {
                carro.setQuantidade(quantidade);
                carro.setPreco(preco);
                return true;
            }
        }
        return false;
    }

    public void exibirEstoque() {
        if (carros.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            System.out.println("Estoque da concessionária:");
            for (Carro carro : carros) {
                System.out.println("Modelo: " + carro.getModelo() + ", Quantidade: " + carro.getQuantidade() + ", Preço: " + carro.getPreco());
            }
        }
    }
}