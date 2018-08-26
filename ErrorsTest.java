import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ErrorsTest.
 *
 * @author  (Daniel Morales L)
 * @version (aug 26 2018)
 */
public class ErrorsTest
{
    Errors errors1;
    /**
     * Default constructor for test class ErrorsTest
     */
    public ErrorsTest()
    {
        System.out.println("IGNORE THIS MESAGGES");
        errors1 = new Errors();
    }

    @Test
    public void sizeSintaxCheck()
    {
        assertTrue(errors1.sizeSintaxCheck(new String[]{"4","5","2"})); //Right input
        assertFalse(errors1.sizeSintaxCheck(new String[]{"4","5"})); // lefting args
        assertFalse(errors1.sizeSintaxCheck(new String[]{"4","5","2","5"})); //too much args
        assertFalse(errors1.sizeSintaxCheck(new String[]{"dfd","erggds","2"})); // wrong args
    }
    
    @Test
    public void sizeLogicCheck()
    {
        assertTrue(errors1.sizeLogicCheck(new String[]{"4","5","2"})); //Right input
        assertFalse(errors1.sizeLogicCheck(new String[]{"4","5","222"})); //too much mines
        assertFalse(errors1.sizeLogicCheck(new String[]{"-4","5","2"})); //out of boudns 
    }
    
    @Test
    public void inputSintaxCheck()
    {
        assertTrue(errors1.inputSintaxCheck(new String[]{"4","5","U"})); //Right input
        assertTrue(errors1.inputSintaxCheck(new String[]{"4","5","M"})); //Right input
        assertFalse(errors1.inputSintaxCheck(new String[]{"3","4"})); // lefting args
        assertFalse(errors1.inputSintaxCheck(new String[]{"3","4","U","5"})); //too much args
        assertFalse(errors1.inputSintaxCheck(new String[]{"dfd","erggds","2"})); // wrong args
    }
    
    @Test
    public void inputLogicCheck()
    {
        assertTrue(errors1.inputLogicCheck(new String[]{"2","2","U"},4,5)); //Right input
        assertTrue(errors1.inputLogicCheck(new String[]{"2","2","M"},4,5)); //Right input
        assertFalse(errors1.inputLogicCheck(new String[]{"-2","2","U"},4,5)); //out of boudns
        assertFalse(errors1.inputLogicCheck(new String[]{"56","70","U"},4,5)); //out of boudns
    }
    
}
