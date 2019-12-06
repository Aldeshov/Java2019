abstract class Pieces{
	public Position a;
	public Pieces(int x,int y) {
		a = new Position(x,y);
	}
}
class Rook extends Pieces{
	public Rook(int x, int y) {
		super(x,y);
	}
	public boolean isLegalMove(Position a, Position b){
		return a.x == b.x || a.y == b.y;
	}
}
class King extends Pieces{
	public King(int x, int y) {
		super(x,y);
	}
	public boolean isLegalMove(Position a, Position b){
		return Math.abs(a.x - b.x) <= 1 && Math.abs(a.y - b.y) <= 1;
	}
}
class Queen extends Pieces{
	public Queen(int x, int y) {
		super(x,y);
	}
	public boolean isLegalMove(Position a, Position b){
		return true;
	}
}
class Position{
	public int x;
	public int y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class problem4 {
	public static void main(String args[]) {
		King X = new King(5,1);
		System.out.println(X.isLegalMove(new Position(5,1),new Position(6,1)));
		Rook R = new Rook(7,3);
		System.out.println(R.isLegalMove(new Position(7,3),new Position(8,2)));
	}
}
