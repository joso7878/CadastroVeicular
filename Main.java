//importando Libs nescessarias
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//criando nosso executavel
public class Main {
//Criando a lista de veiculos
    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        //Funcao para pegar o inPut do usuario no terminal
        char opcao = ' ';
        while (opcao != 'd') {
            System.out.println("Escolha uma opção:");
            System.out.println("a) Cadastrar veículo");
            System.out.println("b) Listar veículos cadastrados");
            System.out.println("c) Remover veículo");
            System.out.println("d) Sair");
            opcao = scanner.next().charAt(0);
            //Enquato a opcao for diferente de D ele entre no While, ou de for igual sai
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
//Funcao para cadastrar o veiculo e seus dados, usando add para adicionar os parametros (marca, modelo, ano) na lista (Veiculo)
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
//Usando for para acessar a lista e monstrando ao usuario os veiculos cadastrados
//Definindo uma variavel inteira anoAtual para calcular se o veiculo paga ou nao IPVA
    public static void listarVeiculos(List<Veiculo> veiculos) {
        int anoAtual = 2023;
        for (Veiculo veiculo : veiculos) {
            int idade = anoAtual - veiculo.getAno();
            String ipva = idade > 5 ? "Isento de IPVA" : "Paga IPVA";
            System.out.println("Marca: " + veiculo.getMarca() + " | Modelo: " + veiculo.getModelo() +
                               " | Idade: " + idade + " anos | IPVA: " + ipva);
        }
    }
//Usa metodo remove passando o indice dado pelo usuario para remover o respectivo veiculo da lista
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
//Instanciando a classe dos objetos
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
