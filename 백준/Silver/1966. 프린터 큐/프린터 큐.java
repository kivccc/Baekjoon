import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            LinkedList<int[]> queue = new LinkedList<>(); 
            int N = sc.nextInt();
            int M = sc.nextInt();
            for (int j = 0; j < N; j++) 
                queue.add(new int[]{j, sc.nextInt()});
            
            int answer = 0;
            while (!queue.isEmpty()) {
                int[] front = queue.poll();  
                boolean flag = false;

                for (int[] doc : queue) {  
                    if (front[1] < doc[1]) {
                        queue.add(front); 
                        flag = true;
                        break;
                    }
                }

                if (flag) 
                    continue; 
                
                answer++;
                if (front[0] == M) 
                    break; 
            }
            
            System.out.println(answer);
        }
    }
}
