package crearCueta;

import mypackage.Home;
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
import com.samples.toolkit.ui.component.LabeledSwitch;
import com.samples.toolkit.ui.container.JustifiedHorizontalFieldManager;

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
	
    Bitmap switch_left = Bitmap.getBitmapResource("switch_left.png");
    Bitmap switch_right = Bitmap.getBitmapResource("switch_right.png");
    Bitmap switch_left_focus = Bitmap.getBitmapResource("switch_left_focus.png");
    Bitmap switch_right_focus = Bitmap.getBitmapResource("switch_right_focus.png");
    
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
    		bannerImage = Bitmap.getBitmapResource("head_320.png");
			btnNuevo 	= Bitmap.getBitmapResource("3btn_nuevo_320.png");
			btnNuevo1 	= Bitmap.getBitmapResource("3btn_nuevo1_320.png");
			
			btnYa 	= Bitmap.getBitmapResource("3btn_ya_320.png");
			btnYa1 	= Bitmap.getBitmapResource("3btn_ya1_320.png");
			
			tFuente = 18;
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
		info.setMargin(10, 20, 10, 20);
		add(info);
		//End Title
		
		/**campo nombre*/
		VerticalFieldManager vfmNombre = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER) {
            public int getPreferredWidth()
            {
                return 270;
            }
            public int getPreferredHeight()
            {
                return 20;
            }
            protected void sublayout( int maxWidth, int maxHeight )
            {
                super.sublayout(getPreferredWidth(), getPreferredHeight());
                setExtent(getPreferredWidth(), getPreferredHeight());
            }
        };
        vfmNombre.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
        //vfmNombre.setMargin(top, 0, bottom, 0);
        txtCorreo = new BasicEditField("Nombre: ", "", 30,BasicEditField.FILTER_DEFAULT);      
        vfmNombre.add(txtCorreo);
       	add(vfmNombre);
       	/**end campo nombre*/
       	
       	
		/**campo genero*/
       	HorizontalFieldManager hfmGenero = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER);
        LabeledSwitch callSwitch = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "Masculino", "Femenino", true );
        JustifiedHorizontalFieldManager phoneCalls = new JustifiedHorizontalFieldManager( new LabelField( "" ), callSwitch, false, (USE_ALL_WIDTH/2)+(USE_ALL_WIDTH/4) );
        phoneCalls.setPadding(5,5,5,5);
        hfmGenero.add(phoneCalls);
        hfmGenero.setPadding(10,0,10,0);
       	add(hfmGenero);
       	/**end campo genero*/
       	
       	
        BitmapButtonField btnYaUser = new BitmapButtonField(btnYa,btnYa1,Field.FIELD_HCENTER);
        btnYaUser.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	pushScreen(new Home());
            	
            }
        });
        btnYaUser.setPadding(10,0,15,0);
        add(btnYaUser);
       
    }
	public boolean onClose() {
		pushScreenBack(new crearCuenta2());
		return true;
	}
}
