package mypackage;

import java.util.Vector;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;

//Private class to populate the ListField private variable
 class ListCallback implements ListFieldCallback{

  
  private Vector listElements = new Vector();
        
     public void drawListRow(ListField list, Graphics g, 
                         int index, int y, int w) {  

        String text = (String)listElements.elementAt(index);
        g.setColor(Color.LIGHTGREY);
        g.drawText(text, 0, y, 0, w);  
     }
        
     public Object get(ListField list, int index) {  
        return listElements.elementAt(index); 
     }     

     public int indexOfList(ListField list, String p, int s) {  
        //return listElements.getSelectedIndex();
        return listElements.indexOf(p, s);  
     }
        
        
     public void insert(String toInsert, int index) {  
        listElements.insertElementAt(toInsert, index);  
     }
     
     public void add(String toInsert){
      listElements.addElement(toInsert);
     }
        
     public void erase() {  
        listElements.removeAllElements();  
     }

  public int getPreferredWidth(ListField listField) {
   // TODO Auto-generated method stub
   return 0;
  }

  
  
  }
 

