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
        // variavel para guadar a opção selecionada
        int opcao;
    // LOOP DO_WHILE
        do {
        	//chama o METODO PARA EXIBIR O MENU
            exibirMenu();
            // salva a opção selecionada 
            opcao = scanner.nextInt();
            // ESTRUTURA "SWITCH"
            switch (opcao) {
                case 1:
                	//criar conta
                    criarConta();
                    break;
                case 2:
                	//realizar a operações
                    realizarOperacoes();
                   
                    break;
                case 3:
                	//FIM
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                	//ERRO
                    System.out.println("Opção inválida!");
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
        System.out.println("2. Realizar operações na conta");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }
    //cria uma nova conta (CORRENTE OU POUPANÇA)
    private static void criarConta() {
        Scanner scanner = new Scanner(System.in);
        int tipoConta;

        System.out.println("\nTIPOS DE CONTA");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
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
                System.out.println("Conta poupança criada com sucesso!");
                System.out.println("Numero da conta: "+contas[numContas]);
            } else {
                System.out.println("Tipo de conta inválido!");
                return;
            }

            numContas++;
        } else {
            System.out.println("Número máximo de contas atingido!");
        }
    }
   // 	Realizar as operaçoes (DEPOSITAR, SACAR e SALDO)
    private static void realizarOperacoes() {
        Scanner scanner = new Scanner(System.in);
        int numConta;

        System.out.print("\nDigite o número da conta: ");
        numConta = scanner.nextInt();

        if (numConta >= 0 && numConta < numContas) {
            ContaBancaria conta = contas[numConta];

            int opcao;

            do {
                exibirOperacoes();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
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
                    	// verifica se a conta é uma instancia da classe conta poupança (instanceof)
                    	// OBS: é necessário porque a opção de calcular juros está disponível apenas para contas poupança.
                        if (conta instanceof ContaPoupanca) {
                            ((ContaPoupanca) conta).calcularJuros();
                            System.out.println("Juros calculados e aplicados com sucesso!");
                        } else {
                            System.out.println("Operação não permitida para este tipo de conta!");
                        }
                        break;
                    case 5:
                        System.out.println("Encerrando operações na conta.");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (opcao != 5);
        } else {
            System.out.println("Número de conta inválido!");
        }
    }
   // MOSTRA o menu de operaçoes da conta 
    private static void exibirOperacoes() {
        System.out.println("\nOPERAÇÕES NA CONTA");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Ver saldo");
        System.out.println("4. Calcular juros (apenas para Conta Poupança)");
        System.out.println("5. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }
}