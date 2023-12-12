import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n / 4;
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', -target);
        map.put('W', -target);
        map.put('E', -target);
        map.put('R', -target);

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            int count = map.get(cur);
            count++;
            map.put(cur, count);
        }

        if(map.get('Q') <= 0){
            map.remove('Q');
        }
        if(map.get('W') <= 0){
            map.remove('W');
        }
        if(map.get('E') <= 0){
            map.remove('E');
        }
        if(map.get('R') <= 0){
            map.remove('R');
        }
        if(map.isEmpty()){
            return 0;
        }
        int minWindow = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                count--;
                map.put(ch, count);
            }
            if(map.values().stream().allMatch(v -> v <= 0)){
                minWindow = Math.min(minWindow, right - left + 1);
            }
            while (map.values().stream().allMatch(v -> v <= 0)  && left < right){
                char charLeft = s.charAt(left);
                if(map.containsKey(charLeft)){
                    int count = map.get(charLeft);
                    count++;
                    map.put(charLeft, count);
                }
                left++;
                if(map.values().stream().allMatch(v -> v <= 0)){
                    minWindow = Math.min(minWindow, right - left + 1);
                }
            }


        }

        return minWindow;
    }
}
