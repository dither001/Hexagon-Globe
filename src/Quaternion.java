
public class Quaternion {
	// fields
	protected double a, i, j, k;

	// constructors
	public Quaternion() {
		this.a = 1;
		this.i = 0;
		this.j = 0;
		this.k = 0;
	}

	public Quaternion(Vector3 axis, double angle) {
		a = Math.cos(angle * 0.5);

		Vector3 v = Vector3.normalize(axis);
		v = v.scale(Math.sin(angle * 0.5));
		i = v.x;
		j = v.y;
		k = v.z;
	}

	public Quaternion(Vector3 v1, Vector3 v2) {
		Vector3 v = Vector3.normalize(v1);
		Vector3 u = Vector3.normalize(v2);

		Quaternion q = new Quaternion();
		if (v.isParallel(u)) {
			if (v.equals(u) != true) {
				Vector3 inter;
				if (v.isParallel(new Vector3(1, 0, 0))) {
					inter = new Vector3(0, 1, 0);
				} else {
					inter = new Vector3(1, 0, 0);
				}

				q = new Quaternion(inter, u);
				Quaternion r = new Quaternion(inter, v);
				q = q.multiplyByQuaternion(r);
			}
		} else {
			q = new Quaternion(u.cross(v), -Math.acos(Vector3.dotProduct(v, u)));
		}

		this.a = q.a;
		this.i = q.i;
		this.j = q.j;
		this.k = q.k;
	}

	public Quaternion(double a, double i, double j, double k) {
		this.a = a;
		this.i = i;
		this.j = j;
		this.k = k;
	}

	// operators
	Quaternion multiplyByQuaternion(Quaternion other) {
		double a, i, j, k;
		Vector3 v1 = this.toVector3();
		Vector3 v2 = other.toVector3();
		a = (this.a * other.a) - Vector3.dotProduct(v1, v2);
		i = (this.j * other.k) - (this.k * other.j) + (this.a * other.i) + (this.i * other.a);
		j = (this.k * other.i) - (this.i * other.k) + (this.a * other.j) + (this.j * other.a);
		k = (this.i * other.j) - (this.j * other.i) + (this.a * other.k) + (this.k * other.a);

		Quaternion q = new Quaternion(a, i, j, k);
		return q;
	}

	Vector3 multiplyByVector3(Vector3 vector) {
		if (vector.isZero() != true) {
			Quaternion q = new Quaternion(0, vector.x, vector.y, vector.z);

			Quaternion r = q.conjugate(this);
			r = this.multiplyByQuaternion(q);
			vector = r.toVector3();
		}

		return vector;
	}

	// methods
	Quaternion conjugate(Quaternion other) {
		Quaternion q = new Quaternion(other.a, -other.i, -other.j, -other.k);
		return q;
	}

	boolean equals(Quaternion other) {
		boolean equals = false;
		Quaternion q = this.round();
		other = other.round();
		if (Integer.compare((int) q.a, (int) other.a) == 0 && Integer.compare((int) q.i, (int) other.i) == 0
				&& Integer.compare((int) q.j, (int) other.j) == 0 && Integer.compare((int) q.k, (int) other.k) == 0)
			equals = true;

		return equals;
	}

	Quaternion round() {
		double a = this.a + 0.5;
		double i = this.i + 0.5;
		double j = this.j + 0.5;
		double k = this.k + 0.5;
		Quaternion q = new Quaternion(a, i, j, k);

		return q;
	}

	Matrix3 toMatrix3() {
		Matrix3 m = new Matrix3();

		m.matrix[0][0] = 1 - (2 * this.j * this.j) - (2 * this.k * this.k);
		m.matrix[0][1] = (2 * this.i * this.j) - (2 * this.k * this.a);
		m.matrix[0][2] = (2 * this.i * this.k) - (2 * this.j * this.a);

		m.matrix[1][0] = (2 * this.i * this.j) - (2 * this.k * this.a);
		m.matrix[1][1] = 1 - (2 * this.i * this.i) - (2 * this.k * this.k);
		m.matrix[1][2] = (2 * this.j * this.k) - (2 * this.i * this.a);

		m.matrix[2][0] = (2 * this.i * this.k) - (2 * this.j * this.a);
		m.matrix[2][1] = (2 * this.j * this.k) - (2 * this.i * this.a);
		m.matrix[2][2] = 1 - (2 * this.i * this.i) - (2 * this.j * this.j);

		return m;
	}

	Vector3 toVector3() {
		Vector3 v = new Vector3((float) this.i, (float) this.j, (float) this.k);

		return v;
	}

	// static methods
	public static Quaternion normalize(Quaternion q) {
		double d = Math.sqrt(q.a * q.a + q.i * q.i + q.j * q.j + q.k * q.k);
		Quaternion normal = new Quaternion(q.a / d, q.i / d, q.j / d, q.k / d);

		return normal;
	}

}
