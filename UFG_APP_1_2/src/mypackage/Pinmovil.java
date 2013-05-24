package mypackage;

import estilos.BitmapButtonField;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

public class Pinmovil extends Metodos{

	     BitmapButtonField mis,vis,val,compe,cali,ini,inno,eti;
	     HorizontalFieldManager v,v1,v2,v3;
	     Bitmap _bitmap,_bitmap1;
	     String value="";
	     
	public Pinmovil(){

		
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.LIGHTBLUE, Color.LIGHTBLUE,Color.WHITE,Color.WHITE));
		
		
		
		mis	= new BitmapButtonField(Bitmap.getBitmapResource("mision.png"), Bitmap.getBitmapResource("mision.png"),0| Field.FIELD_HCENTER );
		add(mis);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean onClose() {
        
		TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 600);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		
		openScreen(new principal());
		return true;
	 }
}