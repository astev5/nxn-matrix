package cstevens_week8;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Chad Stevens
 * @Assignment Name: Week 8 Assignment
 * @Date: Jul 6, 2021
 * @Description: Multidimensional Arrays
 */
//Imports
import java.util.Scanner;

//Begin Class Main
public class Main {

    //Begin Main Method
    public static void main(String[] args) {

        // Declarations
        String again;           //used to run again
        int iRowCol;
        int iRowCnt;
        int iColCnt;
        //iColCnt = 0;

        // Create an object of the Scanner
        Scanner sc = new Scanner(System.in);

        System.out.print("\nWelcome! This program that accepts an n x n "
                + "matrix,\ntotals the rows and columns & finds the product "
                + "of\neach row and column.\n");

        // Begin DO WHILE loop to re-run the program
        do {

            // Accept user input for number of rows and columns
            System.out.print("\nPlease enter a number of rows and columns "
                    + "(they will be the same): ");
            iRowCol = sc.nextInt();

            // Declare the matrix
            int[][] numMatrix = new int[iRowCol][iRowCol];

            /* Accept values for the matrix
             * Enter the first row and populate the columns
             * Advance to the next row and repeat
             */
            for (iRowCnt = 0; iRowCnt < iRowCol; iRowCnt++) {
                for (iColCnt = 0; iColCnt < iRowCol; iColCnt++) {
                    System.out.printf("Enter value of Row %d, Column %d: ",
                            iRowCnt + 1, iColCnt + 1);
                    numMatrix[iRowCnt][iColCnt] = sc.nextInt();
                    sc.nextLine();
                }
            }

            // Call to display matrix in matrix format
            System.out.print("\nThe Matrix**************************");
            displayMatrix(numMatrix);

            // Call to display total of each row
            System.out.print("\nRow Totals**************************\n");
            totalRows(numMatrix);

            // Call to display total of each column
            System.out.print("\nColumn Totals***********************\n");
            totalCols(numMatrix);

            // Call to display product of each row
            System.out.print("\nRow Products************************\n");
            prodRows(numMatrix);

            // Call to display product of each column
            System.out.print("\nColumn Products*********************\n");
            prodCols(numMatrix);

            // Call to display the greatest value in the matrix
            maxMatrix(numMatrix);

            // Call to display the lowest value in the matrix
            minMatrix(numMatrix);

            // request input to continue program
            System.out.print("\n\nEnter another matrix? (Y or N): ");
            again = sc.nextLine();

        } while (again.equalsIgnoreCase("Y"));

        System.out.print("\nThank you for using the program!\nGoodbye!\n\n");

    } //End Main Method

    /**
     * Method @displayMatrix: Displays Matrix based on user input     
     * @param array 
     */
    public static void displayMatrix(int array[][]) {
        System.out.print("\nYou entered the following Matrix:\n\t");
        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array.length; cols++) {
                System.out.printf("%d\t", array[rows][cols]);
            }
            System.out.print("\n\t");
        }

    } // End displayMatrix method

    /**
     * Method @totalRows: Displays the total of each row of the Matrix
     * @param array 
     */
    public static void totalRows(int[][] array) {
        int rowSum = 0;
        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array.length; cols++) {
                rowSum += array[rows][cols];
            }
            System.out.printf("The sum of row %d is: %d\n", rows + 1, rowSum);
            rowSum = 0; // Reset the sum before next row
        }
    } // End totalRows method

    /**
     * Method @totalCols: Displays the total of each column of the Matrix
     * @param array 
     */
    public static void totalCols(int[][] array) {
        int colSum = 0;
        for (int cols = 0; cols < array.length; cols++) {
            for (int rows = 0; rows < array.length; rows++) {
                colSum += array[rows][cols];
            }
            System.out.printf("The sum of column %d is: %d\n", cols + 1, colSum);
            colSum = 0; // Reset the sum before next column
        }
    } // End totalCols method 

    /**
     * Method @prodRows: Displays the product of each row of the Matrix 
     * @param array 
     */
    public static void prodRows(int[][] array) {
        int rowProd = 1;
        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array.length; cols++) {
                rowProd = rowProd * array[rows][cols];
            }
            System.out.printf("The product of row %d is: %d\n",
                    rows + 1, rowProd);
            rowProd = 1; // Reset the product before next row
        }
    } // End prodRows method

    /**
     * Method @prodCols: Displays the product of each column of the Matrix
     * @param array 
     */
    public static void prodCols(int[][] array) {
        int colProd = 1;
        for (int cols = 0; cols < array.length; cols++) {
            for (int rows = 0; rows < array.length; rows++) {
                colProd = colProd * array[rows][cols];
            }
            System.out.printf("The product of column %d is: %d\n",
                    cols + 1, colProd);
            colProd = 1; // Reset the product before next column
        }
    } // End prodCols method      

    /**
     * Method @maxMatrix: Find greatest value in the matrix
     *
     * @param matrix
     */
    public static void maxMatrix(int[][] matrix) {
        int maxNum = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxNum < matrix[i][j]) {
                    maxNum = matrix[i][j];
                }
            }
        }
        System.out.printf("\nThe greatest value in this matrix is: %d\n",
                maxNum);
    } // End maxMatrix method  

    /**
     * Method @minMatrix: Find greatest value in the matrix
     *
     * @param matrix
     */
    public static void minMatrix(int[][] matrix) {
        int minNum = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (minNum > matrix[i][j]) {
                    minNum = matrix[i][j];
                }
            }
        }
        System.out.printf("\nThe lowest value in this matrix is: %d",
                minNum);
    } // End maxMatrix method    

} //End Class Main
