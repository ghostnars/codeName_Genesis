package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import estilos.BitmapButtonField;

public final class principal extends Metodos{  

	BitmapButtonField bts1 , bts2 , bts3 , bts4,bts5;
	String value="";
	Bitmap imo = Bitmap.getBitmapResource("copyright_imoves.png");
	public principal(){
		
		setTitle("UNIVERSIDAD FRANCISCO GAVIDIA");
	
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK, Color.BLACK,Color.BLACK,Color.BLACK));
		
		VerticalFieldManager allcontent = new VerticalFieldManager();
		
		HorizontalFieldManager contentup = new HorizontalFieldManager();
		
		HorizontalFieldManager content = new HorizontalFieldManager();
		
		HorizontalFieldManager contentdown = new HorizontalFieldManager();
		
		bts1 = new BitmapButtonField(Bitmap.getBitmapResource("u.png"), Bitmap.getBitmapResource("u1.png"));
		bts1.setChangeListener(this);
		bts1.setMargin(8, 5, 5, 5);
		
		bts3 = new BitmapButtonField(Bitmap.getBitmapResource("noticia.png"), Bitmap.getBitmapResource("noticia1.png"),BitmapButtonField.FIELD_BOTTOM);
		bts3.setChangeListener(this);
		bts3.setMargin(0, 5, 5, 5);
		
	    bts2 = new BitmapButtonField(Bitmap.getBitmapResource("calendario.png"), Bitmap.getBitmapResource("calendario1.png"));
		bts2.setChangeListener(this);
		bts2.setMargin(0, 5, 5, 5);
		
		bts5 = new BitmapButtonField(Bitmap.getBitmapResource("nota.png"),Bitmap.getBitmapResource("nota1.png"),BitmapButtonField.FIELD_RIGHT | BitmapButtonField.FIELD_TOP  );
		bts5.setChangeListener(this);
		bts5.setMargin(0, 5, 5, 5);

		contentup.add(bts1);
		content.add(bts3);
		content.add(bts5);
		contentdown.add(bts2);
		allcontent.add(contentup);
		allcontent.add(content);
		allcontent.add(contentdown);
		add(allcontent);
	}
	
	
	public void fieldChanged(Field field, int context) {
	// TODO Auto-generated method stub
		if(bts1== field){
			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 600);
	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
	        
	        UiEngineInstance engine = Ui.getUiEngineInstance();
	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new mision());
		}else if(bts2== field){
			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 600);
	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
	        UiEngineInstance engine = Ui.getUiEngineInstance();
	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			
			openScreen(new calendar());
		}else if(bts3== field){

    			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
    	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 600);
    	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
    	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
    	        
    	        UiEngineInstance engine = Ui.getUiEngineInstance();
    	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
            	
            	openScreen(new Noticias());
	    
		}else if(bts5== field){
			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 600);
	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
	        
	        UiEngineInstance engine = Ui.getUiEngineInstance();
	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			openScreen(new login());
		}
	}
	
	public boolean onClose() {
		//force the app to quit
		Dialog.alert("Saliendo de UFG APP");
		
		System.exit(0);
		return true;
	
	}
}