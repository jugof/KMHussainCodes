package app.components;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class LottoTag extends SimpleTagSupport {
    
    private String digitVar;

    private int digitCount = 8;

    private static Random rdm = new Random();

    public void setDigitVar(String name) {
        digitVar = name;
    }

    public void setDigitCount(int value) {
        digitCount = value > 5 ? value : 8;
    }

    @Override
    public void doTag() throws JspException, IOException {
        var context = super.getJspContext();
        var body = super.getJspBody();
        for(int i = 0; i < digitCount; ++i){
            int digitVal = rdm.nextInt(0, 10);
            context.setAttribute(digitVar, digitVal);
            body.invoke(null);
        }
    }

    
}
