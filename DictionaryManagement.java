import java.io.*;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
    private Scanner scanner = new Scanner(System.in);

    public void insertFromCommandline() {
        System.out.print("Nhập số lượng từ và các từ:");
        int n = scanner.nextInt();
        for (int i=0; i<n; i++) {
            String target = scanner.nextLine();
            String explain = scanner.nextLine();
            addWord(target, explain);
        }
    }

    public void insertFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("dictionaries.txt"));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data;
            data = line.split("\t");
            addWord(data[0], data[1]);
        }
    }

    public void dictionaryLookup(String target) {
        for (int i = 0; i<words.size(); i++)
            if (target.equals(words.get(i).getWord_target())) {
                System.out.println("No" + "\t" + "|English" +"\t\t\t\t" + "|Vietnamese");
                System.out.println( i+1 + "\t|" + words.get(i).getWord_target()
                        +"\t\t\t\t|" + words.get(i).getWord_explain());
                break;
            }
    }

    public void dictionaryExportToFile(String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (int i=0; i<words.size(); i++)
            bufferedWriter.write(words.get(i).getWord_target()
                    + "\t" + words.get(i).getWord_explain() + "\n");
    }


}
