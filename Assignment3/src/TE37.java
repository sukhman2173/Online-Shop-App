/**
 * Class that represents a Product which holds a code and price
 * 
 * @author Sukhman Singh 18041216
 */
public class TE37 extends Product
{
	/**
	 * Default Constructor calls ProductDetails method
	 * @author Sukhman Singh 18041216
	 */
	public TE37()
	{
		ProductDetails();
	}
	
	/**
	 * Method sets price and code for product
	 * @author Sukhman Singh 18041216
	 */
	public void ProductDetails()
	{
		setPrice(700);
		setCode(200);
	}
	
	/**
	 * String representation of the product
	 * @author Sukhman Singh 18041216
	 */
	public String toString()
	{
		return "(200)Volk Racing TE37 Wheels $700.00";
	}
}
