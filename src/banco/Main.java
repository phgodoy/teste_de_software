package banco;
//829122 Pedro Henrique
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int op;
        
        Conta conta = new Conta();
        
        String cliente;
        int numeroConta, agencia, tipoConta;
        double saldo, limite;
        
        Scanner s = new Scanner(System.in);
         
        do {
            System.out.println("Informe o que deseja fazer: ");
            System.out.println("1-Criar uma conta");
            System.out.println("2-Consultar saldo");
            System.out.println("3-Depositar");
            System.out.println("4-Sacar");
            System.out.println("5-Transferir");
            System.out.println("6-Consultar extrato");
            System.out.println("7-Sair");
            op = s.nextInt();
            s.nextLine();
            
            switch(op){
                case 1:

                   System.out.println("Informe o seu nome: ");
                   cliente = s.nextLine();
                   System.out.println("Informe o número da conta: ");
                   numeroConta = s.nextInt();
                   System.out.println("Informe agência da conta: ");
                   agencia = s.nextInt();
                   System.out.println("Informe o saldo inicial: ");
                   saldo = s.nextDouble();
                   System.out.println("Informe o limite da conta: ");
                   limite = s.nextDouble();
                   System.out.println("Informe o tipo de conta:\n ");
                   System.out.println("1-poupanca\t2- corrente\t3- salario");
                   tipoConta = s.nextInt();
                   
                   if(tipoConta == 1) {
                       conta = new ContaPoupanca(cliente, numeroConta, agencia, saldo, limite);
                   }
                   
                   if(tipoConta == 2) {
                       conta = new ContaCorrente(cliente, numeroConta, agencia, saldo, limite);
                   }
                   
                   if(tipoConta == 3) {
                       conta = new ContaSalario(cliente, numeroConta, agencia, saldo, limite);
                   }
                   
                    break;
                case 2:
                    System.out.println("####################");
                    System.out.println("Saldo em conta: " + conta.getSaldo());
                    System.out.println("####################");
                    
                    break;

                case 3:
                    System.out.println("Informe a quantidade para deposito: ");
                    if(conta.depositar(s.nextDouble())) {
                        System.out.println("Depositando dinheiro...");
                        Thread.sleep (1000);
                        System.out.println("Dinheiro depositado com sucesso!!");

                        System.out.println("Saldo em conta: " + conta.getSaldo());
                    }
                    
                    break;

                case 4:
                    System.out.println("Informe a quantidade para saque: ");
                    
                    if(conta.sacar(s.nextDouble())) {
                       System.out.println("Sacando dinheiro...");
                       Thread.sleep (1000);
                       System.out.println("Saque realizado com sucesso!!");

                       System.out.println("Saldo em conta: " + conta.getSaldo()); 
                    } else {
                        System.out.println("Não é possivel realizar esse saque, pois sua conta não pode negativar.");
                    }
                    
                    break;

                case 5:
                    
                    Conta conta2 = new Conta();
                    conta2.setSaldo(200);
                    
                    System.out.println("Informe a quantidade para transferencia: ");
                    if(conta.transferencia(conta2, s.nextDouble())) {
                        System.out.println("Transferindo dinheiro....");
                        Thread.sleep (1000);
                        conta.transferencia(conta2, s.nextDouble());
                        System.out.println("Transferencia realizada com sucesso!!");
                        System.out.println("Saldo da conta transferente: " + conta.getSaldo());
                        System.out.println("Saldo da conta transferida: " + conta2.getSaldo());
                    }

                    break;
                    
                case 6:
                    conta.extrato();
                  
                    break;
                 
            }
        } while(op != 7);
         
        s.close();
    }
}
