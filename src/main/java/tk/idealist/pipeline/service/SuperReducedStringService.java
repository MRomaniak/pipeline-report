package tk.idealist.pipeline.service;

import org.springframework.stereotype.Service;

@Service
public class SuperReducedStringService {

    private static final String EMPTY_STRING_TEXT = "Empty String";

    public String reduce(String s) {
        if (s.isEmpty()) {
            return EMPTY_STRING_TEXT;
        }
        return s.length() == 1 ? s : reduceString(s);
    }

    private String reduceString(String s) {
        char[] chars = s.toCharArray();
        int indexOfFirstRepetition = findIndexOfFirstRepetition(chars);
        String resultString = indexOfFirstRepetition == -1 ? s : buildResultString(s, indexOfFirstRepetition);

        if (resultString.isEmpty()) {
            return EMPTY_STRING_TEXT;
        }

        return s.equals(resultString) ? s : reduceString(resultString);
    }

    private int findIndexOfFirstRepetition(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    private String buildResultString(String s, int index) {
        return new StringBuilder()
                .append(index == 1 ? "" : s.substring(0, index - 1))
                .append(index < s.length() ? s.substring(index + 1) : "")
                .toString();
    }
}
