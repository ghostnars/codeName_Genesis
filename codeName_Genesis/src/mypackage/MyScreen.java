package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.samples.toolkit.ui.component.AutoScaleImageField;
import com.samples.toolkit.ui.component.BitmapButtonField;

import crearCueta.crearCuenta1;

import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class MyScreen extends Estilos
{
    /**
     * Creates a new MyScreen object
     */
	Bitmap _caret = Bitmap.getBitmapResource( "chevron_right_black_15x22.png" );
	Bitmap imgLogo = Bitmap.getBitmapResource( "logo.png" );
	Bitmap bannerImage;
	
	int tFuente;
	int topTitulo;
	Font fLite;
	Font fBold;
	
	VerticalFieldManager manager;
	AutoScaleImageField field;
	
	Bitmap btnNuevo;
	Bitmap btnNuevo1;
	Bitmap btnYa;
	Bitmap btnYa1;	
	
    public MyScreen()
    {        
    	
    	if (Display.getWidth() == 320)
		{
    		bannerImage = Bitmap.getBitmapResource("head_640.png");
			btnNuevo 	= Bitmap.getBitmapResource("3btn_nuevo_640.png");
			btnNuevo1 	= Bitmap.getBitmapResource("3btn_nuevo1_640.png");
			
			btnYa 	= Bitmap.getBitmapResource("3btn_ya_640.png");
			btnYa1 	= Bitmap.getBitmapResource("3btn_ya1_640.png");
			
			tFuente = 30;
			topTitulo = 13;
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
			topTitulo = 13;
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
        RichTextField tituloHead = new RichTextField("INGRESAR" , RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_HCENTER);
        tituloHead.setMargin(topTitulo, 0, 0, 0);
        head.add(tituloHead);
		setBanner(head);
		//End Banner
		
		
		
		VerticalFieldManager allContent = new VerticalFieldManager(USE_ALL_WIDTH | Field.FIELD_HCENTER | Field.FIELD_VCENTER);
		//size logo
        EncodedImage normalImage = EncodedImage.getEncodedImageResource( "logo.png" );
        long style = Field.FOCUSABLE | AutoScaleImageField.REDUCE_TO_WIDTH | AutoScaleImageField.REDUCE_TO_WIDTH;   
        manager = new VerticalFieldManager( USE_ALL_WIDTH | Field.FIELD_HCENTER | Field.FIELD_VCENTER );
        manager.setMargin( 10, 230, 10, 230 );
        //manager.setPadding( 16, 16, 16, 16 );        
        field = new AutoScaleImageField( normalImage, normalImage, style );   
        manager.add( field );
        allContent.add( manager );
        
        RichTextField info = new RichTextField("Lorem ipsum dolor sit amet, consectetuer adipiscing elit," +
        										" sed diam nonummy nibh euismod tincidunt ut laoreet dolore" +
        										" magna aliquam erat volutpat.", RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE);
        info.setFont(fLite);
        info.setMargin(5, 10, 5, 10);
        allContent.add(info);
		
        add(allContent);
        
        
        BitmapButtonField btnNuevoUser = new BitmapButtonField(btnNuevo,btnNuevo1,Field.FIELD_HCENTER);
        btnNuevoUser.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	pushScreen(new crearCuenta1());
            }
        });
        
        
        add(btnNuevoUser);
		BitmapButtonField btnYaUser = new BitmapButtonField(btnYa,btnYa1,Field.FIELD_HCENTER);
		btnYaUser.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	//pushScreen(new Listas());
            }
        });
        add(btnYaUser);
        
    }


}
