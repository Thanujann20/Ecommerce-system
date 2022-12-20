/*
 * Thanujann Dayaparan
 * 501100701 
 * 
 * class Customer defines a registered customer. It keeps track of the customer's name and address. 
 * A unique id is generated when when a new customer is created. 
 * Implement the Comparable interface and compare two customers based on name
 */
public class Customer implements Comparable<Customer>
{
	private String id;  
	private String name;
	private String shippingAddress;
	
	public Customer(String id)
	{
		this.id = id;
		this.name = "";
		this.shippingAddress = "";
	}
	
	public Customer(String id, String name, String address)
	{
		this.id = id;
		this.name = name;
		this.shippingAddress = address;
	}
	
	/*
	 * returns id
	 */
	public String getId()
	{
		return id;
	}

	/*
	 * sets id to value passed in parameter
	 */
	public void setId(String id)
	{
		this.id = id;
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
	 * returns shipping address
	 */
	public String getShippingAddress()
	{
		return shippingAddress;
	}
	
	/*
	 * sets shipping address to value in parameter
	 */
	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}
	
	/*
	 * prints customer information
	 */
	public void print()
	{
		System.out.printf("\nName: %-20s ID: %3s Address: %-35s", name, id, shippingAddress);
	}
	
	/*
	 * Two customers are equal if they have the same customer Id.
	 */
	public boolean equals(Object other)
	{
		Customer otherC = (Customer) other;
		return this.id.equals(otherC.id);
	}

	/*
	 * compares customers by name and returns them in descending alphabetical order
	 */
	public int compareTo(Customer o) {
		String name1 = this.getName();
		String name2 = o.getName();
		return name1.compareTo(name2);
	}

	
	
}
