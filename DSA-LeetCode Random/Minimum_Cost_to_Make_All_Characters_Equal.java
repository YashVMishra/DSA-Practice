public class Minimum_Cost_to_Make_All_Characters_Equal {
    public static void main(String[] args) {

    }

    public static long minimumCost(String s) {
        return solve(s, 0);
    }

    public static long solve(String str, int index){
        if(index>=str.length()){
            return 0;
        }

        if(allSame(str)){
            return 0;
        }

        int firstOp=Integer.MAX_VALUE;
        int secondOp=Integer.MAX_VALUE;

        for(int i=0;i<str.length();i++){
            firstOp=i+1 + solve(invert(str), index)
        }
    }
}
