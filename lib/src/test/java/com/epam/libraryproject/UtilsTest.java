package com.epam.libraryproject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @ParameterizedTest
    @DisplayName("Should return true if number does not contain - sign or not null or blank")
    @ValueSource(strings = {"123", "12 3", "1 5 5"})
    public void isPositiveReturningTrue(String number) {
        assertTrue(Utils.isPositive(number));
    }

    @ParameterizedTest
    @DisplayName("Should return false if number contains - sign or not null or blank")
    @ValueSource(strings = {"", "   ", "-123", "-12 3", "ab2c", "12-3", "12.3"})
    public void isPositiveReturningFalse(String number) {
        assertFalse(Utils.isPositive(number));
    }

    @ParameterizedTest
    @DisplayName("Should return true if number follows right format and does not have - sign")
    @ValueSource(strings = {"123", "+1234"})
    public void checkPositiveReturningTrue(String number) {
        assertTrue(Utils.checkIsPositive(number));
    }

    @ParameterizedTest
    @DisplayName("Should return false if number follows right format and has - sign")
    @ValueSource(strings = {"-123"})
    public void checkPositiveReturningFalse(String number) {
        assertFalse(Utils.checkIsPositive(number));
    }

    @ParameterizedTest
    @DisplayName("Should throw IllegalArgumentException if number does not follows right format")
    @ValueSource(strings = {"-12 3", "+ 11", "asd12", "121.3", "  ", ""})
    public void checkPositiveThrowingIllegalArgumentException(String number) {
        assertThrows(IllegalArgumentException.class, () -> Utils.checkIsPositive(number));
    }
}
