import banco.ContaCorrente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContaCorrenteTest {
    
    public ContaCorrenteTest() {
        ContaCorrente conta = new ContaCorrente("Giovanni",123,234,200,400);
    }
        
    @Before
    public void setUp() {
        ContaCorrente conta = new ContaCorrente("Giovanni",123,234,200,400);
    }
    
    @After
    public void tearDown() {
        ContaCorrente conta = new ContaCorrente("Giovanni",123,234,200,400);
        conta.extrato();
    }

    @Test
    public void saldoTest() {
        ContaCorrente conta = new ContaCorrente("Giovanni",123,234,200,400);
        conta.setSaldo(200);
                
        assertEquals(200.0, conta.getSaldo(),0.0001);
        
        conta.setSaldo(600);
        
        assertEquals(400.0, conta.getSaldo(),0.0001);
    }

    @Test
    public void depositarTest() {
        ContaCorrente conta = new ContaCorrente("Giovanni",123,234,200,400);
        
        assertEquals(conta.depositar(200), true);
        assertEquals(conta.depositar(500), true);
        assertEquals(conta.depositar(1100), true);
        assertEquals(conta.depositar(40000), true);
    }
    
    @Test
    public void sacarTest() {
        ContaCorrente conta = new ContaCorrente("Giovanni",123,234,200,400);
        conta.setSaldo(200);
        
        assertEquals(conta.sacar(100), true);
        assertEquals(conta.sacar(300), false);
        
        conta.setSaldo(200);
        
        assertEquals(conta.sacar(80), true);
        assertEquals(conta.sacar(500), false);
    }
    
    @Test
    public void transferenciaTest() {
        ContaCorrente conta1 = new ContaCorrente("Giovanni",123,234,200,400);
        ContaCorrente conta2 = new ContaCorrente("Marcus",222,555,300,500);
        
        conta1.setSaldo(500);
        assertEquals(conta1.transferencia(conta2, 200), true);
        assertEquals(200, conta1.getSaldo(), 0.0001);
        assertEquals(500, conta2.getSaldo(), 0.0001);
    }
}
