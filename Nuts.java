package amandaxu;

/**
 * Created by yadongxu on 11/16/17.
 */
public class Nuts extends Entity{
    final int totalNuts = 5;


    @Override
    void create(Maze maze){
        this.maze = maze;

        int a;
        int b;

        while (true){
            a = (int)(Math.random() * 20) + 1;
            b = (int)(Math.random() * 50) + 1;

            if (maze.available(a, b)){
                this.x = a;
                this.y = b;
                maze.insert(x, y, symbol);
                break;
            }

        }
    }

    int isNuts(char symbol){
        if (symbol == 'A' ){
            return 5;
        }
        else if(symbol == 'P'){
            return 10;
        }
        else{
            return 0;
        }
    }

}
