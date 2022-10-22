import java.io.*;
import java.util.*;
 
class DisjointUnionSets {
    int[] rank, parent;
    int n;
 
    // Constructor
    public DisjointUnionSets(int n)
    {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }
 
    // Creates n sets with single item in each
    void makeSet()
    {
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in
            // their own set.
            parent[i] = i;
        }
    }
 
    // Returns representative of x's set
    int find(int x)
    {
        // Finds the representative of the set
        // that x is an element of
        if (parent[x] != x) {
            // if x is not the parent of itself
            // Then x is not the representative of
            // his set,
            parent[x] = find(parent[x]);
 
            // so we recursively call Find on its parent
            // and move i's node directly under the
            // representative of this set
        }
 
        return parent[x];
    }
 
    // Unites the set that includes x and the set
    // that includes x
    void union(int x, int y)
    {
        // Find representatives of two sets
        int xRoot = find(x), yRoot = find(y);
 
        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot == yRoot)
            return;
 
        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot])
 
            // Then move x under y  so that depth
            // of tree remains less
            parent[xRoot] = yRoot;
 
        // Else if y's rank is less than x's rank
        else if (rank[yRoot] < rank[xRoot])
 
            // Then move y under x so that depth of
            // tree remains less
            parent[yRoot] = xRoot;
 
        else // if ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            parent[yRoot] = xRoot;
 
            // And increment the result tree's
            // rank by 1
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] text;

        DisjointUnionSets gen = new DisjointUnionSets(n);
        
        for(int i = 0; i < n; i++) {
            text = br.readLine().split(" ");
            int len = Integer.parseInt(text[0]);
            DisjointUnionSets dus = new DisjointUnionSets(len);
            for(int j = 2; j <= len; j++) {
                dus.union(Integer.parseInt(text[1]), Integer.parseInt(text[j]));
            }
        }

        int l = gen.parent.length;
        System.out.println("parent array: ");
        for(int i = 0; i < l; i++) {
            System.out.print(gen.parent[i] + " ");
        }
        System.out.println();

        l = gen.rank.length;
        System.out.println("rank array: ");
        for(int i = 0; i < l; i++) {
            System.out.print(gen.rank[i] + " ");
        }
    }
}
