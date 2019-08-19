package tests;

import controller.Game;
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
public class ParameterizedGameOpenLetterTest {

    @Rule
    public TestName testName = new TestName();
    @After
    public void displayTestNameAfterTest(){
        System.out.println("Test finished :"+testName.getMethodName());
    }

    static Game game = new Game();
    char input;
    int extended;
    @BeforeClass
    public static void init(){
        game.startGame("word","description");
        System.out.println("Started tests of ParameterizedGameOpenLetterTest.class");
    }
    public ParameterizedGameOpenLetterTest(char input,int extended){
        this.input=input;
        this.extended=extended;
    }
    @Parameterized.Parameters
    public static List<Object[]> data1(){
        return Arrays.asList(new Object[][]{{'w',5},{'o',10},{'f',5},{'r',10},{'t',5},{'d',10}});
    }
    @Test
    public void gameOpenLetterTest(){
        game.openLetter(input);
        assertEquals(extended,game.getBalance());
    }
}
