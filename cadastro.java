//Definindo a classe Veiculo
class Veiculo {
    String marca;
    String modelo;
    int ano;

//Atribuindo atributos a classe Veiculo. (marca, modelo, ano)
    public Veiculo(String marca, String modelo, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

//Funcao para verificar se o veiculo paga IPVA (ate 20 anos)
    public int calcularIdade(int anoAtual){
        return anoAtual - ano;
    }

    public boolean pagarIPVA(){
        return calcularIdade(2023) <= 20;
    }
}