class Solution {
    Map<String,List<String>> childs;
    Map<String,Boolean> dp;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        childs=new HashMap<>();
        dp=new HashMap<>();
        for(String cur:allowed){
            String key=cur.substring(0,2);
            String value=cur.substring(2);
            List<String> list=childs.get(key);
            if(list==null)list=new ArrayList<>();
            list.add(value);
            childs.put(key,list);
        }
        StringBuilder next=new StringBuilder();
        return isPossible(0,bottom,next);
    }

    boolean isPossible(int i,String cur,StringBuilder next){

        

        if(i==cur.length()-1){
            if(next.length()==1)return true;

            if(dp.get(next.toString())!=null)return dp.get(next.toString());

            boolean possible=isPossible(0,next.toString(),new StringBuilder());
            dp.put(next.toString(),possible);

            if(possible)return true;
            return false;
        }
        //System.out.println(cur);
        String key=cur.charAt(i)+""+cur.charAt(i+1);
        if(!childs.containsKey(key))return false;
        for(String ch:childs.get(key)){
            next.append(ch);
            if(isPossible(i+1,cur,next))return true;
            next.deleteCharAt(next.length()-1);
        }



        return false;

    }
}

/**
solve(i,cur,next)
    if(i==cur.length()){
        if(next.length()==1)return true;
        if(isPossible(0,next,"")) return true;
        else return false;
    }
    key=i ,i+1
    for(childs)
        if(solve(i+2,cur,next+[ch]))
 */