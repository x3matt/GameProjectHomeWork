package view;
import model.*;
import controller.*;
import exception.*;

import java.util.Scanner;

public class GameBox {
    private int maxAttempts;
    private Scanner scanner = new Scanner(System.in);
    private Game game;

    public GameBox(Game game){
        this.game=game;
    }

    public void play() throws WrongWordLengthException {
        game.startGame(game.getWord().getWord(),game.getWord().getDescription());
        maxAttempts = game.getWord().getWord().length()+3;
        System.out.println(game.getWord().getDescription());
        System.out.println("Start Word : "+game.getWord().getWordWithStars());
        System.out.println("---If you want to write full word - Enter symbols:| @#$ |---");
        while(game.getAttempts() != maxAttempts){
            System.out.println("---Enter letter---");
            String c = scanner.nextLine();
            if(c.equals("@#$")){
                System.out.println("---Enter Word---");
                String res = scanner.nextLine();
                game.openWord(res);
            }else {
                game.openLetter(c.charAt(0));
                System.out.println(game.getWord().getWordWithStars());
            }
            if(game.getAttempts() == maxAttempts){
                System.out.println("---You lose---");
            }
            if(game.getWord().isWin()){
                System.out.println("---You win---");
                System.out.println("Your points :"+game.getBalance());
                System.out.println("Your attempts :"+game.getAttempts());
                break;
            }
        }
    }
}
