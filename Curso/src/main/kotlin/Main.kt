fun main() {
    println("Bem vindo ao seu banco")

//    ctrl + botão / para remover ou adicionar comentarios nas linhas

    val contaJorge = Conta("Jorge", 1000) //Instancia os atributos da classe Conta em uma variavel não mutavel
    contaJorge.deposita(1000.0)


    val contaRoberto = Conta("Roberto", 2000) //Instancia os atributos da classe Conta em uma variavel não mutavel
    contaRoberto.deposita(100.0)

    println("Titular da conta ${contaJorge.titular}")
    println("Numero da conta ${contaJorge.numeroConta}")
    println("Saldo da conta ${contaJorge.saldo}")
    println("////////////////////////")
    println("Titular da conta ${contaRoberto.titular}")
    println("Numero da conta ${contaRoberto.numeroConta}")
    println("Saldo da conta ${contaRoberto.saldo}")

//    //teste de deposito
//    println("Depositando na conta do Jorge")
//    contaJorge.deposita(1000.0)
//    println("Valor após o deposito ${contaJorge.saldo}")
//
//    //teste de saque
//    println("Sacando da conta do Jorge")
//    contaJorge.saca(100.0)
//    println("Valor final ${contaJorge.saldo}")
//
//    teste de saque acima do valor da conta
//    contaJorge.saca(5000.0)
//    println("Valor final ${contaJorge.saldo}")
//
//    //teste de transferencia para a conta do roberto
//    println("Transferencia da conta do Jorge para a conta do Roberto")
//
//    if(contaJorge.transfere(100.0, contaRoberto)){
//        println("Transferencia concluida")
//    }else{
//        println("Erro ao transferir")
//    }
//    println("Valor final do Jorge ${contaJorge.saldo}")
//    println("Valor final do Roberto ${contaRoberto.saldo}")
}

//Criando a classe conta
//variaveis como val não serão alteradas na classe
//variaveis como var serão como o saldo por exemplo
class Conta(var titular: String,
            val numeroConta: Int
) {

    var saldo = 0.0
        private set

//    //Construtor para permitir criar conta somente se possuir titular e numero dac onta
//    constructor(titular: String, numero: Int){
//        this.titular = titular
//        this.numeroConta = numeroConta
//    }

    //Função de deposito na conta (Metodos e comportamentos da classe)
    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    //função de sacar
    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }

    }

    //função de transferir
    fun transfere(valor: Double, destino: Conta): Boolean {

        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

    //encapsula a variavel saldo que é privada, retornando uma copia do saldo
    //encapsulado para permitir que apenas a classe modifique os atributos
//    fun getSaldo(): Double {
//        return saldo
//    }
//
//    fun setSaldo(valor: Double) {
//        if (valor < 0) {
//            saldo = valor
//        }
//    }

}

//função que mostra caso alterar uma variável de um objeto todas as váriareias
//que apontam para o mesmo objeto recebem o mesmo valor
fun testaCopiasEReferencias() {

    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("NumeroX $numeroX");
    println("NumeroY $numeroY")

    val contaJoao = Conta("João", 1001);
    var contaMaria = contaJoao
    contaMaria.titular = "Maria"

    println("Titular da conta João: ${contaJoao.titular}");


}

//função de testar laços de repetição
fun testaLacos() {
    var i = 0

    //Enquanto a variavel i for menor que 5 executa o código
    while (i < 5) {

        val titular: String = "Jorge $i";
        val numeroConta: Int = 1000 + i;
        var saldo = i + 10.0
        saldo = 100 + 2.0

        println("Titular $titular");
        println("Número da conta $numeroConta");
        println("Saldo $saldo");
        println();
        i++
    }

    //For decrescente começando do 5 até o 1
//    for (i in 5 downTo 1 ) {
//        val titular: String = "Jorge $i";
//        val numeroConta: Int = 1000 + i;
//        var saldo = i + 10.0
//        saldo = 100 + 2.0
//
//        println("Titular $titular");
//        println("Número da conta $numeroConta");
//        println("Saldo $saldo");
//        println();
//    }
}

//Função de testar condições
fun testaCondicoes(saldo: Double) {

    //teste de if
    if (saldo > 0.0) {
        println("Conta positiva")
    } else if (saldo == 0.0) {
        println("Conta neutra")
    } else {
        println("Conta negativa")
    }

    //Mesma condição porém substituindo o If por when
    when {
        saldo > 0.0 -> println("Conta positiva")
        saldo == 0.0 -> println("Conta neutra")
        else -> println("Saldo negativo")
    }

}