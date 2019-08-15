import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import sun.plugin.dom.exception.WrongDocumentException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class WordTest {


    @Rule
    public TestName testName = new TestName();
    @After
    public void displayTestNameAfterTest(){
        System.out.println("Test finished :"+testName.getMethodName());
    }


    @Test
    public void openLetterTest(){
        Word word = new Word("apple","description");
        assertEquals(1,word.openLetter('a'));
        assertEquals(0,word.openLetter('b'));
        assertEquals(0,word.openLetter('1'));
        assertEquals(0,word.openLetter('*'));
        assertEquals(0,word.openLetter(' '));
        //rus
        assertEquals(0,word.openLetter('а'));
        assertEquals(1,word.openLetter('e'));
        //expected = 2 -> aPPle
        assertEquals(2,word.openLetter('p'));

        Word word2 = new Word("apPle","description");
        assertEquals(1,word2.openLetter('P'));
    }
    @Test
    public void openWordTest() throws WrongWordLengthException {
        Word word = new Word("owl","description");

        assertEquals(false,word.openWord("owu"));
        assertEquals(true,word.openWord("owl"));
    }
    @Test(expected = WrongWordLengthException.class)
    public void WrongWordLengthExceptionTest() throws WrongWordLengthException{
        Word word = new Word("employee","description");
        word.openWord("eemployee") ;
    }
    @Test
    public void getWordWithStartTest() throws WrongWordLengthException {
        Word word = new Word("island","description");
        assertEquals("******",word.getWordWithStars());
        word.openLetter('i');
        assertEquals("i*****",word.getWordWithStars());
        word.openLetter('f');
        assertEquals("i*****",word.getWordWithStars());
        word.openLetter('D');
        assertEquals("i*****",word.getWordWithStars());
        //rus
        word.openLetter('а');
        assertEquals("i*****",word.getWordWithStars());
        word.openLetter('*');
        assertEquals("i*****",word.getWordWithStars());
        word.openLetter('@');
        assertEquals("i*****",word.getWordWithStars());
        word.openLetter('d');
        assertEquals("i****d",word.getWordWithStars());
        word.openLetter('l');
        word.openLetter('a');
        assertEquals("i*la*d",word.getWordWithStars());

        word.openWord("island");
        assertEquals("island",word.getWordWithStars());
    }
    @Test(expected = NullPointerException.class)
    public void getWordWithStartNullPointerExceptionTest() throws WrongWordLengthException {
        Word word = new Word("island","description");
        word.openWord(null);
    }
    @Test
    public void isWinTest() throws WrongWordLengthException {
        Word word1 = new Word("Antony","description");
        word1.openWord("Antony");
        assertTrue("You win",word1.isWin());

        Word word2 = new Word("Ivan","description");
        word2.openLetter('I');
        word2.openLetter('v');
        word2.openLetter('a');
        word2.openLetter('n');
        assertTrue("You win",word2.isWin());

        Word word3 = new Word("break","description");
        word3.openLetter('b');
        word3.openLetter('r');
        word3.openLetter('e');
        word3.openLetter('o');
        word3.openLetter('k');
        assertEquals(false,word3.isWin());
        word3.openLetter('a');
        assertTrue("You win",word3.isWin());
    }
    @Test
    public void hasCharTest(){
        Word word = new Word("Ivan","description");
        assertEquals(true,word.hasChar('n'));
        assertEquals(true,word.hasChar('v'));
        assertEquals(true,word.hasChar('I'));
        assertEquals(true,word.hasChar('a'));

        assertEquals(false,word.hasChar('i'));
        assertEquals(false,word.hasChar('1'));
        assertEquals(false,word.hasChar('%'));
    }
}
