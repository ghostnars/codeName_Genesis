package packageCalendar;

import estilos.BitmapButtonField;

import mypackage.Metodos;
import mypackage.calendar;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

public class notiCalendar2 extends Metodos{
	BitmapButtonField amarillo,gris, verde, rojo, rosado;
	String value="";
	public notiCalendar2(){
		super();

		setTitle("Calendario Marzo");
		
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK, Color.BLACK,Color.BLACK,Color.BLACK));
		
Bitmap borderBitmap = Bitmap.getBitmapResource("barrac.png");
		
			
		
		
		HorizontalFieldManager Panel1 = new HorizontalFieldManager(Field.USE_ALL_WIDTH);
		Panel1.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,5,5,5), borderBitmap));
		amarillo = new BitmapButtonField(Bitmap.getBitmapResource("yellow.png"), Bitmap.getBitmapResource("yellow1.png") );
		Panel1.setMargin(5, 5, 5, 5);
		
		HorizontalFieldManager Panel2 = new HorizontalFieldManager(Field.FIELD_HCENTER | Field.USE_ALL_WIDTH);
		Panel2.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,5,5,5), borderBitmap));
		verde = new BitmapButtonField(Bitmap.getBitmapResource("green.png"), Bitmap.getBitmapResource("green1.png") );		
		Panel2.setMargin(0, 5, 0, 5);
		
		HorizontalFieldManager Panel3 = new HorizontalFieldManager(Field.FIELD_HCENTER | Field.USE_ALL_WIDTH);
		Panel3.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,5,5,5), borderBitmap));
		gris = new BitmapButtonField(Bitmap.getBitmapResource("gray.png"), Bitmap.getBitmapResource("gray1.png") );
		Panel3.setMargin(5, 5, 5, 5);
		
		HorizontalFieldManager Panel4 = new HorizontalFieldManager(Field.FIELD_HCENTER | Field.USE_ALL_WIDTH);
		Panel4.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,5,5,5), borderBitmap));
		rojo = new BitmapButtonField(Bitmap.getBitmapResource("red.png"), Bitmap.getBitmapResource("red1.png") );		
		Panel4.setMargin(5, 5, 0, 5);
		
		HorizontalFieldManager Panel5 = new HorizontalFieldManager(Field.FIELD_HCENTER | Field.USE_ALL_WIDTH);
		Panel5.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,5,5,5), borderBitmap));
		rosado = new BitmapButtonField(Bitmap.getBitmapResource("pink.png"), Bitmap.getBitmapResource("pink1.png") );
		Panel5.setMargin(5, 5, 5, 5);
 
		
		WLabelField  r1 = new WLabelField("Vacación o Asueto \n (Del 1 al 2 de enero)");
		WLabelField  r2 = new WLabelField("Desarrollo de Clases");
		WLabelField  r3 = new WLabelField("Curso Propedéutico \n (Del 3 al 15 de enero)");
		WLabelField  r4 = new WLabelField("Pruebas Parciales \n (Del 19 al 25 de marzo)");
		WLabelField  r5 = new WLabelField("Pruebas Parciales Diferidas \n (4 marzo)");
		
		r1.setMargin(5, 0, 9, 10);
		r2.setMargin(5, 0, 9, 10);
		r3.setMargin(5, 0, 9, 10);
		r4.setMargin(5, 0, 9, 10);
		r5.setMargin(5, 0, 9, 10);
		
		Panel1.add(amarillo);
		Panel1.add(r1);
		Panel2.add(verde);
		Panel2.add(r2); 
		Panel3.add(gris);
		Panel3.add(r3);
		Panel4.add(rojo);
		Panel4.add(r4);
		Panel5.add(rosado);
		Panel5.add(r5);
 
		//add(Panel1);
		add(Panel2);
		//add(Panel3);
		add(Panel4);
		add(Panel5);
		
		 
	}
	
	public void fieldChanged(Field field, int context) {
	
	}
	
	public boolean onClose() {
		TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new calendar());
		return true;
	}

}