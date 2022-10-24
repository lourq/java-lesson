package step.learning;

import javax.inject.Singleton;
import java.util.Random;

// альтернативное название служб - провайдеры
@Singleton
public class RandomProvider {
    private final int n = new Random().nextInt() ;

    public int getN() {
        return n;
    }
}
