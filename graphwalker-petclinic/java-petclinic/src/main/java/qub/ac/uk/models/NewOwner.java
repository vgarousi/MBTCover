package qub.ac.uk.models;

import qub.ac.uk.NewOwnerSharedState;
import qub.ac.uk.helper.Helper;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.apache.commons.lang3.RandomStringUtils;

@GraphWalker(value = "random(edge_coverage(100))")
public class NewOwner extends ExecutionContext implements NewOwnerSharedState {

    @Override
    public void v_OwnerInformation() {
        Helper.getWaiter().until(ExpectedConditions.textToBe(By.tagName("h2"), "Owner Information"));
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/table[last()]/tbody/tr/td[2]/img")));
    }

    @Override
    public void e_CorrectData() {
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("firstName"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")))
            .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("lastName")))
            .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("address"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("address")))
            .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("city"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("city")))
            .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("telephone"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("telephone")))
            .sendKeys(RandomStringUtils.randomNumeric(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type=\"submit\"]"))).click();
    }

    @Override
    public void e_IncorrectData() {
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("firstName"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")))
            .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("lastName")))
            .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("address"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("address")))
            .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("city"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("city")))
            .sendKeys(RandomStringUtils.randomAlphabetic(Helper.getRandomInt(10)));

        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("telephone"))).clear();
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("telephone"))).sendKeys(RandomStringUtils.randomNumeric(20));

        Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type=\"submit\"]"))).click();
    }

    @Override
    public void v_IncorrectData() {
        Helper.getWaiter().until(ExpectedConditions.textToBe(By.tagName("h2"), "New Owner"));
        Helper.getWaiter().until(ExpectedConditions.textToBe(By.cssSelector("div.control-group.error > div.controls > span.help-inline"),
                                                             "numeric value out of bounds (<10 digits>.<0 digits> expected)"));
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td[2]/img")));
    }

    @Override
    public void v_NewOwner() {
        Helper.getWaiter().until(ExpectedConditions.textToBe(By.tagName("h2"), "New Owner"));
        Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td[2]/img")));
    }

    @BeforeElement
    public void printBeforeElement() {
        System.out.println("Before element " + getCurrentElement().getName());
        Helper.pause(250);
    }

    @AfterElement
    public void printAfterElement() {
        System.out.println("After element " + getCurrentElement().getName());
        Helper.pause(250);
    }

}
