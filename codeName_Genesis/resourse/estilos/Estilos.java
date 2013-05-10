package estilos;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.MainScreen;

public abstract class Estilos extends MainScreen{
	
		Estilos prevScreen ;
	
	public Estilos(){
		
	}
	
	
    public void pushScreen( Screen toPush ) 
    {
    	TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_WIPE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 500);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		UiApplication.getUiApplication().popScreen(this);
		UiApplication.getUiApplication().pushScreen(toPush);
    }

    public void pushScreenBack( Screen toPush ) 
    {
    	TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_WIPE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 500);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		UiApplication.getUiApplication().popScreen(this);
		UiApplication.getUiApplication().pushScreen(toPush);
    } 
    
	public class WRichTextField extends RichTextField
	{
		public WRichTextField(String string)
		{
			super(string);
		}
		
		public void paint(Graphics g)
		{      
			g.setColor(Color.WHITE);
			super.paint(g);
		}
	}
	
}	
	
