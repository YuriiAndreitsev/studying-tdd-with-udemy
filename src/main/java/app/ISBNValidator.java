package app;

public class ISBNValidator {
    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;
    public static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String isbn) {
        int total = 0;
        if (isbn.length() == LONG_ISBN_LENGTH) {
            return isThisAValidLongISBN(isbn, total);
        } else if (isbn.length() == SHORT_ISBN_LENGTH) {
            return (isThisAValidShortISBN(isbn, total));
        }
        throw new NumberFormatException("ISBN number is not 10 or 13 digits");
    }

    private boolean isThisAValidShortISBN(String isbn, int total) {
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN number should contain only digits");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
            }
        }
        System.out.println("TOTAL for 10 digit isbn : " + total);
        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean isThisAValidLongISBN(String isbn, int total) {
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        System.out.println("Total for 13 digit isbn: " + total);
        return total % LONG_ISBN_MULTIPLIER == 0;
    }
}
