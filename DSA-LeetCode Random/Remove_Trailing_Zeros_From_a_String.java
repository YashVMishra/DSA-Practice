public class Remove_Trailing_Zeros_From_a_String {
    public static void main(String[] args) {
        String num = "0";
        System.out.println(removeTrailingZeros(num));
    }

    public static String removeTrailingZeros(String num) {
        int index = num.length();

        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                index = i;
            }

            else {
                break;
            }
        }

        return num.substring(0, index);
    }
}
