// https://leetcode.com/problems/count-items-matching-a-rule/description/

import java.util.List;

public class Count_Items_Matching_a_Rule {
    public static void main(String[] args) {
        List<List<String>> items = List.of(
                List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"),
                List.of("phone", "gold", "iphone"));
        String ruleKey = "color";
        String ruleValue = "silver";
        System.out.println(countMatches(items, ruleKey, ruleValue));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;

        for (List<String> item : items) {
            if (ruleKey.equals("type") && item.get(0).equals(ruleValue)) {
                count++;
            } else if (ruleKey.equals("color") && item.get(1).equals(ruleValue)) {
                count++;
            } else if (ruleKey.equals("name") && item.get(2).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }
}
