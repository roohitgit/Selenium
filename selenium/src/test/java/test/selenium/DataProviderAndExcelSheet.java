package test.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.HerokuAppPageObject;
import utilities.BaseClass;
import utilities.ReadExcel;

@Test
public class DataProviderAndExcelSheet extends BaseClass {

	 @Test(dataProvider = "dataProvider",enabled=false)
	    public void dataProviderAndExcelSheet(String userName, String passWord) {
	        HerokuAppPageObject p = new HerokuAppPageObject(driver);
	        p.clickOnFormAuthentication();
	        p.username.sendKeys(userName);
	        p.password.sendKeys(passWord);
	        p.clickOnLogin();
	        test.log(Status.INFO, "user and pws - " + userName+" "+passWord);
	        test.log(Status.INFO, "Message - " + p.getMessageOnFormAuthentication());
	    }

	    @DataProvider
	    public Object[][] dataProvider() {
	        ReadExcel re = new ReadExcel();
	        int rowCount = re.getRowCount("Sheet1");
	        Object[][] data = new Object[rowCount-1][2]; // Adjusting for 0-based index

	        for (int i = 1; i < rowCount; i++) {  // Assuming row 1 has the headers
	            data[i-1][0] = re.getCellData("Sheet1", i, 0); // Username
	            data[i-1][1] = re.getCellData("Sheet1", i, 1); // Password
	        }
	        return data;
	    }
	    
	    
	    
	    @Test
	    public void readDataFromPropertyFile() throws IOException
	    {
	    	String propFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\PropertyFile.txt";
	    	Properties properties = new Properties();
	    	FileInputStream file = new FileInputStream(propFilePath);
	    	properties.load(file);
	    	test.log(Status.INFO, "url from prop is- "+properties.getProperty("url"));
	    	test.log(Status.INFO, "browser from prop is- "+properties.getProperty("browser"));
	    	test.log(Status.INFO, "input from prop is- "+properties.getProperty("input"));

	    }
	    
	    
	    
	    
	    
	    

}
