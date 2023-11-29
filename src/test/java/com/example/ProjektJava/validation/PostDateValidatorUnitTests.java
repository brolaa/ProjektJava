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
public class PostDateValidatorUnitTests {
    private PostDateValidator validator;
    private ConstraintValidatorContext context;

    @BeforeEach
    public void setUp() {
        this.validator = new PostDateValidator();
        this.context = mock(ConstraintValidatorContext.class);
    }

    @Test
    @DisplayName("Ensure validator return true when string is empty")
    void testIsValidWithEmptyValue() {
        PostDate postDate = mock(PostDate.class);
        validator.initialize(postDate);

        String value = "";

        boolean result = validator.isValid(value, context);

        assertTrue(result);
    }

    @Test
    @DisplayName("Ensure validator return true when string is null")
    void testIsValidWithNullValue() {
        PostDate postDate = mock(PostDate.class);
        validator.initialize(postDate);

        String value = null;

        boolean result = validator.isValid(value, context);

        assertTrue(result);
    }

    @Test
    @DisplayName("Ensure validator return true when date is valid")
    void testIsValidWithValidDate() {
        PostDate postDate = mock(PostDate.class);
        validator.initialize(postDate);

        String value = "2023-11-22";

        boolean result = validator.isValid(value, context);

        assertTrue(result);
    }

    @Test
    @DisplayName("Ensure validator return false when date format is invalid")
    void testIsInvalidWithInvalidDateFormat() {
        PostDate postDate = mock(PostDate.class);
        validator.initialize(postDate);

        String value = "22.11.2023";

        boolean result = validator.isValid(value, context);

        assertFalse(result);
    }

    @Test
    @DisplayName("Ensure validator return false when date is invalid")
    void testIsInvalidWithInvalidDate() {
        PostDate postDate = mock(PostDate.class);
        validator.initialize(postDate);

        String value = "2023-02-29";

        boolean result = validator.isValid(value, context);

        assertFalse(result);
    }
}
