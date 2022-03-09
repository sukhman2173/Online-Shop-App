import java.util.ArrayList;
import java.util.Collections;
/**
 * OnlineShop class represents a single transaction completed by the user
 * 
 * @author Sukhman Singh 18041216
 **/
public class OnlineShop implements PaymentSystem
{
	private ProductDatabase productDB;
	private ArrayList<Product> cart = new ArrayList<Product>();
	private RecommenderSystem recommender;
	
	/**
	 * Default constructor setting default values for each variable
	 * @author Sukhman Singh 18041216
	 **/
	public OnlineShop()
	{
		productDB = null;
		cart = null;
		recommender = null;
	}
	
	/**
	 * Constructor uses input of ProductDatabase and PurchaseHistory Arraylist to set values
	 * @param pd is a ProductDatabase with all products in it
	 * @param ph is a PurchaseHistory ArrayList used to initialize the RecommenderSystem variable
	 * @author Sukhman Singh 18041216
	 **/
	public OnlineShop(ProductDatabase pd, ArrayList<PurchaseHistory> ph)
	{
		productDB = pd;
		recommender = new RecommenderSystem(ph, productDB);
	}
	
	/**
	 * Method adds product to cart and checks that the product is not already added
	 * @param aProduct is a Product variable that is used to add to the cart
	 * @return A boolean which returns true if the Product is added to the cart successfully
	 * @author Sukhman Singh 18041216
	 **/
	public boolean addToCart(Product aProduct)
	{
		int check = 0;
		
		for (int i = 0; i < cart.size(); ++i)
		{
			if (cart.get(i).getCode() == aProduct.getCode())
			{
				check = 1;
			}
		}
		
		if (check == 0)
		{
			cart.add(aProduct);
			System.out.println(aProduct+" Added to Cart");
			return true;
		}
		else
		{
			System.out.println("You've already added this product to Cart!");
			return false;
		}
	}
	
	/**
	 * Method gets recommended products using the productRecommenderAlgorithm
	 * @return A Product ArrayList which contains all the recommended products
	 * @author Sukhman Singh 18041216
	 **/
	public ArrayList<Product> getRecommendedProducts()
	{
		return recommender.productRecommenderAlgorithm(cart, recommender.getProductFreq(cart.get(0)));
	}
	
	/**
	 * Method gets all the products from the ProductDatabase
	 * @return A Product ArrayList which consists of all the products
	 * @author Sukhman Singh 18041216
	 **/
	public ArrayList<Product> getProductListing()
	{
		return productDB.getProducts();
	}
	
	/**
	 * Method gets all products from user Shopping cart
	 * @return A Product ArrayList consisting of user's Shopping cart products
	 * @author Sukhman Singh 18041216
	 **/
	public ArrayList<Product> getShoppingCart()
	{	
		if (cart.size() == 0)
		{
			System.out.println("Empty. Add products from Product Collection");
		}
		else
		{
			Collections.sort(cart);
		}
		
		return cart;
	}
	
	/**
	 * Method gets all products from cart and adds all the prices together
	 * @return A double variable which is a the sum of the cart's products
	 * @author Sukhman Singh 18041216
	 **/
	public double amountOwing()
	{
		double total = 0;
		
		for (int i = 0; i < cart.size(); ++i)
		{
			total += cart.get(i).getPrice();
		}
		
		return total;
	}
	
	/**
	 * Method clears cart contents and completes payment
	 * @author Sukhman Singh 18041216
	 **/
	public void completeTransaction()
	{
		cart.clear();
		System.out.println("Thank you for your payment");
	}
}
