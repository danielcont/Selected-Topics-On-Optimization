import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        Generator gen = new Generator();
        Heuristica heur = new Heuristica();

        long start = System.nanoTime();
        gen.getUserInput();
        heur.Heuristics();
        long finish = System.nanoTime();
        long elapsedTime = (finish - start);
        long elapsedTimeMillis = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
        System.out.println(elapsedTimeMillis + " ms");
        
    }
}