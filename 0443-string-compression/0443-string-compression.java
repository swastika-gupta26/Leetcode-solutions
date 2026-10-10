class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int left = 0;
        int right = 0;
        int index = 0;
        String s = "";
        while (right < n) {

            while (right < n && chars[left] == chars[right]) {
                right++;
            }
            int length = right - left;
            if (length == 1) {
                s = s + chars[left];
            } else {
                String string_length = String.valueOf(length);
                s = s + chars[left] + string_length;
            }

            left = right;
        }
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();

    }
}