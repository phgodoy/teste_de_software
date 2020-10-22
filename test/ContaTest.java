import banco.Conta;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContaTest {
    
    public ContaTest() {
    }
    
    @Test
    public void saldoTest() {
        Conta conta = new Conta();
        conta.setSaldo(200);
                
        assertEquals(200.0, conta.getSaldo(),0.0001);
        
        conta.setSaldo(600);
        
        assertEquals(600.0, conta.getSaldo(),0.0001);
    }

    @Test
    public void depositarTest() {
        Conta conta = new Conta();
        conta.setSaldo(200);
        
        assertEquals(conta.depositar(200), true);
        assertEquals(conta.depositar(500), true);
        assertEquals(conta.depositar(1100), true);
        assertEquals(conta.depositar(40000), true);
    }
    
    @Test
    public void sacarTest() {
        Conta conta = new Conta();
        conta.setSaldo(200);
        
        assertEquals(conta.sacar(100), true);
        assertEquals(conta.sacar(300), false);
        
        conta.setSaldo(200);
        
        assertEquals(conta.sacar(80), true);
        assertEquals(conta.sacar(500), false);
    }
    
    @Test
    public void transferenciaTest() {
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        
        conta1.setSaldo(500);
        assertEquals(conta1.transferencia(conta2, 200), true);
        assertEquals(300, conta1.getSaldo(), 0.0001);
        assertEquals(200, conta2.getSaldo(), 0.0001);
    }
        
}
