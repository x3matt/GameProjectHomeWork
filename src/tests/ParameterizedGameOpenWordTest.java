package tests;

import controller.Game;
import exception.WrongWordLengthException;
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
public class ParameterizedGameOpenWordTest {

    @Rule
    public TestName testName = new TestName();
    @After
    public void displayTestNameAfterTest(){
        System.out.println("Test finished :"+testName.getMethodName());
    }

    Game game = new Game();
    String input;
    int extended;
    @BeforeClass
    public static void start(){
        System.out.println("Started tests of ParameterizedWordOpenLetterTest.class");
    }
    @Before
    public void init(){
        game.startGame("word","description");
    }
    public ParameterizedGameOpenWordTest(String input,int extended){
        this.input=input;
        this.extended=extended;
    }
    @Parameterized.Parameters
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{{"word",50},{"bird",-25}});
    }
    @Test
    public void gameOpenWordTest() throws WrongWordLengthException {
        game.openWord(input);
        assertEquals(extended,game.getBalance());
    }
}
