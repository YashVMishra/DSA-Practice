//https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string0652/1?page=2&company[]=SAP%20Labs&sortBy=submissions

public class Count_Palindrome_Sub_Strings_of_a_String {
    public static void main(String[] args) {
        String str = "abaab";
        System.out.println(CountPS(str, str.length()));
    }

    public static int CountPS(String str, int N) {
        if (str.length() == 0) {
            return 0;
        }

        char[] temp = str.toCharArray();
        int count = 0;

        for (int i = 0; i < temp.length; i++) {
            // Cheack for odd and even lengths
            // Center of odd -> (i,i)
            // Center of even -> (i.i+1).

            count += isPalin(i, i, temp);
            count += isPalin(i, i + 1, temp);
        }

        // we have minus the str length as in question they are not considering
        // single character as palindrome.
        return count - str.length();
    }

    public static int isPalin(int start, int end, char[] temp) {
        int count = 0;

        while (start >= 0 && end < temp.length && temp[start--] == temp[end++]) {
            count++;
        }

        return count;
    }
}
