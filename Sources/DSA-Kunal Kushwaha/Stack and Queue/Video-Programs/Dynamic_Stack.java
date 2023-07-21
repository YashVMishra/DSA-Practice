public class Dynamic_Stack extends Static_Stack {

    public Dynamic_Stack() {
        super();
    }

    public Dynamic_Stack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            // double the array size.
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }

        return super.push(item);
    }
}
