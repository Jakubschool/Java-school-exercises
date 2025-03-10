import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

    public static int[][] loadPixelsFromFile(BufferedImage image) throws IOException {
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        int[][] colors = new int[image.getWidth()][image.getHeight()];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
              // colors[x][y] = new Color(image.getRGB(x, y));
              Color c = new Color(image.getRGB(x, y));
              if (c.getRed() == 255 && c.getGreen() == 255 && c.getBlue() == 255){
                colors[x][y] = 0;
              }else if (c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 0){
                colors[x][y] = 1;
              }else{
                System.out.println("Invalid color");
                colors[x][y] = 1;
              }
            }
        }

        return colors;
    }

    static void myMethod(int colors[][]) {
      for (int x = 0; x < colors.length; x++) {
            for (int y = 0; y < colors[x].length; y++) {
              System.out.println(colors[x][y]);
            }
        }
    }

    static void testMethod(int colors[][]) {
      for (int x = 0; x < colors.length; x++) {
            for (int y = 0; y < colors[x].length; y++) {
              System.out.print(colors[x][y] + " ");
            }
          System.out.println();
        }
    }


    public static int[][] produceOut(int a[][]){
      int[][] b = new int[a.length][a[0].length];
      for (int row = 0; row<a.length; row++){
        for (int col = 0; col<a[row].length; col++){
          if (row == 0 || row == a.length-1 || col == 0 || col == a[row].length-1){
            b[row][col] = a[row][col];
          }else{
            if (a[row][col] == 0){
              b[row][col] = 0;
            } else if (a[row][col] == 1 && a[row-1][col] == 1 && a[row][col-1] == 1 && a[row][col+1] == 1 && a[row+1][col] == 1){
              b[row][col] = 0;
            }else{
              b[row][col] = 1;
            }
          }
        }
      }
     return b;
    }

    public static BufferedImage changepixels(int a[][], BufferedImage image){
      for(int x = 0; x < a.length;x++)
        for(int y = 0; y < a[x].length ; y++){
          if (a[x][y]== 1){
            image.setRGB(x, y, 0x000000);
          }else{
            image.setRGB(x, y, 0xFFFFFF);
          }

        }
        return image;
    }


    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("sample.jpg"));
        int[][] colors = loadPixelsFromFile(image);
        System.out.println("Color[0][0] = " + colors[0][0]);
        System.out.println("Old Shape:");
        // testMethod(colors);
        int[][] out = produceOut(colors);
        System.out.println("New Shape:");
        // testMethod(out);
        BufferedImage img = new BufferedImage(image.getWidth(),image.getWidth(),
    BufferedImage.TYPE_INT_RGB);
        BufferedImage bob = changepixels(out, img);
        File outputfile = new File("image.jpg");
        ImageIO.write(bob, "jpg", outputfile);
    }
}