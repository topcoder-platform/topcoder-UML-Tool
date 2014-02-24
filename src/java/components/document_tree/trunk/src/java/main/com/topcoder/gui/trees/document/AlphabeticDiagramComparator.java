package com.topcoder.gui.trees.document;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.topcoder.diagraminterchange.Diagram;

/**
 * <p>
 * This is comparator used to sort diagrams in diagram centric tree view
 * </p>
 *
 * @version 1.0
 */
public class AlphabeticDiagramComparator implements Comparator<Diagram> {

    /**
     * Compare two diagrams alphabetically by name
     */
    public int compare(Diagram d1, Diagram d2) {
        /*
         * BUGR-367-fix In order to sort the diagrams names that are numerically prefixed according to those
         * numbers.
         */
        String name1 = d1.getName();
        String name2 = d2.getName();
        Matcher matcher1 = Pattern.compile("([0-9]\\.?)+").matcher(name1);
        Matcher matcher2 = Pattern.compile("([0-9]\\.?)+").matcher(name2);
        if (matcher1.find() && matcher2.find()) {
            String number1 = matcher1.group();
            String number2 = matcher1.group();
            if (Character.isDigit(number1.charAt(0)) && Character.isDigit(number2.charAt(0))) {
                String[] tmp1 = number1.split("\\.");
                String[] tmp2 = number2.split("\\.");
                int min = Math.min(tmp1.length, tmp2.length);

                try {
                    for (int i = 0; i < min; i++) {
                        if (tmp1[i].equals(tmp2[i])) {
                            continue;
                        }
                        return ((Integer.parseInt(tmp1[i]) < Integer.parseInt(tmp2[i])) ? -1 : 1);
                    }
                } catch (NumberFormatException e) {
                    // if there is any error, just compare it old ways
                }
            }
        }
        return name1.compareToIgnoreCase(name2);
    }
}