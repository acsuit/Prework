//Creates mazes to run
public class MazeTest {
	public static void main(String args[]){
		//valid maze example
		Maze maze = new Maze(4, 4);
		String string1="111111111100010001111010101100010101101110101100000101111011101100000101111111111"; 
		maze.load(string1);
		maze.display();
		System.out.print(maze.solve(0, 0, 1, 0));
		System.out.print("\n");
		//invalid maze example
		Maze maze2 = new Maze(2, 2);
		String string2="1111110101111111010111111";
		maze2.load(string2);
		maze2.display();
		System.out.print(maze2.solve(0, 0, 1, 0));
	}
}
