
public class Tile {
	// fields
	protected final int tID;
	protected final int edgeCount;
	protected Vector3 vector;

	protected Corner[] corners;
	protected Edge[] edges;
	protected Tile[] tiles;

	// constructors
	public Tile(int tID, int edgeCount) {
		this.tID = tID;
		this.edgeCount = edgeCount;

		corners = new Corner[edgeCount];
		edges = new Edge[edgeCount];
		tiles = new Tile[edgeCount];
		// TODO
	}

	// methods
	public int getTID() {
		return this.tID;
	}
	
	public boolean equals(Tile other) {
		return this.tID == other.tID;
	}

	public void updateCorner(Tile tile, Corner c) {
		int index = -1;
		for (int i = 0; i < this.edgeCount; ++i) {
			if (this.tiles[i].equals(tile))
				index = i;
		}
		
		corners[index] = c;
	}
	
	public void updateTiles(int index, Tile tile) {
		this.tiles[index] = tile;
	}
	
	public void updateVector(Vector3 vector) {
		this.vector = vector;
	}

	// static methods
	// public static int position(Tile t1, Tile t2) {
	// for (int i = 0; i < t1.edgeCount; ++i) {
	// if (t1.tiles[i].equals(t2))
	// return i;
	// }
	//
	// return -1;
	// }

}
