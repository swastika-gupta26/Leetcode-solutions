class Solution {
    public boolean checkDivisibility(int n) {
      
        int original =n;
        int digit_sum=0;
        int product=1;
        while(n >= 1){
            int digit= n%10;
            digit_sum= digit_sum+ digit;
            product = product* digit;
            n=n/10;
        }

        int total_sum= digit_sum +product;
        return original % total_sum == 0;
    }
}