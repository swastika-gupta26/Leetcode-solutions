class Solution {
    public int maximumLengthSubstring(String s) {
        int n =s.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        int left=0;
        int maxm_count=0;
        for (int right = 0; right < n; right++) {
            mp.put(s.charAt(right), mp.getOrDefault(s.charAt(right), 0) + 1);

            while (mp.get(s.charAt(right)) > 2) {
                char ch = s.charAt(left);
                if (mp.get(ch) == 1) {
                    mp.remove(ch);
                } else {
                    mp.put(ch, mp.get(ch) - 1);
                }
                left++;
            }
            maxm_count= Math.max(maxm_count, right-left+1);
        }
        return maxm_count;
    }
}