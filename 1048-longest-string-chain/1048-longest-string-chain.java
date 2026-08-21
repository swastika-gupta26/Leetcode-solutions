class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)-> a.length()- b.length());
        int dp[]= new int[words.length];
        int ans=1;
        Arrays.fill(dp, 1);
        HashMap<String, Integer> mp= new HashMap<>();
        for(int k=0; k<words.length; k++){
            mp.put(words[k], k);
        }
        for(int i = 1; i<dp.length; i++){
           int length =  words[i].length();
           String s= words[i];
           for(int j=0; j<length; j++){
              String new_s = s.substring(0, j) + s.substring(j + 1);
              if(mp.containsKey(new_s)==true){
                dp[i]= Math.max(dp[mp.get(new_s)]+1, dp[i]);
              }
           }
           ans= Math.max(ans, dp[i]);
        }
        return ans;
    }
}