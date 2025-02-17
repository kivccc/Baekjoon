import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<N;i++){
            String cmd=br.readLine();
            if(!cmd.contains(" ")){
                switch(cmd){
                    case "empty":
                        set.clear();
                        break;
                    case "all":
                        set=new HashSet<>();
                        for(int v=1;v<=20;v++)
                            set.add(v);
                        break;                        
                }
            }
            else{
                String[] s=cmd.split(" ");
                switch(s[0]){
                    case "add":
                        set.add(Integer.parseInt(s[1]));
                        break;
                    case "remove":
                        set.remove(Integer.parseInt(s[1]));
                        break;                       
                    case "check":
                        if(set.contains(Integer.parseInt(s[1])))
                            bw.write("1\n");
                        else
                            bw.write("0\n");
                        break;
                    case "toggle":
                        if(set.contains(Integer.parseInt(s[1])))
                            set.remove(Integer.parseInt(s[1]));
                        else
                            set.add(Integer.parseInt(s[1]));
                        break;
                }
            }
            //System.out.println(set);
        }
        bw.flush();
	}

}