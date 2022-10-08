import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aabab", 3));
    }

    static int countOfSubstrings(String S, int K) {
        // Store the count
        int count = 0;

        // Store the count of distinct characters
        // in every window
        Map<Character, Integer> map = new HashMap<>();

        // Store the frequency of the first K length substring
        for (int i = 0; i < K; i++) {

            // Increase frequency of i-th character
            if (map.get(S.charAt(i)) == null) {
                map.put(S.charAt(i), 1);
            } else {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            }
        }

        // If K distinct characters
        // exist
        if (map.size() == K - 1)
            count++;

        // Traverse the rest of the
        // substring
        for (int i = K; i < S.length(); i++) {

            // Increase the frequency
            // of the last character
            // of the current substring
            if (map.get(S.charAt(i)) == null) {
                map.put(S.charAt(i), 1);
            } else {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            }


            // Decrease the frequency of the first character
            // of the previous substring
            map.put(S.charAt(i - K), map.get(S.charAt(i - K)) - 1);

            // If the character is not present
            // in the current substring
            if (map.get(S.charAt(i - K)) == 0) {
                map.remove(S.charAt(i - K));
            }


            // If the count of distinct
            // characters is k-1
            if (map.size() == K - 1) {
                count++;
            }

        }

        return count;
    }
}