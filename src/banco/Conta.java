package banco;

import java.util.ArrayList;
import java.util.Date;


public class Conta {
   private String cliente;
   private int numeroConta;
   private int agencia;
   private double saldo;
   private  double limiteContratado;
   private ArrayList<String> historico = new ArrayList();
   private Date data = new Date();

    public Conta() {
    }

    public Conta(String cliente, int numeroConta, int agencia, double saldo, double limiteContratado) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.limiteContratado = limiteContratado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo <= this.getLimiteContratado()) {
            this.saldo = saldo;
        } else {
            this.saldo = this.getLimiteContratado();
        }
         
    }

    public double getLimiteContratado() {
        return limiteContratado;
    }

    public void setLimiteContratado(double limiteContratado) {
        this.limiteContratado = limiteContratado;
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }

    public boolean sacar(double quantidade) {
        
        if(!(this.saldo >= quantidade)) {
            return false;
        }
        
        this.saldo -= quantidade;
        
        this.historico.add("Saque de " + quantidade + " " + data);
        
        return true;
    }
    
    public boolean depositar(double quantidade) {
        
     
        this.saldo += quantidade;
        
        this.historico.add("Depósito de " + quantidade + " " + data);
        
        return true;
    }
    
    public boolean transferencia(Conta contaPessoa, double quantidade) {
        
        if(!(this.saldo >= quantidade)) {
            return false;
        }
        
        this.saldo -= quantidade;
        
        contaPessoa.depositar(quantidade);
        
        this.historico.add("Transferencia de " + quantidade + " para a conta " + contaPessoa.getNumeroConta() + " " + data);
        
        return true;
    }
    
    public void extrato() {
        System.out.println("######IMPRIMINDO EXTRATO#####");
        System.out.println("Nome: " + this.getCliente());
        System.out.println("Conta: " + this.getNumeroConta());
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Saldo atual: " + this.getSaldo());
        System.out.println("Movimentações do mês: ");
        for(String extrato: this.historico) {
            System.out.println(extrato);
        }
    }
}
