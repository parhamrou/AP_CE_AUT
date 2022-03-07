public class Cinema {
    
    private int rows;
    private Row[] rowsArray;

    public Cinema(int rows) {
        this.rows = rows;
        rowsArray = new Row[rows];
        for (int i = 0; i < rowsArray.length; i++) {
            rowsArray[i] = new Row();
        }
    }

    public boolean getChair(int c, int r) {
        return rowsArray[r].getChair(c);
    } 

    public void setChair(int c, int r) {
        rowsArray[r].setChair(c);
    }

    public boolean checkChairs(int l, int r, int x) {
        // x : row;   l : leftmost requested chair;  r : rightmost requsted chair
        for (int i = l; i < r + 1; i++) {
            if (rowsArray[x - 1].getChair(i) == true) {
                return false;
            }
        }
        return true;
    }

    public void occupyChairs(int l, int r, int x) {
        for (int i = l; i < r + 1; i++) {
            rowsArray[x - 1].setChair(i);
        }
    }


}
