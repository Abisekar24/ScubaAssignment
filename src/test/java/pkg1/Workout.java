package pkg1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Workout {

	@DataProvider(name="inputs")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };
    }

	  @Test(dataProvider="inputs") 
	  public void testMethod1(String input1, String input2) 
	  { 
		 // System.out.println(input1 + input2);
		  
	  System.out.println("Input 1: " +input1); 
	  System.out.println("Input 2: " +input2);
	}
}