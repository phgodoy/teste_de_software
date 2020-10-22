import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContaCorrenteTest.class, ContaSalarioTest.class, ContaPoupancaTest.class })
public class TestAll {

    public TestAll() {
    }

}
