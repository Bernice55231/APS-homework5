import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] text;

        int[] groups = new int[1000000];
        for(int i = 0; i < 1000000; i++) {
            groups[i] = -1;
        }

        for(int i = 0; i < n; i++) {
            text = br.readLine().split(" ");
            int len = Integer.parseInt(text[0]);
            if(len == 0) continue;
            int first = Integer.parseInt(text[1]);
            for(int j = 1; j < len+1; j++) {
                groups[Integer.parseInt(text[j])] = first;
            }
        }
        String line;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        Queue<Integer> q_group = new LinkedList<Integer>();
        Queue<Integer> res = new LinkedList<Integer>();
        while(true) {
            line = br.readLine();
            if(line.contains("Shutdown"))
                break;
            if(line.contains("Push")) {
                text = line.split(" ");
                int ele = Integer.parseInt(text[1]);
                int group = groups[ele];
                Queue<Integer> q = map.getOrDefault(group, new LinkedList<Integer>());
                if(q.isEmpty()) {
                    q_group.add(group);
                }
                q.add(ele);
                map.put(group, q);
            } 
            if(line.contains("Pop")) {
                int group = q_group.peek();
                Queue<Integer> q = map.get(group);
                res.add(q.remove());
                if(q.isEmpty()) {
                    q_group.remove();
                }
                map.put(group, q);
            }
        }
        // for(Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
        //     int key = entry.getKey();
        //     String s = entry.getValue().toString();
        //     System.out.println("key=" + key + " queue=" + s);
        // }
        for(Integer i : res) {
            System.out.println(i);
        }
        
    }
}
