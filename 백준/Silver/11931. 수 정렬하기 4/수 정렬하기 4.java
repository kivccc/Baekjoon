import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list,Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(int i:list)
            sb.append(i).append("\n");
        System.out.println(sb);

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}