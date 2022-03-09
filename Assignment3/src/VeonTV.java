/**
 * Class that represents a Product which holds a code and price
 * 
 * @author Sukhman Singh 18041216
 */
public class VeonTV extends Product
{
	/**
	 * Default Constructor calls ProductDetails method
	 * @author Sukhman Singh 18041216
	 */
	public VeonTV()
	{
		ProductDetails();
	}
	
	/**
	 * Method sets price and code for product
	 * @author Sukhman Singh 18041216
	 */
	public void ProductDetails()
	{
		setPrice(150);
		setCode(865);
	}
	
	/**
	 * String representation of the product
	 * @author Sukhman Singh 18041216
	 */
	public String toString()
	{
		return "(865)Veon 32 Inch TV $150.00";
	}
}
