import java.util.*;
import java.io.*;
public class Main {
    public static class ArrayStack{
        int top_idx;
        int size;
        int[] stack;
        public ArrayStack(){
            stack=new int[10000];
            top_idx=-1;
            size=0;
        }
        public void push(int val){
            top_idx++;
            size++;
            stack[top_idx]=val;
        }
        public int pop(){
            if(size==0)
                return -1;
            else{
                int tmp=stack[top_idx];
                top_idx--;
                size--;
                return tmp;
            }
        }
        public int getSize(){
            return size;            
        }
        public int isEmpty(){
            if(size==0)
                return 1;
            else 
                return 0;
        }
        public int getTop(){
            if(size==0)
                return -1;
            else{
                return stack[top_idx];
            }
        }
    }
	public static void main(String[] args) throws IOException {
        //Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        ArrayStack stack=new ArrayStack();
        for(int i=0;i<N;i++){
            String cmd=br.readLine();
            if(cmd.equals("top")){
                bw.write(Integer.toString(stack.getTop()));
                bw.write("\n");
            }
            else if(cmd.equals("size")){
                bw.write(Integer.toString(stack.getSize()));
                bw.write("\n");
            }
            else if(cmd.equals("empty")){
                bw.write(Integer.toString(stack.isEmpty()));
                bw.write("\n");
            }
            else if(cmd.equals("pop")){
                bw.write(Integer.toString(stack.pop()));
                bw.write("\n");
            }
            else{
                String[] sa=cmd.split(" ");
                stack.push(Integer.parseInt(sa[1]));
            }
        }
        bw.flush();
	}
}