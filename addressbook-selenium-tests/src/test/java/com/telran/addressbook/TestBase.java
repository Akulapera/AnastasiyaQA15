package com.telran.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeClass

    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        login("admin", "secret");
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        wd.findElement(By.cssSelector("[type='submit']")).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void returnToGroupPage() {
        wd.findElement(By.cssSelector("i [href=\"group.php\"]")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void openGroupsPage() {
        wd.findElement(By.cssSelector("[href=\"group.php\"]")).click();
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public void submitModification() {
        wd.findElement(By.name("update")).click();
    }

    public void initGroupModification() {
        wd.findElement(By.cssSelector("[name=edit]:last-child")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void deleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void openContactPage() {

        wd.findElement(By.cssSelector("a[href=\"edit.php\"]")).click();
    }

    public void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.getNameFirstName());
        type(By.name("lastname"), contact.getNameLastName());
        type(By.name("address"), contact.getNameAddress());
        type(By.name("home"), contact.getNameTelephone());
        type(By.name("email"), contact.getNameEmail());

    }

    public void deleteContact() {
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void updateContact() {
        wd.findElement(By.name("update")).click();
    }

    public void selectContactForModify() {
        wd.findElement(By.cssSelector("img[src=\"icons/pencil.png\"]")).click();
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
}
