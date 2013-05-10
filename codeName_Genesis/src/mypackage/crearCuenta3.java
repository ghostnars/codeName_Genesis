package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.AutoScaleImageField;
import com.samples.toolkit.ui.component.BitmapButtonField;

import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class crearCuenta3 extends Estilos
{
	Bitmap _caret = Bitmap.getBitmapResource( "chevron_right_black_15x22.png" );
	Bitmap imgLogo = Bitmap.getBitmapResource( "logo.png" );
	Bitmap bannerImage;
	Bitmap bordes = Bitmap.getBitmapResource("bordes.png");
	
	int tFuente;
	
	Font fLite;
	Font fBold;
	
	VerticalFieldManager manager;
	AutoScaleImageField field;
	
	Bitmap btnNuevo;
	Bitmap btnNuevo1;
	Bitmap btnYa;
	Bitmap btnYa1;
	PasswordEditField txtPass;
	BasicEditField txtCorreo;	
	/**
     * Creates a new MyScreen object
     */
    public crearCuenta3()
    {        
    	if (Display.getWidth() == 320)
		{
			bannerImage = Bitmap.getBitmapResource("titulo_320.png");
			tFuente = 20;
		}
		if (Display.getWidth() == 360)
		{
			bannerImage = Bitmap.getBitmapResource("titulo_360.png");
			tFuente = 25;
		}
		if (Display.getWidth() == 480)
		{
			bannerImage = Bitmap.getBitmapResource("titulo_480.png");	
			tFuente = 28;		
		}	
		if (Display.getWidth() == 640)
			
		{
			bannerImage = Bitmap.getBitmapResource("head_640.png");
			btnNuevo 	= Bitmap.getBitmapResource("3btn_nuevo_640.png");
			btnNuevo1 	= Bitmap.getBitmapResource("3btn_nuevo1_640.png");
			
			btnYa 	= Bitmap.getBitmapResource("3btn_ya_640.png");
			btnYa1 	= Bitmap.getBitmapResource("3btn_ya1_640.png");
			
			tFuente = 30;
		}
		
		try
		 {
		 	FontFamily ffFont = FontFamily.forName("Arial");
		 	fBold = ffFont.getFont(Font.BOLD, tFuente );
		 	
		 	FontFamily ffFont1 = FontFamily.forName("Arial");
		 	fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente - 2);
		 	
		 }catch (ClassNotFoundException e){
		 	   System.out.println(e.getMessage());
		 }
		
    	//Banner
		HorizontalFieldManager head = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_VCENTER){
            public int getPreferredWidth()
            {
                return bannerImage.getWidth();
            }
            public int getPreferredHeight()
            {
                return bannerImage.getHeight();
            }  
            protected void sublayout( int maxWidth, int maxHeight )
            {
                super.sublayout(getPreferredWidth(), getPreferredHeight());
                setExtent(getPreferredWidth(), getPreferredHeight());
            }
        };	
        head.setBackground(BackgroundFactory.createBitmapBackground(bannerImage));
		head.add(new RichTextField("CREAR CUENTA" , RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE));
		setBanner(head);
		//End Banner
		
		//Title
		LabelField info = new LabelField("INTRODUCE LOS SIGUIENTES CAMPOS", RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER );
		info.setFont(fLite);
		info.setMargin(30, 20, 30, 20);
		add(info);
		//End Title
		
		/**campo correo*/
		VerticalFieldManager vfmCorreo = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER) {
            public int getPreferredWidth()
            {
                return 500;
            }
            public int getPreferredHeight()
            {
                return 30;
            }
            protected void sublayout( int maxWidth, int maxHeight )
            {
                super.sublayout(getPreferredWidth(), getPreferredHeight());
                setExtent(getPreferredWidth(), getPreferredHeight());
            }
        };
        vfmCorreo.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
        //vfmCorreo.setMargin(top, 0, bottom, 0);
        txtCorreo = new BasicEditField("Correo: ", "", 30,BasicEditField.FILTER_DEFAULT);      
        vfmCorreo.add(txtCorreo);
       	add(vfmCorreo);
       	/**end campo correo*/
       	
       	
		/**campo password*/
		VerticalFieldManager vfmPass = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER) {
            public int getPreferredWidth()
            {
                return 500;
            }
            public int getPreferredHeight()
            {
                return 30;
            }
            protected void sublayout( int maxWidth, int maxHeight )
            {
                super.sublayout(getPreferredWidth(), getPreferredHeight());
                setExtent(getPreferredWidth(), getPreferredHeight());
            }
        };
        vfmPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
        //vfmCorreo.setMargin(top, 0, bottom, 0);
        txtPass = new PasswordEditField ("Password: ", "", 20,BasicEditField.FILTER_DEFAULT);      
        vfmPass.add(txtPass);
       	add(vfmPass);
       	/**end campo password*/
       	
       	
        BitmapButtonField btnYaUser = new BitmapButtonField(btnYa,btnYa1,Field.FIELD_HCENTER);
        btnYaUser.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	//pushScreen(new crearCuenta2());
            	Dialog.alert(txtPass.getText());
            }
        });
        add(btnYaUser);
        //Head
        LabelField infoTerminos = new LabelField("Dándote de alta en nuestro servicio aceptas nuestros Términos de Servicio y Privacidad", RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE );
        infoTerminos.setFont(fLite);
        infoTerminos.setMargin(40, 20, 30, 20);
  		add(infoTerminos);
  		//End Head
       
    }
}
