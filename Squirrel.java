package amandaxu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yadongxu on 11/16/17.
 */
public class Squirrel extends Entity{
    int points;
    int numbers;



    void moveLeft(){
        if (maze.Character(x, y-1) == '*'){
            maze.display();
        }
        else if(maze.Character(x, y-1) == ' '){
            maze.insert(x, y-1, symbol);
            maze.insert(x, y, ' ');
            y--;
            maze.display();
        }
        else{
            if (maze.Character(x, y-1) == 'P'){
                numbers++;
                points = points + 10;
                maze.insert(x, y-1, symbol);
                maze.insert(x, y, ' ');
                y--;
                maze.display();
                System.out.println("!!! Squirrel got 10 points (Total "+ points +" points) !!! ");
            }
            else if (maze.Character(x, y-1) == 'A'){
                numbers++;
                points = points + 5;
                maze.insert(x, y-1, symbol);
                maze.insert(x, y, ' ');
                y--;
                maze.display();
                System.out.println("!!! Squirrel got 5 points (Total "+ points +" points) !!! ");
            }

        }
    }

    void moveRight(){
        if (maze.Character(x, y+1) == '*'){
            maze.display();
        }
        else if(maze.Character(x, y+1) == ' '){
            maze.insert(x, y+1, symbol);
            maze.insert(x, y, ' ');
            y++;
            maze.display();
        }
        else{
            if (maze.Character(x, y+1) == 'P'){
                numbers++;
                points = points + 10;
                maze.insert(x, y+1, symbol);
                maze.insert(x, y, ' ');
                y++;
                maze.display();
                System.out.println("!!! Squirrel got 10 points (Total "+ points +" points) !!! ");
            }
            else if (maze.Character(x, y+1) == 'A'){
                numbers++;
                points = points + 5;
                maze.insert(x, y+1, symbol);
                maze.insert(x, y, ' ');
                y++;
                maze.display();
                System.out.println("!!! Squirrel got 5 points (Total "+ points +" points) !!! ");
            }
        }
    }

    void moveUp(){
        if (maze.Character(x-1, y) == '*'){
            maze.display();
        }
        else if(maze.Character(x-1, y) == ' '){
            maze.insert(x-1, y, symbol);
            maze.insert(x, y, ' ');
            x--;
            maze.display();
        }
        else{
            if (maze.Character(x-1, y) == 'P'){
                numbers++;
                points = points + 10;
                maze.insert(x-1, y, symbol);
                maze.insert(x, y, ' ');
                x--;
                maze.display();
                System.out.println("!!! Squirrel got 10 points (Total "+ points +" points) !!! ");
            }
            else if (maze.Character(x-1, y) == 'A'){
                numbers++;
                points = points + 5;
                maze.insert(x-1, y, symbol);
                maze.insert(x, y, ' ');
                x--;
                maze.display();
                System.out.println("!!! Squirrel got 5 points (Total "+ points +" points) !!! ");
            }
        }
    }

    void moveDown(){
        if (maze.Character(x+1, y) == '*'){
            maze.display();
        }
        else if(maze.Character(x+1, y) == ' '){
            maze.insert(x+1, y, symbol);
            maze.insert(x, y, ' ');
            x++;
            maze.display();
        }
        else{
            if (maze.Character(x+1, y) == 'P'){
                numbers++;
                points = points + 10;
                maze.insert(x+1, y, symbol);
                maze.insert(x, y, ' ');
                x++;
                maze.display();
                System.out.println("!!! Squirrel got 10 points (Total "+ points +" points) !!! ");
            }
            else if (maze.Character(x+1, y) == 'A'){
                numbers++;
                points = points + 5;
                maze.insert(x+1, y, symbol);
                maze.insert(x, y, ' ');
                x++;
                maze.display();
                System.out.println("!!! Squirrel got 5 points (Total "+ points +" points) !!! ");
            }
        }
    }

    @Override
    void create(Maze maze){
        this.maze = maze;
        this.symbol = '@';
        this.numbers = 0;
        this.points = 0;

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(in);

        String coordinate = null;
        System.out.println("Enter the initial location of the squirrel <x, y> (x from 1-20 and y from 1-50):");
        try{
            while ((coordinate = keyboard.readLine()) != null){
                String[] info = coordinate.split(",");
                int i = Integer.parseInt(info[0].trim());
                int j = Integer.parseInt(info[1].trim());

                this.x = i;
                this.y = j;

                if ( !this.maze.available(i, j) ||info.length != 2 || i > 20 || i < 1 || j > 50 || j < 1 ){
                    System.err.println("Invalid format entered. Try again");
                    System.out.println("Please Enter the initial location of the squirrel <x, y> (x from 1-20 and y from 1-50):");
                    continue;
                }
                else{
                    put(i, j);
                    maze.display();
                    break;
                }
            }
            //keyboard.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
