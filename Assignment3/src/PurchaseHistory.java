import java.util.ArrayList;
/**
 * Class contains cart contents from previous customers
 * 
 * @author Sukhman Singh 18041216
 **/
public class PurchaseHistory 
{
	private ArrayList<Product> purchases;
	
	/**
	 * Default Constructor initializes purchases variable
	 * @author Sukhman Singh 18041216
	 **/
	public PurchaseHistory()
	{
		purchases = new ArrayList<Product>();
	}
	
	/**
	 * Constructor sets PurchaseHistory data
	 * @param p is a Product ArrayList. This is used to set the purchases variables
	 * @author Sukhman Singh 18041216
	 */
	public PurchaseHistory(ArrayList<Product> p)
	{
		purchases = p;
	}
	
	/**
	 * Method gets purchase histories
	 * @return A Product ArrayList containing purchase histories
	 * @author Sukhman Singh 18041216
	 */
	public ArrayList<Product> getPurchases()
	{
		return purchases;
	}
	
	/**
	 * String representation of PurchaseHistory class
	 * @author Sukhman Singh 18041216
	 **/
	public String toString()
	{
		return "Purchase History";
	}
}
