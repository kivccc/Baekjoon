import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        long cost; 

        Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost); 
        }
    }

    static HashMap<Integer, HashMap<Integer, Integer>> reversedMap = new HashMap<>();
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            reversedMap.put(i, new HashMap<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (!reversedMap.get(v).containsKey(u) || reversedMap.get(v).get(u) > c) {
                reversedMap.get(v).put(u, c);
            }
        }

        int[] test = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            test[i] = Integer.parseInt(st.nextToken());
        }

        long[] dist = dijkstra(test); 

        long maxDist = -1; 
        int answerCity = -1;

        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                answerCity = i;
            }
        }

        System.out.println(answerCity);
        System.out.println(maxDist);
    }

    static long[] dijkstra(int[] startNodes) { 
        long[] dist = new long[n + 1]; 
        Arrays.fill(dist, Long.MAX_VALUE); 
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int startNode : startNodes) {
            dist[startNode] = 0;
            pq.add(new Node(startNode, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;
            long cost = cur.cost; 

            if (cost > dist[now]) continue;
            
            for (int next : reversedMap.get(now).keySet()) {
                long newCost = dist[now] + reversedMap.get(now).get(next);
                if (dist[next] > newCost) {
                    dist[next] = newCost;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }
        return dist;
    }
}