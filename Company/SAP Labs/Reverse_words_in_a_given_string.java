//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1?page=1&company[]=SAP%20Labs&sortBy=submissions

public class Reverse_words_in_a_given_string {
    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        System.out.println(reverseWords(S));
    }

    public static String reverseWords(String str) {
        String ans = "";
        str = str + ".";
        String word = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != '.') {
                word = word + ch;
            } else {

                // add the reversed current word to answer string and reset it as empty again
                ans = word + "." + ans;
                word = "";
            }
        }

        // returning substring till second last character as last character is '.'
        return ans.substring(0, ans.length() - 1);
    }

}
