package Arrays;

public class Array2D {
    public static void main(String[] args) {
        int[][] int2DArray1 = new int[3][];
        int[][] int2DArray = new int[3][5];

        int2DArray[2][4] = 10; //3rd row
        int2DArray[0][3] = 12; //1st row

        int[][] arr = {{1,2},{3,4},{5,6,7}};

        // two loops to navigate through the elements
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(int2DArray[2][4]);
       // System.out.println(int2DArray1[0][0]); //error: NullPointerException
        int x = 10, y = 3;
        double z = (double)x/y;
        double p = x/(double)y;
        System.out.println(z);
        System.out.println(p);

    }
}
