package com.telran.addressbook.manager;

import com.telran.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    private SessionHelper sessionHelper;
    private  GroupHelper groupHelper;
    private NavigationHelper navigationHelper;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navigationHelper.openSite("http://localhost/addressbook");
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        navigationHelper=new NavigationHelper(wd);
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void stop() {
        wd.quit();
    }

    public void submitModification() {
        groupHelper.click(By.name("update"));
    }

    public void submitContactCreation() {
        groupHelper.click(By.name("submit"));
    }

    public void openContactPage() {

        groupHelper.click(By.cssSelector("a[href=\"edit.php\"]"));
    }

    public void fillContactForm(Contact contact) {
        groupHelper.type(By.name("firstname"), contact.getNameFirstName());
        groupHelper.type(By.name("lastname"), contact.getNameLastName());
        groupHelper.type(By.name("address"), contact.getNameAddress());
        groupHelper.type(By.name("home"), contact.getNameTelephone());
        groupHelper.type(By.name("email"), contact.getNameEmail());

    }

    public void deleteContact() {
        groupHelper.click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        groupHelper.click(By.name("selected[]"));
    }

    public void updateContact() {
        groupHelper.click(By.name("update"));
    }

    public void selectContactForModify() {
        groupHelper.click(By.cssSelector("img[src=\"icons/pencil.png\"]"));
    }

    public boolean isGContactPresent() {
        return groupHelper.isElementPresent(By.name("selected[]"));
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

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
