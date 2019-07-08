import com.epam.at.shulha.pages.GoogleCloud;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import model.Calculator;
import java.util.concurrent.TimeUnit;


public class GoogleCloudTests {
    private WebDriver driver;

    @Before
    public void openChrome() {

        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void createCalculating() {
        Calculator expectedCalculator = new Calculator();
        GoogleCloud googleCloud = new GoogleCloud(driver)
                .openPage()
                .goToCalculator()
                .createEstimate();
        Calculator actualCalculator = googleCloud.readEstimate();
        Assert.assertEquals(expectedCalculator, actualCalculator);
    }

    @Test
    public void createCalculatingWithEmail() {
        Calculator expectedCalculator = new Calculator();
        GoogleCloud googleCloud = new GoogleCloud(driver)
                .openPage()
                .goToCalculator()
                .createEstimate()
                .createEmailEstimate();

        Calculator actualCalculator = googleCloud.readEmailEstimate();
        Assert.assertEquals(expectedCalculator, actualCalculator);
    }
}
