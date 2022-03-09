/**
 * Class that represents a Product which holds a code and price
 * 
 * @author Sukhman Singh 18041216
 **/
public class InvidiaGemini extends Product
{
	/**
	 * Method calls ProductDetails method
	 * @author Sukhman Singh 18041216
	 **/
	public InvidiaGemini()
	{
		ProductDetails();
	}
	
	/**
	 * Method sets price and code for product;
	 * @author Sukhman Singh 18041216
	 **/
	public void ProductDetails()
	{
		setPrice(1500);
		setCode(187);
	}
	
	/**
	 * String representation of product
	 * @author Sukhman Singh 18041216
	 **/
	public String toString()
	{
		return "(187)Invidia Gemini Catback Exhaust $1500.00";
	}
}
