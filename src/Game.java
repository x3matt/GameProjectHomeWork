import java.util.Scanner;

public class Game {

    private Word word;
    private int balance;
    private int attempts;
    private int maxAttempts;
    private int delta = 5;
    Scanner scanner = new Scanner(System.in);

    public int getBalance() {
        return balance;
    }

    public int getAttempts() {
        return attempts;
    }

    public void play() throws WrongWordLengthException {
        startGame("crocodile","Giant green lizard");
        maxAttempts = word.getWord().length()+3;
        System.out.println(word.getDescription());
        System.out.println("Start Word : "+word.getWordWithStars());
        System.out.println("---If you want to write full word - Enter symbols:| @#$ |---");
        while(attempts != maxAttempts){
            System.out.println("---Enter letter---");
            String c = scanner.nextLine();
            if(c.equals("@#$")){
                System.out.println("---Enter Word---");
                String res = scanner.nextLine();
                openWord(res);
            }else {
                openLetter(c.charAt(0));
                System.out.println(word.getWordWithStars());
            }
            if(attempts == maxAttempts){
                System.out.println("---You lose---");
            }
            if(word.isWin()){
                System.out.println("---You win---");
                System.out.println("Your points :"+getBalance());
                System.out.println("Your attempts :"+getAttempts());
                break;
            }
        }
    }

    public void startGame(String w, String d) {
        word = new Word(w, d);
    }

    public void openLetter(char letter) {

        int match = word.openLetter(letter);

        if (match == 0) balance -= delta;
        else {
            if (match == 1) balance += delta;
            else balance += match * delta;
        }
        attempts++;

    }

    public boolean isWin() {
        return word.isWin();

    }

    public void openWord(String w) throws WrongWordLengthException {
        if (word.openWord(w) == true) balance += delta * 10;
        else balance -= delta * 5;
        attempts++;
    }


}
