class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        ans.add(intervals[0]);

        for(int[] cur:intervals){
            int st=cur[0];
            int end=cur[1];
            int lastEnd=ans.get(ans.size()-1)[1];

            if(st<=lastEnd){
                ans.get(ans.size()-1)[1]=Math.max(lastEnd,end);
            }
            else{
                ans.add(cur);
            }

        }

        return ans.toArray(new int[ans.size()][]);


    }
}