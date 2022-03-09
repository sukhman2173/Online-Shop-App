/**
 * Class that represents a Product which holds a code and price
 * 
 * @author Sukhman Singh 18041216
 **/
public class Interstellar extends Product
{
	/**
	 * Default Constructor which calls the ProductDetails method
	 * @author Sukhman Singh 18041216
	 **/
	public Interstellar()
	{
		ProductDetails();
	}
	
	/**
	 * Method sets price and code for specific product
	 * @author Sukhman Singh 18041216
	 **/
	public void ProductDetails()
	{
		setPrice(30);
		setCode(199);
	}
	
	/**
	 * Method displays a string representation of this product
	 * @author Sukhman Singh 18041216
	 **/
	public String toString()
	{
		return "(199)Interstellar 2014 $30.00";
	}
}
