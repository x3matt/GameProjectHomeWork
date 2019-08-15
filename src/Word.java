public class Word {

    private String word;
    private String description;
    private boolean[] guessed;


    public Word(String word, String description) {
        this.word = word;
        this.description = description;
        this.guessed = new boolean[word.length()];

    }

    public int openLetter(char ch) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                guessed[i] = true;
                count++;

            }
        }

        return count;
    }

    public boolean openWord(String inputWord) throws WrongWordLengthException {

        if (!(word.length() == inputWord.length()))
            throw new WrongWordLengthException();


        if (word.equals(inputWord)) {
            for (int i = 0; i < word.length(); i++) {
                guessed[i] = true;

            }
            return true;
        }
        return false;
    }

    public String getWordWithStars() {
        StringBuilder wordWithStars = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) {
                wordWithStars.append(word.charAt(i));
            } else {
                wordWithStars.append("*");
            }
        }
        System.out.println(wordWithStars.toString());
        return wordWithStars.toString();
    }

    public boolean isWin() {
        for (boolean letter : guessed) {
            if (letter == false) return false;
        }
        return true;

    }

    public boolean hasChar(char ch) {

        return word.contains(String.valueOf(ch));

    }

    public String getWord() {
        return word;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (word != null ? !word.equals(word1.word) : word1.word != null) return false;
        return description != null ? description.equals(word1.description) : word1.description == null;

    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


}