// https://leetcode.com/problems/find-unique-binary-string/description/?envType=daily-question&envId=2023-11-16

import java.util.HashSet;

public class Find_Unique_Binary_String {
    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[] { "111", "011", "000", }));
    }

    public static String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // convert the binary string to integer and store it in the set
        for (String s : nums) {
            set.add(Integer.parseInt(s, 2));
        }

        // logic is that all the numbers will be from
        // 0 to 2^n - 1
        int length = nums.length;
        int upperLimit = (int) Math.pow(2, length);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < upperLimit; i++) {
            if (!set.contains(i)) {
                sb.append(Integer.toBinaryString(i));
                break;
            }
        }

        // make the length of the string equal to the length of the array
        if (sb.length() < length) {
            int diff = length - sb.length();

            while (diff-- > 0) {
                sb.insert(0, "0");
            }
        }

        return sb.toString();
    }

    // --------------------------------------------------------------------------------

    // this is a better solution
    // in this we change one digit from every given string
    // so that we can get a unique string
    public static String findDifferentBinaryString_2(String[] nums) {
        int length = nums.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (nums[i].charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }
}
