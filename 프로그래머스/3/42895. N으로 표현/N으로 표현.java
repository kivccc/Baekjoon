import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        Set<Integer>[] dp = new HashSet[9]; 
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
            int concat = Integer.parseInt(String.valueOf(N).repeat(i));
            dp[i].add(concat); 
            System.out.println(Arrays.toString(dp));
            for (int j = 1; j < i; j++) {
                for (int op1 : dp[j]) {
                    for (int op2 : dp[i - j]) {
                        dp[i].add(op1 + op2);
                        dp[i].add(op1 - op2);
                        dp[i].add(op1 * op2);
                        if (op2 != 0) dp[i].add(op1 / op2);
                    }
                }
            }

            if (dp[i].contains(number)) return i;
        }

        return -1;
    }
}
