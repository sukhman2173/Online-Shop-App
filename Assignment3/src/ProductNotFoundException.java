/**
 * Exception class for when a code read from the text file doesn't appear in the product database
 * 
 * @author Sukhman Singh 18041216
 */
public class ProductNotFoundException extends Exception 
{
	public ProductNotFoundException()
	{
	}
	
	public ProductNotFoundException(String message)
	{
		super(message);
	}
}
