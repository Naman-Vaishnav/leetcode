class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList<>();
        
        for(int[] cur:intervals){
            if(newInterval==null||cur[1]<newInterval[0]){
                ans.add(cur);
            }
            else if(newInterval[1]<cur[0]){
                ans.add(newInterval);
                ans.add(cur);
                newInterval=null;
            }
            else{
                newInterval[0]=Math.min(newInterval[0],cur[0]);
                newInterval[1]=Math.max(newInterval[1],cur[1]);
            }

        }
        if(newInterval!=null)ans.add(newInterval);
        


        int[][] ansArray=new int[ans.size()][2];
        int i=0;
        for(int[] cur:ans){
            ansArray[i][0]=cur[0];
            ansArray[i][1]=cur[1];
            i++;
        }
        return ansArray;

    }
}