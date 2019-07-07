package com.epam.at.shulha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import model.Calculator;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GoogleCloud extends AbstractPage {

    private final String CLOUD_GOOGLE_URL = "https://cloud.google.com/";
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@track-name='pricing']")
    private WebElement pricing;

    @FindBy(xpath = "//a[@track-metadata-eventdetail='calculators']")
    private WebElement priceCalculator;

    @FindBy(xpath = "(//input[@aria-label='quantity'])[1]")
    private WebElement instanses;

    @FindBy(xpath = "//md-select[@id='select_75']")
    private WebElement mashineType;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement instanceTypeN1Standart8;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGups;

    @FindBy(xpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")///
    private WebElement numberOfGupsOne;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']/md-select-value")
    private WebElement typeOfGups;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPU;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//span[1]")
    private WebElement localSSD;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedSsd' and @value='2']/div[@class='md-text ng-binding']")
    private WebElement localSSD375Gb;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_50']")
    private WebElement location;

    @FindBy(xpath = "//md-option[@id='select_option_181' and @value='europe-west3']")
    private WebElement locationFrankfurt;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_50']")
    private WebElement commitedUsageClick;

    @FindBy(xpath = "//md-option[@id='select_option_82']//div[text()='1 Year']")
    private WebElement commitedUsage;

    @FindBy(xpath = "(//button[text()='Add to Estimate'])[1]")
    private WebElement addToEstimate;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimate;

    @FindBy(xpath = "//input[@id='mailAddress']")
    private WebElement emailAddress;

    @FindBy(xpath = ".//input[@id='input_361']")
    private WebElement emailClick;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmail;

    @FindBy(xpath = ".//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement openEmail;

    public GoogleCloud(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloud goToCalculator() {
        pricing.click();
        priceCalculator.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='idIframe']")));
        driver.switchTo().frame("idIframe");

        return new GoogleCloud(driver);
    }

    public GoogleCloud createEstimate() {

        instanses.sendKeys("4");
        mashineType.click();
        instanceTypeN1Standart8.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        addGPU.click();
        numberOfGups.click();
        numberOfGupsOne.click();
        typeOfGups.click();
        gpuType.click();
        wait.until(ExpectedConditions.visibilityOf(localSSD));
        localSSD.click();
        wait.until(ExpectedConditions.visibilityOf(localSSD375Gb));
        localSSD375Gb.click();
        wait.until(ExpectedConditions.visibilityOf(location));

        location.click();
        wait.until(ExpectedConditions.visibilityOf(locationFrankfurt));
        locationFrankfurt.click();

        commitedUsageClick.click();
        wait.until(ExpectedConditions.visibilityOf(commitedUsage));
        commitedUsage.click();
        addToEstimate.click();

        return new GoogleCloud(driver);
    }

    public GoogleCloud createEmailEstimate() {
        driver.switchTo().window("https://10minutemail.net/");

        ArrayList<String> windowHandler = new ArrayList<String>(driver.getWindowHandles());
        String tabGoogle = windowHandler.get(0);
        String tabMinuteMail = windowHandler.get(1);

        driver.switchTo().window(tabMinuteMail);
        wait.until(ExpectedConditions.visibilityOf(emailAddress));

        String emailCopy = emailAddress.getAttribute("value");

        driver.switchTo().window(tabGoogle);

        driver.switchTo().frame("idIframe");
        emailClick.click();
        emailClick.sendKeys(emailCopy);

        sendEmail.click();

        driver.switchTo().window(tabMinuteMail);

        new WebDriverWait(driver, 400).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(".//a[text()='Google Cloud Platform Price Estimate']")));
        openEmail.click();

        return new GoogleCloud(driver);
    }

    public Calculator readEstimate() {
        Calculator calculator = new Calculator();

        calculator.setVMClass(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy']")).getAttribute("VM class: regular"));
        calculator.setInstanceType(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy'][2]")).getAttribute("Instance type: n1-standard-8"));
        calculator.setRegion(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy'][3]")).getAttribute("Region: Frankfurt"));
        calculator.setLocalSSD(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope'][2]")).getAttribute("Total available local SSD space 2x375 GB"));
        calculator.setCommitmentTerm(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope'][3]")).getAttribute("Commitment term: 1 Year"));
        calculator.setCost(driver.findElement(By.xpath("//md-list-item[@role='listitem']//div//b")).getAttribute("Estimated Component Cost"));
        return calculator;
    }


    public Calculator readEmailEstimate() {
        Calculator calculator = new Calculator();
        calculator.setEmail(driver.findElement(By.xpath("//*[@id='mobilepadding']/td/table/tbody/tr[1]/td[4]")).getAttribute("Total Estimated Monthly Cost"));
        return calculator;
    }

    public GoogleCloud openPage() {
        driver.navigate().to(CLOUD_GOOGLE_URL);
        return this;
    }
}
