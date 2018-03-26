
public class Matrix3 {
	// fields
	protected double[][] matrix;

	// constructors
	public Matrix3() {
		matrix = new double[3][3];
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (i == j)
					this.matrix[i][j] = 1;
				else
					this.matrix[i][j] = 0;
			}
		}
	}

	public Matrix3(double[][] other) {
		matrix = new double[3][3];
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.matrix[i][j] = other[i][j];
			}
		}
	}

	// methods
	boolean equals(Matrix3 other) {
		boolean equals = true;
		Matrix3 m = this.round();
		other = other.round();

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (Integer.compare((int) m.matrix[i][j], (int) other.matrix[i][j]) != 0) {
					equals = false;
					break;
				}
			}
		}

		return equals;
	}

	Vector3 multiplyByVector3(Vector3 vector) {
		Vector3 v = new Vector3();
		v.x = (float) (vector.x * this.matrix[0][0] + vector.y * this.matrix[0][1] + vector.z * this.matrix[0][2]);
		v.y = (float) (vector.x * this.matrix[1][0] + vector.y * this.matrix[1][1] + vector.z * this.matrix[1][2]);
		v.z = (float) (vector.x * this.matrix[2][0] + vector.y * this.matrix[2][1] + vector.z * this.matrix[2][2]);

		return v;
	}

	Matrix3 round() {
		double[][] array = new double[2][2];
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				array[i][j] = this.matrix[i][j] + 0.5;
			}
		}
		Matrix3 matrix = new Matrix3(array);

		return matrix;
	}

}
