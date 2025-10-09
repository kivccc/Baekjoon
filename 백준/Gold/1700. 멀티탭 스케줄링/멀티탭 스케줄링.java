import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        for(int i=0;i<k;i++){
            int target = arr[i];
            if(set.contains(target)) continue; // 이미 꽂혀있으면
            if(set.size()<n){                  // 남아있는 플러그가 있으면
                set.add(target);
                continue;
            }
            
            int max = -1;
            int unplug = -1;
            for(int s:set){
                int next = k;
                for(int j=i+1;j<k;j++){
                    if(arr[j] == s){
                        next = j;
                        break;
                    }
                }
                if(next > max){
                    max = next;
                    unplug = s;
                }
            }
            
            set.remove(unplug);
            set.add(target);
            answer++;
        }
        System.out.println(answer);
        //
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}