//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

public class First_Occurence {
    public static void main(String[] args) {
        System.out.println(strStr_2("mississippi", "issipi"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr_2(String haystack, String needle) {

        if (haystack.length() <= needle.length()) {

            int index = -1;

            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    index = i;
                    for (int j = 0; j < needle.length(); j++) {

                        // do (i+j) checking first we are using && if we find the first
                        // condition as false then it will not check the next one
                        // so for that reason we have wriithen the (i+j) condition first.
                        if (((i + j) < haystack.length()) && (haystack.charAt(i + j) == needle.charAt(j))) {
                            ;
                        }

                        else {
                            index = -1; // important as it will hold the index of the first character as it matches.
                            break;
                        }
                    }

                    if (index != -1) {
                        break;
                    }
                }
            }

            return index;
        }

        else {
            return -1;
        }

    }
}
