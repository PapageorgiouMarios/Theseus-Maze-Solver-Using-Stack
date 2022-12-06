import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TheseusMazeSolverWithStack<T> extends GenericsStackImplementation<T>
{

    public static void setAlreadyVisited(int i, int j, String[][] labyrinth)
    {
        labyrinth[i][j] = "V";
    }

    public static String[][] createMaze(int i, int j)
    {
        return new String[i][j];
    }

    public static void printMaze(String[][] maze)
    {
        for (String[] row : maze)
        {
            for (String row_element : row)
            {
                System.out.print(row_element);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static boolean canGoRight(int i, int j, String[][] maze)
    {
        if (j < maze[0].length - 1)
        {
            return maze[i][j + 1].equals("0");
        }
        return false;
    }

    public static boolean canGoLeft(int i, int j, String[][] maze)
    {
        if (j > 0)
        {
            return maze[i][j - 1].equals("0");
        }
        return false;
    }

    public static boolean canGoDown(int i, int j, String[][] maze)
    {
        if (i < maze.length - 1)
        {
            return maze[i + 1][j].equals("0");
        }
        return false;

    }

    public static boolean canGoUp(int i, int j, String[][] maze)
    {
        if (i > 0)
        {
            return maze[i - 1][j].equals("0");
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException
    {

        String txt_filename = args[0];
        File file = new File(txt_filename);
        Scanner txt_scanner = new Scanner(file);

        boolean debug_mode = true;

        //-------------------------First Line: Labyrinth's dimensions-------------------------------------
        String first_txt_line = txt_scanner.nextLine();
        String[] dimensions_seperate = first_txt_line.split(" ");

        int dimension_rows = Integer.parseInt(dimensions_seperate[0]);
        int dimension_columns = Integer.parseInt(dimensions_seperate[1]);
        String[][] maze = createMaze(dimension_rows, dimension_columns);

        if(debug_mode)
        {
            System.out.println("Maze's rows: " + Integer.parseInt(dimensions_seperate[0]));
            System.out.println("Maze's columns: " + Integer.parseInt(dimensions_seperate[1]));
            System.out.println("Maze's dimensions initialized!");
        }
        //----------------------------------------------------------------------------------------------

        //-------------------------Second Line: Starting point------------------------------------------
        String second_line = txt_scanner.nextLine();
        String[] indexes_seperate = second_line.split(" ");

        int E_row = Integer.parseInt(indexes_seperate[0]);
        int E_column = Integer.parseInt(indexes_seperate[1]);
        maze[E_row][E_column] = "E";

        if(debug_mode)
        {
            System.out.println();
            System.out.println("Beginning row: " + Integer.parseInt(indexes_seperate[0]));
            System.out.println("Beginning column: " + Integer.parseInt(indexes_seperate[1]));
            System.out.println("Starting point initialized!");
        }
        //----------------------------------------------------------------------------------------------

        //-------------------------Initialize Labyrinth------------------------------------------
        while (txt_scanner.hasNextLine())
        {
            for (String[] strings : maze)
            {
                String[] maze_row = txt_scanner.nextLine().trim().split(" ");
                System.arraycopy(maze_row, 0, strings, 0, maze[0].length);
            }
        }

        if(debug_mode)
        {
            System.out.println();
            System.out.println("Labyrinth initialized");
            System.out.println();
        }

        printMaze(maze);

        txt_scanner.close();
        //---------------------------------------------------------------------------------------

        GenericsStackImplementation<String> moves_coordinates = new GenericsStackImplementation<>();

        int current_row = E_row;
        int current_column = E_column;

        String position;
        System.out.println();

        int number_of_possible_exits = 0;

        ArrayList<String> closed_set_of_exits = new ArrayList<>();

        if (maze[current_row][current_column].equals("E"))
        {

            while (true)
            {
                if(debug_mode)
                {
                    System.out.println("Current location: " + "(" + current_row + "," + current_column + ")");
                }

                if(canGoRight(current_row, current_column, maze))
                {
                    moves_coordinates.push(current_row + " " + (current_column + 1));
                }

                if(canGoLeft(current_row, current_column, maze))
                {
                    moves_coordinates.push(current_row + " " + (current_column - 1));
                }

                if(canGoDown(current_row, current_column, maze))
                {
                    moves_coordinates.push((current_row + 1) + " " + current_column);
                }

                if(canGoUp(current_row, current_column, maze))
                {
                    moves_coordinates.push((current_row - 1) + " " + current_column);
                }

                if ((current_row == 0 || current_row == maze.length - 1 || current_column == 0 || current_column == maze[0].length - 1))
                {
                    if (!maze[current_row][current_column].equals("E"))
                    {
                        String current_location = "(" + current_row + "," + current_column + ")";

                        number_of_possible_exits++;

                        if(!closed_set_of_exits.contains(current_location))
                        {
                            System.out.println("Found new exit in position " + ": " + "(" + current_row + "," + current_column + ")");
                            closed_set_of_exits.add(current_location);
                        }
                    }
                }
                setAlreadyVisited(current_row, current_column, maze);

                if(debug_mode)
                {
                    System.out.print("Stack status:");
                    moves_coordinates.printStack(System.out);
                }

                if (!moves_coordinates.isEmpty())
                {
                    position = moves_coordinates.pop();
                    StringTokenizer s = new StringTokenizer(position, " ");
                    current_row = Integer.parseInt(s.nextToken());
                    current_column = Integer.parseInt(s.nextToken());
                }
                else
                {
                    if (number_of_possible_exits == 0)
                    {
                        System.out.println();
                        System.out.println("There is no exit in given maze!!");

                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Found total of " + closed_set_of_exits.size() + " exits ");

                    }
                    break;

                }
                if(debug_mode)
                {
                    System.out.println();
                    printMaze(maze);
                    System.out.println();
                }
            }
        }
        else
        {
            System.out.println("There is no entrance in maze!");
        }

    }

}

