import java.util.ArrayList;
/**
 * ProductDatabase class contains all the products available in the shop
 * 
 * @author Sukhman Singh 18041216
 **/
public class ProductDatabase 
{
	private ArrayList<Product> database;
	
	/**
	 * Default Constructor used to initialize the database variable
	 * @author Sukhman Singh 18041216
	 **/
	public ProductDatabase()
	{
		database = new ArrayList<Product>();
	}
	
	/**
	 * Method uses Product as input to add to the database
	 * @param p is a Product type. This is added to the Product ArrayList called database
	 * @author Sukhman Singh 18041216
	 */
	public void put(Product p)
	{
		database.add(p);
	}
	
	/**
	 * Method uses products code to find product
	 * @param pcode is a integer. Product with this code will be returned
	 * @return Product with same code as parameter is returned
	 * @author Sukhman Singh 18041216
	 */
	public Product get(int pcode)
	{	
		for(int i = 0; i < database.size(); ++i)
		{
			if (database.get(i).getCode() == pcode)
			{
				return database.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Method gets all products in the database
	 * @return Product ArrayList containing all products from database
	 * @author Sukhman Singh 18041216
	 */
	public ArrayList<Product> getProducts()
	{
		return database;
	}
}
