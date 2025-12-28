import java.util.Arrays;

public class CountingBits {
    public static int[] countBits(int n) {

        int[] output = new int[n + 1];

        if (n == 0) {
            return output;
        }

        output[0] = 0;
        boolean[] bits = new boolean[(int) (Math.log10(n) / Math.log10(2)) + 1];
        System.out.println(Arrays.toString(bits));
        for (int i = 1; i < n + 1; i++) {
            int bitCount = output[i - 1];
            for (int j = 0; j < bits.length; j++) {
                if (!bits[j]) {
                    bits[j] = true;
                    bitCount = bitCount += 1;
                    break;
                }
                else {
                    bits[j] = false;
                    bitCount -= 1;
                    continue;
                }
            }

            output[i] = bitCount;
            System.out.println(Arrays.toString(bits));

        }
        return output;
    }

    public static void main(String[] args) {
        int bits = 16;

        System.out.println(Arrays.toString(countBits(bits)));
    }
}
