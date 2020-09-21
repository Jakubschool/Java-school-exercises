import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    String[][] a = {{"*", "*", "*", "*"}, {"*","*", "*", "*"} , {"*","*", "*", "*"}, {"*"," ", " ", "*"}};
    String[][] b = new String [a.length][a[0].length];

    System.out.println("Shape: ");
    System.out.println();

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
    System.out.println("Outline:");
    System.out.println();

    for (int row = 0; row<a.length; row++){
      for (int col = 0; col<a[row].length; col++){
        if (row == 0 || row == a.length-1){
          b[row][col] = a[row][col];
        }else if (col == 0 || col == a[row].length-1){
          b[row][col] = a[row][col];
        }else{
          if (a[row][col] == " "){
            b[row][col] = " ";
          } else if (a[row][col] == "*" && a[row-1][col] == "*" && a[row][col-1] == "*" && a[row][col+1] == "*" && a[row+1][col] == "*"){
            b[row][col] = " ";
          }else{
            b[row][col] = "*";
          }
        }
      }
    }

    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[i].length; j++) {
          System.out.print(b[i][j] + " ");
      }
      System.out.println();
    }
      
  }
}