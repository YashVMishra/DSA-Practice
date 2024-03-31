// https://leetcode.com/problems/defanging-an-ip-address/description/

public class Defanging_an_IP_Address {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (char ch : address.toCharArray()) {
            if (ch != '.') {
                sb.append(ch);
            } else {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }
}
