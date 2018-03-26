
public class Vector3 {
	// fields
	protected float x, y, z;

	// constructors
	public Vector3() {
		this(0, 0, 0);
	}

	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/*
	 * OPERATIONS
	 */
	Vector3 add(Vector3 other) {
		float x = this.x + other.x;
		float y = this.y + other.y;
		float z = this.z + other.z;
		Vector3 v = new Vector3(x, y, z);
		return v;
	}

	Vector3 subtract(Vector3 other) {
		float x = this.x - other.x;
		float y = this.y - other.y;
		float z = this.z - other.z;
		Vector3 v = new Vector3(x, y, z);
		return v;
	}

	Vector3 round() {
		Vector3 vector = new Vector3(new Float(this.x + 0.5), new Float(this.y + 0.5), new Float(this.z + 0.5));
		return vector;
	}
	
	Vector3 scale(double d) {
		float x = (float) (this.x * d);
		float y = (float) (this.y * d);
		float z = (float) (this.z * d);
		Vector3 v = new Vector3(x, y, z);
		return v;
	}

	/*
	 * METHODS
	 */
	Vector3 cross(Vector3 other) {
		// returns the cross-product
		float x = this.y * other.z - this.z * other.y;
		float y = this.z * other.x - this.x * other.z;
		float z = this.x * other.y - this.y * other.x;
		Vector3 v = new Vector3(x, y, z);

		return v;
	}

	boolean equals(Vector3 other) {
		// casts the floats as integers before comparing them
		boolean equals = false;
		if (Integer.compare((int) this.round().x, (int) other.round().x) == 0
				&& Integer.compare((int) this.round().y, (int) this.round().y) == 0
				&& Integer.compare((int) this.round().z, (int) this.round().z) == 0)
			equals = true;

		return equals;
	}

	boolean isZero() {
		boolean isZero = false;
		if (Integer.compare((int) this.round().x, 0) == 0 && Integer.compare((int) this.round().y, 0) == 0
				&& Integer.compare((int) this.round().z, 0) == 0)
			isZero = true;

		return isZero;
	}

	double lengthSquared() {
		return x * x + y * y + z * z;
	}
	
	double magnitude() {
		return Math.sqrt(lengthSquared());
	}

	Vector3 normalize() {
		double d = 1.0 / this.magnitude();
		return this.scale(d);
	}
	
	boolean isParallel(Vector3 other) {
		Vector3 v = this.cross(other);
		return v.isZero();
	}

	/*
	 * STATIC METHODS
	 */
	static double angle(Vector3 left, Vector3 right) {
		// I don't understand this
		double angle = Math.acos(dotProduct(left, right) / left.magnitude() * right.magnitude());
		return angle;
	}

	static double distance(Vector3 left, Vector3 right) {
		return Math.sqrt(distanceSquared(left, right));
	}

	static double distanceSquared(Vector3 left, Vector3 right) {
		return left.subtract(right).lengthSquared();
	}

	static double dotProduct(Vector3 left, Vector3 right) {
		return left.x * right.x + left.y * right.y + left.z * right.z;
	}

	static Vector3 normalize(Vector3 v) {
		double d = 1.0 / v.magnitude();
		return v.scale(d);
	}
}
