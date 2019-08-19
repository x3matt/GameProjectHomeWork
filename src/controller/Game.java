package controller;

import model.*;
import exception.*;
public class Game {

    private Word word;
    private int balance;
    private int attempts;
    private int delta = 5;

    public int getBalance() {
        return balance;
    }

    public int getAttempts() {
        return attempts;
    }

    public Word getWord() {
        return word;
    }

    public Game(){}

    public Game(Word word){
        this.word=word;
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
