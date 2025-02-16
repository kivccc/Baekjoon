import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        //Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm=br.readLine().split(" ");
        int N=Integer.parseInt(nm[0]);
        int M=Integer.parseInt(nm[1]);
        HashSet<String> set1=new HashSet<>();
        HashSet<String> set2=new HashSet<>();
        for(int i=0;i<N;i++)
            set1.add(br.readLine());
        for(int i=0;i<M;i++)
            set2.add(br.readLine());
        set1.retainAll(set2);
        String[] array = set1.toArray(new String[0]);
        Arrays.sort(array);
        System.out.println(array.length);
        for(String s:array)
            System.out.println(s);
            
	}
}