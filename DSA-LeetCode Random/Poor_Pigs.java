// https://leetcode.com/problems/poor-pigs/description/?envType=daily-question&envId=2023-10-29

public class Poor_Pigs {
    public static void main(String[] args) {
        System.out.println(poorPigs(1000, 15, 60));
        System.out.println(poorPigs(4, 15, 15));
        System.out.println(poorPigs(4, 15, 30));
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int trials = minutesToTest / minutesToDie + 1;
        int pigs = 0;

        while (Math.pow(trials, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }
}