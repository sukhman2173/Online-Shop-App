 import java.util.ArrayList;
import java.io.*;
import java.util.*;
/**
 * Main class where user's input is used to call 
 * other methods and execute processes
 * 
 * @author Sukhman Singh 18041216
 *
 **/
public class OnlineShopApp 
{
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Method initializes a ProductDatabase with all 5 products
	 * @return ProductDatabase type with all 5 products.
	 * @author Sukhman Singh 18041216
	 **/
	public static ProductDatabase generateSampleDatabase()
	{
		ProductDatabase pd = new ProductDatabase();
		
		pd.put(new Nissan350Z());
		pd.put(new InvidiaGemini());
		pd.put(new Interstellar());
		pd.put(new TE37());
		pd.put(new VeonTV());
		
		return pd;
	}
	
	/**
	 * Method displays all the menu items the user can choose from. Calls other menu methods depending on users input.
	 * @param pd is a ProductDatabase with all 5 products containing in it.
	 * @param os is a OnlineShop object that is declared in the main
	 * @author Sukhman Singh 18041216
	 **/
	public static void MainMenu(ProductDatabase pd, OnlineShop os) throws IOException, ProductNotFoundException
	{	
		System.out.println("------------------------------------------------");
		System.out.println("Main Menu\n");
		System.out.println("1. Product Collection");
		System.out.println("2. Shopping Cart");
		System.out.println("3. Checkout");
		System.out.println("4. Quit");
		
		System.out.println("Choose a menu item (1-4):");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		if (choice == 1)
		{
			ProductMenu(pd, os);
		}
		else if (choice == 2)
		{
			CartMenu(pd, os);
		}
		else if (choice == 3)
		{
			CheckoutMenu(pd, os);
		}
		else
		{
			System.out.println("Thank you for using Online Shop");
		}
		
	}
	
	/**
	 * 
	 * @param pd is a ProductDatabase type that contains all 5 products
	 * @param os is a OnlineShop object that initialized with a ProductDatabase and PurchaseHistories as input
	 * @author Sukhman Singh 18041216
	 **/
	public static void ProductMenu(ProductDatabase pd, OnlineShop os) throws IOException, ProductNotFoundException
	{	
		System.out.println("------------------------------------------------");
		System.out.println("Product Collection\n");
		
		for (int i = 0; i < os.getProductListing().size(); ++i)
		{
			System.out.println(i+1+". "+os.getProductListing().get(i));
		}
		
		System.out.println("Please choose product (1-5): ");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		if (choice == 1)
		{
			os.addToCart(pd.get(123));
		}
		else if (choice == 2)
		{
			os.addToCart(pd.get(187));
		}
		else if (choice == 3)
		{
			os.addToCart(pd.get(199));
		}
		else if (choice == 4)
		{
			os.addToCart(pd.get(200));
		}
		else if (choice == 5)
		{
			os.addToCart(pd.get(865));
		}
		else
		{
			System.out.println("Please enter from 1-5");
		}
		
		MainMenu(pd, os);
		
	}
	
	/**
	 * Method displays all the products and depending on users choice, adds it to the shopping cart
	 * @param pd is a ProductDatabase type with all products in it
	 * @param os is a OnlineShop object that initialized with a ProductDatabase and PurchaseHistories as input
	 * @author Sukhman Singh 18041216
	 **/
	public static void CartMenu(ProductDatabase pd, OnlineShop os) throws IOException, ProductNotFoundException
	{
		System.out.println("------------------------------------------------");
		System.out.println("Shopping Cart\n");
		
		for (int i = 0; i < os.getShoppingCart().size(); ++i)
		{
			System.out.println(os.getShoppingCart().get(i));
		}
		
		MainMenu(pd, os);
	}
	
