class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,TreeSet<Integer>> X=new HashMap<>();
        Map<Integer,TreeSet<Integer>> Y=new HashMap<>();

        for(int[] cor:buildings){
            TreeSet<Integer> tX=X.get(cor[0]);
            if(tX==null)tX=new TreeSet<>();
            tX.add(cor[1]);
            X.put(cor[0],tX);

            TreeSet<Integer> tY=Y.get(cor[1]);
            if(tY==null)tY=new TreeSet<>();
            tY.add(cor[0]);
            Y.put(cor[1],tY);

        }
        int ans=0;
        for(int[] cor:buildings){
            int x=cor[0],y=cor[1];
            TreeSet<Integer> tX=X.get(x);
            TreeSet<Integer> tY=Y.get(y);

            if(tX!=null&&tY!=null&&tX.lower(y)!=null&&tX.higher(y)!=null
            &&tY.lower(x)!=null&&tY.higher(x)!=null)ans++;

        }
        return ans;

    }
}