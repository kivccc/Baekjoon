import java.util.*;
import java.io.*;
public class Main {
    public static class Book implements Comparable<Book> {
        int count;
        String name;
        public Book(String name,int count){
            this.count=count;
            this.name=name;
        }
        @Override
        public int compareTo(Book o){
            if(this.count!=o.count)
                return o.count-this.count;
            return this.name.compareTo(o.name);
        }
    }
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String book=br.readLine();
            map.put(book,map.getOrDefault(book,0)+1);
        }
        PriorityQueue<Book> pq=new PriorityQueue<>();
        for(String name:map.keySet())
            pq.add(new Book(name,map.get(name)));
        System.out.println(pq.poll().name);
	}
}