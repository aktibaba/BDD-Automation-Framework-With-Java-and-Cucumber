package com.autotrader.pages;

import com.autotrader.utilities.MyDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Base {

    public Base (){

        PageFactory.initElements(MyDriver.get(), this);
    }

    /**
     * Web site was not allowing the automation browser
     * And I saw that browser was doing it with cookies and
     * I cleaned the cookies every page navigation to make sure
     * my automation works.
     */
    public static void clearCookiees() {

        // Set<Cookie> a = MyDriver.get().manage().getCookies();
        //System.out.println(a);
        //Delete all the cookies
        MyDriver.get().manage().deleteAllCookies();

    }

    public void scrollDown(WebElement link) {


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor js = (JavascriptExecutor) MyDriver.get();
        /**
         *  this script must scroll, until link element is visible
         *  once link element visible, it will stop scrolling
         *  arguments[0] = means first webelement after comma (link)
         *  arguments it's an array of webelements after comma
         *  arguments[0] = link web element, it can be any web element
         */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void wait2(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}