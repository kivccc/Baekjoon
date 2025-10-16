import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arrA = new long[n];
        long[] arrB = new long[n];
        long[] arrC = new long[n];
        long[] arrD = new long[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrA[i] = Long.parseLong(st.nextToken());
            arrB[i] = Long.parseLong(st.nextToken());
            arrC[i] = Long.parseLong(st.nextToken());
            arrD[i] = Long.parseLong(st.nextToken());
        }

        int size = n * n;
        long[] ab = new long[size];
        long[] cd = new long[size];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = arrA[i] + arrB[j];
                cd[idx] = arrC[i] + arrD[j];
                idx++;
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long answer = 0;
        int idxAB = 0;
        int idxCD = size - 1;

        while (idxAB < size && idxCD >= 0) {
            long sum = ab[idxAB] + cd[idxCD];

            if (sum < 0) {
                idxAB++;
            } else if (sum > 0) {
                idxCD--;
            } else {
                long valAB = ab[idxAB];
                long countAB = 0;
                while (idxAB < size && ab[idxAB] == valAB) {
                    countAB++;
                    idxAB++;
                }

                long valCD = cd[idxCD];
                long countCD = 0;
                while (idxCD >= 0 && cd[idxCD] == valCD) {
                    countCD++;
                    idxCD--;
                }
                answer += countAB * countCD;
            }
        }
        System.out.println(answer);
    }
}