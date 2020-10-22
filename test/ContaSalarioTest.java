import banco.ContaSalario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContaSalarioTest {
    
    public ContaSalarioTest() {
    }

    @Before
    public void setUp() {
        ContaSalario conta = new ContaSalario("Giovanni",123,234,200,400);
    }
    
    @After
    public void tearDown() {
        ContaSalario conta = new ContaSalario("Giovanni",123,234,200,400);
        conta.extrato();
    }

    @Test
    public void saldoTest() {
        ContaSalario conta = new ContaSalario("Giovanni",123,234,200,400);
        conta.setSaldo(200);
                
        assertEquals(200.0, conta.getSaldo(),0.0001);
        
        conta.setSaldo(600);
        
        assertEquals(400.0, conta.getSaldo(),0.0001);
    }

    @Test
    public void depositarTest() {
        ContaSalario conta = new ContaSalario("Giovanni",123,234,200,400);
        
        assertEquals(conta.depositar(200), false);
        assertEquals(conta.depositar(500), false);
        assertEquals(conta.depositar(1100), false);
        assertEquals(conta.depositar(40000), false);
    }
    
    @Test
    public void sacarTest() {
        ContaSalario conta = new ContaSalario("Giovanni",123,234,200,400);
        conta.setSaldo(200);
        
        assertEquals(conta.sacar(100), true);
        assertEquals(conta.sacar(300), false);
        
        conta.setSaldo(200);
        
        assertEquals(conta.sacar(80), true);
        assertEquals(conta.sacar(500), false);
    }
    
    @Test
    public void transferenciaTest() {
        ContaSalario conta1 = new ContaSalario("Giovanni",123,234,200,400);
        ContaSalario conta2 = new ContaSalario("Marcus",222,555,300,500);
        
        conta1.setSaldo(500);
        assertEquals(conta1.transferencia(conta2, 200), false);
        assertEquals(400, conta1.getSaldo(), 0.0001);
        assertEquals(300, conta2.getSaldo(), 0.0001);
    }
}
