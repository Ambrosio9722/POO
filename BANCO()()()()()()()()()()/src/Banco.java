// usar o scaner para receber as entradas
// CLASSE PRINCIPLA 
import java.util.Scanner;
public class Banco {
	//uma CONSTANTE que define o numero maximo de contas
    private static final int MAX_CONTAS = 100;
    // um VETOR de objetos para armazenar as INSTANCIAS das contas
    private static ContaBancaria[] contas = new ContaBancaria[MAX_CONTAS];
    //controle de quantas contas foram criadas 
    private static int numContas = 0;

    public static void main(String[] args) {
    	//INSTANCIA da classe "Scanner"
        Scanner scanner = new Scanner(System.in);
        // variavel para guadar a op��o selecionada
        int opcao;
    // LOOP DO_WHILE
        do {
        	//chama o METODO PARA EXIBIR O MENU
            exibirMenu();
            // salva a op��o selecionada 
            opcao = scanner.nextInt();
            // ESTRUTURA "SWITCH"
            switch (opcao) {
                case 1:
                	//criar conta
                    criarConta();
                    break;
                case 2:
                	//realizar a opera��es
                    realizarOperacoes();
                   
                    break;
                case 3:
                	//FIM
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                	//ERRO
                    System.out.println("Op��o inv�lida!");
                    break;
            }
            // fecha quando selecionar o 3 
        } while (opcao != 3);
    }
 
    /////////////////// METODOS ////////////////
    //Mostrar o menu
    private static void exibirMenu() {
        System.out.println("\nMENU");
        System.out.println("1. Criar conta");
        System.out.println("2. Realizar opera��es na conta");
        System.out.println("3. Sair");
        System.out.print("Escolha uma op��o: ");
    }
    //cria uma nova conta (CORRENTE OU POUPAN�A)
    private static void criarConta() {
        Scanner scanner = new Scanner(System.in);
        int tipoConta;

        System.out.println("\nTIPOS DE CONTA");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupan�a");
        System.out.print("Escolha o tipo de conta: ");
        tipoConta = scanner.nextInt();

        if (numContas < MAX_CONTAS) {
            if (tipoConta == 1) {
                contas[numContas] = new ContaCorrente(500.0);
                System.out.println("Conta corrente criada com sucesso!");
                System.out.println("-----------------------------------");
                System.out.println("Numero da conta: "+ numContas);
                System.out.println("-----------------------------------");
            } else if (tipoConta == 2) {
                contas[numContas] = new ContaPoupanca(0.05);
                System.out.println("Conta poupan�a criada com sucesso!");
                System.out.println("Numero da conta: "+contas[numContas]);
            } else {
                System.out.println("Tipo de conta inv�lido!");
                return;
            }

            numContas++;
        } else {
            System.out.println("N�mero m�ximo de contas atingido!");
        }
    }
   // 	Realizar as opera�oes (DEPOSITAR, SACAR e SALDO)
    private static void realizarOperacoes() {
        Scanner scanner = new Scanner(System.in);
        int numConta;

        System.out.print("\nDigite o n�mero da conta: ");
        numConta = scanner.nextInt();

        if (numConta >= 0 && numConta < numContas) {
            ContaBancaria conta = contas[numConta];

            int opcao;

            do {
                exibirOperacoes();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para dep�sito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        System.out.println("Dep�sito realizado com sucesso!");
                        break;
                    case 2:
                        System.out.print("Digite o valor para saque: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso!");
                        break;
                    case 3:
                        double saldo = conta.getSaldo();
                        System.out.println("Saldo: " + saldo);
                        break;
                    case 4:
                    	// verifica se a conta � uma instancia da classe conta poupan�a (instanceof)
                    	// OBS: � necess�rio porque a op��o de calcular juros est� dispon�vel apenas para contas poupan�a.
                        if (conta instanceof ContaPoupanca) {
                            ((ContaPoupanca) conta).calcularJuros();
                            System.out.println("Juros calculados e aplicados com sucesso!");
                        } else {
                            System.out.println("Opera��o n�o permitida para este tipo de conta!");
                        }
                        break;
                    case 5:
                        System.out.println("Encerrando opera��es na conta.");
                        break;
                    default:
                        System.out.println("Op��o inv�lida!");
                        break;
                }
            } while (opcao != 5);
        } else {
            System.out.println("N�mero de conta inv�lido!");
        }
    }
   // MOSTRA o menu de opera�oes da conta 
    private static void exibirOperacoes() {
        System.out.println("\nOPERA��ES NA CONTA");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Ver saldo");
        System.out.println("4. Calcular juros (apenas para Conta Poupan�a)");
        System.out.println("5. Voltar ao menu principal");
        System.out.print("Escolha uma op��o: ");
    }
}