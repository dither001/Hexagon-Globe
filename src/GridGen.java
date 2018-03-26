import java.util.ArrayList;

public class GridGen {
	// methods
	public static Grid createGrid() {
		Grid grid = new Grid(0);
		float x = (float) -0.525731112119133606;
		float z = (float) -0.850650808352039932;

		Vector3 icosTileVectors[] = { new Vector3(-x, 0, z), new Vector3(x, 0, z), new Vector3(-x, 0, -z),
				new Vector3(x, 0, -z), new Vector3(0, z, x), new Vector3(0, z, -x), new Vector3(0, -z, x),
				new Vector3(0, -z, -x), new Vector3(z, x, 0), new Vector3(-z, x, 0), new Vector3(z, -x, 0),
				new Vector3(-z, -x, 0) };

		int icosTileAdjacency[][] = { { 9, 4, 1, 6, 11 }, { 4, 8, 10, 6, 0 }, { 11, 7, 3, 5, 9 }, { 2, 7, 10, 8, 5 },
				{ 9, 5, 8, 1, 0 }, { 2, 3, 8, 4, 9 }, { 0, 1, 10, 7, 11 }, { 11, 6, 10, 3, 2 }, { 5, 3, 10, 1, 4 },
				{ 2, 5, 4, 0, 11 }, { 3, 7, 6, 1, 8 }, { 7, 2, 9, 0, 6 } };
		// TODO
		
		return null;
	}
	
	void addCorner(int id, Grid grid, int t1, int t2, int t3) {
		// TODO
		Corner c = grid.corners.get(id);
		Tile[] t = {grid.tiles.get(t1), grid.tiles.get(t2), grid.tiles.get(t3)};
		Vector3 v = t[0].vector.add(t[1].vector.add(t[2].vector));
		
		c.setVector(Vector3.normalize(v));
		for (int i = 0; i < 3; ++i) {
//			t[i]
		}
		
	}

}
