public class Matriz implements Operable {
	
	private double[][] matriz;
	private int n;
	private int m;

	public  Matriz(int n, int m) {
		if(n < 1 || m < 1) {
			throw new IllegalArgumentException("Dimension incorrecta");
		}
		if(n > 1000 || m > 1000) {
			throw new IllegalArgumentException("Dimension incorrecta");
		}
		matriz = new double[n][m];
		this.n = n;
		this.m = m;
	}

	public Matriz(Matriz mat) {
		this.matriz = new double[mat.n][mat.m];
		for(int i = 0; i < mat.n; i++) {
			for(int j = 0; j < mat.m; j++) {
				this.matriz[i][j] = mat.matriz[i][j];
			}
		}
		this.m = mat.m;
		this.n = mat.n;
	}

	public double[] getRow(int row) throws IllegalArgumentException {
		if(row < 0 || row >= this.n) {
			throw new IllegalArgumentException("Dimension incorrecta");
		}
		else {			
			return this.matriz[row];
		}
	}

	public double[] getColumn(int column) throws IllegalArgumentException {
		return null;
	}

	public boolean equals(Matriz m) {
		return false;
	}

	public Matriz sum(Matriz m) throws UnsupportedOperationException {
		return null;
	}

	public Matriz scalarProduct(double c) throws UnsupportedOperationException {
		return null;
	}

	public Matriz product(Matriz m) throws UnsupportedOperationException {
		return null;
	}

	public double determinant2x2() throws UnsupportedOperationException {
		return 0.0;
	}

	public double determinant3x3() throws UnsupportedOperationException {
		return 0.0;
	}

	public Matriz transposed() throws UnsupportedOperationException {
		return null;
	}
}