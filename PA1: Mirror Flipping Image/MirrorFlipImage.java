import java.util.Scanner;
public class MirrorFlipImage {
    public static void main(String[] args){
        char[][] image = {
            {'#', 'x', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', 'J', ' ', '#'},
            {'*', ' ', ' ', ' ', '|'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', 'y', '#'},
        };
        System.out.println("Original Image: ");
        displayImage(image); //calls displayImage method allowing 2D array to display
        System.out.println();

        System.out.println("Horizontally Flipped Image: ");
        char[][] horizontal = horizontalMirror(image);
        displayImage(horizontal);
        System.out.println();


        System.out.println("Vertically Flipped Image: ");
        char[][] vertical = verticalMirror(image);
        displayImage(vertical);
        System.out.println();

        System.out.println("Horizontally and then Vertically flipped image: ");
        char[][] verticalHorizontal = verticalAndHorizontal(image);
        displayImage(verticalHorizontal);


        }


    public static void displayImage(char[][] image){
        for (int i = 0; i < image.length; ++i){ //iterating through rows
            for (int j = 0; j < image[0].length; ++j){ //iterating through columns
                System.out.print(image[i][j]);
            }
            //keeps format of 2D array
            System.out.println();
        }
    }

    public static char[][] horizontalMirror(char[][] image){
        int rows = image.length; //stores number of rows from original image
        int cols = image[0].length; //stores number of columns from original image

        char[][] horizontal = new char[rows][cols]; //creates new 2D array called horizontal

        for (int i = 0; i < rows; ++i){ //iterates through rows which were taken from the original image
            for (int j = 0; j < cols; ++j){ //iterates through columns which were taken from the original image

                /*
                 * horizontal[i][j] = new 2D array with original row and columns
                 * image[rows-1-i][j] = original 2D array modified to horizontally flip image
                 *      rows = number of rows in original image = 5
                 *      Example: horizontal[0][3] = image[5-1-0][3];
                 *      Which would result in image[4][3] which would move the character '*' to row 4 column 3
                 */
                horizontal[i][j] = image[rows-1-i][j]; 
            }
        }
        return horizontal;
    }

    public static char[][] verticalMirror(char[][] image){
        int rows = image.length; 
        int cols = image[0].length; 
        
        char[][] vertical = new char[rows][cols]; //creates new 2D array called vertical

        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                vertical[i][j] = image[i][cols-1-j];
            }
        }
        return vertical;
    }

    public static char[][] verticalAndHorizontal(char[][] image){
        int rows = image.length; 
        int cols = image[0].length;

        char[][] verticalHorizontal = new char[rows][cols]; //creates new 2D array called verticalHorizontal
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                verticalHorizontal[i][j] = image[rows-1-i][cols-1-j];
            }
        }
        return verticalHorizontal;
    }
}  


