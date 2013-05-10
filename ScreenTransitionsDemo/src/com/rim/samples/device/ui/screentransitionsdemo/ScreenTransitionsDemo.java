/*
 * ScreenTransitionsDemo.java
 *
 * Copyright � 1998-2011 Research In Motion Ltd.
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
import net.rim.device.api.ui.component.*;


/**
 * A sample application to demonstrate the use of the TransitionContext class to 
 * create screen transitions.
 */
public final class ScreenTransitionsDemo extends UiApplication
{  
    private boolean _threadRunning;
    private boolean _pauseThread;
    private TransitionThread _tt;
    
    
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        ScreenTransitionsDemo app = new ScreenTransitionsDemo();
        app.enterEventDispatcher();                
    }


    /**
     * Creates a new ScreenTransitionsDemo object
     */
    public ScreenTransitionsDemo()
    {        
        pushScreen(new ScreenTransitionsDemoScreen());
    }
    
    
   /**
    * Pauses or resumes the screen transitions thread
    */
    public void startOrStopThread()
    {        
        if(_threadRunning == false)
        {            
            _tt = new TransitionThread();
            _tt.start();
            
            _threadRunning = true;
            
        }
        else
        {
            if(_pauseThread)
            {
                _pauseThread = false;                
            }
            else
            {
                _pauseThread = true;
            }                
        }            
    }
       

    /**
     * MainScreen class for the ScreenTransitionsDemo application 
     */
    final class ScreenTransitionsDemoScreen extends MainScreen 
    {
        /**
         * Creates a new ScreenTransitionsDemoScreen object
         */
        ScreenTransitionsDemoScreen()
        {            
            setTitle("Screen Transitions Demo");
            
            add(new LabelField("Click trackpad or screen to start and stop animation", Field.NON_FOCUSABLE));               
        }        
        
        
       /**
        * @see Screen#invokeAction(int)
        */
        protected boolean invokeAction(int action)
        {
            if(action == ACTION_INVOKE)
            {                
                startOrStopThread();                
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
    
    
    /**
     * A thread class to present a sequence of screen transitions
     */
    final class TransitionThread extends Thread
    {        
        public static final int SLIDE = 0;
        public static final int FADE = 1;    
        public static final int WIPE = 2;    
        public static final int ZOOM = 3;    
        
        boolean _pushed;      
        
        /**
         * Default constructor
         */
        TransitionThread()
        {            
        }
        
        
        /**
         * @see Runnable#run()
         */
        public void run()
        {       
            int type = 0;         
            
            while(true)
            {         
                while(_pauseThread)
                {
                    try
                    {
                        // Sleep so we don't spin
                        sleep(500);     
                    }
                    catch(InterruptedException e)
                    {                        
                    }
                }                
                
                if(!_pushed)
                {
                    // Push a screen to demonstrate a screen transition                    
                    push(type);
                    snooze();
                }
                if(!_pauseThread)
                {
                    pop();
                }
                
                // Set the transition type for the next iteration
                if(type == 3)
                {
                    type = 0;
                }
                else
                {
                    type ++;
                }                          
            }                              
        }
        
        
        /**
         * Removes a TransitionScreen from the stack
         */
        void pop()
        {        
            synchronized(UiApplication.getEventLock())
            {                    
                Screen activeScreen = getActiveScreen();                
                popScreen(activeScreen);     
                _pushed = false;                               
            }          
        }
        
        
        /**
         * Creates a TransitionContext object for both pushing and popping a
         * screen pushes a TransitionScreen onto the stack.
         * @param type Represents the type of screen transitions to execute
         */
        void push(int type)
        {                           
            TransitionScreen screen = null;
            TransitionContext transitionContextIn;
            TransitionContext transitionContextOut;
            UiEngineInstance engine = Ui.getUiEngineInstance();
            switch(type)
            {
                case SLIDE:                        
                    screen = new TransitionScreen("Slider", Color.BEIGE);   
                                     
                    transitionContextIn = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
                    transitionContextIn.setIntAttribute(TransitionContext.ATTR_DURATION, 1000);
                    transitionContextIn.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_UP);              
                    
                    transitionContextOut = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_DURATION, 1000);
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_DOWN);                                                            
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_KIND, TransitionContext.KIND_OUT);                
                                                                                
                    engine.setTransition(null, screen, UiEngineInstance.TRIGGER_PUSH, transitionContextIn);
                    engine.setTransition(screen, null, UiEngineInstance.TRIGGER_POP, transitionContextOut);
                    break;
                case FADE:
                    screen = new TransitionScreen("Fade", Color.TEAL);  
                                      
                    transitionContextIn = new TransitionContext(TransitionContext.TRANSITION_FADE);
                    transitionContextIn.setIntAttribute(TransitionContext.ATTR_DURATION, 1000); 
                    
                    transitionContextOut = new TransitionContext(TransitionContext.TRANSITION_FADE);
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_DURATION, 1000);                    
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_KIND, TransitionContext.KIND_OUT);   
                                       
                    engine.setTransition(null, screen, UiEngineInstance.TRIGGER_PUSH, transitionContextIn);
                    engine.setTransition(screen, null, UiEngineInstance.TRIGGER_POP, transitionContextOut);
                    break;
                case WIPE:
                    screen = new TransitionScreen("Wipe", Color.LIGHTBLUE);   
                                     
                    transitionContextIn = new TransitionContext(TransitionContext.TRANSITION_WIPE);
                    transitionContextIn.setIntAttribute(TransitionContext.ATTR_DURATION, 1000);
                    transitionContextIn.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);      
                                        
                    transitionContextOut = new TransitionContext(TransitionContext.TRANSITION_WIPE);
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_DURATION, 1000);
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);  
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_KIND, TransitionContext.KIND_OUT);   
                                                      
                    engine.setTransition(null, screen, UiEngineInstance.TRIGGER_PUSH, transitionContextIn);
                    engine.setTransition(screen, null, UiEngineInstance.TRIGGER_POP, transitionContextOut);
                    break;
                case ZOOM:
                    screen = new TransitionScreen("Zoom", Color.LIGHTGREEN);  
                                      
                    transitionContextIn = new TransitionContext(TransitionContext.TRANSITION_ZOOM);
                    transitionContextIn.setIntAttribute(TransitionContext.ATTR_DURATION, 1000);                    
                    
                    transitionContextOut = new TransitionContext(TransitionContext.TRANSITION_ZOOM);
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_DURATION, 1000); 
                    transitionContextOut.setIntAttribute(TransitionContext.ATTR_KIND, TransitionContext.KIND_OUT); 
                    
                    engine.setTransition(null, screen, UiEngineInstance.TRIGGER_PUSH, transitionContextIn);
                    engine.setTransition(screen, null, UiEngineInstance.TRIGGER_POP, transitionContextOut);
                    break;
            }
            
            synchronized(UiApplication.getEventLock())
            {
                pushScreen(screen);    
                _pushed = true;                      
            }           
        }
        
        
       /**
        * Causes this thread to pause between transitions
        */
        private void snooze()
        {
            try
            {
                sleep(2000);
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
    }
}
