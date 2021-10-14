package com.autotrader.steps;

import com.autotrader.pages.AdvenceSearchPage;
import com.autotrader.pages.AutotraderPage;
import com.autotrader.pages.Base;
import com.autotrader.utilities.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class AutotreaderSteps {
  AutotraderPage autotraderPage =new AutotraderPage();
  AdvenceSearchPage advenceSearchPage= new AdvenceSearchPage();


    @ Given ("user test with {string} browser")

    public void user_test_with_browser(String brs){
        if(brs.equals("chrome")){
            //ConfigurationReader.getProperty("browser");
            System.setProperty("browser","chrome");


        }else
            //ConfigurationReader.getProperty("browserfx");
            System.setProperty("browser","firefox");
    }
    @Given("user is in landing page")
    public void user_is_in_landing_page() {
        System.out.println("landing page");
        String actualTitle= MyDriver.get().getTitle();
        String expectedTitle="Used and New Car Sales, Review - Autotrader";

        try {Assert.assertEquals(actualTitle,expectedTitle);
        }catch (Exception e){
          System.out.println("title is wrong");
        }
    }

    @Then("Verify that {string} are present")
    public void verify_that_are_present(String expected) {
      autotraderPage.verification(expected);

    }

    @Then("Verify that search button is present")
    public void verify_that_search_button_is_present() {
      autotraderPage.searchButton();
    }

    @Then("Verify that {string} and {string} is visible")
    public void verify_that_and_is_visible(String make, String model) {
      autotraderPage.verifMakeAndModel(make,model);
    }
//second scenerio started 
    @Given("User click Advance link on  the home page")
    public void user_click_Advance_link_on_the_home_page() {
      Base.clearCookiees();
      advenceSearchPage.advanceSearchClick();
      Base.wait2();
    }

    @Then("User enter {string} in the zip code text box")
    public void user_enter_in_the_zip_code_text_box(String zipcode) {
     advenceSearchPage.zipCode(zipcode);
    }

    @Then("User select {string} check box under {string}")
    public void user_select_check_box_under(String string, String string2) {
advenceSearchPage.verifyclickCertifiedAndConvertible(string);
    }

    @Then("User update year {string} to {string}")
    public void user_update_year_to(String from, String to) {
        advenceSearchPage.startDateAndEndDate(from,to);

    }

    @Then("User select {string} car from Make, Model and Trim")
    public void user_select_car_from_Make_Model_and_Trim(String vehicle) {
advenceSearchPage.selectVehicle(vehicle);
    }

    @Then("User clicks Search Button")
    public void user_clicks_Search_Button() {

        advenceSearchPage.clickSeachButton();
        Base.wait2();
    }

    @Then("User verify that he is in result page")
    public void user_verify_that_he_is_in_result_page() {
        advenceSearchPage.VerifyUsersInPage();
    }

    @Then("User verify that he sees only {string} cars in listing")
    public void user_verify_that_he_sees_only_cars_in_listing(String car) {
        advenceSearchPage.VerifyThereIsOnlySelectedVehicle(car);
    }

    @Then("Display in console, the number of cars")
    public void display_in_console_the_number_of_cars() {
        advenceSearchPage.verifyNumberOfBMW();
    }
    @Given("choose make as {string}")
    public void choose_make_as(String make) {

        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        autotraderPage.multiplechoice(make);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
