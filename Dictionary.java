import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<Word> words = new ArrayList<>();

    public void addWord(String target, String explain) {
        words.add(new Word(target, explain));
    }
}
