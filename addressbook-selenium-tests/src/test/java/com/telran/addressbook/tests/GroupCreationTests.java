package com.telran.addressbook.tests;

import com.telran.addressbook.model.Group;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTests  extends TestBase{
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line!=null){
            String [] split=line.split(";");
            list.add(new Object[]{new Group()
                    .setGroupName(split[0])
                    .setGroupHeader(split[1])
                    .setGroupFooter(split[2])});
            line = reader.readLine();
        }

//        list.add(new Object[]{"test1", "header1", "footer1"});
//        list.add(new Object[]{"test22", "header22", "footer22"});
//        list.add(new Object[]{"t3", "h3", "f3"});
//        list.add(new Object[]{"", "", ""});
//        list.add(new Object[]{"test44444444444", "head444444444444444444", "footer4444444444444444444444"});
        return  list.iterator();
    }

    @Test (dataProvider="validGroups")
    public void testGroupCreation(Group group) throws InterruptedException {
        app.getGroupHelper().openGroupsPage();
        Thread.sleep(3000);
        int before = app.getGroupHelper().getGroupsCount();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
                //(new Group()
              //  .setGroupFooter(footer)
               // .setGroupHeader(header)
               // .setGroupName(name));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();

        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after,before+1);
    }

}
