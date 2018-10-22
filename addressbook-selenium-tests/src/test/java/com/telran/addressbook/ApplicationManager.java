package com.telran.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        login("admin", "secret");
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("[type='submit']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void returnToGroupPage() {
        click(By.cssSelector("i [href=\"group.php\"]"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void openGroupsPage() {
        click(By.cssSelector("[href=\"group.php\"]"));
    }

    public void stop() {
        wd.quit();
    }

    public void submitModification() {
        click(By.name("update"));
    }

    public void initGroupModification() {
        click(By.cssSelector("[name=edit]:last-child"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void openContactPage() {

        click(By.cssSelector("a[href=\"edit.php\"]"));
    }

    public void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.getNameFirstName());
        type(By.name("lastname"), contact.getNameLastName());
        type(By.name("address"), contact.getNameAddress());
        type(By.name("home"), contact.getNameTelephone());
        type(By.name("email"), contact.getNameEmail());

    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void selectContactForModify() {
        click(By.cssSelector("img[src=\"icons/pencil.png\"]"));
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    protected void createCroup() {
        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupFooter("ttt")
                .setGroupHeader("iiii")
                .setGroupName("uuuu"));
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isGContactPresent() {
        return isElementPresent(By.name("selected[]"));
        // name("selected[]"));
    }

    public void createContact() {
        openContactPage();
        fillContactForm(new Contact()
                .setNameLastName("Max")
                .setNameEmail("ouy@com")
                .setNameFirstName("Ivaniv")
                .setNameTelephone("415436")
                .setNameAddress("Tel Aviv"));
        submitContactCreation();
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
}
