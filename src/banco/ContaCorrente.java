package banco;

public class ContaCorrente extends Conta {

    public ContaCorrente() {
    }
    
    public ContaCorrente(String cliente, int numeroConta, int agencia, double saldo, double limiteContratado) {
        super(cliente, numeroConta, agencia, saldo, limiteContratado);
    }
    
    
    @Override
    public boolean sacar(double quantidade) {
        
        quantidade = quantidade + 3;
        
        return super.sacar(quantidade);
    }
    
    @Override
    public boolean depositar(double quantidade) {
        return super.depositar(quantidade);
    }
    
    @Override
    public boolean transferencia(Conta contaPessoa, double quantidade) {
        return super.transferencia(contaPessoa, quantidade);
    }
    
    @Override
    public void extrato() {
        double taxa = 2.50;
        
        super.sacar(taxa);
        
        super.extrato();
    }
    
    @Override
    public double getSaldo() {
        return super.getSaldo();
    }   
}
