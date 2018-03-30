package amandaxu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yadongxu on 11/16/17.
 */
public class HungrySquirrelGame {
    public static void main (String[] args){
        Maze maze = new Maze();
        maze.create("Maze.txt");
        maze.display();

        Squirrel sam = new Squirrel();
        sam.create(maze);

        Nuts[] nuts = new Nuts[5];
        for (int i = 0; i < nuts.length; i++){
            double type = Math.random();
            if (type < 0.5){
                nuts[i] = new Almonds();
            }
            else{
                nuts[i] = new Peanuts();
            }
            nuts[i].create(maze);
        }

        maze.display();


        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(in);

        System.out.println("Do you want to use script to find the shortest path to eat a nut?");
        try{
            String s = null;
            while((s = keyboard.readLine()) != null){
                if(!(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")||
                        s.equals("n") || s.equals("N") || s.equals("No") || s.equals("no"))){
                    System.out.println("Invalid Enter. Please try again.");

                }

                else{
                    break;
                }


            }
            if(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")){
                //double start = System.nanoTime();
                Solution solution = new Solution();
                solution.script(maze);
                //double end = System.nanoTime();
                //System.out.println(end-start);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Enter the commands <w, s, a ,d>:");
        try{
            String commands = null;
            String s = null;
            while ((commands = keyboard.readLine()) != null){
                int curPoints = sam.points;
                if (commands.equals("w")){
                    sam.moveUp();
                    if(curPoints != sam.points){
                        System.out.println("Do you want to use script to find the shortest path to eat a nut?");
                        while((s = keyboard.readLine()) != null){
                            if(!(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")||
                                    s.equals("n") || s.equals("N") || s.equals("No") || s.equals("no"))){
                                System.out.println("Invalid Enter. Please try again.");

                            }

                            else{
                                break;
                            }


                        }
                        if(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")){
                            Solution solution = new Solution();
                            solution.script(maze);
                        }
                        else{
                            System.out.println("Enter the commands <w, s, a ,d>:");
                        }
                    }
                }
                else if (commands.equals("s")){
                    sam.moveDown();
                    if(curPoints != sam.points){
                        System.out.println("Do you want to use script to find the shortest path to eat a nut?");
                        while((s = keyboard.readLine()) != null){
                            if(!(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")||
                                    s.equals("n") || s.equals("N") || s.equals("No") || s.equals("no"))){
                                System.out.println("Invalid Enter. Please try again.");

                            }

                            else{
                                break;
                            }


                        }
                        if(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")){
                            Solution solution = new Solution();
                            solution.script(maze);
                        }
                        else{
                            System.out.println("Enter the commands <w, s, a ,d>:");
                        }
                    }
                }
                else if (commands.equals("a")){
                    sam.moveLeft();
                    if(curPoints != sam.points){
                        System.out.println("Do you want to use script to find the shortest path to eat a nut?");
                        while((s = keyboard.readLine()) != null){
                            if(!(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")||
                                    s.equals("n") || s.equals("N") || s.equals("No") || s.equals("no"))){
                                System.out.println("Invalid Enter. Please try again.");

                            }

                            else{
                                break;
                            }


                        }
                        if(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")){
                            Solution solution = new Solution();
                            solution.script(maze);
                        }
                        else{
                            System.out.println("Enter the commands <w, s, a ,d>:");
                        }
                    }
                }
                else if (commands.equals("d")){
                    sam.moveRight();
                    if(curPoints != sam.points){
                        System.out.println("Do you want to use script to find the shortest path to eat a nut?");
                        while((s = keyboard.readLine()) != null){
                            if(!(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")||
                                    s.equals("n") || s.equals("N") || s.equals("No") || s.equals("no"))){
                                System.out.println("Invalid Enter. Please try again.");

                            }

                            else{
                                break;
                            }


                        }
                        if(s.equals("y") || s.equals("Y") || s.equals("Yes") || s.equals("yes")){
                            Solution solution = new Solution();
                            solution.script(maze);
                        }
                        else{
                            System.out.println("Enter the commands <w, s, a ,d>:");
                        }
                    }
                }
                else{
                    System.out.println("Invalid command. Please reenter.");
                }

                if (sam.numbers == 5){
                    keyboard.close();
                    System.out.println("Squirrel successfully collected all the nuts. Total points " + sam.points + ".");
                    System.out.println("Thank you for playing this game!");
                    break;
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }


    }
}
