/**
 * Class that represents a Product which holds a code and price
 * 
 * @author Sukhman Singh 18041216
 */
public class Nissan350Z extends Product
{
	/**
	 * Default Constructor calls ProductDetails method
	 * @author Sukhman Singh 18041216
	 */
	public Nissan350Z()
	{
		ProductDetails();
	}
	
	/**
	 * Method sets price and code
	 * @author Sukhman Singh 18041216
	 */
	public void ProductDetails()
	{
		setPrice(12000);
		setCode(123);
	}
	
	/**
	 * String representation of the product
	 * @author Sukhman Singh 18041216
	 */
	public String toString()
	{
		return "(123)Nissan 350Z 2005 $12000.00";
	}
}
