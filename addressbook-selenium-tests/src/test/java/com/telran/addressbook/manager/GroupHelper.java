package com.telran.addressbook.manager;

import com.telran.addressbook.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.cssSelector("i [href=\"group.php\"]"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
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

    public void initGroupModification() {
        click(By.cssSelector("[name=edit]:last-child"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
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

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
