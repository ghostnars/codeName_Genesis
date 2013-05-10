/*
 * TagListField.java
 *
 *
 * This product uses the Remember The Milk API but is not endorsed or certified by Remember The Milk.
 */

package org.emerick.rtm.ui.lists;

import java.util.Vector;

import net.rim.device.api.ui.DrawStyle;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;

import org.emerick.rtm.RTM;
import org.emerick.rtm.ui.field.FontColorField;
import org.emerick.rtm.ui.screens.TaskListScreen;

/**
 * @author Jason Emerick
 */
public class TagListField extends ListField implements ListFieldCallback
{
    
    private String[] tags;
    private Vector rows;
    private Font font;
    private RTM rtm;
    
    public TagListField(RTM rtm)
    {
        super(0);
        setEmptyString("Hooray, no tags here!", DrawStyle.HCENTER);
        setCallback(this);
        this.rtm = rtm;
        font = Font.getDefault();
        
        this.tags = rtm.getTags();
        rows = new Vector();
        
        for(int x = 0; x < tags.length; ++x)
        {
            TableRowManager row = new TableRowManager();
            // set the list name
            row.add(new LabelField(tags[x], DrawStyle.ELLIPSIS));
            
            // set the number of due items in the given list
            row.add(new FontColorField("(" + rtm.countByTag(tags[x]) + ") ", DrawStyle.ELLIPSIS | Field.USE_ALL_WIDTH | DrawStyle.RIGHT, 0x00878787, font));
            
            rows.addElement(row);
        }
        
        setSize(rows.size());             
    }      
    
    private class TableRowManager extends Manager
    {
        public TableRowManager()
        {
            super(0);
        }
        
        // Causes the fields within this row manager to be layed out then
        // painted.
        public void drawRow(Graphics g, int x, int y, int width, int height)
        {
            // Arrange the cell fields within this row manager.
            layout(width, height);

            // Place this row manager within its enclosing list.
            setPosition(x, y);

            // Apply a translating/clipping transformation to the graphics
            // context so that this row paints in the right area.
            g.pushRegion(getExtent());

            // Paint this manager's controlled fields.
            subpaint(g);
            
            //g.setColor(0x00CACACA);
            //g.drawLine(0, 0, getPreferredWidth(), 0);

            // Restore the graphics context.
            g.popContext();
        }
        
        // Arrages this manager's controlled fields from left to right within
        // the enclosing table's columns.
        protected void sublayout(int width, int height)
        {
            int preferredWidth = getPreferredWidth();
            int preferredHeight = getPreferredHeight();
            
            Field field = getField(0);
            layoutChild(field, preferredWidth - 75, preferredHeight);
            setPositionChild(field, 0, 0);
            
            field = getField(1);
            layoutChild(field, 75, preferredHeight);
            setPositionChild(field, preferredWidth-75, 0);

            setExtent(preferredWidth, preferredHeight);
        }
        
        // The preferred width of a row is defined by the list renderer.
        public int getPreferredWidth()
        {
            return Graphics.getScreenWidth();
        }

        // The preferred height of a row is the "row height" as defined in the
        // enclosing list.
        public int getPreferredHeight()
        {
            return getRowHeight();
        }
    }
        
        

    // ListFieldCallback Implementation
    public void drawListRow(ListField listField, Graphics g, int index, int y, int width)
    {
        TagListField list = (TagListField) listField;
        TableRowManager rowManager = (TableRowManager)list.rows.elementAt(index);
        rowManager.drawRow(g, 0, y, width, list.getRowHeight());
    }
    
    public Object get(ListField list, int index)
    {
        return tags[index];
    }
    
    public int indexOfList(ListField list, String p, int s)
    {
        return -1;
    }
    
    public int getPreferredWidth(ListField list)
    {
        return Graphics.getScreenWidth();
    }
    
    
    protected boolean trackwheelClick(int status, int time)
    {
        int index = getSelectedIndex();
        UiApplication.getUiApplication().pushScreen(new TaskListScreen(rtm, tags[index], rtm.getTasksByTag(tags[index])));
        return true;
    }
} 
