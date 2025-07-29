import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[] rowBingo = new boolean[5];
    static boolean[] colBingo = new boolean[5];
    static boolean diag1Bingo = false;
    static boolean diag2Bingo = false;
    static int bingoCount = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int next = Integer.parseInt(st.nextToken());
                erase(next);
                answer++;
                if (checkBingo()) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }

    public static void erase(int val) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == val) {
                    arr[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static boolean checkBingo() {
        for (int i = 0; i < 5; i++) {
            if (!rowBingo[i]) {
                boolean allZero = true;
                for (int j = 0; j < 5; j++) {
                    if (arr[i][j] != 0) {
                        allZero = false;
                        break;
                    }
                }
                if (allZero) {
                    rowBingo[i] = true;
                    bingoCount++;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (!colBingo[i]) {
                boolean allZero = true;
                for (int j = 0; j < 5; j++) {
                    if (arr[j][i] != 0) {
                        allZero = false;
                        break;
                    }
                }
                if (allZero) {
                    colBingo[i] = true;
                    bingoCount++;
                }
            }
        }

        if (!diag1Bingo) {
            boolean allZero = true;
            for (int i = 0; i < 5; i++) {
                if (arr[i][i] != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                diag1Bingo = true;
                bingoCount++;
            }
        }

        if (!diag2Bingo) {
            boolean allZero = true;
            for (int i = 0; i < 5; i++) {
                if (arr[i][4 - i] != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                diag2Bingo = true;
                bingoCount++;
            }
        }

        return bingoCount >= 3;
    }
}
