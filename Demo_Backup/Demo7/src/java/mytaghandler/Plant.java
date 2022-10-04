/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytaghandler;

import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author thanhtra
 */
public class Plant extends SimpleTagSupport {

    private int id;

    /**
     * Called by the container to invoke this tag. The implementation of this method is provided by the tag library developer, and handles all tag processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            ArrayList<Orchid> list = new ArrayList<>();
            list.add(new Orchid(1, "vanda"));
            list.add(new Orchid(2, "catleya"));
            list.add(new Orchid(3, "denro"));
            out.println("<h2>id:" + id + "</h2>");
            out.println("<h3>id:" + list.get(id - 1) + "</h3>");
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Plant tag", ex);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

}
