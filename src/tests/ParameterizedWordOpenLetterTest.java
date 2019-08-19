package tests;
import model.*;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParameterizedWordOpenLetterTest {

    @Rule
    public TestName testName = new TestName();
    @After
    public void displayTestNameAfterTest(){
        System.out.println("Test finished :"+testName.getMethodName());
    }

    static Word word= new Word("word","description");
    char input;
    int extended;

    @BeforeClass
    public static void start(){
        System.out.println("Started tests of ParameterizedWordOpenLetterTest.class");
    }

    public ParameterizedWordOpenLetterTest(char input, int extended) {
        this.input = input;
        this.extended = extended;
    }
    @Parameterized.Parameters
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{{'w',1},{'o',1},{'f',0},{'r',1},{'t',0},{'d',1}});
    }
    @Test
    public void wordOpenLetterTest(){
        Assert.assertEquals(extended,word.openLetter(input));
    }
 }
