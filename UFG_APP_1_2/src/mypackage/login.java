package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.CoverageInfo;
import net.rim.device.api.system.WLANInfo;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.twmacinta.util.Autenticacion;

import estilos.BitmapButtonField;

public class login extends Metodos implements FieldChangeListener {
		BitmapButtonField boton,pinmovil;
		WLabelField lbluser , lblpwd;
		LabelField  label1;
		BasicEditField name;
		PasswordEditField pwd;
		ButtonField btm;

		String value="";
		String token = "";
    	Autenticacion verificar = new Autenticacion();
		
	public  login (){
		
		//setTitle("Ingresa a las notas de tus materias");
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK, Color.BLACK,Color.BLACK,Color.BLACK));
 		
		//getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK));
		  Bitmap bitmapfondo = Bitmap.getBitmapResource("fondologin.png");
		VerticalFieldManager fondo = new VerticalFieldManager(VerticalFieldManager.USE_ALL_WIDTH | VerticalFieldManager.FIELD_HCENTER);
		fondo.setBorder(BorderFactory.createBitmapBorder(new XYEdges(10,10,12,10), bitmapfondo));
		fondo.setMargin(5, 5, 5, 5);
	

        VerticalFieldManager contenido = new VerticalFieldManager(HorizontalFieldManager.USE_ALL_WIDTH | VerticalFieldManager.FIELD_HCENTER);
        VerticalFieldManager contenidov0 = new VerticalFieldManager(Field.FIELD_HCENTER);
        VerticalFieldManager contenidov1 = new VerticalFieldManager(Field.FIELD_HCENTER);
        
        Bitmap _bitmap = Bitmap.getBitmapResource("rounded-border1.png");
        VerticalFieldManager vfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
	    vfm.setBorder(BorderFactory.createBitmapBorder(new XYEdges(13,15,13,15), _bitmap));

	       

        lbluser = new WLabelField ("USUARIO");
        
        name = new BasicEditField("", "", 100, EditField.NO_NEWLINE){
        	public int getPreferredHeight(){
                return 70;
            }

            public int getPreferredWidth(){
                return 220;
            }

            public void layout(int width, int height){
            	setExtent(getPreferredWidth(), getPreferredHeight());
                super.layout(getPreferredWidth(), getPreferredHeight());
            }
        };
        
      
        name.setFont(getFont());
        name.setBackground( BackgroundFactory.createSolidTransparentBackground( Color.WHITE, 50 ) );
        name.setMargin(0, 0, 0, 0);
        name.setPadding(0,0,0,0);
      
        VerticalFieldManager vfm1 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
	    vfm1.setBorder(BorderFactory.createBitmapBorder(new XYEdges(13,15,13,15), _bitmap));
	    
        lblpwd = new WLabelField ("CONTRASEÑA");
        
        pwd = new PasswordEditField("", "", 100, EditField.NO_NEWLINE){
        	public int getPreferredHeight(){
                return 70;
            }

            public int getPreferredWidth(){
                return 220;
            }

            public void layout(int width, int height){
                setExtent(getPreferredWidth(), getPreferredHeight());
                super.layout(getPreferredWidth(), getPreferredHeight());
            }
        };
        pwd.setFont(getFont());
        pwd.setBackground( BackgroundFactory.createSolidTransparentBackground( Color.WHITE, 50 ) );
        pwd.setMargin(0, 0, 0, 0);
        pwd.setPadding(0,0,0,0);
        VerticalFieldManager vfm2 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
        VerticalFieldManager vfm3 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
        
        vfm.add(name);
        vfm1.add(pwd);
        vfm2.add(lbluser);
        vfm3.add(lblpwd);
        contenidov0.setMargin(90, 0, 20, 0);
        contenidov1.setMargin(30, 0, 20, 0);
        contenidov0.add(vfm2);
        contenidov0.add(vfm);
        contenidov1.add(vfm3);
        contenidov1.add(vfm1);

        contenido.add(contenidov0);
        contenido.add(contenidov1);
        fondo.add(contenido);

		boton = new BitmapButtonField(Bitmap.getBitmapResource("acceder4.png"), Bitmap.getBitmapResource("acceder3.png"),BitmapButtonField.FIELD_BOTTOM);
		boton.setChangeListener(this);
		boton.setMargin(45,0,45,85);
		fondo.add(boton);
		
     	pinmovil = new BitmapButtonField(Bitmap.getBitmapResource("pinmovil.png"), Bitmap.getBitmapResource("pinmovil1.png"),BitmapButtonField.FIELD_BOTTOM);
       	pinmovil.setChangeListener(this);
       	pinmovil.setMargin(20,0,15,0);
 		fondo.add(pinmovil);
       	add(fondo);

		
	}

	public void fieldChanged(Field field, int context) {
		if ( pinmovil == field){
			openScreen(new image());
		}
	if ( boton == field){
			final String destination = this.name.getText();
			final String destination1 = this.pwd.getText();
			
	        if ((destination == null) || (destination1 == null)   ){
	            Dialog.alert("Inserte su Usuario");
	            return;
	        }
	        
            if (CoverageInfo. isOutOfCoverage ()){
            	Dialog.alert ("No hay conexion. Por favor, intente de nuevo.");
            	// return "";
            }else if (WLANInfo. getWLANState () == WLANInfo. WLAN_STATE_CONNECTED ){
            	//Dialog. alert ("Inalambricos encontrados");
            	token = verificar.validar(name.getText(), pwd.getText());
            	if (token == ""){
            		Dialog. alert ("Usuario y/o Contraseña no son Validos");
            	}else if(token == "error"){
            		Dialog. alert ("Usted no posee conexion a internet. Tiene que estar conectado a WI-FI o tener plan de datos habilitado");
            	}else{
            		openScreen(new materias(token,"d8dc4f3276a19391c160b7e6b65c4a10", name.getText(), pwd.getText()));
            		value="deviceside=true";
            	}
            	value="interface=wifi";
            	// return "";
            }else{
            	// Web Service...
            	token = verificar.validar(name.getText(), pwd.getText());
            	
            	if (token == ""){
            		Dialog. alert ("Usuario y/o Contraseña no son Validos");
            	}else if(token == "error"){
            		Dialog. alert ("Usted no posee conexion a internet. Tiene que estar conectado a WI-FI o tener plan de datos habilitado");
            	}else{
            		TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
        	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 500);
        	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
        	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        	        UiEngineInstance engine = Ui.getUiEngineInstance();
        	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
            		openScreen(new materias(token,"d8dc4f3276a19391c160b7e6b65c4a10", name.getText(), pwd.getText()));
            		value="deviceside=true";
            	}
            }
		}
	}
	

	public boolean onClose() {
		TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 300);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new principal());
		return true;
	}
}