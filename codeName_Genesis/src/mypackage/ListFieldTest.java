package mypackage;

import net.rim.device.api.system.Bitmap;  
import net.rim.device.api.system.Display;  
import net.rim.device.api.ui.*;  
import net.rim.device.api.ui.component.*;  
import net.rim.device.api.ui.container.*;  
  
import java.util.Vector;  

import estilos.Estilos;
  
public class ListFieldTest extends Estilos {  
   
	 /*public static void main(String[] args){  
		    
		  //main entry point   
		  ListFieldTest theApp = new ListFieldTest();  
		  theApp.enterEventDispatcher();  
		   
		 } */
  
  
 public ListFieldTest(){  
  
   HorizontalFieldManager _hfm;  
                  
   //The _vfm will hold the ListField and we'll add it to the _hfm  
   VerticalFieldManager _vfm;  
  
  //Create the vars for ListField creation  
  ListField myList;  
  ListCallback myCallback;  
  
  //Get the device width and height  
  final int width = Display.getWidth();  
  final int height = Display.getHeight();  
          
  //Create the mainScreen - this holds the _hfm and _vfm managers  
  MainScreen mainScreen;  
  mainScreen = new MainScreen();  
                  
  //Private class that we will create in a minute  
  myCallback = new ListCallback();  
  myCallback.erase();  
  
  myList = new MyListField();  
  myList.setCallback(myCallback);  
                  
  //Populate the list with sample elements  
  for(int i=0;i<20;i++){  
        myList.insert(i);  
        myCallback.insert("Element #" + Integer.toString(i), i);  
       
        
  }  
  
//Draw background gradient on this manager and add VerticalFieldManager for scrolling.  
  _hfm = new HorizontalFieldManager() {  
    
   public void paint(Graphics g)  
   {  
      
     
    //Variables for drawing the gradient  
    int[] X_PTS_MAIN = { 0, width, width, 0};   
    int[] Y_PTS_MAIN = { 0, 0, height, height };   
    int[] drawColors_MAIN = { Color.BLACK, Color.BLACK, Color.DARKBLUE, Color.DARKBLUE};  
  
      
    try {  
     //Draw the gradients     
        g.drawShadedFilledPath(X_PTS_MAIN, Y_PTS_MAIN, null, drawColors_MAIN, null);  
          
    } catch (IllegalArgumentException iae) {  
        System.out.println("Bad arguments.");   
    }  
      
      
      
    //Call super to paint the graphics on the inherited window   
    super.paint(g);  
      
       
     }  
    
  //Sublayout is passed the width and height of the parent window and will tell the window manager  
  //how to layout the buttons, images, etc.  
  protected void sublayout(int w, int h) {    
     
   //GetFieldCount returns the number of fields attached to the instance of this manager.  
   //and lays out the position  
             if (getFieldCount() >0) {                   
                             
                  Field searchRes = getField(0);  
                  layoutChild(searchRes, width, height);  
                  setPositionChild(searchRes,0,0);  
                 
             }  
               
               
              
             setExtent(width,height);  
              
         }  
    
    
 };  
 
 _vfm = new VerticalFieldManager(Manager.VERTICAL_SCROLL|Manager.USE_ALL_HEIGHT|Manager.USE_ALL_WIDTH) {  
     
	   public void paint(Graphics g)  
	      {  
	           g.setColor(Color.GRAY);    
	          super.paint(g);  
	      
	      }  
	     
	   protected boolean navigationMovement(int dx, int dy, int status, int time){  
	          this.invalidate();  
	          return super.navigationMovement(dx,dy,status,time);  
	         }  
	           
	     
	  };  
	       //Add the list to the verticalFieldManager  
	        _vfm.add(myList);  
	          
	       //Add the verticalFieldManager to the HorizontalFieldManager  
	       _hfm.add(_vfm);  
	      //Finally, add the HorizontalFieldManager to the MainScreen and push it to the stack   
	       mainScreen.add(_hfm);  
	       pushScreen(mainScreen);  
	  
	  
	}//End Ctor  
}
