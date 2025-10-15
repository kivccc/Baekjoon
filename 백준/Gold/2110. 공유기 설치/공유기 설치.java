import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] pos = new int[n];
        for(int i=0;i<n;i++){
            pos[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(pos);
        int left = 1;
        int right = pos[n-1] - pos[0] +1;
        
        while(left<right){
            int mid = (left + right) / 2;
            
            int count = 1;
            int last = pos[0];
            
            for(int i=1;i<n;i++){
                int tPos = pos[i];
                
                if(tPos - last >= mid ){
                    count++;
                    last = tPos;
                }
            }
            
            if(count < c){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(left-1);
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}