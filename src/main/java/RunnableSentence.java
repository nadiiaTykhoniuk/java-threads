import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RunnableSentence implements Runnable{

    public List<String> sentences;
    public int sentenceNumber;

    public RunnableSentence(List<String> _sentences, int _sentenceNumber) {
        this.sentences = _sentences;
        this.sentenceNumber = _sentenceNumber;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " running");
        System.out.println(sentences);
        this.sentences.forEach(s -> {
            List<String> words = Arrays.asList(s.split("\\s+"));
            List<String> result = words.stream().filter(w -> w.matches("([A-Z][-A-Za-z]*)")).collect(Collectors.toList());
            System.out.println("In sentence number " + sentenceNumber + " I found " + result.size() + " words");
            result.forEach(r -> System.out.println(r));
            sentenceNumber++;
        });
    }
}
