package app;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AppTest {
    @Test
    public void checkValid10DigitISBN() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("0140449116");
        Assertions.assertTrue(result);
        result = validator.checkISBN("0140177396");
        Assertions.assertTrue(result);
    }

    @Test
    public void checkAValid13DigitISBN() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("9781853260087");
        Assertions.assertTrue(result);

        result = validator.checkISBN("9781853267338");
        Assertions.assertTrue(result);

        result = validator.checkISBN("9781853267338");
        Assertions.assertTrue(result);
    }

    @Test
    public void tenDigitISBNNumberEndsWithXValid() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("012000030X");
        Assertions.assertTrue(result);
    }

    @Test
    public void checkInvalid10DigitISBN() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("0140449117");
        Assertions.assertFalse(result);
    }

    @Test (expected = NumberFormatException.class)
    public void checkInvalid13DigitISBN() {
        ISBNValidator validator = new ISBNValidator();
        boolean result = validator.checkISBN("978185326733");
        Assertions.assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNnotAllowed() {
        ISBNValidator validator = new ISBNValidator();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void ifISBNcontainsNonDigits() {
        ISBNValidator validator = new ISBNValidator();
        validator.checkISBN("Hello World");
    }
}
