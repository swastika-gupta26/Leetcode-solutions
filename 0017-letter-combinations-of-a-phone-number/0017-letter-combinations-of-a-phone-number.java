class Solution {
    static String codes[]={
        "","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            List<String> bres= new ArrayList<>();
            bres.add("");
            return bres;
        }
        List<String> rres= letterCombinations(digits.substring(1));
        List<String> ans=new ArrayList<>();
        String code=codes[digits.charAt(0)-'0'];
        char ch[]= code.toCharArray();
       
            for(int i=0; i<ch.length; i++){
             for(String x: rres){
                ans.add(ch[i]+x);
             }
            }
            return ans;
        
    }
}