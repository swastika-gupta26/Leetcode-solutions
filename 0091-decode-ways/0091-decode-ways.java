class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return  0;
        }
        int dp[] = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
                dp[i] = 0;
            } else if (s.charAt(i) == '0' && s.charAt(i - 1) != '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2];
                    } else {
                        dp[i] = 1;
                    }
                }
                else{
                    dp[i]=0;
                }
            }
            else if (s.charAt(i) != '0' && s.charAt(i - 1) == '0') {
                       dp[i]=dp[i-1];
            } else {
                int num= (s.charAt(i-1) -'0')*10 +(s.charAt(i)-'0') ;
                if(num>=10 && num<=26){
                    if(i>=2){
                    dp[i]=dp[i-1]+dp[i-2];
                    }else{
                        dp[i]=2;
                    }
                }
                else{
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[s.length()-1];
    }

}