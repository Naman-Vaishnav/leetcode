// Last updated: 13/04/2025, 00:32:26
class Solution {
    long countNumbers(long x,int limit,long num,long sLen){
        //2000
        long tenPow=(long)Math.pow(10,sLen);//10
        long preFix=x/tenPow;//2000
        long sufFix=x%tenPow;//0
        if(sufFix<num)preFix--;//199
        if(preFix==-1)return 0L;
        //0 preFix <each digit limit
        String preStr=Long.toString(preFix);//199 
        StringBuilder temp=new StringBuilder();
        int i;
        for(i=0;i<preStr.length();i++){
            if(preStr.charAt(i)-'0'>limit)break;
            temp.append(preStr.charAt(i));
        }
        for(;i<preStr.length();i++){
            temp.append(Integer.toString(limit));
        }
        System.out.println("preStr="+preStr);
        preStr=temp.toString();
        System.out.println("preStr="+preStr);
        long ans=0;//
        tenPow=1L;
        for( i=preStr.length()-1;i>=0;i--){
            long curDigit=preStr.charAt(i)-'0';//9
            long posDig;
            if(i==preStr.length()-1)posDig=curDigit+1;//9
            else posDig=curDigit;//
            ans+=tenPow*(posDig);//9+72+81
            System.out.println(tenPow*(posDig));
            tenPow*=(limit+1);//9*9
        }
        return ans;

    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long num=Long.parseLong(s);
        long sLen=s.length();
        long zeroToFin=countNumbers(finish,limit,num,sLen);
        long zeroToStm1=countNumbers(start-1,limit,num,sLen);
        System.out.println(zeroToFin+" "+zeroToStm1);
        return zeroToFin-zeroToStm1;
    }
}