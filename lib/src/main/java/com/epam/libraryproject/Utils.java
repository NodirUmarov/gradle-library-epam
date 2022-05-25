package com.epam.libraryproject;

import static org.apache.commons.lang3.StringUtils.*;

/**
 * <p>Operations on {@link java.lang.CharSequence} that are in numeric format.
 * The purpose of this class is to check whether number is positive or not</p>
 *
 * <ul>

 *  <li><b>IsPositive</b>
 *      - checks whether charSequence contains positive numeric format in null-safe manner</li>
 *  <li><b>IsPositive</b>
 *      - checks whether charSequence contains positive numeric format</li>
 * </ul>
 *
 * <p>The {@code Utils} class defines certain words related to
 * String handling.</p>
 *
 * <ul>
 *  <li>null - {@code null}</li>
 *  <li>empty - a zero-length string ({@code ""})</li>
 *  <li>blank - non-zero length string containing only whitespace {@link Character#isWhitespace(char)}</li>
 * </ul>
 *
 * <p>Methods in this class include sample code in their Javadoc comments to explain their operation.</p>
 *
 * @see org.apache.commons.lang3.StringUtils
 * @version 1.3.5
 * @since 1.3.5
 */
public final class Utils {

    /**
     * To prevent instantiating this class. All methods are static and should be accessed via class.
     */
    private Utils() {}

    /**
     * <p>Checks if the String contains a positive number.
     * A decimal point is not a Unicode digit and returns false.</p>
     * <ul>
     * <li> If the argument is {@code null}, empty (length()=0) or
     * contains {@code -} sign as first character, will return {@code false}.</li>
     * <li> If the argument contains {@code +} sign as first character or
     * just number itself, will return {@code true}.</li>
     * </ul>
     * <pre>
     * Utils.isPositive(null)     = false
     * Utils.isPositive("")       = false
     * Utils.isPositive("  ")     = false
     * Utils.isPositive("123")    = true
     * Utils.isPositive("-123")   = false
     * Utils.isPositive("12 3")   = true
     * Utils.isPositive("-12 3")  = false
     * Utils.isPositive("ab2c")   = false
     * Utils.isPositive("12-3")   = false
     * Utils.isPositive("12.3")   = false
     * </pre>
     *
     * @param number the String to check, may be null
     * @return {@code true} if number does not contain {@code -} sign,
     * and is non-null
     * @since 1.3.5
     */
    public static boolean isPositive(CharSequence number) {
        if (isAllBlank(number) || !isNumericSpace(number)) return false;
        return number.charAt(0) != '-';
    }

    /**
     * <p>Checks if the String contains a positive number.
     * A decimal point is not a Unicode digit and returns false.</p>
     * <ul>
     * <li> If the argument is {@code null}, empty (length()=0) or
     * contains {@code -} sign as first character, will return {@code false}.</li>
     * <li> If the argument contains {@code +} sign as first character or
     * just number itself, will return {@code true}.</li>
     * </ul>
     * <pre>
     * Utils.checkPositive(null)   = false
     * Utils.checkPositive("")     = false
     * Utils.checkPositive("  ")   = false
     * Utils.checkPositive("123")  = true
     * Utils.checkPositive("+123")  = true
     * Utils.checkPositive("ab2c") = false
     * Utils.checkPositive("12-3") = false
     * Utils.checkPositive("12.3") = false
     * </pre>
     *
     * @param number the String to check, {@code null} will cause {@link IllegalArgumentException}
     * @return {@code true} if number does not contain {@code -} sign,
     * and is non-null
     *
     * @throws IllegalArgumentException
     * <ul>
     * <li>If argument is {@code null}</li>
     * <li>If argument is empty or blank</li>
     * <li>If argument contains non digit character except {@code +} and @{code -}</li>
     * </ul>
     * @since 1.3.5
     */
    public static boolean checkIsPositive(CharSequence number) throws IllegalArgumentException {
        if (isAllBlank(number) || !number.toString().matches("([-+])*\\d+")) {
            throw new IllegalArgumentException("Invalid number format \"" + number + "\"");
        }
        return number.charAt(0) != '-';
    }
}