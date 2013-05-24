package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.samples.toolkit.ui.component.AutoScaleImageField;

import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class Historial extends Estilos
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
	
    public Historial()
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
		
		

		
		LabelField lblLunes 	= new LabelField("5",Field.FIELD_HCENTER);
		LabelField lblMartes 	= new LabelField("6",Field.FIELD_HCENTER);
		LabelField lblMiercoles = new LabelField("7",Field.FIELD_HCENTER);
		LabelField lblJueves 	= new LabelField("8",Field.FIELD_HCENTER);
		LabelField lblViernes 	= new LabelField("9",Field.FIELD_HCENTER);
		LabelField lblSabado 	= new LabelField("10",Field.FIELD_HCENTER);
		LabelField lblDomingo 	= new LabelField("11",Field.FIELD_HCENTER);
		
		
		
		HorizontalFieldManager hContent = new HorizontalFieldManager(HorizontalFieldManager.USE_ALL_WIDTH | HorizontalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_VCENTER);
		
		VerticalFieldManager cLunes = new VerticalFieldManager();
		cLunes.add(new BitmapField(Bitmap.getBitmapResource("h_flag_320.png")));
		cLunes.add(lblLunes);
		cLunes.add(new LabelField("Lu",Field.FIELD_HCENTER));
		
		VerticalFieldManager cMartes = new VerticalFieldManager();
		cMartes.add(new BitmapField(Bitmap.getBitmapResource("h_flag_320.png")));
		cMartes.add(lblMartes);
		cMartes.add(new LabelField("Ma",Field.FIELD_HCENTER));
		
		VerticalFieldManager cMiercoles = new VerticalFieldManager();
		cMiercoles.add(new BitmapField(Bitmap.getBitmapResource("h_flag_320.png")));
		cMiercoles.add(lblMiercoles);
		cMiercoles.add(new LabelField("Mi",Field.FIELD_HCENTER));
		
		VerticalFieldManager cJueves = new VerticalFieldManager();
		cJueves.add(new BitmapField(Bitmap.getBitmapResource("h_flag_320.png")));
		cJueves.add(lblJueves);
		cJueves.add(new LabelField("Ju",Field.FIELD_HCENTER));
		
		VerticalFieldManager cViernes = new VerticalFieldManager();
		cViernes.add(new BitmapField(Bitmap.getBitmapResource("h_single_320.png")));
		cViernes.add(lblViernes);
		cViernes.add(new LabelField("Vi",Field.FIELD_HCENTER));
		
		VerticalFieldManager cSabado = new VerticalFieldManager();
		cSabado.add(new BitmapField(Bitmap.getBitmapResource("h_single_320.png")));
		cSabado.add(lblSabado);
		cSabado.add(new LabelField("Sa",Field.FIELD_HCENTER));
		
		VerticalFieldManager cDomingo = new VerticalFieldManager();
		cDomingo.add(new BitmapField(Bitmap.getBitmapResource("h_single_320.png")));
		cDomingo.add(lblDomingo);
		cDomingo.add(new LabelField("Do",Field.FIELD_HCENTER));
		
		cLunes		.setMargin(5, 7, 5, 7);
		cMartes		.setMargin(5, 7, 5, 7);
		cMiercoles	.setMargin(5, 7, 5, 7);
		cJueves		.setMargin(5, 7, 5, 7);
		cViernes	.setMargin(5, 7, 5, 7);
		cSabado		.setMargin(5, 7, 5, 7);
		cDomingo	.setMargin(5, 7, 5, 7);
		
		hContent.add(cLunes);
		hContent.add(cMartes);
		hContent.add(cMiercoles);
		hContent.add(cJueves);	
		hContent.add(cViernes);
		hContent.add(cSabado);	
		hContent.add(cDomingo);
		add(hContent);
		//size logo
       
        
    }


}
