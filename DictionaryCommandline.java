import java.io.IOException;

public class DictionaryCommandline extends DictionaryManagement{

    public void showAllWords() {
        System.out.println("No" + "\t" + "|English" +"\t\t\t\t" + "|Vietnamese");
        for (int i =0; i<words.size(); i++)
            System.out.println( i+1 + "\t|" + words.get(i).getWord_target()
                    +"\t\t\t\t|" + words.get(i).getWord_explain());
    }
    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }
    public void dictionaryAdvanced(String target) throws IOException {
        insertFromFile();
        showAllWords();
        dictionaryLookup(target);
    }
    public String[] dictionarySearch(String word) {
        String[] search = new String[1000];
        for(int i=0; i<words.size(); i++)
            if (words.get(i).getWord_target().substring(0,word.length()).equals(word)) {
                search[search.length] = words.get(i).getWord_target();
            }
        return search;
     }
}
