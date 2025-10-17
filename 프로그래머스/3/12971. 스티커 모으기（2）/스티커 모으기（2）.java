import java.util.*;

class Solution {
    public int solution(int[] sticker) {
        int size = sticker.length;

        if (size == 1) {
            return sticker[0];
        }

        int[] dp1 = new int[size];
        for (int i = 0; i < size - 1; i++) {
            dp1[i+1] = sticker[i];
        }

        for (int i = 2; i < size; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + dp1[i]);
        }

        int[] dp2 = new int[size];
        for (int i = 0; i < size - 1; i++) {
            dp2[i+1] = sticker[i+1];
        }

        for (int i = 2; i < size; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + dp2[i]);
        }

        return Math.max(dp1[size - 1], dp2[size - 1]);
    }
}