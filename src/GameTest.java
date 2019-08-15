import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class GameTest {
    @Rule
    public TestName testName = new TestName();
    @After
    public void displayTestNameAfterTest(){
        System.out.println("Test finished :"+testName.getMethodName());
    }

    @Test
    public void startGameTest(){
        Game game = new Game();
        game.startGame("word","description");
        assertEquals(0,game.getBalance());
        assertEquals(0,game.getAttempts());
    }

    @Test
    public void openLetterTest(){
        Game game = new Game();
        game.startGame("Japan","description");
        game.openLetter('J');
        assertEquals(5,game.getBalance());
        game.openLetter('j');
        assertEquals(0,game.getBalance());
        game.openLetter('p');
        game.openLetter('n');
        assertEquals(10,game.getBalance());

        assertEquals(4,game.getAttempts());
    }
    @Test
    public void openWordTrueTest() throws WrongWordLengthException {
        Game game = new Game();
        game.startGame("island","description");
        game.openWord("island");
        assertEquals(50,game.getBalance());

        assertEquals(1,game.getAttempts());
    }
    @Test
    public void openWordFalseTest() throws WrongWordLengthException {
        Game game = new Game();
        game.startGame("island","description");
        game.openWord("Kirill");
        assertEquals(-25,game.getBalance());

        assertEquals(1,game.getAttempts());
    }
    @Test
    public void attemptsAndBalanceTest() throws WrongWordLengthException {
        Game game = new Game();
        game.startGame("word","description");
        game.openLetter('w');
        game.openLetter('o');
        game.openLetter('c');
        game.openLetter('z');
        game.openLetter('x');
        game.openLetter('t');
        game.openLetter('f');
        game.openLetter('u');
        assertEquals(-20,game.getBalance());
        assertEquals(8,game.getAttempts());

        game.openWord("wore");
        assertEquals(-45,game.getBalance());
        game.openWord("word");
        assertEquals(5,game.getBalance());

        assertEquals(10,game.getAttempts());
    }
    @Test
    public void isWinTest() throws WrongWordLengthException {
        Game game = new Game();
        game.startGame("word","description");
        game.openWord("duck");
        assertEquals(false,game.isWin());
        game.openWord("word");
        assertTrue("You win",game.isWin());

        assertEquals(25,game.getBalance());
        assertEquals(2,game.getAttempts());
    }
    @Test(expected = NullPointerException.class)
    public void openWordNullTest() throws WrongWordLengthException {
        Game game = new Game();
        game.openWord("word");
    }

}
