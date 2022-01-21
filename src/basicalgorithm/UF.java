package basicalgorithm;

public class UF {
    private int count;
    private int[] parent;
    private int[] size;

    public UF(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ)
            return;
        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] = size[rootP] + size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] = size[rootQ] + size[rootP];
        }
        count--;
        return;
    }

    public boolean connect(int p, int q){
        if(find(p) == find(q))
            return true;
        else
            return false;
    }

    //find the root
    public int find(int p){
        int x = p;
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x=parent[x];
        }
        return x;
    }

    public int count(){
        return this.count;
    }
}
