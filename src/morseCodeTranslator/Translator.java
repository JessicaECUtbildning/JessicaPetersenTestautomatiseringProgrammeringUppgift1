package morseCodeTranslator;

import java.util.HashMap;

public class Translator {
    private final HashMap<Character, String> textToMorse;
    private final HashMap<String, Character> morseToText;

    public Translator() {
        textToMorse = new HashMap<>();
        morseToText = new HashMap<>();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,?";
        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--..", "-----", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.", ".-.-.-", "--..--", "..--.."};

        for (int i = 0; i < alphabet.length(); i++) { //Fyll HasMaps med tecken <--> morsekod
            textToMorse.put(alphabet.charAt(i), morseCode[i]);
            morseToText.put(morseCode[i], alphabet.charAt(i));
        }
    }

    public String getMorse(String text) {
        StringBuilder morse = new StringBuilder();

        if (!text.isBlank()) { //Kontrollera att användarinput inte är tom
            String[] words = text.trim().toUpperCase().split(" "); //Ta bort mellanslag i början och/eller slutet av texten, dela upp i ord, separerat med mellanslag, och omvandla till versaler

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    char letter = words[i].charAt(j);

                    if (textToMorse.get(letter) != null) { //Kontrollera om tecknet finns i morsekodens HashMap
                        morse.append(textToMorse.get(letter));
                    } else {
                        morse.append("[n/a]"); //Om angivet tecken inte finns i den internationella morsekoden
                    }
                    if (j != words[i].length() - 1) { //Så länge tecknet inte är det sista i ordet, lägg till ett mellanslag
                        morse.append(" ");
                    }
                }
                if (i != words.length - 1) { //Så länge ordet inte är det sista i denna array, lägg till / för att separera ord
                    morse.append(" / ");
                }
            }
            if (morse.toString().contains("[n/a]")) {
                morse.append("\n[n/a] = Character not available in Morse Code");
            }
        } else {
            morse.append("You didn't write anything...");
        }
        return morse.toString();
    }

    public String getText(String morse) {
        StringBuilder text = new StringBuilder();

        if (!morse.isBlank()) { //Kontrollera att användarinput inte är tom
            String[] codes = morse.trim().split(" "); //Ta bort mellanslag i början och/eller slutet av morsekoden och dela upp i symboler, separerat med mellanslag

            for (String code : codes) {
                if (morseToText.get(code) != null) { //Kontrollera om morsekoden finns i morsekodens HashMap
                    text.append(morseToText.get(code));
                } else if (code.isEmpty()) { //Ett extra mellanslag i morsekoden tolkas som mellanslag mellan ord
                    text.append(" ");
                } else { //Om angiven morsekod inte finns i den internationella morsekoden
                    text.append("*");
                }
            }
            if (text.toString().contains("*")) {
                text.append("\n* = Invalid Morse Code");
            }
        } else {
            text.append("You didn't write anything...");
        }
        return text.toString();
    }
}