
public class Vector2 {
	// fields
	protected float x, y;

	// constructors
	public Vector2() {
		this(0, 0);
	}

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * OPERATIONS
	 */
	Vector2 add(Vector2 other) {
		float x = this.x + other.x;
		float y = this.y + other.y;
		Vector2 v = new Vector2(x, y);
		return v;
	}

	Vector2 subtract(Vector2 other) {
		float x = this.x - other.x;
		float y = this.y - other.y;
		Vector2 v = new Vector2(x, y);
		return v;
	}
	
	Vector2 scale(double d) {
		float x = (float) (this.x * d);
		float y = (float) (this.y * d);
		Vector2 v = new Vector2(x, y);
		return v;
	}

	/*
	 * METHODS
	 */
	boolean equals(Vector2 other) {
		// casts the floats as integers before comparing them
		boolean equals = false;
		if (Integer.compare((int) this.x, (int) other.x) == 0 && Integer.compare((int) this.y, (int) other.y) == 0)
			equals = true;

		return equals;
	}

	double lengthSquared() {
		return x * x + y * y;
	}
	
	double magnitude() {
		return Math.sqrt(lengthSquared());
	}

	/*
	 * STATIC METHODS
	 */
	static double angle(Vector2 v) {
		// I don't understand this
		double angle = Math.atan2(v.x, v.y);
		return angle;
	}

	static double distance(Vector2 left, Vector2 right) {
		return Math.sqrt(distanceSquared(left, right));
	}

	static double distanceSquared(Vector2 left, Vector2 right) {
		return left.subtract(right).lengthSquared();
	}
}
