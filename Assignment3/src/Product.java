/**
 * Abstract Product class which holds a price and a code to represent a product
 * 
 * @author Sukhman Singh 18041216
 **/
public abstract class Product implements Comparable<Product>
{
	private double price;
	private int code;
	
	/**
	 * Default constructor sets default values for price and code
	 * @author Sukhman Singh 18041216
	 **/
	public Product()
	{
		setPrice(0);
		setCode(0);
	}
	
	/**
	 * Abstract method which is called by subclasses
	 * @author Sukhman Singh 18041216
	 **/
	abstract protected void ProductDetails();
	
	/**
	 * Method gets product price
	 * @return A double variable which is the products price
	 * @author Sukhman Singh 18041216
	 **/
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * Method uses double variable as input to set price
	 * @param p represents a price
	 * @author Sukhman Singh 18041216
	 */
	public void setPrice(double p)
	{
		this.price = p;
	}
	
	/**
	 * Method gets products code
	 * @return A int which is the product code
	 * @author Sukhman Singh 18041216
	 */
	public int getCode()
	{
		return code;
	}
	
	/**
	 * Method sets products code using integer as a input
	 * @param c is a integer which is the products code
	 * @author Sukhman Singh 18041216
	 */
	public void setCode(int c)
	{
		this.code = c;
	}
	
	/**
	 * Method gets the price minus parameter product's price and uses it in Comparable
	 * @param aProduct is a Product type used to compare to price
	 * @return A integer which is the price difference between the two products
	 * @author Sukhman Singh 18041216
	 */
	@Override
	public int compareTo(Product aProduct)
	{
		return (int)(price - aProduct.getPrice());
	}
	
	/**
	 * String representation of the product class
	 * @author Sukhman Singh 18041216
	 */
	public String toString()
	{
		return ("Product Collection");
	}
}
