package mypackage;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.XYRect;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;

class MyListField extends ListField{
	  
	  
	  //0,ListField.MULTI_SELECT
	    private boolean hasFocus = false;
	    
	    public  void onFocus(int direction){
	      hasFocus = true;  
	    }
	    
	     public void onUnfocus() 
	        {
	               hasFocus = false;
	               super.onUnfocus();
	               invalidate();
	        }
	     
	    public void paint(Graphics graphics) 
	          {   int width = Display.getWidth();
	              //Get the current clipping region 
	              XYRect redrawRect = graphics.getClippingRect();
	              if(redrawRect.y < 0)
	              {
	                  throw new IllegalStateException("Error with clipping rect.");
	              }

	              //Determine the start location of the clipping region and end.
	              int rowHeight = getRowHeight();

	              int curSelected;
	              
	              //If the ListeField has focus determine the selected row.
	              if (hasFocus) 
	              {
	                   curSelected = getSelectedIndex();
	                   
	              } 
	              else 
	              {
	                  curSelected = -1;
	              }
	              
	              int startLine = redrawRect.y / rowHeight;
	              int endLine = (redrawRect.y + redrawRect.height - 1) / rowHeight;
	              endLine = Math.min(endLine, getSize() - 1);
	              int y = startLine * rowHeight;

	              //Setup the data used for drawing.
	              int[] yInds = new int[]{y, y, y + rowHeight, y + rowHeight};
	              int[] xInds = new int[]{0, width, width, 0};

	              //Set the callback - assuming String values.
	              ListFieldCallback callBack = this.getCallback();

	              //Draw each row
	              for(; startLine <= endLine; ++startLine) 
	              {               
	             //If the line we're drawing is the currentlySelected line then draw the fill path in LIGHTYELLOW and the 
	               //font text in Black.  
	             if(startLine == curSelected){
	              
	                     graphics.setColor(Color.LIGHTYELLOW);
	                     graphics.drawFilledPath(xInds, yInds, null, null);
	                     graphics.setColor(Color.BLACK);
	                     graphics.drawText((String)callBack.get(this, startLine), 0, yInds[0]);
	                   
	             }
	             else{
	                     //Draw the odd or selected rows.
	                    graphics.setColor(Color.LIGHTGREY);
	                    graphics.drawText((String)callBack.get(this, startLine), 0, yInds[0]);
	             }
	             
	              //Assign new values to the y axis moving one row down.
	                y += rowHeight;
	                yInds[0] = y;
	                yInds[1] = yInds[0];
	                yInds[2] = y + rowHeight;
	                yInds[3] = yInds[2];
	              }
	              
	              //super.paint(graphics);
	          }
	 }