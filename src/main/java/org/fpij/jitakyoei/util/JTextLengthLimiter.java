package main.java.org.fpij.jitakyoei.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class JTextLengthLimiter extends DocumentFilter {
    private final int limit;

    public JTextLengthLimiter(int limit) {
        this.limit = limit;
    }

    @Override  
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException  {
        if(fb.getDocument().getLength()+string.length() > limit) {
            return;
        }

        fb.insertString(offset, string, attr);
    }  


    @Override  
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {  
        fb.remove(offset, length);
    }  



    @Override  
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)throws BadLocationException {
        if(fb.getDocument().getLength()+text.length() > limit){
            return;
        }

        fb.insertString(offset, text, attrs);
    }
}
