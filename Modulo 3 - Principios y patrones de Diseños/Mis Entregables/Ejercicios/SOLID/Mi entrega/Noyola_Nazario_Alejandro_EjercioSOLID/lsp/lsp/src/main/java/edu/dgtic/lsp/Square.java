package edu.dgtic.lsp;

public class Square implements Shape {
	private Rectangle rectangle;

	public Square(int side) {
		this.rectangle = new Rectangle(side, side);
	}

	public int getSide() {
		return rectangle.getWidth(); // O rectangle.getHeight() (ya que son iguales)
	}

	public void setSide(int side) {
		rectangle.setWidth(side);
		rectangle.setHeight(side);
	}

	@Override
	public double computeArea() {
		return rectangle.computeArea();
	}
}
