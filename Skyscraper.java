import java.util.Scanner;

/**
 * Authors:
 * Ran Cheng URID: 31729772 NetID: rcheng9
   Yiwei Han URID: 31826174 NetID: yhan32
 */

public class Skyscraper {
    static int dim;
    static int[][] puzzle;
    static int value=0;
    static boolean flag=true;
    static int n=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dim = sc.nextInt();
        puzzle = new int [dim+2][dim+2];
        for(int i = 1; i < dim+1; i++) {
            for(int j = 1; j < dim+1; j++) {
                puzzle[i][j] = sc.nextInt();
            }
        }
        print();
        verifyPlacement();
        loadPuzzle();
        if(flag){
            printWithVisibility();
        }
    }


    public static void print() {
        //System.out.println(dim);
        for(int i = 1; i < dim + 1; i++) {
            for(int j = 1; j < dim +1; j++) {
                if(j!=dim){
                    System.out.print(puzzle[i][j] + "  ");}
                else{
                    System.out.print(puzzle[i][j]);
                }
            }
            System.out.println();
        }
    }
    public static boolean verifyPlacement() {
        for(int i=1;i<dim+1;i++){
            n=n+i;
        }
        //System.out.println("n is: "+ n);
        for(int i=1;i<dim+1;i++){
            for(int j=1;j<dim+1;j++){
                value=value+puzzle[i][j];
            }
            //System.out.println("value is: "+ value);
            if(value!=n){
                flag=false;
                System.out.println("the puzzle is invalid");
                return flag;
            }
            else{
                value=0;
            }
        }
        for(int j=1;j<dim+1;j++){
            for(int i=1;i<dim+1;i++){
                value=value+puzzle[i][j];
            }
            if(value!=n){
                flag=false;
                System.out.println("the puzzle is invalid");
                return flag;
            }
            else{
                value=0;
            }
        }
        System.out.println("the puzzle is valid");
        return flag;
    }


    public static void loadPuzzle() {
        int temp = 0;
        int sum = 1;
        for(int i = 1; i < dim+1; i++) {
            temp = puzzle[i][1];
            for(int j = 1; j < dim+1; j++) {
                if(temp < puzzle[i][j+1]) {
                    sum++;
                    temp = puzzle[i][j+1];
                }
            }
            puzzle[i][0] = sum;
            sum = 1;
        }
        for(int i = 1; i < dim+1; i++) {
            temp = puzzle[i][dim];
            for(int j = dim; j > 0; j--) {
                if(temp < puzzle[i][j-1]) {
                    sum++;
                    temp = puzzle[i][j-1];
                }
            }
            puzzle[i][dim+1] = sum;
            sum = 1;
        }
        for(int j = 1; j < dim+1; j++) {
            temp = puzzle[1][j];
            for(int i = 1; i < dim+1; i++) {
                if(temp < puzzle[i+1][j]) {
                    sum++;
                    temp = puzzle[i+1][j];
                }
            }
            puzzle[0][j] = sum;
            sum = 1;
        }
        for(int j = 1; j < dim+1; j++) {
            temp = puzzle[dim][j];
            for(int i = dim; i > 0; i--) {
                if(temp < puzzle[i-1][j]) {
                    sum++;
                    temp = puzzle[i-1][j];
                }
            }
            puzzle[dim+1][j] = sum;
            sum = 1;
        }
    }


    public static void printWithVisibility() {
        for(int i = 0; i < dim + 2; i++) {
            for(int j = 0; j < dim + 2; j++) {
                if(puzzle[i][j] == 0) {
                    System.out.print("   ");
                }
                else if(j==dim){
                    System.out.print(puzzle[i][j] );
                }
                else {
                    System.out.print(puzzle[i][j]+ " ");
                }
                if(i > 0 && i < dim +1) {
                    if(j == 0 || j == dim) {
                        System.out.print("|");
                    }
                }

            }
            System.out.println();
            if(i == 0 || i == dim) {
                System.out.print("   ");
                for(int x=0;x<2*dim-1;x++){
                    System.out.print("-");}
                System.out.println();
            }

        }
    }
}

/* Ran Cheng (NetID:rcheng9 & URID:31729772) and Yiwei Han (NetID:yhan32 & URID:31826174) collaborate on this skyscraper
project.
   In this project, Ran Cheng first wrote a program, but found out that it could not print anything. Then, she told
Yiwei Han, and Yiwei Han wrote another program that could  print the correct puzzle that print meet the criteria, but had
several bugs, and Ran Cheng corrected the bugs below. In general, Yiwei Han wrote loadPuzzle(), basicPrint(),
printwithVisibility(). Ran Cheng wrote verifyPlacement() and corrected several bugs that Yiwei Han wrote.After that,
Yiwei Han wrote the test.txt.
   The first bug is when we enter the puzzle, we must input a blank space after the last number in each row and then press
enter to get the next row to get the correct output of the puzzle, but the professor required that we do not need to print
a blank space after the last number in each row to get the correct puzzle. Ran Cheng corrected this.
   The second bug is that Yiwei Han wrote the program, it output another 4x4 matrix with the calculation on the four sides
of the printwithVisibility() method. Ran Cheng successfully deleted that matrix, which makes the output correct.
   The last bug is when there are invalid puzzle, the original program also print the visibility, not end with "the puzzle
is invalid". Ran Cheng made it end without printing the visibility.


 */