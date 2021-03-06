/**********************************************************************
 * Jhove - JSTOR/Harvard Object Validation Environment
 * Copyright 2004 by JSTOR and the President and Fellows of Harvard College
 **********************************************************************/

package edu.harvard.hul.ois.jhove.module.html;

import java.util.*;
/**
 * Abstract superclass for the representation of portions of
 * an HTML file.  This is not the same usage of "element" as the
 * SGML definition, but refers to a parsed unit, such as an opening
 * tag, closing tag, or PCDATA.
 *
 * @author Gary McGath
 *
 */
public abstract class JHElement {

    public int _column;
    public int _line;

    /** Constructor. 
     * 
     *  @param    elements     List of elements representing the document.
     *                         May be null for a stub element which is implied
     *                         rather than being generated by the parser.
     */
    public JHElement (List elements) {
        if (elements != null) {
            elements.add (this);
        }
    }


    /** Returns the line number for the start of the element. */
    public int getLine ()
    {
        return _line;
    }
    
    /** Returns the column number for the start of the element. */
    public int getColumn ()
    {
        return _column;
    }
    
    /** Extracts entities from a text string and returns them as
     *  a List of Strings.  
     *  If there are no entities, returns an empty List. */
    protected List getEntities (String text)
    {
        List lst = new LinkedList ();
        int startIdx = 0;
        for (;;) {
            // Find the ampersand which starts an entity.
            int idx = text.indexOf ("&", startIdx);
            if (idx < 0) {
                break;   // no more occurrences
            }
            // Find the semicolon which ends the entity.
            int semiIdx = text.indexOf (";", idx);
            if (semiIdx < 0) {
                break;   // broken entity, no terminator
            }
            String ent = text.substring(idx, semiIdx + 1);
            lst.add (ent);
            // Advance to end of this entity
            startIdx = semiIdx;
        }
        return lst;
    }
}
