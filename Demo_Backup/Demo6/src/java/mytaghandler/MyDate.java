/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytaghandler;

import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author thanhtra
 */
public class MyDate implements Tag {

    private PageContext page;
    private Tag parentTag;

    @Override
    public void setPageContext(PageContext pc) {
        this.page = pc;
    }

    @Override
    public void setParent(Tag t) {
        this.parentTag = t;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            Date d = new Date();
            page.getOut().write(d.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return  SKIP_BODY;
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
