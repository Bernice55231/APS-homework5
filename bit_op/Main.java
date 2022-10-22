import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] text;
        int[] res = new int[32];
        for(int i = 0; i < num; i++) {
            text = br.readLine().split(" ");
            if(text[0].equals("ONE")) {
                res[Integer.parseInt(text[1])] = 1;
            }
            if(text[0].equals("ZERO")) {
                res[Integer.parseInt(text[1])] = 0;
            }
            if(text[0].equals("EITHER")) {
                res[Integer.parseInt(text[1])] = res[Integer.parseInt(text[1])] | res[Integer.parseInt(text[2])];
            }
            if(text[0].equals("BOTH")) {
                res[Integer.parseInt(text[1])] = res[Integer.parseInt(text[1])] & res[Integer.parseInt(text[2])];
            }
        }
        StringBuilder output = new StringBuilder();
        for(int i = 31; i >= 0; i--) {
            output.append(res[i]);
        }
        System.out.print(output.toString());
    }
}