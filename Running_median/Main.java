import java.util.*;
import java.io.*;

public class Main {
    public static class MedianPriorityQueue {
        PriorityQueue<Long> left;
        PriorityQueue<Long> right;
    
        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(long val) {
            left.add(val);
            right.add(left.poll());

            if(left.size() < right.size()) {
                left.add(right.poll());
            }
        }


        public long peek() {
            if(left.size() == 0) return -1;
            if(left.size() > right.size()) {
                return left.peek();
            } else {
                return (left.peek() + right.peek()) / 2;
            }
        }
      
        public int size() {
            return left.size() + right.size();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text;
        
        MedianPriorityQueue qu = new MedianPriorityQueue();
        Queue<Long> res = new LinkedList<>();
        while((text = br.readLine()) != null && text.length()!=0) {
            qu.add(Long.parseLong(text.trim()));
            res.add(qu.peek());
        }   
        for(Long ele : res) {
            System.out.println(ele);
        }
        
    }
}
