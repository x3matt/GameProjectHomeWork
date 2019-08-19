import controller.*;
import model.*;
import  view.*;
import exception.*;

public class Main {

    public static void main(String[] args) throws WrongWordLengthException {
//        Word word = new Word("crocodile","giant green lizard");
//        Game game = new Game(word);
//        GameBox gameBox = new GameBox(game);
//        gameBox.play();

        Game game = new Game();
        game.startGame("crocodile","giant green lizard");
        GameBox gameBox = new GameBox(game);
        gameBox.play();
    }

}
