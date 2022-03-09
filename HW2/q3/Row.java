public class Row {

    private Chair[] left;
    private Chair[] middle;
    private Chair[] right;

    public Row() {

        left = new Chair[3];
        for (int i = 0; i < left.length; i++) {
            left[i] = new Chair();
        }

        middle = new Chair[4];
        for (int i = 0; i < middle.length; i++) {
            middle[i] = new Chair();
        }

        right = new Chair[3];
        for (int i = 0; i < right.length; i++) {
            right[i] = new Chair();
        }
    }
    public boolean getChair(int c) {
        if (c < 4) {
            return left[c - 1].getCondition();
        } else if (c < 8) {
            return middle[c - 4].getCondition();
        } else {
            return right[c - 8].getCondition();
        }
    }

    public void setChair(int c) {
        if (c < 4) {
            left[c - 1].setCondition(!left[c - 1].getCondition());
        } else if (c < 8) {
            middle[c - 4].setCondition(!middle[c - 4].getCondition());
        } else {
            right[c - 8].setCondition(!right[c - 8].getCondition());
        }
    }


}
