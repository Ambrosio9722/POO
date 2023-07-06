// Essa classe representa a conta bancaria
class ContaBancaria {
	// o saldo da conta (o atributo que vai dar para modificar)
    protected double saldo;
    //CONSTRUTOR e inicializa a instancia com o saldo com 0
    public ContaBancaria() {
        saldo = 0.0;
    }
    // METODO para depositar dinheiro
    public void depositar(double valor) {
        saldo += valor;
    }
     // METODO para sacar (verifica se o saldo é maior que a retirada)
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
 // METODO que retorna o saldo || GET
    public double getSaldo() {
        return saldo;
    }
}