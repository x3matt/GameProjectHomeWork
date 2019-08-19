package tests;
import model.*;
import exception.*;
import junit.framework.TestCase;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WordTest {


    @Rule
    public TestName testName = new TestName();
    @After
    public void displayTestNameAfterTest(){
        System.out.println("Test finished :"+testName.getMethodName());
    }

    @BeforeClass
    public static void start(){
        System.out.println("Started tests of WordTest.class");
    }

    @Test
    public void openLetterTest(){
        Word word = new Word("apple","description");
        Assert.assertEquals(1,word.openLetter('a'));
        Assert.assertEquals(0,word.openLetter('b'));
        Assert.assertEquals(0,word.openLetter('1'));
        Assert.assertEquals(0,word.openLetter('*'));
        Assert.assertEquals(0,word.openLetter(' '));
        //rus
        Assert.assertEquals(0,word.openLetter('а'));
        Assert.assertEquals(1,word.openLetter('e'));
        //expected = 2 -> aPPle
        Assert.assertEquals(2,word.openLetter('p'));

        Word word2 = new Word("apPle","description");
        Assert.assertEquals(1,word2.openLetter('P'));
    }
    @Test
    public void openWordTest() throws WrongWordLengthException {
        Word word = new Word("owl","description");

        Assert.assertEquals(false,word.openWord("owu"));
        Assert.assertEquals(true,word.openWord("owl"));
    }
    @Test(expected = WrongWordLengthException.class)
    public void WrongWordLengthExceptionTest() throws WrongWordLengthException {
        Word word = new Word("employee","description");
        word.openWord("eemployee") ;
    }
    @Test
    public void getWordWithStartTest() throws WrongWordLengthException {
        Word word = new Word("island","description");
        Assert.assertEquals("******",word.getWordWithStars());
        word.openLetter('i');
        Assert.assertEquals("i*****",word.getWordWithStars());
        word.openLetter('f');
        Assert.assertEquals("i*****",word.getWordWithStars());
        word.openLetter('D');
        Assert.assertEquals("i*****",word.getWordWithStars());
        //rus
        word.openLetter('а');
        Assert.assertEquals("i*****",word.getWordWithStars());
        word.openLetter('*');
        Assert.assertEquals("i*****",word.getWordWithStars());
        word.openLetter('@');
        Assert.assertEquals("i*****",word.getWordWithStars());
        word.openLetter('d');
        Assert.assertEquals("i****d",word.getWordWithStars());
        word.openLetter('l');
        word.openLetter('a');
        Assert.assertEquals("i*la*d",word.getWordWithStars());

        word.openWord("island");
        Assert.assertEquals("island",word.getWordWithStars());
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
        TestCase.assertTrue("You win",word1.isWin());

        Word word2 = new Word("Ivan","description");
        word2.openLetter('I');
        word2.openLetter('v');
        word2.openLetter('a');
        word2.openLetter('n');
        TestCase.assertTrue("You win",word2.isWin());

        Word word3 = new Word("break","description");
        word3.openLetter('b');
        word3.openLetter('r');
        word3.openLetter('e');
        word3.openLetter('o');
        word3.openLetter('k');
        Assert.assertEquals(false,word3.isWin());
        word3.openLetter('a');
        TestCase.assertTrue("You win",word3.isWin());
    }
    @Test
    public void hasCharTest(){
        Word word = new Word("Ivan","description");
        Assert.assertEquals(true,word.hasChar('n'));
        Assert.assertEquals(true,word.hasChar('v'));
        Assert.assertEquals(true,word.hasChar('I'));
        Assert.assertEquals(true,word.hasChar('a'));

        Assert.assertEquals(false,word.hasChar('i'));
        Assert.assertEquals(false,word.hasChar('1'));
        Assert.assertEquals(false,word.hasChar('%'));
    }
}
