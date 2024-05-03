// https://leetcode.com/problems/compare-version-numbers/description/?envType=daily-question&envId=2024-05-03

public class Compare_Version_Numbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0, j = 0;

        while (i < v1.length && j < v2.length) {
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[j])) {
                return 1;
            } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[j])) {
                return -1;
            }

            i++;
            j++;
        }

        while (i < v1.length) {
            if (Integer.parseInt(v1[i]) > 0) {
                return 1;
            }

            i++;
        }

        while (j < v2.length) {
            if (Integer.parseInt(v2[j]) > 0) {
                return -1;
            }

            j++;
        }

        return 0;
    }
}
