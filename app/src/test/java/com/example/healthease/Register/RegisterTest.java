package com.example.healthease.Register;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.healthease.RegisterActivity;

import org.junit.Test;

public class RegisterTest {

    @Test
    public void testIsValid() {
        String validPassword = "Abc@1234";
        assertTrue(RegisterActivity.isValid(validPassword));

        String noSpecialChar = "Abc12345";
        assertFalse(RegisterActivity.isValid(noSpecialChar));

        String noDigit = "Abcdef@gh";
        assertFalse(RegisterActivity.isValid(noDigit));

        String noLetter = "12345@67";
        assertFalse(RegisterActivity.isValid(noLetter));

        String tooShort = "A@1";
        assertFalse(RegisterActivity.isValid(tooShort));

        String edgeCase = "A1b@1234";
        assertTrue(RegisterActivity.isValid(edgeCase));
    }
}
