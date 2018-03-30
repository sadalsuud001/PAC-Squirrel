package amandaxu;

/**
 * Created by yadongxu on 12/1/17.
 */
public class Poisons extends Entity {
    // final int nPoints = -5;

    // Poisons(){
      //  this.symbol = 'X';
    //}

    @Override
    void create(Maze maze){

        int a;
        int b;

        while (true){
            a = (int)(Math.random() * 20) + 1;
            b = (int)(Math.random() * 50) + 1;

            if (maze.available(a, b)){
                this.x = a;
                this.y = b;
                maze.insert(x, y, 'X');
                break;
            }

        }
    }


}
