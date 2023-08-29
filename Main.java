import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        char opcao = ' ';
        while (opcao != 'd') {
            System.out.println("Escolha uma opção:");
            System.out.println("a) Cadastrar veículo");
            System.out.println("b) Listar veículos cadastrados");
            System.out.println("c) Remover veículo");
            System.out.println("d) Sair");
            opcao = scanner.next().charAt(0);
            
            if (opcao == 'a') {
                cadastrarVeiculo(veiculos, scanner);
            } else if (opcao == 'b') {
                listarVeiculos(veiculos);
            } else if (opcao == 'c') {
                removerVeiculo(veiculos, scanner);
            } else if (opcao == 'd') {
                System.out.println("Encerrando o programa.");
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    public static void cadastrarVeiculo(List<Veiculo> veiculos, Scanner scanner) {
        System.out.println("Informe a marca do veículo:");
        String marca = scanner.next();
        System.out.println("Informe o modelo do veículo:");
        String modelo = scanner.next();
        System.out.println("Informe o ano do veículo:");
        int ano = scanner.nextInt();
        
        veiculos.add(new Veiculo(marca, modelo, ano));
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public static void listarVeiculos(List<Veiculo> veiculos) {
        int anoAtual = 2023;
        for (Veiculo veiculo : veiculos) {
            int idade = anoAtual - veiculo.getAno();
            String ipva = idade > 5 ? "Isento de IPVA" : "Paga IPVA";
            System.out.println("Marca: " + veiculo.getMarca() + " | Modelo: " + veiculo.getModelo() +
                               " | Idade: " + idade + " anos | IPVA: " + ipva);
        }
    }

    public static void removerVeiculo(List<Veiculo> veiculos, Scanner scanner) {
        System.out.println("Informe o índice do veículo que deseja remover:");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < veiculos.size()) {
            Veiculo removido = veiculos.remove(indice);
            System.out.println("Veículo removido: " + removido.getMarca() + " " + removido.getModelo());
        } else {
            System.out.println("Índice inválido.");
        }
    }
}

class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }
}
