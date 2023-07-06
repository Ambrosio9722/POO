//HERANÇA de Conta_Bancaria 
class ContaCorrente extends ContaBancaria {
	// o limite do cheque especial 
    private double limiteChequeEspecial;

    // CONSTRUTOR || recebe o limite do cheque 
    public ContaCorrente(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
   // SOBRESCREVE o metodo SACAR da Conta_bancaria || considera o cheque especial (seu saldo é o valor da conta + o valor do cheque)
    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}