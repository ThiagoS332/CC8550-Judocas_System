package main.java.org.fpij.jitakyoei.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class JTextIntLimiterFilter extends DocumentFilter {
    private final int limit;

    public JTextIntLimiterFilter(int limit) {
        this.limit = limit;
    }

    @Override  
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException  {
        if(fb.getDocument().getLength()+string.length() > limit) {
            return;
        }

        if (test(fb.getDocument().getText(0, fb.getDocument().getLength()).toString())) {
            fb.insertString(offset, string, attr);
        } else {
            // warn the user and don't allow the insert
        }

        // fb.insertString(offset, string, attr);
    }  


    @Override  
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {  
        fb.remove(offset, length);
    }  

    private boolean test(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override  
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.replace(offset, offset + length, text);

        if(fb.getDocument().getLength()+text.length() > limit){
            return;
        }

        // fb.insertString(offset, text, attrs);

        if (test(text.toString())) {
            fb.insertString(offset, text, attrs);
        } else {
            // warn the user and don't allow the insert
        }
    }
}
