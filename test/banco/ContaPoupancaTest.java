
package banco;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pepe
 */
public class ContaPoupancaTest {
    
    public ContaPoupancaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testSacar() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.sacar(200);
        
        assertEquals(contaPoupanca.sacar(100), true);
        assertEquals(contaPoupanca.sacar(300), false);
        
        contaPoupanca.setSaldo(200);
        
        assertEquals(contaPoupanca.sacar(80), true);
        assertEquals(contaPoupanca.sacar(500), false);
    }

   
    @Test
    public void testDepositar() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.sacar(200);
        
        assertEquals(contaPoupanca.depositar(200), true);
        assertEquals(contaPoupanca.depositar(500), true);
        assertEquals(contaPoupanca.depositar(1100), true);
        assertEquals(contaPoupanca.depositar(40000), true);
    }

    @Test
    public void testTransferencia() {
       ContaPoupanca contaPoupanca = new ContaPoupanca();
        Conta conta2 = new Conta();
        
        contaPoupanca.setSaldo(500);
        assertEquals(contaPoupanca.transferencia(conta2, 200), false);
      
    }

  
    @Test
    public void testExtrato() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.sacar(200);
      
    }

    
    @Test
    public void testGetSaldo() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        assertEquals(contaPoupanca.getSaldo(),true);
    }
    
}
