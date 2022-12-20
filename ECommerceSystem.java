import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * Thanujann Dayaparan
 * 501100701
 * 
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
    private ArrayList<Product>  products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	
    	// Create some products. Notice how generateProductId() method is used
    	products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney"));
    	products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    	products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast"));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive"));
    	products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney"));
    	products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));
    	// creating shoe products
      products.add(new Shoes("Shoe", generateProductId(), 200.0, "Air Jordan 1s", 2, 4, 1, 3, 4, 2, 1, 8, 9, 12));
      products.add(new Shoes("Shoe", generateProductId(), 200.0, "Crocs", 2, 4, 1, 3, 4, 2, 1, 8, 9, 12));
     

    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    }
    
    /*
     * generates an order number String 
     */
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    /*
     * generates a customer Id String 
     */
    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    /*
     * generates a product Id String 
     */
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    /*
     * generates an error message String 
     */
    public String getErrorMessage()
    {
    	return errMsg;
    }
    
    /*
     * prints all products 
     */
    public void printAllProducts()
    { 
      // loops through all objects in arraylist of Product objects and prints them
    	for (Product p : products)
    		p.print();
    }
    
    /*
     * prints all products that are books
     */
    public void printAllBooks()
    {
      // loops through all objects in arraylist of Product objects and prints them if they belong to the category BOOKS
    	for (Product p : products) 
        if (p.getCategory().equals(Product.Category.BOOKS)) {
          p.print();
        }
      
    }
    
    /*
     * prints all current orders
     */
    public void printAllOrders()
    {
      // loops through all ProductOrder objects in arraylist of orders and prints them 
    	for (ProductOrder o : orders)
    		o.print();
      
    }
    /*
     * prints all shipped orders
     */
    public void printAllShippedOrders()
    {
      // loops through all ProductOrder objects in arraylist of shipped orders and prints them
    	for (ProductOrder o : shippedOrders)
    		o.print();
    }
    
    /*
     * prints all customers
     */
    public void printCustomers()
    {
      // loops through all Customer objects in arraylist of customers and prints them
    	for (Customer c : customers) {
        c.print();
      }
    }

    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public boolean printOrderHistory(String customerId)
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	Customer c1 = new Customer(customerId); // creating Customer object
      for (int i = 0; i < customers.size(); i++) {
        // if the customer object's id is equal to customerId then retrieve that customer
        if (customers.get(i).getId().equals(customerId)) {
          c1 = customers.get(i); 
          // printing orders of customer
          System.out.println("Current Orders of Customer " + customerId);
          for (ProductOrder o : orders) {
            if (o.getCustomer().equals(c1)) { // checking if the ProductOrder object has the same customer
              // Print current orders of this customer
              o.print();
              System.out.println();
            }
          }
          System.out.println("\nShipped Orders of Customer " + customerId);
          // printing shipped orders of customer
          for (ProductOrder o1 : shippedOrders) {
            if (o1.getCustomer().equals(c1)) {
              // Print shipped orders of this customer 
              o1.print();
              return true;
            }
          }
        }
      }
      // if the customer Id does not exist set an error message and return false
      errMsg = "customer " + customerId + " does not exist" ;
      return false;  
    }
    
     /*
     * Orders a product 
     * Checks to see if customer and product Ids exist and that product options are available 
     */
    public String orderProduct(String productId, String customerId, String productOptions)
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
      Customer cust = new Customer(customerId);
      boolean exists = false;
      // loop through customers arraylist and check if a Customer object has the same customer Id as the one in the parameter 
      // retrieve Customer object and set boolean variable to true
      for (int i = 0; i < customers.size(); i++) {
        if (customers.get(i).getId().equals(customerId)) {
          cust = customers.get(i);
          exists = true;
        }
      }
      // if no Customer object is found, set an error message and return false
      if (exists == false) {
        errMsg = "Customer " + customerId + " not found";
        return null;
      }
      
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
      Product prod = new Product(productId);
      boolean prod_exists = false;
      // loop through products arraylist and check if a Product object has the same product Id as the one in the parameter 
      // retrieve Product object and set boolean variable to true
      for (int i = 0; i < products.size(); i++) {
        if (products.get(i).getId().equals(productId)) {
          prod = products.get(i);
          prod_exists = true;
        }
      }
      // if no Product object is found, set an error message and return false
      if (prod_exists == false) {
        errMsg = "Product " + productId + " not found";
        return null;
      }
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
      if (prod.validOptions(productOptions) == false) {
        errMsg = "Invalid product options";
        return null;
      }
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
      int stock_count = prod.getStockCount(productOptions);
      if (stock_count <= 0) {
        errMsg = "Out of Stock";
        return null;
      }
      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string
      // creates new ProductOrder object
      ProductOrder p2 = new ProductOrder(generateOrderNumber(), prod, cust, productOptions); 	
      // reduces stock count
      prod.reduceStockCount(productOptions);
      // add order to list of orders
      orders.add(p2);
      // returns the order number String
      return p2.getOrderNumber();
    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    public boolean createCustomer(String name, String address)
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter
      if (name == null || name == "") {
        errMsg = "Invalid Customer name" ;
        return false;
      }
      else if (address == null || address == "") {
        errMsg = "Invalid Customer address" ;
        return false;
      }
    	// Create a Customer object and add to array list
      else {
        // creates new Customer object
        customers.add(new Customer(generateCustomerId(),name, address));
        return true;
      }
    }
    
     /*
     * retrieves order from orders array list and adds it to shippedOrders array list
     * returns reference to the order
     */
    public ProductOrder shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return null
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
    	// loops through orders array list and checks to see if any have the same order number as the one in the parameter
      for (int i = 0; i < orders.size(); i++) {
        if (orders.get(i).getOrderNumber().equals(orderNumber)) {
          // add to shipped orders and remove from orders array list
          ProductOrder p = orders.get(i);
          shippedOrders.add(p);
          orders.remove(p);
          return p;
        }
      }
      errMsg = "Order Number " + orderNumber + " Not Found";
      return null;
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	for (int i = 0; i < orders.size(); i++) {
        if (orders.get(i).getOrderNumber().equals(orderNumber)) {
          // removes order if the order number exists
          orders.remove(orders.get(i));
          return true;
        }
      }
      errMsg = "Order Number " + orderNumber + " Not Found";
    	return false;
    }
    
     /*
     * Sort products by increasing price
     */
    public void sortByPrice()
    {
      Collections.sort(products, Product.productPrice);
    }
    
    /*
     * Sort products alphabetically by product name
     */
    public void sortByName()
    {
  	  Collections.sort(products, Product.productName);
    }
    
        
    /*
     * Sort customers alphabetically by customer name
     */
    public void sortCustomersByName()
    {
  	  Collections.sort(customers);
    }
    
}
