/*
 * Thanujann Dayaparan
 * 501100701
 * class shoes defines a shoe product. 
 * shoes have 2 colours (Black and Brown) as well as 5 sizes (6, 7, 8, 9, 10)
 * There are 10 different combinations for shoe stock
 * 
 */
public class Shoes extends Product {
	// represents different stock options (stock1 is a black shoe that is size 6...)
    int stock1;
    int stock2; 
    int stock3;
    int stock4;
    int stock5;
    int stock6;
    int stock7;
    int stock8;
    int stock9;
    int stock10;
    private String shoe_name;
	
	public Shoes(String name, String id, double price, String shoe_name, int stock1, int stock2, int stock3, int stock4, int stock5, int stock6, int stock7, int stock8, int stock9, int stock10)
	{
		super(name, id, price, 10000, Product.Category.CLOTHING);
        this.stock1 = stock1;
        this.stock2 = stock2;
        this.stock3 = stock3;
        this.stock4 = stock4;
        this.stock5 = stock5;
        this.stock6 = stock6;
        this.stock7 = stock7;
        this.stock8 = stock8;
        this.stock9 = stock9;
        this.stock10 = stock10;
        this.shoe_name = shoe_name;
	}

    
    /*
    * Check if parameter is a valid shoe type and returns true if so
    */
    public boolean validOptions(String productOptions)
	{
        // check productOptions for different shoe combinations
  	    // if it is one of these, return true, else return false
		if (productOptions.equals("6 Black") || productOptions.equals("7 Black") || productOptions.equals("8 Black") || productOptions.equals("9 Black")
        || productOptions.equals("10 Black") || productOptions.equals("6 Brown") || productOptions.equals("7 Brown") || productOptions.equals("8 Brown")
        || productOptions.equals("9 Brown") || productOptions.equals("10 Brown")) {
			return true;
		}
		else {
			return false;
		}
	}

    /*
    * Check for number of stock for a specific shoe based on parameter  
    */
    public int getStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and return) the number of stock for "6 Black" etc
        if (productOptions == "6 Black") {
            return stock1;
        }
        else if (productOptions == "7 Black") {
            return stock2;
        }
        else if (productOptions == "8 Black") {
            return stock3;
        }
        else if (productOptions == "9 Black") {
            return stock4;
        }
        else if (productOptions == "10 Black") {
            return stock5;
        }
        else if (productOptions == "6 Brown") {
            return stock6;
        }
        else if (productOptions == "7 Brown") {
            return stock7;
        }
        else if (productOptions == "8 Brown") {
            return stock8;
        }
        else if (productOptions == "9 Brown") {
            return stock9;
        }
        else {
            return stock10;
        }
    
	}
    /*
    * sets stock count of shoes
    */
    public void setStockCount(int stockCount, String productOptions)
	{
    // Use the productOptions to check for (and set) the number of stock for "6 Black" etc
        if (productOptions == "6 Black") {
            this.stock1 = stockCount;
        }
        else if (productOptions == "7 Black") {
            this.stock2 = stockCount;
        }
        else if (productOptions == "8 Black") {
            this.stock3 = stockCount;
        }
        else if (productOptions == "9 Black") {
            this.stock4 = stockCount;
        }
        else if (productOptions == "10 Black") {
            this.stock5 = stockCount;
        }
        else if (productOptions == "6 Brown") {
            this.stock6 = stockCount;
        }
        else if (productOptions == "7 Brown") {
            this.stock7 = stockCount;
        }
        else if (productOptions == "8 Brown") {
            this.stock8 = stockCount;
        }
        else if (productOptions == "9 Brown") {
            this.stock9 = stockCount;
        }
        else if (productOptions == "10 Brown") {
            this.stock10 = stockCount;
	    }
    }

    /*
    * When a shoe is ordered, reduce the stock count for the specific stock type
    */
    public void reduceStockCount(String productOptions)
    {
    // Use the productOptions to check for (and reduce) the number of stock for "6 Black" etc
        if (productOptions == "6 Black") {
            stock1--;
        }
        else if (productOptions == "7 Black") {
            stock2--;
        }
        else if (productOptions == "8 Black") {
            stock3--;
        }
        else if (productOptions == "9 Black") {
            stock4--;
        }
        else if (productOptions == "10 Black") {
            stock5--;
        }
        else if (productOptions == "6 Brown") {
            stock6--;
        }
        else if (productOptions == "7 Brown") {
            stock7--;
        }
        else if (productOptions == "8 Brown") {
            stock8--;
        }
        else if (productOptions == "9 Brown") {
            stock9--;
        }
        else if (productOptions == "10 Brown") {
            stock10--;
        }
    }


    /*
    * Print product information in super class and append 
    */
    public void print()
    {
        super.print();
        System.out.print(" Shoe Name: " + shoe_name);
   }
}
