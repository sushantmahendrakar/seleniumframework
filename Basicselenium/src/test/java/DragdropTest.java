import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.bs.base.BaseClass;
import com.bs.pageobjects.DragandDrop;

public class DragdropTest extends BaseClass   {
	
	// DragandDrop dp=new DragandDrop();
	@Test
	public void drag() {
		ExtentReports extent = new ExtentReports();
		 ExtentTest logger=extent.createTest("LoginTest");
		DragandDrop dp = new DragandDrop();
		dp.dragdrop();
	}
	
	@BeforeMethod()
	public void launched() {
		launch();
	}
	

}
