package tests;

import exception.WrongWordLengthException;
import model.Word;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParameterizedWordOpenWordTest {

    @Rule
    public TestName testName = new TestName();
    @After
    public void displayTestNameAfterTest(){
        System.out.println("Test finished :"+testName.getMethodName());
    }

    static Word word= new Word("word","description");
    String input;
    boolean extended;

    @BeforeClass
    public static void start(){
        System.out.println("Started tests of ParameterizedWordOpenWordTest.class");
    }

    public ParameterizedWordOpenWordTest(String input,boolean extended){
        this.input = input;
        this.extended=extended;
    }
    @Parameterized.Parameters
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{{"word",true},{"bird",false}});
    }
    @Test
    public void wordOpenWordTest() throws WrongWordLengthException {
        assertEquals(extended,word.openWord(input));
    }
}
