class Solution {
    boolean canDo(int target,int[] tasks,TreeMap<Integer,Integer> workers,int p,int s){
        //target tasks
        for(int i=target-1;i>=0;i--){
            int curTask=tasks[i];
            Integer ceiling =workers.ceilingKey(curTask);
            if(ceiling==null){
                if(p==0)return false;
                ceiling=workers.ceilingKey(Math.max(curTask-s,0));
                if(ceiling==null)return false;
                p--;
                workers.put(ceiling,workers.get(ceiling)-1);
                
            }
            else workers.put(ceiling,workers.get(ceiling)-1);
            
            if(workers.get(ceiling)==0)workers.remove(ceiling);
             
        }
        return true;

    }
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int t=tasks.length,w=workers.length;
        int l=-1,r=t+1;

        Arrays.sort(tasks);
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int x:workers)tm.put(x,tm.getOrDefault(x,0)+1);

        while(r-l>1){
            int m=l+(r-l)/2;
            if(canDo(m,tasks,new TreeMap<>(tm),pills,strength))l=m;
            else r=m;

        }
        return l;


    }
}