package basic;

import java.util.Random;

public class RandomSeedTest {
    public static void main(String[] args) {
        Random random = new Random(15);
        for(int i=0;i<10;i++){
            System.out.println(random.nextInt(10));
        }
    }
}
