package bridge.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BridgeRandomNumberGenerator implements RandomNumberGenerator {

    private static final Random random = new Random();

    @Override
    public List<Integer> generate(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(0, 2);
            numbers.add(randomNumber);
        }
        return numbers;
    }
}
