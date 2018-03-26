
public class Corner {
	// fields
	protected final int cID;
	protected Vector3 vector;
	protected Tile[] tiles;

	// constructors
	public Corner(int cID) {
		this.cID = cID;
		// TODO
		tiles = new Tile[3];
	}

	// methods
	Vector3 setVector(Vector3 vector) {
		return this.vector = vector;
	}

	// static methods
	public static void updateCorner(Corner c, Grid g, int t1, int t2, int t3) {
		/*
		 * MODIFIED FROM "_add_corner" function in "create_grid" class TODO - I'm not
		 * 100% that I understand exactly what this method does. I'm pretty sure I was
		 * able to improve efficiency by creating the update methods within their
		 * respective classes, however I could be totally out of my depth here.
		 */
		Tile[] tilesToUpdate = { g.getTile(t1), g.getTile(t2), g.getTile(t3) };
		Vector3 v = tilesToUpdate[0].vector.add(tilesToUpdate[1].vector.add(tilesToUpdate[2].vector));
		c.setVector(v.normalize());

		for (int i = 0; i < 3; ++i) {
			tilesToUpdate[i].updateCorner(tilesToUpdate[(i + 2) % 3], c);
			c.tiles[i] = tilesToUpdate[i];
		}

	}

	public static int getID(Corner c) {
		return c.cID;
	}

	public static Vector3 getVector(Corner c) {
		return c.vector;
	}

}
