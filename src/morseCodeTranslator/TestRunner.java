package morseCodeTranslator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRunner {
    /*
    Krav:
    1. Skriv ett program som gör om morsekod till engelska och engelska till morsekod
    2. Skriv programmet med minst en logikklass samt en klass som läser in text och
       skriver ut text (med en main-metod)
    3. Använd den internationella morsekoden
    4. Utveckla programmet i TDD och skriv minst 3 JUnit-testfall
    5. Skapa minst två felhanteringar i systemet som fångar två saker
       som användaren kan göra som går utanför det vanliga användandet av systemet
    */

    @Test
    public void testLetterToMorse() {
        Translator translator = new Translator();
        String expected = ".---";
        String actual = translator.getMorse("J");
        assertEquals(expected, actual);
    }

    @Test
    public void testDigitToMorse() {
        Translator translator = new Translator();
        String expected = "--...";
        String actual = translator.getMorse("7");
        assertEquals(expected, actual);
    }

    @Test
    public void testSpecialCharToMorse() {
        Translator translator = new Translator();
        String expected = "..--..";
        String actual = translator.getMorse("?");
        assertEquals(expected, actual);
    }

    @Test
    public void testLowerCaseToMorse() {
        Translator translator = new Translator();
        String expected = ".--.";
        String actual = translator.getMorse("p");
        assertEquals(expected, actual);
    }

    @Test
    public void testWordToMorse() {
        Translator translator = new Translator();
        String expected = "-- --- .-. ... .";
        String actual = translator.getMorse("Morse");
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidChar() {
        Translator translator = new Translator();
        String expected = "[n/a]\n[n/a] = Character not available in Morse Code";
        String actual = translator.getMorse("Ö");
        assertEquals(expected, actual);
    }

    @Test
    public void testMorseToLetter() {
        Translator translator = new Translator();
        String expected = "K";
        String actual = translator.getText("-.-");
        assertEquals(expected, actual);
    }

    @Test
    public void testMorseToWord() {
        Translator translator = new Translator();
        String expected = "MORSE";
        String actual = translator.getText("-- --- .-. ... .");
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidMorse() {
        Translator translator = new Translator();
        String expected = "*\n* = Invalid Morse Code";
        String actual = translator.getText("....----");
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleWordsToMorse() {
        Translator translator = new Translator();
        String expected = "-- --- .-. ... . / -.-. --- -.. .";
        String actual = translator.getMorse("Morse Code");
        assertEquals(expected, actual);
    }

    @Test
    public void testMorseToMultipleWords() {
        Translator translator = new Translator();
        String expected = "MORSE CODE";
        String actual = translator.getText("-- --- .-. ... .  -.-. --- -.. .");
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyText() {
        Translator translator = new Translator();
        String expected = "You didn't write anything...";
        String actual = translator.getMorse("   ");
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyMorse() {
        Translator translator = new Translator();
        String expected = "You didn't write anything...";
        String actual = translator.getText("   ");
        assertEquals(expected, actual);
    }

    @Test
    public void testAllCharsToMorse() {
        Translator translator = new Translator();
        String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. " +
                "--.- .-. ... - ..- ...- .-- -..- -.-- --.. ----- .---- ..--- ...-- ....- ..... " +
                "-.... --... ---.. ----. .-.-.- --..-- ..--..";
        String actual = translator.getMorse("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,?");
        assertEquals(expected, actual);
    }

    @Test
    public void testAllMorseToChars() {
        Translator translator = new Translator();
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,?";
        String actual = translator.getText(".- -... -.-. -.. . ..-. --. .... .. " +
                ".--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. ----- " +
                ".---- ..--- ...-- ....- ..... -.... --... ---.. ----. .-.-.- --..-- ..--..");
        assertEquals(expected, actual);
    }

    @Test
    public void testTrailingSpacesTextToMorse() {
        Translator translator = new Translator();
        String expected = ".-- .... .- - / .. ... / - .... .. ... ..--..";
        String actual = translator.getMorse("     What is this?     ");
        assertEquals(expected, actual);
    }

    @Test
    public void testTrailingSpacesMorseToText() {
        Translator translator = new Translator();
        String expected = "WHO ARE YOU?";
        String actual = translator.getText("     .-- .... ---  .- .-. .  -.-- --- ..- ..--..     ");
        assertEquals(expected, actual);
    }
}