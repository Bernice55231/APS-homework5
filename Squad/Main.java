import java.util.*;
import java.io.*;

public class Main {
    public static class MedianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
    
        public MedianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            left.add(val);
            right.add(left.poll());

            if(left.size() < right.size()) {
                left.add(right.poll());
            }
        }


        public int peek() {
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
        String[] text = br.readLine().split(" ");

        MedianPriorityQueue qu = new MedianPriorityQueue();
        for(int i = 1; i < Integer.parseInt(text[0]) + 1; i++) {
            qu.add(Integer.parseInt(text[i]));
        }
        System.out.println(qu.peek());
        
        
        
        
        
    }
}
