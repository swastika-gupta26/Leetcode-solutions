class Solution {
    public String removeOuterParentheses(String s) {
        String ans ="";
        int previous=0;
        int balance =0;
        for(int i=0; i<s.length(); i++){
          if(s.charAt(i)=='('){
            previous=balance;
            balance++;
            if(previous == 0 && balance ==1){
                ans+="";
            }
            else{
                ans+=s.charAt(i);
            }
          }else{
            previous = balance;
            balance--;
            if(previous ==1 && balance == 0){
                ans+="";
            }
            else{
                ans+=s.charAt(i);
            }
          }
        }
        return ans;
    }
}