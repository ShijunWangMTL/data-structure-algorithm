package Arrays;

public class TaskDay2 {
    public static void main(String[] args) {
        int[][] data2D = {
                {1, 3, 6},
                {7, 1, 2, 3, 4, 5},
                {8, 3, 2, 1, 4},
                {1, 7, 1, 9},
        };

        //Using sumOfCross() method write a search that will find
        //which element at row/col has the smallest sum of itself and the cross elements surrounding it.
        int smallest = sumOfCross(data2D, 0, 0);
        int row = 0, colume = 0;
        for (int i = 0; i < data2D.length; i++) {
            for (int j = 0; j < data2D[i].length; j++) {
                if (sumOfCross(data2D, i, j) < smallest) {
                    smallest = sumOfCross(data2D, i, j);
                    row = i;
                    colume = j;
                }
            }
        }
        System.out.printf("The element %d at data2D[%d][%d] has the smallest sumOfCross %d.\n", data2D[row][colume], row, colume, smallest);

        /*Create an integer array data2Dsums of identical size to data2D where
        each element of it is the cross-sum of the element in the original array.
                then print out the original, and print out the new array*/
        int[][] data2Dsums = duplicateEmptyArray2D(data2D);
        for (int i = 0; i < data2Dsums.length; i++) {
            for (int j = 0; j < data2Dsums[i].length; j++) {
                data2Dsums[i][j] = sumOfCross(data2D,i,j);
            }
        }
        print2D(data2D);
        System.out.println();
        print2D(data2Dsums);

    }

    // If exists, return the element, otherwise return 0
    private static int getIfExists(int[][] data, int row, int col) {
        /*if (row < 0 || row >= data.length || col < 0 || col >= data[row].length) return 0;
        return data[row][col];*/
        try {
            return data[row][col];
        }
        catch (ArrayIndexOutOfBoundsException exc){
            return 0;
        }
    }

    // return sum of the element at row/col
    // plus (if they exist) element above, below, to the left and right of it
    static int sumOfCross(int[][] data, int row, int col) {
        int sum = 0;
        sum += getIfExists(data, row, col);
        sum += getIfExists(data, row - 1, col); //above
        sum += getIfExists(data, row, col - 1); // left
        sum += getIfExists(data, row + 1, col); // below
        sum += getIfExists(data, row, col + 1); // right
        return sum;
    }

    // useful helper for debugging
    private static void print2D(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%s%3d", j == 0 ? "" : ",", data[i][j]);
            }
            System.out.println();
        }
    }

    // duplicate a jagged array
    private static int[][] duplicateEmptyArray2D(int[][] orig2d) {
        int[][] orig2dDuplicate = new int[orig2d.length][];
        for (int i = 0; i < orig2d.length; i++) {
            int rowLength = orig2d[i].length;
            orig2dDuplicate[i] = new int[rowLength];

            /*for (int j = 0; j < orig2d[i].length; j++) {
                orig2dDuplicate[i][j] = orig2d[i][j];
            }*/
        }
        return orig2dDuplicate;
    }

}
