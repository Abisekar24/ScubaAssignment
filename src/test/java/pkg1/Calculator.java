package pkg1;

import java.lang.Math;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test; 

public class Calculator {
	
	@DataProvider(name="inputs")		//dataProviders has been implemented
	public Object[][] getData() {
		return new Object[][] {
			{"Abi"},
		};
	}
	
	@BeforeTest(groups = "Important")		//annotations has been implemented
	public void intro(){
		Reporter.log("TestNG_ReportsAndLogs -> This runs once before class", true);		//ReportsAndLogs has been implemented
	}
	
	@AfterTest(groups = "Important")		//annotations has been implemented
	public void end(){
		Reporter.log("TestNG_ReportsAndLogs -> This runs once after class", true);		//ReportsAndLogs has been implemented
	}
	
	@Test(dataProvider="inputs",groups = {"Important"})		//dataProviders has been implemented
	public void welcome(String name) {
		System.out.println("Welcome" + " " +name);
		Assert.assertTrue(name.equals("Abi"), "AssertTrue passed");				//assertTrue has been implemented
		System.out.println("This line is executed as assertTrue is passed");
	}
	
	@Test(groups = {"Important"})
	@Parameters({"number1","number2","expected"})
	public static void add(int number1, int number2, int expected) {
	   int actual = number1 + number2;
	   try 									
	   {
		   Assert.assertEquals(actual, expected);		//assertequals has been implemented
		   System.out.println("Expected result is met");
	   } 
	   catch (Throwable e) {
		   System.out.println("Expected result is not met");
	   }
   }
	
   @Test(groups = {"Important"})			//groups has been implemented
   @Parameters({"number1","number2"})
   public static int sub(int number1, int number2) {
	  int a = number1 - number2;
      //System.out.println("sub val is" +a);
	  return a;
   }
 
   @Test(groups = {"Important"})
   @Parameters({"number1","number2"})						//parameters has been implemented
   public static int mul(int number1, int number2) {
     int mulVal = number1 * number2;
     System.out.println("the result is:" +mulVal);
     return mulVal;
   }
   
   @Test(groups = {"Division"})
   @Parameters({"number1","number2"})
   public static int divInt(int number1, int number2) {
		Assert.assertFalse(number2==0, "AssertFalse passed");					//assertFalse has been implemented
		System.out.println("This line is executed as assertFalse is passed");
		return number1 / number2;
   }
 
   @Test(groups = {"Division"})
   @Parameters({"number1","number2"})
   public static double divReal(int number1, int number2) {
      if (number2 == 0) {
         throw new IllegalArgumentException("Cannot divide by 0!");
      }
      return (double) number1 / number2;
   }
   
   // Exponent
   @Test
   @Parameters({"number1","number2"})
   public static double exp(double number1, double number2) {
	   Assert.assertNotEquals(number1, 0);								//assertNotEquals has been implemented
	   System.out.println("assertNotEquals is passed i.e., number1 is not 0");
       return Math.pow(number1, number2);
   }
   
   // Modulus
   @Test
   @Parameters({"number1","number2"})
   public static int mod(int number1, int number2) {
	   Assert.assertNotNull(number2);								//assertNotNull has been implemented
	   System.out.println("assertNotNull is passed i.e., number1 is not null");
	   if (number2 == 0) {
         throw new IllegalArgumentException("Cannot divide by 0!");
      }
      return number1%number2;
   }
       
     
   // Inverse
   @Test
   @Parameters("number1")
   public static double inverse(int number1) {
      if (number1 == 0) {
         throw new IllegalArgumentException("Cannot divide by 0!");
      }
      return (double) 1 / number1;
   }
         
   
   // Negate
   @Test
   @Parameters({"number1","expected"})
   public static int negate(int number1, int expected) {
      if (number1 == 0) {
         throw new IllegalArgumentException("Cannot divide by 0!");
      }
      return (-1) * number1;
      
   }   

}