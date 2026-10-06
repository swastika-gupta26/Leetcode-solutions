class Solution {
    public int minAddToMakeValid(String s) {
        int balance =0;
        int answer =0;
        char ch[] = s.toCharArray();
        for(int i=0; i<ch.length; i++){
            if(ch[i] == '('){
                balance++;
            }
            else{
                if(balance == 0){
                    answer++;
                }
                else{
                    balance--;
                }
            }
        }
        if(balance != 0){
            return balance;
        } else{
           return answer + balance;
        }
    
       
        
    }
}