//HERAN�A de Conta_Bancaria
class ContaPoupanca extends ContaBancaria {
	// a taxa��o de juros da conta poupan�a
    private double taxaJuros;
    //CONSTRUTOR || Inicia a variavel taxaJuros
    public ContaPoupanca(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
// METODO  que calcula os juros 
    public void calcularJuros() {
        saldo += saldo * taxaJuros;
    }
}