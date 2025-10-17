import java.util.*;
import java.io.*;
public class Main {
    static class Person{
        String name;
        
        Person(String name){
            this.name = name;
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            
            Person person = (Person) o;
            return Objects.equals(name,person.name);
        }
        @Override
        public int hashCode(){
            return Objects.hash(name);
        }
    }
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int n = Integer.parseInt(st.nextToken());
        HashSet<Person> set = new HashSet<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();
            if(action.equals("enter"))
                set.add(new Person(name));
            else if(action.equals("leave") && set.contains(new Person(name)))
                set.remove(new Person(name));
        }
        ArrayList<String> list = new ArrayList<>();
        for(Person person : set)
            list.add(person.name);
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1;i>=0;i--)
            sb.append(list.get(i)).append("\n");
        System.out.println(sb);

        //
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}