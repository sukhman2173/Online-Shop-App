/**
 * Class stores a recommended product with a frequency
 * 
 * @author Sukhman Singh 18041216
 */
public class RecommendedItem 
{
	private Product product;
	private int freq;
	
	/**
	 * Constructor sets product and frequency
	 * @param p is a Product type. This is set to the Product variable
	 * @param f is a integer type. This is set to the frequency variable
	 * @author Sukhman Singh 18041216
	 */
	public RecommendedItem(Product p, int f)
	{
		setProduct(p);
		setFreq(f);
	}
	
	/**
	 * Method gets product
	 * @return A product
	 * @author Sukhman Singh 18041216
	 */
	public Product getProduct()
	{
		return product;
	}
	
	/**
	 * Method sets Product
	 * @param p is a Product type. This is set as the product
	 * @author Sukhman Singh 18041216
	 */
	public void setProduct(Product p)
	{
		this.product = p;
	}
	
	/**
	 * Method gets the frequency
	 * @return A integer. This is the frequency
	 * @author Sukhman Singh 18041216
	 */
	public int getFreq()
	{
		return freq;
	}
	
	/**
	 * Method sets the frequency 
	 * @param f is a integer. This is set as the frequency
	 * @author Sukhman Singh 18041216
	 */
	public void setFreq(int f)
	{
		this.freq = f;
	}
}
