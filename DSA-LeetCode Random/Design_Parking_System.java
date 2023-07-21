//https://leetcode.com/problems/design-parking-system/description/

public class Design_Parking_System {
    public static void main(String[] args) {
        ParkingSystem ob = new ParkingSystem(1, 1, 0);
        System.out.println(ob.addCar(1));
        System.out.println(ob.addCar(2));
        System.out.println(ob.addCar(3));
        System.out.println(ob.addCar(1));
    }

}

class ParkingSystem {
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean ans = false;
        if (carType == 1) {
            if (big > 0) {
                big--;
                ans = true;
            }
        }

        else if (carType == 2) {
            if (medium > 0) {
                medium--;
                ans = true;
            }
        }

        else if (carType == 3) {
            if (small > 0) {
                small--;
                ans = true;
            }
        }

        return ans;
    }

}