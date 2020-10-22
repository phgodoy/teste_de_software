package banco;

public class ContaSalario extends Conta{
    
    public ContaSalario(String cliente, int numeroConta, int agencia, double saldo, double limiteContratado) {
        super(cliente, numeroConta, agencia, saldo, limiteContratado);
    }
    
    
    @Override
    public boolean depositar(double quantidade) {
        
        System.out.println("Seu tipo de conta não pode realizar depositos!");
        
        return false;
    }
    
    @Override
    public boolean transferencia(Conta contaPessoa, double quantidade) {
        
        System.out.println("Seu tipo de conta não pode fazer transferencias!");
        
        return false;
    }
    
    @Override
    public boolean sacar(double quantidade) {
        return super.sacar(quantidade);
    }
    
    @Override
    public void extrato() {
        super.extrato();
    }
    
    @Override
    public double getSaldo() {
        return super.getSaldo();
    }
    
}
