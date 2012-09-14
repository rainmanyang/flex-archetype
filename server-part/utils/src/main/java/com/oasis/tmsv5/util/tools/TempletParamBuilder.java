package com.oasis.tmsv5.util.tools;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TempletParamBuilder {

    private static final Log logger = LogFactory.getLog(TempletParamBuilder.class);

    private static final String CRLF = "" + (char) 13 + (char) 10;

    public String build(String oldContent, Map<String, String> replacements) {

        if (oldContent == null)
            return null;

        StringBuilder newContent = new StringBuilder();

        BufferedReader buffRdr = null;
        StringReader strRdr = null;
        try {
            // Use a buffered reader to parse the string.
            strRdr = new StringReader(oldContent);
            buffRdr = new BufferedReader(strRdr);

            // Evaluate one line at a time and replace the parameter with value.
            String str = null;
            while ((str = buffRdr.readLine()) != null) {
                String newStr = replaceLine(str + CRLF, replacements);
                newContent.append(newStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (strRdr != null)
                    strRdr.close();
                if (buffRdr != null)
                    buffRdr.close();
            } catch (IOException ioe) {
                logger.error("Caught an exception while closing stream: " + ioe, ioe);
            }
        }

        return newContent.toString();
    }

    private String replaceLine(String str, Map<String, String> replacements) {
        // Sanity Check - Do nothing if the parameter is invalid.
        if (str == null || replacements == null)
            return str;

        StringBuilder buff = new StringBuilder(str);

        // Look for each token in this line.
        int startIndex = 0;
        int endIndex = 0;
        while ((startIndex = str.indexOf("${", endIndex)) != -1) {
            endIndex = str.indexOf("}", startIndex);

            // Use the token to find the predefined value in the Map.
            String token = str.substring(startIndex + 2, endIndex);
            String value = (String) replacements.get(token);

            // Replace the token with the predefined value, otherwise erase the
            // token.
            value = (value != null) ? value : "";
            String repStr = this.padString(value, token.length() + 3);
            buff.replace(startIndex, startIndex + Math.max(token.length(), repStr.length()), repStr);
        }

        return buff.toString();
    }

    private String padString(String str, int length) {
        String newStr = str;

        // Pad string with white spaces only if the string is not long enough.
        if (str != null && str.length() < length) {
            char spaceChars[] = new char[length - str.length()];
            for (int i = 0; i < spaceChars.length; i++)
                spaceChars[i] = ' ';
            StringBuilder buff = new StringBuilder(str);
            newStr = (buff.append(spaceChars)).toString();
        }

        return newStr;
    }

}
