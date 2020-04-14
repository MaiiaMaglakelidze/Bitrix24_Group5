package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * It meant to be extended
 */
public abstract class AbstractBasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(tagName = "h1")
    protected WebElement pageLogo;

    @FindBy(tagName = "h2")
    protected WebElement pageSubtitle;

    public String getPageSubtitleText(){
        BrowserUtils.waitForPageToLoad(10);
        return pageSubtitle.getText();
    }

    public String getPageLogoText() {
        return pageLogo.getText();
    }

    public AbstractBasePage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Specify component name as a parameter, like: View all products or Orders
     * @param component
     */
    public void navigateTo(String component) {
        String locator = "//a[text()='" + component + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }
}
