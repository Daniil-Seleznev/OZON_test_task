import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;


public class ButtonsTests extends AbstractTest {

    @Test
    void travelHomePage() {
        natigateToButtonsPage();
        WebElement homePage = getDriver().findElement(By.id("home"));
        homePage.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("home.html"));
    }

    @Test
    void getButtonLocation() {
        natigateToButtonsPage();
        WebElement buttonLocation = getDriver().findElement(By.id("position"));
        int x = buttonLocation.getLocation().getX();
        int y = buttonLocation.getLocation().getY();
        System.out.println("X coordinate of the button is " + x);
        System.out.println("Y coordinate of the button is " + y);
        //Assertions.assertEquals(x, 8);
        //Assertions.assertEquals(y, 286);
    }

    @Test
    void getColour() {
        natigateToButtonsPage();
        WebElement colour = getDriver().findElement(By.id("color"));
        //Assertions.assertEquals(colour.getCssValue("background-color"), "rgba(144, 238, 144, 1)");
        System.out.println("Background-color of the button is " + colour.getAttribute("style"));
        Assertions.assertTrue(colour.getAttribute("style").contains("lightgreen"));
    }

    @Test
    void getSize() {
        natigateToButtonsPage();
        WebElement size = getDriver().findElement(By.id("size"));
        int buttonWidth = size.getSize().getWidth();
        int buttonHeight = size.getSize().getHeight();
        System.out.println("The button's width is "+ buttonWidth+" pixels");
        System.out.println("The button's hight is "+ buttonHeight+" pixels");
        //Assertions.assertEquals(buttonWidth, 117);
        //Assertions.assertEquals(buttonHeight, 22);
    }
}