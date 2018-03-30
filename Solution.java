package amandaxu;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by yadongxu on 12/2/17.
 */
public class Solution {

    public Solution(){}

    private int startR, startC;
    private int endR, endC;

    public void script (Maze maze) {

        // change maze to an 02 based 2d array, including 7-squirrel, 8-peanuts, 9-almonds
        int[][] newMaze = mazeInterpreter(maze);

        // set start position
        int[] samPosition = getSamPosition(maze);
        startR = samPosition[0];
        startC = samPosition[1];

        // set end position
        // get all nuts' positions
        ArrayList<int[]> nutsPositions = getNutsPositions(maze);

        // find target nut
        int[] targetNut = nutsPositions.get(smallestDistance(samPosition, nutsPositions));
        endR = targetNut[0];
        endC = targetNut[1];

        // remove 7-8-9
        newMaze = mazeInterpreter2(newMaze);

        for(int i = 0; i < 20; i ++){
            for(int j = 0; j < 50; j++){
                System.out.print(newMaze[i][j]);
            }
            System.out.print("\n");
        }

        System.out.println("Start: " + startR + " " + startC);
        System.out.println("End: " + endR + " " + endC);



        // BFS
        dx = startR;
        dy = startC;
        gx = endR;
        gy = endC;



        int len = bfs(newMaze);

        System.out.println("The min steps is " + len + ".");
        System.out.println("The end of script.");

    }


     int dx, dy, gx, gy;
    //int[][] deep = new int[20][50];
    //int M = 20;
    //int N = 50;

    private int bfs(int[][] newMaze) {
        int[][] deep = new int[newMaze.length][newMaze[0].length];
        int M = newMaze.length;
        int N = newMaze[0].length;

        Queue<Point> q = new LinkedList<Point>();
        // down, up, right, left
        int[] tx = { -1, 1, 0, 0 };
        int[] ty = { 0, 0, 1, -1 };
        q.offer(new Point(dx, dy));

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++) {
                deep[i][j] = -1;
            }
        }

        deep[dx][dy] = 0;

        for(int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                System.out.print(deep[i][j]);
            }
            System.out.println();
        }



        while (q.size() > 0) {
            Point p = q.poll();
            if (p.x == gx && p.y == gy)
                break;
            for (int i = 0; i < 4; i++) {
                int x = p.x + tx[i];
                int y = p.y + ty[i];
                if (x >= 0 && x < M && y >= 0 && y < N && newMaze[x][y] != '1'
                        && deep[x][y] == -1) {
                    deep[x][y] = deep[p.x][p.y] + 1;
                    q.offer(new Point(x, y));
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(deep[i][j]);
            System.out.println();
        }
        return deep[gx][gy];
    }




    // 1 is wall
    // 0 is the space, which is available to pass.
    // 7 is the cute squirrel
    // 8 is peanuts
    // 9 is almonds
    private int[][] mazeInterpreter(Maze maze){
        // row = 20
        int rowLength = maze.getMaxRow();
        // column = 50
        int columnLength = maze.getMaxColumn();

        int[][] result = new int[rowLength][columnLength];
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 50; j++){
                if(maze.Character(i+1,j+1) == '*'){
                    result[i][j] = 1;
                }
                else if(maze.Character(i+1,j+1) == ' '){
                    result[i][j] = 0;
                }
                else if(maze.Character(i+1,j+1) == '@'){
                    result[i][j] = 7;
                }
                else if(maze.Character(i+1,j+1) == 'P'){
                    result[i][j] = 8;
                }
                else if(maze.Character(i+1,j+1) == 'A'){
                    result[i][j] = 9;
                }
            }
        }
        return result;
    }

    // change maze to a pure 01 based maze
    // 1 is wall
    // 0 is the space, which is available to pass.
    private int[][] mazeInterpreter2(int[][] newMaze){
        // row = 20
        int rowLength = newMaze.length;
        // column = 50
        int columnLength = newMaze[0].length;

        int[][] result = new int[rowLength][columnLength];
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 50; j++){
                switch(newMaze[i][j]){
                    case 7: result[i][j] = 0;
                    break;

                    case 8:result[i][j] = 0;
                    break;

                    case 9: result[i][j] = 0;
                    break;

                    case 1: result[i][j] = 1;
                    break;

                    case 0: result[i][j] = 0;
                    break;
                }

            }
        }
        return result;
    }

    private int[] getSamPosition(Maze maze){
        int rowLength = maze.getMaxRow();
        int columnLength = maze.getMaxColumn();

        int[] result = new int[2];
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < columnLength; j++){
                if(maze.Character(i+1,j+1) == '@'){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // return ArrayList<[x,y,z], [x,y,z]...>
    // x = row
    // y = column
    // z = points
    private ArrayList<int[]> getNutsPositions(Maze maze){
        int rowLength = maze.getMaxRow();
        int columnLength = maze.getMaxColumn();

        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < columnLength; j++){
                if(maze.Character(i+1,j+1) == 'P'){
                    int[] peanut = new int[3];
                    peanut[0] = i;
                    peanut[1] = j;
                    peanut[2] = 10;
                    result.add(peanut);
                }
                else if(maze.Character(i+1,j+1) == 'A'){
                    int[] almond = new int[3];
                    almond[0] = i;
                    almond[1] = j;
                    almond[2] = 5;
                    result.add(almond);
                }
            }
        }

        return result;
    }

    // calculate distances between sam and each nuts
    private int smallestDistance(int[] samPosition, ArrayList<int[]> nutsPositions){
        int minDis = Integer.MAX_VALUE;
        int minDis_index = 0;
        //int[] distance = new int[nutsPositions.size()];
        for(int i = 0; i < nutsPositions.size(); i++){
            int dis = (int) Math.sqrt((nutsPositions.get(i)[0] - samPosition[0]) * (nutsPositions.get(i)[0] - samPosition[0]) +
                    (nutsPositions.get(i)[1] - samPosition[1]) * (nutsPositions.get(i)[1] - samPosition[1]));
            //distance[i] = dis;
            if(dis < minDis){
                minDis = dis;
                minDis_index = i;
            }
        }
        return minDis_index;
    }

}
