class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
    
        boolean dp[]= new boolean[n+1];
        dp[0]= true;
        for(int i=1; i<n+1; i++ ){
            for(int j=0; j<i; j++){
                if(dp[j]==true){
                    if(wordDict.contains(s.substring(j,i))==true){
                        dp[i]=true;
                    }
                }
            }
        }
        if(dp[n]==true){
            return true;
        } else{
            return false;
        }
    }
}