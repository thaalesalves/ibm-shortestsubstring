package es.thalesalv.ibmtest;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringAllCharactersLength {

    public static void main(String[] args) {
        String str = "daabcbcbdc";
        String str2 = "aabcbcbdca";
        String str3 = "aaaae";
        String str4 = "argh";
        System.out.println(getSubstring(str4));
    }

    private static String getSubstring(String str) {
        Map<Character, Integer> charOccurences = new HashMap<Character, Integer>();
        int strLength = str.length();
        int distinctChars = 0;
        for (int i = 0; i < strLength; i++) {
            if (!charOccurences.containsKey(str.charAt(i))) {
                distinctChars++;
                charOccurences.put(str.charAt(i), 1);
            } else {
                charOccurences.put(str.charAt(i), charOccurences.get(str.charAt(i)) + 1);
            }
        }

        for (int minLength = distinctChars; minLength < strLength; minLength++) {
            for (int start = 0; start + minLength <= strLength; start++) {
                String substr = str.substring(start, start + minLength);
                if (isSuitable(substr, charOccurences)) {
                    return "The first shortest substring in \"" + str + "\" is \"" + substr + "\", and its length is " + substr.length();
                }
            }
        }

        return "No suitable window found.";
    }

    private static boolean isSuitable(String substr, Map<Character, Integer> charMap) {
		for (Character character : charMap.keySet()) {
			if (substr.indexOf(character) == -1) {
				return false;
			}
		}
		return true;
	}
}