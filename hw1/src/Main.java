import java.math.BigDecimal;
import java.util.Arrays;

/**
 * User: Halil Karakose
 * Date: 2019-11-05
 * Time: 17:21
 */
public class Main {
    public static void main(String[] args) {
        String input = "15\n" +
                "0.9 0.8 0\n" +
                "0.85 2.1 0\n" +
                "1.2 1.0 0\n" +
                "2.1 0.95 0\n" +
                "3.0 1.1 0\n" +
                "3.9 0.7 0\n" +
                "4.0 1.4 0\n" +
                "4.2 1.8 0\n" +
                "2.0 2.3 0\n" +
                "3.0 2.3 0\n" +
                "1.5 1.8 1\n" +
                "2.0 1.5 1\n" +
                "2.2 2.0 1\n" +
                "2.6 1.7 1\n" +
                "2.7 1.85 1";

        solution(input);
    }

    private static void solution(String input) {
        BigDecimal[] S = new BigDecimal[4];
        String[] lines = input.split("\\n");

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(" ");
            if (parts[2].equals("1")) {
                BigDecimal partsX = new BigDecimal(parts[0]);
                BigDecimal partsY = new BigDecimal(parts[1]);
                if (S[0] == null && S[1] == null) {
                    S[0] = partsX;
                    S[1] = partsX;
                    S[2] = partsY;
                    S[3] = partsY;
                } else {
                    if (partsX.compareTo(S[0]) == -1 ) {
                        S[0] = partsX;
                    } else if (partsX.compareTo(S[0]) == 1) {
                        S[1] = partsX;
                    }

                    if (partsY.compareTo(S[2]) == -1 ) {
                        S[2] = partsY;
                    } else if (partsY.compareTo(S[3]) == 1) {
                        S[3] = partsY;
                    }
                }
            }
        }

        String string = Arrays.toString(S);
        System.out.println("S = " + string);

        BigDecimal[] G = new BigDecimal[4];

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(" ");

            if (parts[2].equals("0")) {
//                System.out.println(Arrays.toString(parts));
                BigDecimal partsX = new BigDecimal(parts[0]);
                BigDecimal partsY = new BigDecimal(parts[1]);

                    if (partsX.compareTo(S[0]) == -1 && (G[0] == null || partsX.compareTo(G[0]) == 1)) {
                        G[0] = partsX;
                    } else if (partsX.compareTo(S[1]) == 1 && (G[1] == null || partsX.compareTo(G[1]) == -1)) {
                        G[1] = partsX;
                    }

                    if (partsY.compareTo(S[2]) == -1 && (G[2] == null || partsY.compareTo(G[2]) == 1)) {
                        G[2] = partsY;
                    } else if (partsY.compareTo(S[3]) == 1 && (G[3] == null || partsY.compareTo(G[3]) == -1)) {
                        G[3] = partsY;
                    }
            }
        }

        string = Arrays.toString(G);
        System.out.println("G = " + string);

    }
}
