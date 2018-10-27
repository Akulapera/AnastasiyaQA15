package com.telran.addressbook.manager;

import com.telran.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{
    public WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
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
