interface Operable {
	
	double[] getRow(int row) throws IllegalArgumentException;
	double[] getColumn(int column) throws IllegalArgumentException;
	boolean equals(Matriz m);
	Matriz sum(Matriz m) throws UnsupportedOperationException;
	Matriz scalarProduct(double c) throws UnsupportedOperationException;
	Matriz product(Matriz m) throws UnsupportedOperationException;
	double determinant3x3() throws UnsupportedOperationException;
	double determinant2x2() throws UnsupportedOperationException;
	Matriz transposed() throws UnsupportedOperationException;
}