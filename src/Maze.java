//initializes, displays, and attempts to solve a maze.

public class Maze {
	//declare variables
	private int width, height, mwidth, mheight, msize;
	private int[][] maze;
	private Cell[][] cells;
	String mazestring;
	
	public Maze(int n, int m) { //construct the initial maze
		width = n;
		height = m;
		mwidth = (2 * width) + 1; //full width of maze in terms of primitive characters, not cells
		mheight = (2 * height) + 1; //"" height ""
		msize = mwidth * mheight; //the full size of the maze
		maze = new int[mwidth][mheight]; //an array of ints to show the primitive maze
		cells = new Cell[width][height]; //an array of cells
	}
	
	public void load(String mazestring){ //to load the maze
		int length = mazestring.length(); //a new length variable for clarity
		if (length == msize){ //to test that the string is the right length for the size specified for the maze
			for (int i = 0; i < length; i++){
				int x = i % mwidth; //finds the row by modulating by width
				int y = i / mwidth; //finds the column by dividing by width
				maze[x][y] = Character.getNumericValue(mazestring.charAt(i)); //sets that value to the array 
			}	
			
			for (int y = 1; y < (mheight-1); y += 2){ //sets up the cells as well
				for (int x = 1; x < (mwidth-1); x += 2){ 
					cells[x/2][y/2] = new Cell(maze[x][y-1], maze[x+1][y], maze[x][y+1], maze[x-1][y]); //creates new cells
				}
			}	
		}
		else 
			System.out.println("Invalid string."); //the string is invalid
	}
	
	public void display(){ //creates a character display
		char[][] tmaze = new char[mwidth][mheight]; //temporary maze
		for (int y = 0; y < mheight; y++){ 
			for (int x = 0; x < mwidth; x++){
				if (y % 2 == 0){ //horizontal dividers
					if (x % 2 == 0)
						tmaze[x][y] = '+'; //intersections						
					else
						tmaze[x][y] = '-';
					}
				else //vertical dividers
					tmaze[x][y] = '|';
				
				if (maze[x][y] == 0) //takes out all of the spaces where 0's occur in the array of ints
					tmaze[x][y] = ' ';		
			}		
		}
		
		for (int y = 0; y < mheight; y++){ //
			for (int x = 0; x < mwidth; x++){
				System.out.print(tmaze[x][y]); //prints each row of the tempmaze of characters
			}
			System.out.print("\n");
		}
	}
	
	public boolean solve(int begX, int begY, int endX, int endY){ //solves the maze with the use of a helper method
		//Note: begX starts at the 0 index, and so does begY
		boolean mark = false; //marker variable
		boolean found = true; //found variable
		if ((begX == endX) && (begY == endY)){ //base case of the recursion
			found = true;
			return found;
		}
		else //recursive function
			return move(begX, begY, endX, endY, found, mark);
		
	}
	
	public boolean move(int begX, int begY, int endX, int endY, boolean find, boolean mark){	
		mark = false; //sets the initial bool to unmarked
		//Note: it's checking bounds here, and the same pattern is followed through each if statement until it finishes.
		if (begX - 1 >= 0  && cells[begX - 1][begY].getRight() == 0 && cells[begX - 1][begY].isValid(false) ){ //check right
			mark = cells[begX - 1][begY].isValid(true); //marks the cell as visited
			find = false; //haven't found it yet
			move(begX-1, begY, endX, endY, find, mark);//recursive call
		}
		if (begY - 1 >= 0 && cells[begX][begY - 1].getDown() == 0 && cells[begX][begY - 1].isValid(false)){ //check down
			mark = cells[begX][begY - 1].isValid(true);
			find = false;
			move(begX, begY-1, endX, endY, find, mark);
		}
		if (begX + 1 < width && cells[begX + 1][begY].getLeft() == 0 && cells[begX + 1][begY].isValid(false)){ //check left
			mark = cells[begX + 1][begY].isValid(true);
			find = false;
			move(begX+1, begY, endX, endY, find, mark);
		}
		if (begY + 1 < height && cells[begX][begY + 1].getUp() == 0 && cells[begX][begY+1].isValid(false)){ //check up
			mark = cells[begX][begY+1].isValid(true);
			find = false;
			move(begX, begY+1, endX, endY, find, mark);
		}
		return find; 
		
	}

}
