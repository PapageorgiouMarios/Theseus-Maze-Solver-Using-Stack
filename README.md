# Theseus-Maze-Solver-Using-Stack
Theseus needs to find a way out. His goal is to search and find any possible exits inside the maze. In our program our maze has the form of a two-dimensional array.
The repertoire has a txt file which holds critical information so that our program can work.
- The first line need two numbers: These numbers show the dimensions of the maze, meaning the total number of rows and columns of the array
- The second line also needs two numbers: The first one holds the row of Theseus' starting point and the second one holds the column of Theseus' starting point inside the maze's 2D array
- The rest of the lines show the form of all the array's elements: 1 if it is a block, 0 if it is a valid path, V if it is already visited and lastly E for the starting point

The interface used to solve the maze is called GenericsStack. Basically, it is a normal LIFO (Last In First Out) Stack which holds Nodes. The Node's data can be of any type, which is why generics are used. So while Theseus is moving inside the maze, the stack holds all possible locations where he can move and at the same time every location which has already been visited is marked.

Depending on the txt file's maze, the results can be one of the following:
- The letter E has not been put in the array so there is no starting point
- How many exits have been found and in which coordinates
- There is no way to get out of the labyrinth

The program also holds a boolean variable called debug mode. If we wish to see the whole stack and the state of the maze in each move etc, all we have to do is to give the value "true" to this boolean. Otherwise, it will only show the maze and all exits' coordinates.

Note --> Edit Configarations: The main method of the program uses as args[0] the txt file inside src
 
