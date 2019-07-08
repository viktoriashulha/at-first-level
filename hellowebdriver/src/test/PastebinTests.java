import com.epam.at.shulha.pages.Pastebin;
import model.Paste;
import org.junit.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class PastebinTests {

    private WebDriver driver;

    @Before
    public  void openChrome() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void createHello() {
        Paste originalPaste = new Paste();
        originalPaste.setCode("Hello from WebDriver");
        originalPaste.setName("helloweb");
        Pastebin pastebin = new Pastebin(driver)
                .openPage()
                .createPasteHelloWeb(originalPaste);
        Paste actualPaste = pastebin.readPasteHelloWeb();

        Assert.assertEquals(originalPaste, actualPaste);
    }

    @Test
    public void createGain() {
        Paste originalPaste = new Paste();
        originalPaste.setCode("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        originalPaste.setName("how to gain dominance among developers");
        Pastebin pastebin = new Pastebin(driver)
                .openPage()
                .createPasteHowToGain(originalPaste);
        Paste actualPaste = pastebin.readPasteHowToGain();

        Assert.assertEquals(originalPaste, actualPaste);
    }
}





