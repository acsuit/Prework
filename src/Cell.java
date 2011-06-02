
public class Cell { //a cell class to make our move work correctly
	int up, down, left, right;
	public Cell(int north, int east, int south, int west){
		up = north;
		right = east;
		down = south;
		left = west;
	}
	//to get and set Up (or the primitive cell immediately above the center)
	public int getUp() {
		return up;
	}
	public void setUp(int n) {
		up = n;
	}
	//to get and set Down
	public int getDown() {
		return down;
	}
	public void setDown(int s) {
		down = s;
	}
	//to get and set Left
	public int getLeft() {
		return left;
	}
	public void setLeft(int w) {
		left = w;
	}
	//to get and set Right
	public int getRight() {
		return right;
	}
	public void setRight(int e) {
		right = e;
	}
	//a simple boolean value to test if the cell has been visited or not (true if visited, false if unvisited)
	public boolean isValid(boolean valid){
		return valid;
	}
}
