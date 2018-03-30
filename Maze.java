package amandaxu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yadongxu on 11/16/17.
 */
public class Maze {
    static final int maxRow = 20;
    static final int maxColumn = 50;
    static char[][] maze = new char[maxRow][maxColumn];


    int getMaxRow (){
        return maxRow;
    }

    int getMaxColumn (){
        return maxColumn;
    }

    void create(String filename){
        try {
            FileReader in = new FileReader(filename);
            BufferedReader br = new BufferedReader(in);
            for (int i = 0; i < maxRow; i++) {
                String line = br.readLine();
                maze[i] = line.toCharArray();
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    void display(){
        int i = 0;      //stands for row
        int j = 0;      //stands for column

        while (i < maxRow){
            while (j < maxColumn){
                System.out.print(maze[i][j]);
                j++;
            }
            System.out.println();
            j = 0;
            i++;
        }
        System.out.println();
    }

    boolean available(int row, int col){
        //determine if the space in the row and the column is empty
        System.out.println(maze[row - 1][col - 1]);
        if (maze[row - 1][col - 1] == ' '){
            return true;
        }
        else{
            return false;
        }
    }

    char Character(int x,int y){
        return maze[x-1][y-1];
    }

    void insert(int x, int y, char symbol){
        maze[x-1][y-1] = symbol;
    }


}
