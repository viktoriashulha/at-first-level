package com.epam.at.shulha.pages;

import model.Paste;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Pastebin extends AbstractPage {
    private final String PASTEBIN_URL = "https://pastebin.com";


    @FindBy(id = "paste_code")
    protected WebElement newPasteField;

    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[1]")
    protected WebElement dropSyntax;

    @FindBy(xpath = "//li[@class='select2-results__option' and text()='Bash']")
    protected WebElement bash;

    @FindBy(xpath = "//option[text()='10 Minutes']")
    protected WebElement pasteExpirationField;

    @FindBy(className = "post_input")
    protected WebElement pasteNameField;

    @FindBy(id = "submit")
    protected WebElement buttonSubmit;


    public Pastebin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Pastebin createPasteHelloWeb(Paste paste) {

        newPasteField.sendKeys(paste.getCode());
        pasteExpirationField.click();
        pasteNameField.sendKeys(paste.getName());
        buttonSubmit.click();
        return new Pastebin(driver);

    }

    public Pastebin createPasteHowToGain(Paste paste) {

        newPasteField.sendKeys(paste.getCode());
        pasteExpirationField.click();
        dropSyntax.click();
        bash.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pasteNameField.sendKeys(paste.getName());
        buttonSubmit.click();
        return new Pastebin(driver);

    }

    public Paste readPasteHelloWeb() {
        Paste paste = new Paste();
        WebElement pasteTitleElement = driver.findElement(By.xpath("//div[@class='paste_box_info']/div[@class='paste_box_line1']"));
        paste.setName(pasteTitleElement.getAttribute("title"));
        paste.setCode(driver.findElement(By.xpath("//textarea[@id='paste_code']")).getText());
        return paste;
    }

    public Paste readPasteHowToGain() {
        Paste paste = new Paste();
        WebElement pasteTitleElement = driver.findElement(By.xpath("//div[@class='paste_box_info']/div[@class='paste_box_line1']"));
        paste.setName(pasteTitleElement.getAttribute("title"));
        paste.setCode(driver.findElement(By.xpath("//textarea[@id='paste_code']")).getText());
        paste.setSyntaxHighlight(driver.findElement(By.xpath("//span[@class='h_640']//a[text()='Bash']")).getAttribute("Bash"));
        return paste;
    }


    public Pastebin openPage() {
        driver.navigate().to(PASTEBIN_URL);
        return this;
    }


}
