import java.util.ArrayList;
/**
 * Class determines what products should be recommended
 * 
 * @author Sukhman Singh 18041216
 **/
public class RecommenderSystem 
{
	private ArrayList<PurchaseHistory> purchaseHistories = new ArrayList<PurchaseHistory>();
	private ProductDatabase productDB;
	private ArrayList<RecommendedItem> recommend = new ArrayList<RecommendedItem>();
	
	/**
	 * Default constructor sets default values for variables
	 * @author Sukhman Singh 18041216
	 **/
	public RecommenderSystem()
	{
		purchaseHistories = null;
		productDB = null;
		recommend = null;
	}
	
	/**
	 * Constructor initializes variables
	 * @param ph is a PurchaseHistory ArrayList. This is set to the purchaseHistories
	 * @param db is a ProductDatabase variable. This is set to ProductDB
	 * @author Sukhman Singh 18041216
	 */
	public RecommenderSystem(ArrayList<PurchaseHistory> ph, ProductDatabase db)
	{
		purchaseHistories = ph;
		productDB = db;
		
		for (int i = 0; i < productDB.getProducts().size(); ++i)
		{
			recommend.add(new RecommendedItem(productDB.getProducts().get(i), 0));
		}
	}
	
	/**
	 * Method gets Product's frequency
	 * @param is a Product type. This is the product's frequency that gets retrieved 
	 * @return A integer type. 
	 * @author Sukhman Singh 18041216
	 */
	public int getProductFreq(Product p)
	{
		int freq = 0;
		
		for (int i = 0; i < purchaseHistories.size(); ++i)
		{
			for (int j = 0; j < purchaseHistories.get(i).getPurchases().size(); ++j)
			{
				if (purchaseHistories.get(i).getPurchases().get(j).getCode() == p.getCode())
				{
					++freq;
				}
			}
		}
		
		return freq;
	}
	
	/**
	 * Method adds 1 to the parameter product frequency
	 * @param p is a Product type. This is the product's frequency that gets 1 added to.
	 * @author Sukhman Singh 18041216
	 */
	public void updateProductFreq(Product p)
	{
		for (int i = 0; i < recommend.size(); ++i)
		{
			if (recommend.get(i).getProduct() == p)
			{
				recommend.get(i).setFreq(recommend.get(i).getFreq() + 1);
			}
		}
	}

	/**
	 * Method uses Shopping cart and frequency of first item in cart as inputs to determine which products to recommend
	 * @param cart is a Product ArrayList. This is the user's shopping cart
	 * @param freq is a integer type. This is the frequency of the first product in the user's cart
	 * @return A Product ArrayList which contains the recommended products determined by the algorithm
	 * @author Sukhman Singh 18041216
	 */
	public ArrayList<Product> productRecommenderAlgorithm(ArrayList<Product> cart, int freq)
	{	
		ArrayList<Product> rItems = new ArrayList<Product>();
		boolean match = false;
		
		for (int i = 0; i < recommend.size(); ++i)
		{
			recommend.get(i).setFreq(0);
		}
		
		for (int entry = 0; entry < purchaseHistories.size(); ++entry)
		{
			do{
				for (int product = 0; product < purchaseHistories.get(entry).getPurchases().size(); ++product)
				{
					if (purchaseHistories.get(entry).getPurchases().get(product).getCode() == cart.get(0).getCode())
					{
						match = true;
					}
					
					if (match == true)
					{
						for (int i = 0; i < purchaseHistories.get(entry).getPurchases().size(); ++i)
						{
							if (purchaseHistories.get(entry).getPurchases().get(i).getCode() != cart.get(0).getCode())
							{
								for (int rprod = 0; rprod < recommend.size(); ++rprod)
								{
									if (recommend.get(rprod).getProduct().getCode() == purchaseHistories.get(entry).getPurchases().get(i).getCode())
									{
										updateProductFreq(recommend.get(rprod).getProduct());
									}
								}
							}
						}
						
						match = false;
					}
				}
				
			} while (match == true);
		}
		
		for (int i = 0; i < recommend.size(); ++i)
		{
			match = false;
			
			if (recommend.get(i).getFreq() >= freq)
			{
				for (int j = 0; j < cart.size(); ++j)
				{
					if (recommend.get(i).getProduct().getCode() == cart.get(j).getCode())
					{
						match = true;
					}
				}
				if(!match)
				{
					rItems.add(recommend.get(i).getProduct());
				}
			}
		}
		
		return rItems;
	}
}
