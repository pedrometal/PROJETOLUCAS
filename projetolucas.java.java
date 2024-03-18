import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concessionaria concessionaria = new Concessionaria();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar carro");
            System.out.println("2. Remover carro");
            System.out.println("3. Consultar carro");
            System.out.println("4. Atualizar carro");
            System.out.println("5. Exibir estoque");
            System.out.println("6. Sair");

            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Modelo do carro: ");
                    String modeloAdicionar = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadeAdicionar = scanner.nextInt();
                    System.out.print("Preço: ");
                    double precoAdicionar = scanner.nextDouble();
                    concessionaria.adicionarCarro(new Carro(modeloAdicionar, quantidadeAdicionar, precoAdicionar));
                    break;
                case 2:
                    System.out.print("Modelo do carro: ");
                    String modeloRemover = scanner.nextLine();
                    if (concessionaria.removerCarro(modeloRemover)) {
                        System.out.println("Carro removido.");
                    } else {
                        System.out.println("Carro não encontrado na concessionária.");
                    }
                    break;
                case 3:
                    System.out.print("Modelo do carro: ");
                    String modeloConsultar = scanner.nextLine();
                    Carro carroConsultado = concessionaria.consultarCarro(modeloConsultar);
                    if (carroConsultado != null) {
                        System.out.println("Modelo: " + carroConsultado.getModelo() + ", Quantidade: " + carroConsultado.getQuantidade() + ", Preço: " + carroConsultado.getPreco());
                    } else {
                        System.out.println("Carro não encontrado na concessionária.");
                    }
                    break;
                case 4:
                    System.out.print("Modelo do carro: ");
                    String modeloAtualizar = scanner.nextLine();
                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    if (concessionaria.atualizarCarro(modeloAtualizar, novaQuantidade, novoPreco)) {
                        System.out.println("Carro atualizado.");
                    } else {
                        System.out.println("Carro não encontrado na concessionária.");
                    }
                    break;
                case 5:
                    concessionaria.exibirEstoque();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

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

class Concessionaria {
    private ArrayList<Carro> carros;

    public Concessionaria() {
        this.carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    public boolean removerCarro(String modelo) {
        for (Carro carro : carros) {
            if (carro.getModelo().equalsIgnoreCase(modelo)) {
                carros.remove(carro);
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