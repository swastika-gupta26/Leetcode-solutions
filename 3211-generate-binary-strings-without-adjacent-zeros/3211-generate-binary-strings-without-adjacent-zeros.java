class Solution {
    public List<String> ans = new ArrayList<>();

    public List<String> validStrings(int n) {
        List<String> ozero = new ArrayList<>();
        List<String> oone = new ArrayList<>();
        ozero.add("0");
        oone.add("1");
        helper(ozero, oone, 1, n);
        return ans;
    }

    public void helper(List<String> ozero, List<String> oone, int idx, int n) {
        if (idx == n) {
            for (String x : ozero) {
                ans.add(x);
            }
            for (String x : oone) {
                ans.add(x);
            }
            return;
        }
        List<String> nzero = new ArrayList<>();
        for (String x : oone) {
            nzero.add(x + '0');
        }
        List<String> none = new ArrayList<>();
        for (String x : oone) {
            none.add(x + '1');
        }
        for (String x : ozero) {
            none.add(x + '1');
        }
        ozero= nzero;
        oone=none;
        helper(ozero, oone, idx + 1, n);

    }
}