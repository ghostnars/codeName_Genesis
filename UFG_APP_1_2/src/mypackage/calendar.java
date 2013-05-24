package mypackage;

import packageCalendar.notiCalendar;
import packageCalendar.notiCalendar1;
import packageCalendar.notiCalendar10;
import packageCalendar.notiCalendar11;
import packageCalendar.notiCalendar2;
import packageCalendar.notiCalendar3;
import packageCalendar.notiCalendar4;
import packageCalendar.notiCalendar5;
import packageCalendar.notiCalendar6;
import packageCalendar.notiCalendar7;
import packageCalendar.notiCalendar8;
import packageCalendar.notiCalendar9;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.decor.BackgroundFactory;
import estilos.BitmapButtonField;

public  class calendar extends Metodos{

	BitmapButtonField b1, b2, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12;
	String value="";
	
	public calendar() {
		
		setTitle("Calendario");
		
		getMainManager().setBackground(BackgroundFactory.createSolidBackground(0x000000));
		
		
		
		bt1 = new BitmapButtonField(Bitmap.getBitmapResource("1ene.png"),Bitmap.getBitmapResource("11ene.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt1.setChangeListener(this);
		bt1.setMargin(2, 0, 2, 0);
		
		bt2 = new BitmapButtonField(Bitmap.getBitmapResource("2feb.png"),Bitmap.getBitmapResource("22feb.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt2.setChangeListener(this);
		bt2.setMargin(2, 0, 2, 0);

		bt3 = new BitmapButtonField(Bitmap.getBitmapResource("3mar.png"),Bitmap.getBitmapResource("33mar.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt3.setChangeListener(this);
		bt3.setMargin(2, 0, 2, 0);

		bt4 = new BitmapButtonField(Bitmap.getBitmapResource("4abr.png"),Bitmap.getBitmapResource("44abr.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt4.setChangeListener(this);
		bt4.setMargin(2, 0, 2, 0);
		
		bt5 = new BitmapButtonField(Bitmap.getBitmapResource("5may.png"),Bitmap.getBitmapResource("55may.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt5.setChangeListener(this);
		bt5.setMargin(2, 0, 2, 0);
		
		bt6 = new BitmapButtonField(Bitmap.getBitmapResource("6jun.png"),Bitmap.getBitmapResource("66jun.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt6.setChangeListener(this);
		bt6.setMargin(2, 0, 2, 0);
		
		bt7 = new BitmapButtonField(Bitmap.getBitmapResource("7jul.png"),Bitmap.getBitmapResource("77jul.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt7.setChangeListener(this);
		bt7.setMargin(2, 0, 2, 0);
		
		bt8 = new BitmapButtonField(Bitmap.getBitmapResource("8ago.png"),Bitmap.getBitmapResource("88ago.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt8.setChangeListener(this);
		bt8.setMargin(2, 0, 2, 0);
		
		bt9 = new BitmapButtonField(Bitmap.getBitmapResource("9sep.png"),Bitmap.getBitmapResource("99sep.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt9.setChangeListener(this);
		bt9.setMargin(2, 0, 2, 0);
		
		bt10 = new BitmapButtonField(Bitmap.getBitmapResource("10oct.png"),Bitmap.getBitmapResource("1010oct.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt10.setChangeListener(this);
		bt10.setMargin(2, 0, 2, 0);
		
		bt11 = new BitmapButtonField(Bitmap.getBitmapResource("11nov.png"),Bitmap.getBitmapResource("1111nov.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt11.setChangeListener(this);
		bt11.setMargin(2, 0, 2, 0);
		
		bt12 = new BitmapButtonField(Bitmap.getBitmapResource("12dic.png"),Bitmap.getBitmapResource("1212dic.png"), BitmapButtonField.FIELD_HCENTER | BitmapButtonField.FIELD_VCENTER);
		bt12.setChangeListener(this);
		bt12.setMargin(2, 0, 2, 0);
		
		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		add(bt5);
		add(bt6);
		add(bt7);
		add(bt8);
		add(bt9);
		add(bt10);
		add(bt11);
		add(bt12);
			
		}

	public void fieldChanged(Field field, int context) {
			
				if (bt1 == field) {
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar());
				}
				else if (bt2 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar1());
				}
				else if (bt3 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar2());
				}
				else if (bt4 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar3());
				}
				else if (bt5 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar4());
				}
				else if (bt6 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar5());
				}
				else if (bt7 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar6());
				}
				else if (bt8 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar7());
				}
				else if (bt9 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar8());
				}
				else if (bt10 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar9());
				}	
				else if (bt11 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar10());
				}
				else if (bt12 == field){
					TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
			        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
			        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
			        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
			        
			        UiEngineInstance engine = Ui.getUiEngineInstance();
			        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
					openScreen(new notiCalendar11());
				}
				
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