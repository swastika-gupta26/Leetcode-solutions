class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //odd
            int left = i;
            int right = i;
            while ((left >= 0 && right < n) && s.charAt(right) == s.charAt(left)) {
                count++;
                left--;
                right++;
            }
            left = i - 1;
            right = i;
            while ((left >= 0 && right < n) && s.charAt(right) == s.charAt(left)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}