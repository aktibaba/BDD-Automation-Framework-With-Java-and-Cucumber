package com.autotrader.pages;

import com.autotrader.utilities.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvenceSearchPage extends Base {
    /**
     * Locators
     */
    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement clickAdvanceSearch;

    @FindBy(xpath = "//input[contains(@type,'tel')]")
    public WebElement enterZipCode;

    @FindBy(xpath = "//div[contains(text(),'Certified')]")
    public WebElement selectCertified;

    @FindBy(xpath = "//div[contains(text(),'Convertible')]")
    public WebElement selectConvertible;

    @FindBy(xpath = "//select[contains(@name,'startYear')]")
    public WebElement selectFrom;

    @FindBy(xpath = "//select[contains(@name,'endYear')]")
    public WebElement selectTo;

    @FindBy(xpath = "//select[contains(@name,'makeFilter0')]")
    public WebElement selectBMW;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block ae-button']")
    public WebElement clickSearchButton;

    @FindBy(xpath = "//title[contains(text(),'Certified BMW Convertibles for Sale')]")
    public WebElement userInPage;

    @FindBy(xpath = "//h2[contains(@data-cmp,'subheading')]")
    public WebElement onlyBMW;

    @FindBy(xpath = "//div[contains(@data-cmp,'inventoryListing')]")
    public WebElement numberOfBMW;


public void advanceSearchClick(){

    MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try{
        clickAdvanceSearch.click();
        Thread.sleep(2000);
    }catch (InterruptedException e){
        e.printStackTrace();

    }
}
public void zipCode(String zip){

    MyDriver.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    enterZipCode.sendKeys("3004");
}
public void verifyclickCertifiedAndConvertible(String a){

    if(a.equalsIgnoreCase(selectCertified.getText())){
        selectCertified.click();
    }else
    {
WebElement link=selectConvertible;
   scrollDown(link);
selectConvertible.click();
    }

}
public void startDateAndEndDate(String from,String to){
    MyDriver.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    Select select = new Select(selectFrom);
     select.selectByValue(from);
    Select select1= new Select(selectTo);
    select1.selectByValue(to);
    Base.wait2();
}
public void selectVehicle(String vehicle){
    Select select= new Select(selectBMW);
    select.selectByValue(vehicle);
}
public void clickSeachButton(){
    WebElement link=clickSearchButton;
    scrollDown(link );
    clickSearchButton.click();
}

//Verifying the title that we are in result page.
public void VerifyUsersInPage() {

        userInPage.getText();
    }

    //Verifying that in result page there is no other car results come.
    public void VerifyThereIsOnlySelectedVehicle(String car) {
        //Storing all the results in List and comparing all the results not contains BMW
        List<WebElement> list = MyDriver.get().findElements(By.xpath("//h2[contains(@data-cmp,'subheading')]"));
        int count = 0;
        int NonBMWcount=0;
        for (WebElement each : list) {
            if (!each.getText().contains(car)) {
                System.out.println("We found non BMW listing " + NonBMWcount);
            }
            count++;
        }
        System.out.println("We found " + count + " BMW listing and There is no non BMW listing");
    }


    //Counting how many listing result displayed.
    public void verifyNumberOfBMW() {

        List<WebElement> list = MyDriver.get().findElements(By.xpath("//div[contains(@data-cmp,'inventoryListing')]"));

        System.out.println("Number of BMW listed in result page is :" + list.size());

        int actual = list.size();
        String expected = MyDriver.get().findElement(By.xpath("//div[@class='results-text-container text-size-200']")).getText();
        System.out.println(expected);

        String[] arr = expected.split(" ");
        //System.out.println(arr[2]);
        int expectedResult = Integer.parseInt(arr[2]);
        Assert.assertEquals("Assertion failed", expectedResult, actual);
    }


}
