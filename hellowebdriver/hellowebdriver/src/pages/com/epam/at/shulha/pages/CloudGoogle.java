package com.epam.at.shulha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import model.Calculator;

import java.util.concurrent.TimeUnit;

public class CloudGoogle extends AbstractPage {

    private final String CLOUD_GOOGLE_URL = "https://cloud.google.com/";
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@track-name='pricing']")
    protected WebElement pricing;

    @FindBy(xpath = "//a[@track-metadata-eventdetail='calculators']")
    protected WebElement priceCalculator;

    @FindBy(xpath = "(//input[@aria-label='quantity'])[1]")
    protected WebElement instanses;

    @FindBy(xpath = "//md-select[@id='select_75']")
    protected WebElement mashineType;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    protected WebElement instanceTypeN1Standart8;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    protected WebElement numberOfGups;

    @FindBy(xpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")///
    protected WebElement numberOfGupsOne;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']/md-select-value")
    protected WebElement typeOfGups;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    protected WebElement gpuType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    protected WebElement addGPU;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//span[1]")
    protected WebElement localSSD;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedSsd' and @value='2']/div[@class='md-text ng-binding']")
    protected WebElement localSSD375Gb;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_50']")
    protected WebElement location;

    @FindBy(xpath = "//md-option[@id='select_option_181' and @value='europe-west3']")
    protected WebElement locationFrankfurt;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_50']")
    protected WebElement commitedUsageClick;

    @FindBy(xpath = "//md-option[@id='select_option_82']//div[text()='1 Year']")
    protected WebElement commitedUsage;

    @FindBy(xpath = "(//button[text()='Add to Estimate'])[1]")
    protected WebElement addToEstimate;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    protected WebElement emailEstimate;

    @FindBy(xpath = ".//input[@id='input_369']")
    protected WebElement email;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    protected WebElement sendEmail;

    @FindBy(xpath = ".//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement openEmail;

    public CloudGoogle(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    public CloudGoogle goToCalculator() {
        pricing.click();
        priceCalculator.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='idIframe']")));
        driver.switchTo().frame("idIframe");

        return new CloudGoogle(driver);
    }

    public CloudGoogle createEstimate() {

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

//        commitedUsageClick.click();
//        wait.until(ExpectedConditions.visibilityOf(commitedUsage));
//        commitedUsage.click();
        addToEstimate.click();

        return new CloudGoogle(driver);
    }

    public CloudGoogle emailEstimate(Calculator calculator){
        emailEstimate.click();
        email.sendKeys(calculator.getEmail());
        sendEmail.click();

        return new CloudGoogle(driver);
    }

    public Calculator readEstimate() {
        Calculator calculator = new Calculator();

      //  calculator.setVMClass(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope'][1]")).getAttribute("VM class: regular"));
        calculator.setInstanceType(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy'][2]")).getAttribute("Instance type: n1-standard-8"));
        calculator.setRegion(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy'][3]")).getAttribute("Region: Frankfurt"));
        calculator.setLocalSSD(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope'][2]")).getAttribute("Total available local SSD space 2x375 GB"));
        calculator.setCommitmentTerm(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope'][3]")).getAttribute("Commitment term: 1 Year"));
        return calculator;
    }

    public Calculator readEstimateWithEmail(){
        Calculator calculator = new Calculator();

        return calculator;
    }

    public CloudGoogle openPage() {
        driver.navigate().to(CLOUD_GOOGLE_URL);
        return this;
    }
}
