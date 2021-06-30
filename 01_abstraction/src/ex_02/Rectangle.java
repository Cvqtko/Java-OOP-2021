package ex_02;

public class Rectangle {
	private final Point a;
	private final Point b;

	public Rectangle(Point a, Point b) {

		this.a = a;
		this.b = b;
	}

	public boolean contains(Point p) {
		return p.getX() >= a.getX() && p.getY() >= a.getY() && p.getX() <= b.getX() && p.getY() <= b.getY();
	}

}
