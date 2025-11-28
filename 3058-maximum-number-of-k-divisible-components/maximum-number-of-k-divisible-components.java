class Solution {
    int ans=0;
    long dfs(int cur,int par,List<List<Integer>> adj, int[] values, int k){

        if(adj.get(cur).size()==0){
            int leaf=cur;
            if(values[leaf]%k==0){ans++;return 0;}
            return values[leaf];
        }
        long curSubTreeSum=values[cur];
        for(int child:adj.get(cur)){
            if(child==par)continue;
            curSubTreeSum+=dfs(child,cur,adj,values,k);
        }
        if(curSubTreeSum%k==0){ans++;return 0;}
        return curSubTreeSum;
    }
    List<List<Integer>> adj=new ArrayList<>();
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
         dfs(0,-1,adj,values,k);
        return ans;
    }
}