import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) throws InterruptedException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        FileReader fl = new FileReader();

        System.out.println("Enter number of threads");
        int threadNum = sc.nextInt();

        ArrayList<Thread> threads = new ArrayList<>();
        List<String> text = fl.readFromFile();
        int sub = (int)Math.ceil((float)text.size()/threadNum);
        System.out.println(sub);
        int p = 0;

        for (int i = 0; i < threadNum; i++) {
            int tempIt = i + 1;
            int nextP = p+sub;
            if (nextP > text.size())
                nextP = text.size();
            List<String> subTexts = text.subList(p, nextP);
            Runnable r = new RunnableSentence(subTexts, p+1);
            new Thread(r, "Thread " + tempIt).start();
            p = nextP;
        }

        for (var thread: threads) {
            thread.join();
        }
    }
}
