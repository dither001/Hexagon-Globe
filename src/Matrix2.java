public class Matrix2 {
	// fields
	protected double[][] matrix;

	// constructors
	public Matrix2() {
		matrix = new double[2][2];
		matrix[0][0] = 1;
		matrix[0][1] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = 1;
	}

	public Matrix2(double[][] other) {
		matrix = new double[2][2];
		this.matrix[0][0] = other[0][0];
		this.matrix[0][1] = other[0][1];
		this.matrix[1][0] = other[1][0];
		this.matrix[1][1] = other[1][1];
	}

	// methods
	boolean equals(Matrix2 other) {
		boolean equals = false;
		Matrix2 temp = this.round();
		other = other.round();
		
		if (Integer.compare((int) temp.matrix[0][0], (int) other.matrix[0][0]) == 0
				&& Integer.compare((int) temp.matrix[0][1], (int) other.matrix[0][1]) == 0
				&& Integer.compare((int) temp.matrix[1][0], (int) other.matrix[1][0]) == 0
				&& Integer.compare((int) temp.matrix[1][1], (int) other.matrix[1][1]) == 0)
			equals = true;

		return equals;
	}

	Vector2 multiplyByVector2(Vector2 vector) {
		Vector2 v = new Vector2();
		v.x = (float) (vector.x * this.matrix[0][0] + vector.y * this.matrix[0][1]);
		v.y = (float) (vector.x * this.matrix[1][0] + vector.y * this.matrix[1][1]);
		
		return v;
	}

	Matrix2 rotatationMatrix(double rotation) {
		Matrix2 m = new Matrix2();
		m.matrix[0][0] = Math.cos(rotation);
		m.matrix[0][1] = -Math.sin(rotation);
		m.matrix[1][0] = Math.sin(rotation);
		m.matrix[1][1] = Math.cos(rotation);
		
		return m;
	}

	Matrix2 round() {
		double[][] array = new double[2][2];
		array[0][0] = this.matrix[0][0] + 0.5;
		array[0][1] = this.matrix[0][1] + 0.5;
		array[1][0] = this.matrix[1][0] + 0.5;
		array[1][1] = this.matrix[1][1] + 0.5;
		Matrix2 matrix = new Matrix2(array);

		return matrix;
	}
}
