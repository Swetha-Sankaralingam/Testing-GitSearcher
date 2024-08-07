import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitSearcher {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://git-searcher-black.vercel.app/");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/input")).sendKeys("Swetha-Sankaralingam");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/button")).click();
		Thread.sleep(3000); // Temporarily using sleep for demo purposes

        // Locate the first course element
        WebElement courseElement = driver.findElement(By.xpath("//*[@id=\"repo\"]/ul/li[2]/p[4]/a"));

        // Use JavaScript Executor to click the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", courseElement);
        String url=driver.getCurrentUrl();
		System.out.println("URL of my Calculator "+url);
		String Projectname=driver.findElement(By.xpath("//*[@id=\"repo\"]/ul/li[2]/h3")).getText();
		System.out.println("Name of the Project : "+Projectname);
		driver.navigate().forward();
		Thread.sleep(4000);
        WebElement protfolio = driver.findElement(By.xpath("//*[@id=\"repo\"]/ul/li[5]/p[4]/a"));
        JavascriptExecutor js1=(JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click()", protfolio);
		String url1=driver.getCurrentUrl();
		System.out.println("URL of my Portfoilo page "+url1);
		String Projectname1=driver.findElement(By.xpath("//*[@id=\"repo\"]/ul/li[5]/h3")).getText();
		System.out.println("Name of the Project : "+Projectname1);
		Thread.sleep(3000);
		driver.quit();
	}

}
