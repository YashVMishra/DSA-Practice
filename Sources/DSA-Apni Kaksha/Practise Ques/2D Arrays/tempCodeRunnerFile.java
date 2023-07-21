public static ArrayList<Integer> traveral_2(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        ArrayList<Integer> list = new ArrayList<>();

        // write down the indexes of each element and then try to make a pattern out of
        // it.
        // for elements above the main diagonal including the main diagonal
        for (int i = 0; i <= col - 1; i++) {
            int k = i;
            for (int j = 0; j <= i; j++) {
                list.add(arr[j][k]);
                k--;
            }
        }

        // for rest of the elements.
        // use the same appraoch.
        for (int i = 1; i < row; i++) {
            int k = col - 1;
            for (int j = i; j <= row - 1; j++) {
                list.add(arr[j][k]);
                k--;
            }
        }

        return list;
    }