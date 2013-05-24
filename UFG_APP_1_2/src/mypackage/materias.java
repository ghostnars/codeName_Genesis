package mypackage;


import java.util.Vector;
import com.twmacinta.util.Autenticacion;
import estilos.BitmapButtonField;
import ws.WsMovilSoap_Stub;
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
import notas.*;

public class materias extends Metodos{

		BitmapButtonField bts1 , bts2 , bts3 , bts4,bts5,boton;
		Bitmap caret = Bitmap.getBitmapResource("arrow.png");
		BitmapButtonField materia1,materia2,materia3,materia4,materia5,materia6,materia7;
		BitmapButtonField[] materias={materia1,materia2,materia3,materia4,materia5,materia6,materia7};
		Vector test = new Vector();
		protected String _login;
		protected String _password;
		protected String _usuario;
		protected String _claveus;
		String carnet="";
		String code="";
		String value="";
		String token = "";
		String userufg = "";
		String pwdufg  = "";
    	Autenticacion verificar = new Autenticacion();
	
	public materias(String name, String password, String user, String pwdus){

		_login = name;
		_password = password;
		_usuario = user;
		_claveus = pwdus;
		
	
		setTitle("Materias");		
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK));
		
			try{ 
			
    		carnet = _login;
    	    code   =_password; 
    	    userufg = _usuario;
    	    pwdufg  = _claveus;
    		
    		WsMovilSoap_Stub service= new WsMovilSoap_Stub();    	
    		ws.ArrayOfAsignaturaInscrita result= service.recuperarAsignaturasInscritas(carnet, code);
    		
    		token = verificar.validar(userufg, pwdufg);
    		
    		for(int i=0;i<=result.getAsignaturaInscrita().length ;i++){

    			
    		    //CREAR BOTON "FLECHA" CON HOOVER PARA CADA LISTA ESTA LLEVA LA ACCION PARA PASAR SCREEN
    			materias[i] = new BitmapButtonField(Bitmap.getBitmapResource("arrow.png"), Bitmap.getBitmapResource("arrow1.png"), BitmapButtonField.FIELD_LEFT);
    			materias[i].setChangeListener(this);
    			materias[i].setMargin(20, 0, 20, 8);
    			
    			//ASIGNA TEXTO AL EL ELEMENTO DE LISTA
    			WLabelField text = new WLabelField(result.getAsignaturaInscrita()[i].getNombreAsignatura());
    			text.setMargin(17, 0, 5, 15);
    			//CREAR ELEMENTO DE LISTA
    	    	Bitmap elementoBitmap = Bitmap.getBitmapResource("fondomaterias.png");
    			HorizontalFieldManager elementolista = new HorizontalFieldManager(Field.USE_ALL_WIDTH);
    			elementolista.setBorder(BorderFactory.createBitmapBorder(new XYEdges(1,1,1,1), elementoBitmap));
    			
    			//AGREGAR A PANTALLA CADA ELEMENTO
    			
    			elementolista.add(materias[i]);
    			elementolista.add(text);
    			elementolista.setMargin(4, 5, 4, 5);
    			add(elementolista);
    		}
			}catch(Exception z ){    			    	
			}
			
		
		}
	 
	public void fieldChanged(Field field, int context) {
	
			if(materias[0]== field){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
    	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
    	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
    	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
    	        UiEngineInstance engine = Ui.getUiEngineInstance();
    	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
				
				openScreen(new notas1(token ,code,0,userufg, pwdufg));
			}	
			else if(materias[1]== field){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
    	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
    	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
    	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
    	        UiEngineInstance engine = Ui.getUiEngineInstance();
    	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
				
				openScreen(new notas1(token ,code,1,userufg, pwdufg));
			}	
			else if(materias[2]== field){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
    	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
    	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
    	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
    	        UiEngineInstance engine = Ui.getUiEngineInstance();
    	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
				
				openScreen(new notas1(token ,code,2,userufg, pwdufg));
			}
			else if(materias[3]== field){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
    	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
    	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
    	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
    	        UiEngineInstance engine = Ui.getUiEngineInstance();
    	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
				
				openScreen(new notas1(token ,code,3,userufg, pwdufg));
			}
			else if(materias[4]== field){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
    	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
    	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
    	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
    	        UiEngineInstance engine = Ui.getUiEngineInstance();
    	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
				
				openScreen(new notas1(token ,code,4,userufg, pwdufg));
			}	
			else if(materias[5]== field){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
    	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
    	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
    	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
    	        UiEngineInstance engine = Ui.getUiEngineInstance();
    	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
				
				openScreen(new notas1(token ,code,5,userufg, pwdufg));
			}	
			else if(materias[6]== field){
				TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
    	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 400);
    	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
    	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
    	        UiEngineInstance engine = Ui.getUiEngineInstance();
    	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
				
				openScreen(new notas1(token ,code,6,userufg, pwdufg));
			}
	}
	
	
	
	public boolean onClose() {
		TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 300);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new login());
		return true;
	 }
}