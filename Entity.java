package amandaxu;

/**
 * Created by yadongxu on 11/16/17.
 */
public abstract class Entity {
    char symbol;
    int x;
    int y;
    Maze maze;

    abstract void create(Maze maze);

    char put(int newX, int newY){
        char oldChar;
        if (maze.available(newX, newY)){
            oldChar = maze.Character(newX, newY);
            maze.insert(newX, newY, symbol);
            return oldChar;
        }
        else{
            return ' ';
        }
    }
}
