class Solution {
    List<List<Integer>> adj;
    int[] color;
    boolean isCycle(int i){
        color[i]=1;
        for(int ch:adj.get(i)){
            if(color[ch]==1)return true;
            if(color[ch]==0&&isCycle(ch))return true;
        }
        color[i]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj=new ArrayList<>();
        color=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            int a=edge[0],b=edge[1];
            adj.get(b).add(a);
        }

        for(int i=0;i<numCourses;i++){
            if(color[i]==0&&isCycle(i))return false;
        }
        return true;

    }
}