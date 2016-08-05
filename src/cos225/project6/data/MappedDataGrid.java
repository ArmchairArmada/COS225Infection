package cos225.project6.data;

import java.lang.reflect.Array;

import cos225.project6.math.ValueWrapper;
import cos225.project6.math.ValueMapper;
import cos225.project6.math.Vector2D;



/**
 * Model: A grid of user specified data that can be accessed through mapping
 * and wrapping a point in infinite space to select the data patch to use.
 * 
 * @author Nathan
 *
 * @param <T>  The type of data that is stored in this data grid
 */
public class MappedDataGrid<T extends Object> {
	private ValueMapper valMapX;
	private ValueWrapper valWrapX;
	private ValueMapper valMapY;
	private ValueWrapper valWrapY;
	private int gridSize;
	private double patchSize;
	private T[] data;
	
	/**
	 * Creates a new MappedDataGrid object.
	 * 
	 * Usage: <br />
	 * MappedDataGrid<DataType> mdg = new MappedDataGrid(DataType.class, gridSize, patchSize); <br /> <br />
	 * 
	 * Pre: clazz must have a default constructor <br />
	 * Post: Creates grid of new data objects
	 * 
	 * @param clazz  The class used for filling the grid with new instances
	 * @param gridSize  Number of data patches along one side of square grid
	 * @param patchSize  Size of one side of edge of square patch
	 */
	public MappedDataGrid(Class<T> clazz, int gridSize, double patchSize) {
		// Wrapping and mapping objects
		valMapX = new ValueMapper(1.0 / patchSize, gridSize / 2.0);
		valWrapX = new ValueWrapper(0, gridSize);
		valMapY = new ValueMapper(1.0 / patchSize, -gridSize / 2.0);
		valWrapY = new ValueWrapper(0, gridSize);
		
		// Data grid information
		this.gridSize = gridSize;
		this.patchSize = patchSize;
		
		// Create array of user specified data type
		@SuppressWarnings("unchecked")
		final T[] data = (T[]) Array.newInstance(clazz, gridSize*gridSize);
		this.data = data;
		
		try {
			// Populate array with new instances of data type
			for (int i=0; i<data.length; i++) {
				data[i] = clazz.newInstance();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the number of patches along one side of the square grid
	 * 
	 * Pre:
	 * Post:
	 * 
	 * @return  The number of patches along one side of the square grid
	 */
	public int getGridSize() {
		return gridSize;
	}
	
	/**
	 * Returns the size of one edge of the square patches it uses
	 * 
	 * Pre:
	 * Post:
	 * 
	 * @return  The size of one edge of the square patches it uses
	 */
	public double getPatchSize() {
		return patchSize;
	}
	
	/**
	 * Get data from the data grid using a Vector2D position in infinite space
	 * and returns the corresponding data patch that position maps to.
	 * 
	 * Pre:
	 * Post:
	 * 
	 * @param position  Vector2D position in infinite space
	 * @return  Data object from patch that position corresponds to.
	 */
	public T getDataAtPosition(Vector2D position) {
		return getMappedData(position.getX(), position.getY());
	}
	
	/**
	 * Get data from the grid by its X and Y index values.
	 * 
	 * Pre:
	 * Post:
	 * 
	 * @param x  Column in grid to get data from
	 * @param y  Row in grid to get data from
	 * @return  The data at the X,Y index
	 */
	public T getDataAt(int x, int y) {
		return data[index(x,y)];
	}
	
	/**
	 * Get data from the data grid using an X,Y position in infinite space
	 * and returns the corresponding data patch that position maps to.
	 * 
	 * Pre:
	 * Post:
	 * 
	 * @param x  X position in infinite space
	 * @param y  Y position in infinite space
	 * @return  Data object from patch that position corresponds to.
	 */
	public T getMappedData(double x, double y) {
		return data[index((int)mappedX(x), (int)mappedY(y))];
	}
	
	/**
	 * Maps and Wraps X position in this grid's finite space.
	 * 
	 * Pre:
	 * Post:
	 * 
	 * @param x  X position in infinite space
	 * @return  X position in grid's finite space
	 */
	public double mappedX(double x) {
		return valWrapX.wrap(valMapX.map(x));
	}
	
	/**
	 * Maps and Wraps Y position in this grid's finite space.
	 * 
	 * Pre:
	 * Post:
	 * 
	 * @param y  Y position in infinite space
	 * @return  Y position in grid's finite space
	 * 
	 */
	public double mappedY(double y) {
		return valWrapY.wrap(valMapY.map(y));
	}
	
	/**
	 * Converts 2D X,Y index positions into 1D array index
	 * 
	 * Pre:
	 * Post:
	 * 
	 * @param x  Column index in grid
	 * @param y  Row index in grid
	 * @return  Array index
	 */
	private int index(int x, int y) {
		return y * gridSize + x;
	}
}
