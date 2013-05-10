/*
 * TransitionScreen.java
 *
 * Copyright © 1998-2011 Research In Motion Ltd.
 * 
 * Note: For the sake of simplicity, this sample application may not leverage
 * resource bundles and resource strings.  However, it is STRONGLY recommended
 * that application developers make use of the localization features available
 * within the BlackBerry development platform to ensure a seamless application
 * experience across a variety of languages and geographies.  For more information
 * on localizing your application, please refer to the BlackBerry Java Development
 * Environment Development Guide associated with this release.
 */

package com.rim.samples.device.ui.screentransitionsdemo;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.ui.decor.*;


/**
 * A screen to display a Bitmap in a BitmapField, used to demonstrate screen transitions
 */
public class TransitionScreen extends MainScreen
{   
    /**
     * Creates a new TransitionScreen object
     */
    public TransitionScreen(String title, int color)
    {        
        setTitle(title);
        VerticalFieldManager manager = (VerticalFieldManager)getMainManager();
        manager.setBackground(BackgroundFactory.createSolidBackground(color));                        
    } 
    
        
   /**
    * @see Screen#invokeAction(int)
    */
    protected boolean invokeAction(int action)
    {
        if(action == ACTION_INVOKE)
        {          
            ScreenTransitionsDemo app = (ScreenTransitionsDemo)UiApplication.getUiApplication();
            app.startOrStopThread();
            return true;            
        }
        
        return super.invokeAction(action);
    }
    
    
   /**
    * @see Screen#TouchEvent(TouchEvent)
    */
    public boolean touchEvent(TouchEvent event)
    {
        if(event.getEvent() == TouchEvent.UNCLICK)
        {            
            invokeAction(ACTION_INVOKE);
            return true;
        }
        
        return super.touchEvent(event);
    } 
}
