import java.util.ArrayList;

public class Grid {
	// static classes
	static float x = (float) -0.525731112119133606;
	static float z = (float) -0.850650808352039932;

	// contains 12 elements
	static Vector3 icosTileVectors[] = { new Vector3(-x, 0, z), new Vector3(x, 0, z), new Vector3(-x, 0, -z),
			new Vector3(x, 0, -z), new Vector3(0, z, x), new Vector3(0, z, -x), new Vector3(0, -z, x),
			new Vector3(0, -z, -x), new Vector3(z, x, 0), new Vector3(-z, x, 0), new Vector3(z, -x, 0),
			new Vector3(-z, -x, 0) };

	// contains 12 arrays of 5 elements each
	static int icosTileAdjacency[][] = { { 9, 4, 1, 6, 11 }, { 4, 8, 10, 6, 0 }, { 11, 7, 3, 5, 9 }, { 2, 7, 10, 8, 5 },
			{ 9, 5, 8, 1, 0 }, { 2, 3, 8, 4, 9 }, { 0, 1, 10, 7, 11 }, { 11, 6, 10, 3, 2 }, { 5, 3, 10, 1, 4 },
			{ 2, 5, 4, 0, 11 }, { 3, 7, 6, 1, 8 }, { 7, 2, 9, 0, 6 } };

	// contains 10 arrays of 3 elements each
	static int cornerInit[][] = { { 10, 1, 8 }, { 1, 10, 6 }, { 6, 10, 7 }, { 6, 7, 11 }, { 11, 7, 2 }, { 11, 2, 9 },
			{ 9, 2, 5 }, { 9, 5, 4 }, { 4, 5, 8 }, { 4, 8, 1 } };

	// fields
	protected final int cornerCount;
	protected final int edgeCount;
	protected final int tileCount;

	protected ArrayList<Corner> corners;
	protected ArrayList<Edge> edges;
	protected ArrayList<Tile> tiles;

	protected int size;

	// constructors
	public Grid(int size) {
		this.size = size;
		this.tileCount = 10 * (int) Math.pow(3, size) + 2;
		this.cornerCount = 20 * (int) Math.pow(3, size);
		this.edgeCount = 30 * (int) Math.pow(3, size);

		/*
		 * initialization is the same regardless of size; derived from the constructor
		 * of the original "grid" class
		 */
		for (int i = 0; i < tileCount; ++i) {
			// first 12 tiles have 5 edges, subsequent tiles have 6
			this.tiles.add(new Tile(i, (i < 12) ? 5 : 6));
		}

		for (int i = 0; i < cornerCount; ++i) {
			this.corners.add(new Corner(i));
		}

		for (int i = 0; i < edgeCount; ++i) {
			// TODO - update Edge constructor
			this.edges.add(new Edge());
		}

		/*
		 * here I folded in the "size_0_grid" function from the "create_grid" class; the
		 * first method initializes tiles with their adjacent tiles
		 */
		for (Tile el : tiles) {
			int tID = el.getTID();
			Tile t;
			el.updateVector(this.icosTileVectors[tID]);
			for (int i = 0; i < 5; ++i) {
				t = tiles.get(this.icosTileAdjacency[tID][i]);
				el.updateTiles(i, t);
			}
		}

		for (int i = 0; i < 5; ++i) {
			int t1 = this.icosTileAdjacency[0][(i + 4) % 5];
			int t2 = this.icosTileAdjacency[0][i];
			Corner.updateCorner(corners.get(i), this, 0, t1, t2);
		}

		for (int i = 0; i < 5; ++i) {
			int t1 = this.icosTileAdjacency[3][(i + 4) % 5];
			int t2 = this.icosTileAdjacency[3][i];
			Corner.updateCorner(corners.get(i + 5), this, 3, t1, t2);
		}

		// updates the first ten corners after making all the others
		for (int i = 0; i < 10; ++i) {
			int t1 = cornerInit[i][0];
			int t2 = cornerInit[i][1];
			int t3 = cornerInit[i][2];
			Corner.updateCorner(corners.get(i + 10), this, t1, t2, t3);
		}

		
		
		
		
		
		// TODO

	}

	// methods
	public Corner getCorner(int index) {
		return this.corners.get(index);
	}

	public Edge getEdge(int index) {
		return this.edges.get(index);
	}

	public Tile getTile(int index) {
		return this.tiles.get(index);
	}

	// static methods
	public static int getCornerCount(Grid grid) {
		return grid.cornerCount;
	}

	public static int getEdgeCount(Grid grid) {
		return grid.edgeCount;
	}

	public static int getTileCount(Grid grid) {
		return grid.tileCount;
	}

	public static Corner getCorner(Grid grid, int index) {
		return grid.corners.get(index);
	}

	public static Edge getEdge(Grid grid, int index) {
		return grid.edges.get(index);
	}

	public static Tile getTile(Grid grid, int index) {
		return grid.tiles.get(index);
	}

	public static ArrayList<Corner> getCorners(Grid grid) {
		return grid.corners;
	}

	public static ArrayList<Edge> getEdges(Grid grid) {
		return grid.edges;
	}

	public static ArrayList<Tile> getTiles(Grid grid) {
		return grid.tiles;
	}

}