	/**
	 * Method gets users shopping cart and adds a entry into text file once the user has confirmed the payment
	 * @param pd is a ProductDatabase type with all products in it
	 * @param os is a OnlineShop object from main
	 * @author Sukhman Singh 18041216
	 **/
	public static void CheckoutMenu(ProductDatabase pd, OnlineShop os) throws IOException, ProductNotFoundException
	{	
		System.out.println("------------------------------------------------");
		System.out.println("Checkout\n");
		
		if (os.getShoppingCart().size() == 0)
		{
			MainMenu(pd, os);
		}
		else
		{
			for (int i = 0; i < os.getShoppingCart().size(); ++i)
			{	
				System.out.println(os.getShoppingCart().get(i));
			}
			
			System.out.printf("\nTotal: $%.2f", os.amountOwing());
			System.out.println("\nConfirm Payment? (Y/N)");
			scan = new Scanner(System.in);
			String pay = scan.nextLine();
			
			if (pay.equalsIgnoreCase("y"))
			{
				writePurchaseHistoryData(os);
				
				if (os.getRecommendedProducts().size() > 0)
				{
					System.out.println("You may also be interested in:\n"+os.getRecommendedProducts()+"\n");
				}
				
				os.completeTransaction();
				os = new OnlineShop(generateSampleDatabase(), readPurchaseHistoryData(generateSampleDatabase(), "purchase-history.txt"));
			}
			else
			{
				System.out.println("Payment Cancelled");
			}
			
			MainMenu(pd, os);
		}
	}
	
	/**
	 * Method gets the text file and reads each cart's product's codes. Then stores these codes into a Purchase History object and does this for each order. 
	 * These objects are then stored into an PurchaseHistory ArrayList.
	 * @param pd is a ProductDatabase type with all products within it.
	 * @param filename is a String that has the name of the text file
	 * @return An PurchaseHistory ArrayList containing codes of each purchase entry.
	 * @author Sukhman Singh 18041216
	 **/
	public static ArrayList<PurchaseHistory> readPurchaseHistoryData(ProductDatabase pd,String filename) throws ProductNotFoundException, IOException, NumberFormatException
	{
		ArrayList<PurchaseHistory> aph = new ArrayList<PurchaseHistory>();
		
		try
		{
			File file = new File(filename);
			scan = new Scanner(file);
			
			while(scan.hasNextInt())
			{	
				ArrayList<Product> p = new ArrayList<Product>();
				int num = scan.nextInt();
				
				for(int i = 0; i < num; ++i)
				{
					int temp = scan.nextInt();
					
					p.add(pd.get(temp));
					
					if (pd.get(temp) == null) throw new ProductNotFoundException(); 
				}
				
				PurchaseHistory ph = new PurchaseHistory(p);
				aph.add(ph);
			}
			scan.close();
		}
		catch (IOException ioe)
		{
			System.out.println("File can not be opened");
		}
		catch (NumberFormatException nfe)
		{
			System.out.println("Integer parsing failed");
		}
		catch (ProductNotFoundException pnfe)
		{
			System.out.println("Product code does not exist");
		}
		
		return aph;

	}
	
	/**
	 * Method gets the user's cart and writes the number of items and codes of each item.
	 * @param os is a OnlineShop object which is used to get access to the user's cart.
	 * @author Sukhman Singh 18041216
	 **/
	public static void writePurchaseHistoryData(OnlineShop os)
	{
		try
		{
			File file = new File("purchase-history.txt");
			scan = new Scanner(file);
			
			String contents = "";
			
			while(scan.hasNextLine())
			{
				contents += scan.nextLine()+"\n";
			}
			
			FileWriter writer = new FileWriter(file);
			
			writer.write(contents);
			writer.write(os.getShoppingCart().size()+"\n");
			
			for (int i = 0; i < os.getShoppingCart().size(); ++i)
			{
				writer.write(os.getShoppingCart().get(i).getCode()+"\n");
			}
		
			writer.close();
			scan.close();
		}
		catch(IOException e)
		{
			System.out.println("Writing to file was unsuccessful");
		}
	}
	
	/**
	 * Main method calls all the methods needed to make the program functional.
	 * @author Sukhman Singh 18041216
	 **/
	public static void main(String[] args) throws ProductNotFoundException, IOException
	{	
		OnlineShop shop = new OnlineShop(generateSampleDatabase(), readPurchaseHistoryData(generateSampleDatabase(), "purchase-history.txt"));
		
		System.out.println("Online Shop Application");
		MainMenu(generateSampleDatabase(), shop);
		
		scan.close();
	}
}
