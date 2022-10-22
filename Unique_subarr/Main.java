import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        String[] text = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < num) {
            int ele = Integer.parseInt(text[right]);
            map.put(ele, map.getOrDefault(ele,0) + 1);
            
            while (map.get(ele) > 1) {
                int l_ele = Integer.parseInt(text[left]);
                map.put(l_ele, map.get(l_ele) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        System.out.println(res);
    }
}