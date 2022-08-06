import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class FieldsTests extends AbstractTest {

    @Test
    void enterEmail() {
        natigateToFieldsPage();
        WebElement emailField = getDriver().findElement(By.id("email"));
        emailField.sendKeys("test@mail.ru");
        Assertions.assertEquals(emailField.getAttribute("value"), "test@mail.ru");
    }

    @Test
    void appendText() {
        natigateToFieldsPage();
        WebElement appendField = getDriver().findElement(By.xpath("//input[contains(@value, 'Append')]"));
        appendField.sendKeys("test");
        appendField.sendKeys(Keys.TAB);
        Assertions.assertEquals(appendField.getAttribute("value"), "Append test");
    }

    @Test
    void enterDefaultText() {
        natigateToFieldsPage();
        WebElement defaultTextField = getDriver().findElement(By.xpath("//input[contains(@value, 'TestLeaf')]"));
        System.out.println("Text is " + defaultTextField.getAttribute("value"));
        Assertions.assertEquals(defaultTextField.getAttribute("value"), "TestLeaf");
    }

    @Test
    void clearField() {
        natigateToFieldsPage();
        WebElement clearField = getDriver().findElement(By.xpath("//input[contains(@value, 'Clear me!!')]"));
        clearField.clear();
        Assertions.assertEquals(clearField.getAttribute("value"), "");
    }

    @Test
    void isDisabled() {
        natigateToFieldsPage();
        WebElement isDisabledField = getDriver().findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input"));
        Assertions.assertFalse(isDisabledField.isEnabled());
    }
}