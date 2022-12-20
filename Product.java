import java.util.Comparator;

/*
 * Thanujann Dayaparan
 * 501100701
 * 
 * class Product defines a product for sale by the system. 
 * A product belongs to one of the 5 categories below. 
 * Some products also have various options (e.g. size, color, format, style, ...). The options can affect
 * the stock count(s). In this generic class Product, product options are not used in get/set/reduce stockCount() methods  
 * implements comparable interface to compare 2 products based on name and price
 */
public class Product implements Comparable<Product>
{
	public static enum Category {GENERAL, CLOTHING, BOOKS, FURNITURE, COMPUTERS};
	
	private String name;
	private String id;
	private Category category;
	private double price;
	private int stockCount;
	
	public Product()
	{
		this.name = "Product";
		this.id = "001";
		this.category = Category.GENERAL;
		this.stockCount = 0;
	}
	
	public Product(String id)
	{
		this("Product", id, 0, 0, Category.GENERAL);
	}

	public Product(String name, String id, double price, int stock, Category category)
	{
		this.name = name;
		this.id = id;
		this.price = price;
		this.stockCount = stock;
		this.category = category;
	}
	/*
	 * This method always returns true in class Product. In subclasses, this method will be overridden
	 * and will check to see if the options specified are valid for this product.
	 */
	public boolean validOptions(String productOptions)
	{
		// checks if productOptions is null or and empty String and returns true if so
		if (productOptions == null || productOptions == "") {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * returns category
	 */
	public Category getCategory()
	{
		return category;
	}
	
	/*
	 * returns name
	 */
	public String getName()
	{
		return name;
	}

	/*
	 * sets name to value in parameter
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/*
	 * returns id
	 */
	public String getId()
	{
		return id;
	}

	/*
	 * sets id to value in parameter
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/*
	 * returns price
	 */
	public double getPrice()
	{
		return price;
	}

	/*
	 * sets price to value in parameter
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	/*
	 * Return the number of items currently in stock for this product
	 * Note: in this general class, the productOptions parameter is not used. It may be used
	 * in subclasses.
	 */
	public int getStockCount(String productOptions)
	{
		return stockCount;
	}
	/*
	 * Set (or replenish) the number of items currently in stock for this product
	 * Note: in this general class, the productOptions parameter is not used. It may be used
	 * in subclasses.
	 */
	public void setStockCount(int stockCount, String productOptions)
	{
		this.stockCount = stockCount;
	}
	/*
	 * Reduce the number of items currently in stock for this product by 1 (called when a product has
	 * been ordered by a customer)
	 * Note: in this general class, the productOptions parameter is not used. It may be used
	 * in subclasses.
	 */
	public void reduceStockCount(String productOIptions)
	{
		stockCount--;
	}
	
	/*
	 * prints product information
	 */
	public void print()
	{
		System.out.printf("\nId: %-5s Category: %-9s Name: %-20s Price: %7.1f", id, category, name, price);
	}
	
	
	/*
	 * Two products are equal if they have the same product Id.
	 * This method is inherited from superclass Object and overridden here
	 */
	public boolean equals(Object other)
	{
		Product otherP = (Product) other;
		return this.id.equals(otherP.id);
	}
	/*
	* Compares two product objects' names
	* Returns names in alphabetical order
	*/
	public static Comparator<Product> productName = new Comparator<Product> () { 
		public int compare(Product p, Product p2) {
			String name1 = p.getName();
			String name2 = p2.getName();
			return name1.compareTo(name2);
		}
	};

	/*
	* Compares two product objects' price
	* Returns prices in increasing order
	*/
	public static Comparator<Product> productPrice = new Comparator<Product> () { 
		public int compare(Product o1, Product o2) {
			double price1 = o1.getPrice();
			double price2 = o2.getPrice();
			return (int) (price1 - price2);
		}
	};

	@Override
	public int compareTo(Product o) {
		return 0;
	}
}
