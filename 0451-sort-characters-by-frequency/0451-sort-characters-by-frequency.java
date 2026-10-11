class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char ch: s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }
        List<Character> list = new ArrayList<>();
        for(char ch : mp.keySet()){
            list.add(ch);
        }
        list.sort((a,b) -> mp.get(b) - mp.get(a));
        String ans ="";
        for(char ch : list){
            int count = mp.get(ch);
            while(count != 0){
              ans += ch;
              count--;
            }
        } return ans;
    }
}