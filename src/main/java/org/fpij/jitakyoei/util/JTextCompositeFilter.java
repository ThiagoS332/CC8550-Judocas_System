package main.java.org.fpij.jitakyoei.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class JTextCompositeFilter extends DocumentFilter {
    private final DocumentFilter[] filters;

    public JTextCompositeFilter(DocumentFilter... filters) {
        this.filters = filters;
    }

    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
        for (DocumentFilter filter : filters) {
            filter.insertString(fb, offs, str, a);
        }
    }

    public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
        for (DocumentFilter filter : filters) {
            filter.replace(fb, offs, length, str, a);
        }
    }
}