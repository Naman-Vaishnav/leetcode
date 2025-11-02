class Solution {
    Map<String,String> cell=new HashMap<>();
    Map<Integer,TreeSet<Integer>> row=new HashMap<>();
    Map<Integer,TreeSet<Integer>> col=new HashMap<>();
    boolean isUnguarded(int i,int j){
        if(cell.get(i+"_"+j)!=null)return false;
        Integer right=row.get(i).higher(j);
        Integer left=row.get(i).lower(j);
        Integer up=col.get(j).lower(i);
        Integer down=col.get(j).higher(i);

        if(right!=null&&cell.get(i+"_"+right).equals("G")
        || left!=null&&cell.get(i+"_"+left).equals("G")
        || up!=null&&cell.get(up+"_"+j).equals("G")
        || down!=null&&cell.get(down+"_"+j).equals("G")
        )return false;

        return true;

    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        for(int[] g:guards){
            cell.put(g[0]+"_"+g[1],"G");
        }

        for(int[] w:walls){
            cell.put(w[0]+"_"+w[1],"W");
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 row.put(i, row.getOrDefault(i,new TreeSet<>()));
                 col.put(j, col.getOrDefault(j,new TreeSet<>()));
                if(cell.get(i+"_"+j)!=null){
                    TreeSet<Integer> set = row.get(i);
                    set.add(j);
                    row.put(i, set);

                    set = col.get(j);
                    set.add(i);
                    col.put(j, set);

                    }
            }
        }
         //System.out.println(cell);
         
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isUnguarded(i,j))ans++;
               
            }
        }
        return ans;
    }
}
/**
Each Row -> G ,W
Each Col -> G, W
 */