package LeetCode;

public class equationsPossible990 {
    int[] parent;
    int[] size;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        size = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(String str : equations){
            if(str.charAt(1) == '='){
                int p = str.charAt(0) - 'a';
                int q = str.charAt(3) - 'a';
                union(p,q);
            }
        }
        for(String str : equations){
            if(str.charAt(1) == '!'){
                int p = str.charAt(0) - 'a';
                int q = str.charAt(3) - 'a';
                if(connection(p,q))
                    return false;
            }
        }
        return true;
    }

    boolean connection(int p,int q){
        if(find(p) == find(q))
            return true;
        return false;
    }

    void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        return;
    }
    int find(int p){
        int x = p;
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
