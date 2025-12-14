class Solution {
    public int numberOfWays(String corridor) {
        long mod=1_000_000_000+7;
        //0->S P->1
        List<long[]> freq=new ArrayList<>();
        long S=0,P=0,totalSeats=0;
        if(corridor.charAt(0)=='S'){S++;totalSeats++;}
        else P++;
        for(int i=1;i<corridor.length();i++){
            if(corridor.charAt(i-1)!=corridor.charAt(i)){
                if(corridor.charAt(i-1)=='S'){
                    freq.add(new long[]{0,S});
                    S=0;
                }
                else{
                    freq.add(new long[]{1,P});
                    P=0;
                }
            }
            if(corridor.charAt(i)=='S'){S++;totalSeats++;}
            else P++;
        }
        if(corridor.charAt(corridor.length()-1)=='S') freq.add(new long[]{0,S});
        else freq.add(new long[]{1,P});

        if(totalSeats%2!=0||totalSeats==0)return 0;
        

        long prefixSeats=0,ans=1;
        for(long[] cur:freq){
            System.out.println(cur[0]+" "+cur[1]);
            if(cur[0]==0)prefixSeats+=cur[1];
            else{
                long remaining=totalSeats-prefixSeats;
                if(prefixSeats%2==0&&prefixSeats>=2&&remaining>=2){
                    ans*=(cur[1]+1);
                    ans%=mod;
                }
            }
        }
        return (int)ans;


        

    }
}

/**
odd seats ->ans=0

S-2 P-2 S-1 P-1 S-1 P-2 S-2
     3

     SSPSSPSSSPPSPSPPS
       2  2      2
 */