package com.example.ProjektJava.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class StrongPasswordValidatorUnitTests {
    private StrongPasswordValidator validator;
    private ConstraintValidatorContext context;

    @BeforeEach
    public void setUp() {
        this.validator = new StrongPasswordValidator();
        this.context = mock(ConstraintValidatorContext.class);
    }

    @Test
    @DisplayName("Ensure validator return true when string is empty")
    void testIsValidWithEmptyValue() {
        StrongPassword strongPassword = mock(StrongPassword.class);
        validator.initialize(strongPassword);

        String value = "";

        boolean result = validator.isValid(value, context);

        assertTrue(result);
    }

    @Test
    @DisplayName("Ensure validator return true when string is null")
    void testIsValidWithNullValue() {
        StrongPassword strongPassword = mock(StrongPassword.class);
        validator.initialize(strongPassword);

        String value = null;

        boolean result = validator.isValid(value, context);

        assertTrue(result);
    }

    @Test
    @DisplayName("Ensure validator return true when password is valid")
    void testIsValidWithValidPassword() {
        StrongPassword strongPassword = mock(StrongPassword.class);
        validator.initialize(strongPassword);

        String value = "Password123@";

        boolean result = validator.isValid(value, context);

        assertTrue(result);
    }

    @Test
    @DisplayName("Ensure validator return false when password is invalid")
    void testIsInvalidWithInvalidPassword() {
        StrongPassword strongPassword = mock(StrongPassword.class);
        validator.initialize(strongPassword);

        String value = "password";

        boolean result = validator.isValid(value, context);

        assertFalse(result);
    }

    @Test
    @DisplayName("Ensure validator return false when password too short")
    void testIsInvalidWithTooShortPassword() {
        StrongPassword strongPassword = mock(StrongPassword.class);
        validator.initialize(strongPassword);

        String value = "Pass32@";

        boolean result = validator.isValid(value, context);

        assertFalse(result);
    }
}
