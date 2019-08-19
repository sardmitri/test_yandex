package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.mainPage;

@Test()
public class test {
    @DataProvider(name = "cities")
    public Object[][] cities() {
        return new Object[][]{{""}, {" Липецк"}, {" Лото"}};
    }

    @Test(dataProvider = "cities")
    public void testDefaultLoc(String city) {
        mainPage page = new mainPage();
        Assert.assertTrue(page.isOpen());
        page.typeToInput("погода" + city);
        Assert.assertTrue(page.isFastAnswer());
        String temp = page.getFastAnswer();
        System.out.println(temp);
        Assert.assertTrue(temp.contains("°"));
    }

    @AfterMethod
    public void close() {
        mainPage.close();
    }
}
