package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.NullField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import Feed.Feed1;

import com.samples.toolkit.ui.component.AutoScaleImageField;
import com.samples.toolkit.ui.component.BitmapButtonField;
import com.samples.toolkit.ui.component.BitmapGaugeField;
import com.samples.toolkit.ui.component.ListStyleButtonField;
import com.samples.toolkit.ui.container.ListStyleButtonSet;

import eligeHabito.EligeHabito1;
import estilos.Estilos;
import estilos.Estilos.ColorText;
import estilos.Estilos.HorizontalField;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class Home extends Estilos implements FieldChangeListener
{
	Bitmap caret = Bitmap.getBitmapResource( "chevron_right_black_15x22.png" );
	Bitmap imgLogo = Bitmap.getBitmapResource( "logo.png" );
	Bitmap bordes = Bitmap.getBitmapResource("bordes1.png");
	
	Bitmap bannerImage;
	
	int tFuente;
	
	Font fLite;
	Font fBold;
	
	VerticalFieldManager manager;
	AutoScaleImageField field;
	
	Bitmap btnOrange;
	Bitmap btnOrange1;
	Bitmap btnNuevo;
	Bitmap btnNuevo1;
	ListStyleButtonField one;
	BitmapButtonField btnOrangina;	
	/**
     * Creates a new MyScreen object
     */
	Bitmap gaugeBack2 = Bitmap.getBitmapResource( "gauge_back_2.png" );
    Bitmap gaugeProgress2 = Bitmap.getBitmapResource( "gauge_progress_2.png" );
    public Home()
    {        
    	//getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK));
		//getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
    	if (Display.getWidth() == 320)
		{
			bannerImage = Bitmap.getBitmapResource("head_320.png");
			btnOrange 	= Bitmap.getBitmapResource("oran_1.png");
			btnOrange1 	= Bitmap.getBitmapResource("oran.png");
			
			btnNuevo 	= Bitmap.getBitmapResource("3btn_ya_320.png");
			btnNuevo1 	= Bitmap.getBitmapResource("3btn_ya1_320.png");		
			
			tFuente = 16;
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
			btnOrange 	= Bitmap.getBitmapResource("oran_1.png");
			btnOrange1 	= Bitmap.getBitmapResource("oran.png");
			
			btnNuevo 	= Bitmap.getBitmapResource("3btn_ya_640.png");
			btnNuevo1 	= Bitmap.getBitmapResource("3btn_ya1_640.png");		
			
			tFuente = 30;
		}
		
		try
		 {
		 	FontFamily ffFont = FontFamily.forName("Arial");
		 	fBold = ffFont.getFont(Font.BOLD, tFuente );
		 	
		 	FontFamily ffFont1 = FontFamily.forName("Arial");
		 	fLite = ffFont1.getFont(Font.ITALIC, tFuente - 2);
		 	
		 }catch (ClassNotFoundException e){
		 	   System.out.println(e.getMessage());
		 }
		
    	/**Banner*/
		getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));    	
		HorizontalField head = new HorizontalField(bannerImage.getWidth(),bannerImage.getHeight(),HorizontalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_VCENTER);	
        head.setBackground(BackgroundFactory.createBitmapBackground(bannerImage));
        ColorText tituloHead = new ColorText("HOME",0x374f5c ,RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_HCENTER);
        tituloHead.setMargin(5, 0, 0, 0);
        tituloHead.setFont(fBold);
        head.add(tituloHead);
		setBanner(head);
		/**End Banner*/

		
		/**contenido1*/
		
		VerticalFieldManager allContent1 = new VerticalFieldManager();
		allContent1.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
		allContent1.setMargin(5, 5, 5, 5);
		
		HorizontalFieldManager contentNivel = new HorizontalFieldManager(HorizontalFieldManager.FIELD_LEFT);
		
		LabelField lblNivel = new LabelField("NIVEL 20", LabelField.FIELD_LEFT);
		lblNivel.setFont(fBold);
		lblNivel.setMargin(10, 10, 5, 5);
		contentNivel.add(lblNivel);
		
		LabelField lblPuntos = new LabelField("3,259 PUNTOS", LabelField.FIELD_RIGHT);
		lblPuntos.setFont(fBold);
		lblPuntos.setMargin(10, 10, 5, 90);
		contentNivel.add(lblPuntos);
		
		VerticalFieldManager contentPorcentage = new VerticalFieldManager();
		
		ColorText lblRestantes = new ColorText("8,349 PUNTOS PARA NIVEL 21",Color.DIMGRAY,0);
		lblRestantes.setFont(fLite);
		lblRestantes.setMargin(5, 10, 5, 5);
		contentPorcentage.add(lblRestantes);
        
        BitmapGaugeField bitGauge3 = new BitmapGaugeField( gaugeBack2, gaugeProgress2, 10, 5, 7, 7, 3, 3, true );
        bitGauge3.setPadding(5, 5, 5, 5);
        contentPorcentage.add(bitGauge3);    
        contentPorcentage.add( new NullField( Field.FOCUSABLE ) );  
		
		VerticalFieldManager contentLogros = new VerticalFieldManager();
		
		ColorText lblLogro = new ColorText("LOGROS",0x374f5c ,0 );
		lblLogro.setFont(fBold);
		lblLogro.setMargin(10, 10, 5, 5);
		
		
        HorizontalFieldManager cEstrellas = new HorizontalFieldManager();              
		cEstrellas.setMargin( 5, 0, 5, 5 );
		
		for(int i = 0; i <= 3;i++){
			cEstrellas.add(new BitmapField(Bitmap.getBitmapResource("star.png")));
			
		}
		
		contentLogros.add(lblLogro);
		contentLogros.add( cEstrellas );
				
		contentNivel.setMargin(0, 10, 10, 0);
		
		allContent1.add(contentNivel);
		allContent1.add(contentPorcentage);
		allContent1.add(contentLogros);
		add(allContent1);
		
		/**end contenido1*/
		
		/**contenido2*/
		
		VerticalFieldManager allContent2 = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | VerticalFieldManager.USE_ALL_WIDTH);
		allContent2.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
		//allContent2.setMargin(10, 10, 10, 10);
		
		HorizontalFieldManager contentDetalle = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER);
		
		ColorText lblHabito = new ColorText("HABITOS",0x374f5c ,0);
		lblHabito.setFont(fBold);
		lblHabito.setMargin(5, 10, 15, 10);
		contentDetalle.add(lblHabito);
		
		HorizontalFieldManager allContentHabitos = new HorizontalFieldManager(HorizontalFieldManager.FIELD_LEFT);
		
		VerticalFieldManager contentHabitos = new VerticalFieldManager(VerticalFieldManager.FIELD_LEFT);
		
		ColorText lblActuales = new ColorText("3 ACTUALES",0x374f5c , LabelField.FIELD_LEFT);
		lblActuales.setFont(fLite);
		lblActuales.setMargin(5, 20, 5, 20);
		contentHabitos.add(lblActuales);
		
		ColorText lblCompletados = new ColorText("2 COMPLETADOS",0x374f5c , LabelField.FIELD_LEFT);
		lblCompletados.setFont(fLite);
		lblCompletados.setMargin(5, 20, 5, 20);
		contentHabitos.add(lblCompletados);
		
		allContentHabitos.add(contentHabitos);
				
		BitmapField bfImagen = new BitmapField(Bitmap.getBitmapResource("imgMewe.png"));
		allContentHabitos.add(bfImagen);
		
		//HorizontalFieldManager contentBoton = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER);
        BitmapButtonField btnNuevoHabito = new BitmapButtonField(btnNuevo,btnNuevo1,Field.FIELD_HCENTER);
        btnNuevoHabito.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	pushScreen(new EligeHabito1());        	
            }
        });
        
        btnNuevoHabito.setPadding(15,0,15,0);
        //add(btnNuevoHabito);
		allContent2.add(contentDetalle);
		//allContent2.add(contentHabitos);
		allContent2.add(allContentHabitos);
		allContent2.add(btnNuevoHabito);
		add(allContent2);
		
		/**end contenido2*/
		
		
		/**contenido3*/     
		VerticalFieldManager allContent3 = new VerticalFieldManager(VerticalFieldManager.FIELD_LEFT);	
		
        VerticalFieldManager contentFeed = new VerticalFieldManager(VerticalFieldManager.FIELD_LEFT);
		contentFeed.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
		//contentFeed.setMargin(0, 10, 10, 0);
		
		LabelField lblFeed = new LabelField("FEED", LabelField.FIELD_LEFT);
		lblFeed.setFont(fBold);
		lblFeed.setMargin(5, 0, 5, 10);
		contentFeed.add(lblFeed);
		ListStyleButtonSet listStyle = new  ListStyleButtonSet();
		one   = new ListStyleButtonField( "Nacho te ha mencionado", caret );
        one.setChangeListener( this );
        listStyle.add( one );
		contentFeed.add( listStyle );
        allContent3.add(contentFeed);
        
        
		VerticalField contentOrangina = new VerticalField(Display.getWidth()-25,btnOrange.getHeight(),0);
		contentOrangina.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
		//contentOrangina.setMargin(0, 10, 10, 0);
		
        btnOrangina = new BitmapButtonField(btnOrange,btnOrange1,BitmapButtonField.FIELD_HCENTER );
        btnOrangina.setChangeListener(this);
        btnOrangina.setMargin(0, 0, 0, 100);
        contentOrangina.add(btnOrangina);
        allContent3.add(contentOrangina);
        add(allContent3);
        
		/**end contenido3*/
        


    }
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if(one == field){
			pushScreen(new Feed1());
			
		}
		if(btnOrangina == field){
			Status.show("Orangina",1000);
		}
	}
	
}
