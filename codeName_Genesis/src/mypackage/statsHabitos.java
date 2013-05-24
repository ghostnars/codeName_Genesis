package mypackage;

import java.util.Vector;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.NullField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.FlowFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.samples.toolkit.ui.component.AutoScaleImageField;
import com.samples.toolkit.ui.component.BitmapGaugeField;
import com.samples.toolkit.ui.component.PillButtonField;
import com.samples.toolkit.ui.container.NegativeMarginVerticalFieldManager;
import com.samples.toolkit.ui.container.PillButtonSet;

import eligeHabito.EligeHabito1;
import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class statsHabitos extends Estilos implements FieldChangeListener
{
	Bitmap caret = Bitmap.getBitmapResource( "chevron_right_black_15x22.png" );
	Bitmap imgLogo = Bitmap.getBitmapResource( "icon.png" );
    Bitmap bordes = Bitmap.getBitmapResource("bordes.png");
    EncodedImage normalImage = EncodedImage.getEncodedImageResource( "icon.png" );
	Bitmap gaugeBack2 = Bitmap.getBitmapResource( "gauge_back_2.png" );
    Bitmap gaugeProgress2 = Bitmap.getBitmapResource( "gauge_progress_2.png" );
	Bitmap bannerImage;
	long style = Field.NON_FOCUSABLE | AutoScaleImageField.REDUCE_TO_WIDTH | AutoScaleImageField.REDUCE_TO_WIDTH;
	int tFuente;
	
	Font fLite;
	Font fBold;
	
	VerticalFieldManager manager;
	AutoScaleImageField field,field1,field2;
	
	Bitmap btnNuevo;
	Bitmap btnNuevo1;
	Bitmap btnYa;
	Bitmap btnYa1;
	
    Manager _contentOne;
    Manager _contentTwo;
    Manager _contentThree;
    
    Manager _bodyWrapper;
    Manager _currentBody;
    
    Vector lista = new Vector();
	//private VerticalFieldManager vfmanager;
	/**
     * Creates a new MyScreen object
     */
    public statsHabitos()
    {        
    	
    	if (Display.getWidth() == 320)
		{
    		bannerImage = Bitmap.getBitmapResource("head_320.png");
			btnNuevo 	= Bitmap.getBitmapResource("3btn_nuevo_640.png");
			btnNuevo1 	= Bitmap.getBitmapResource("3btn_nuevo1_640.png");
			
			btnYa 	= Bitmap.getBitmapResource("3btn_ya_640.png");
			btnYa1 	= Bitmap.getBitmapResource("3btn_ya1_640.png");
			
		
			
			tFuente = 16;
		}
		if (Display.getWidth() == 360)
		{
			bannerImage = Bitmap.getBitmapResource("titulo_360.png");
			tFuente = 25;
		}
		if (Display.getWidth() == 480)
		{
			bannerImage = Bitmap.getBitmapResource("head_480.png");
			//bannerImage = Bitmap.getBitmapResource("titulo_480.png");	
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
		head.add(new RichTextField("HÁBITOS" , RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE));
		setBanner(head);
		//End Banner
		
		/**PillButtons*/
		
		Manager foreground = new foregroundManager();
        
        PillButtonSet pills = new PillButtonSet();
        PillButtonField pillOne = new PillButtonField( "Semana" );
        PillButtonField pillTwo = new PillButtonField( "Estadisticas" );
        PillButtonField pillThree = new PillButtonField( "Tips" );
        pills.add( pillOne );
        pills.add( pillTwo );
        pills.add( pillThree );
        //pills.setPadding( 5, 0, 5, 0 );
        foreground.add( pills );
        
        
        _bodyWrapper = new NegativeMarginVerticalFieldManager( USE_ALL_WIDTH );
        /**PillButtons One*/ 
        _contentOne = new FlowFieldManager();
       // _contentOne.add( new ListStyleButtonField( imgLogo,"Home",null, 0 ) ); 
       /**allContent*/
        VerticalFieldManager allContent = new VerticalFieldManager();
        
		HorizontalFieldManager contentNivel = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER);
		
		LabelField lblNivel = new LabelField("3,259 PUNTOS", LabelField.FIELD_LEFT);
		lblNivel.setFont(fBold);
		lblNivel.setMargin(5, 10, 0, 10);
		contentNivel.add(lblNivel);
		
		LabelField lblPuntos = new LabelField("23 VAMOS", LabelField.FIELD_RIGHT);
		lblPuntos.setFont(fBold);
		lblPuntos.setMargin(5, 10, 0, 100);
		contentNivel.add(lblPuntos);
		
		
        HorizontalFieldManager cEstrellas = new HorizontalFieldManager();              
		cEstrellas.setMargin( 10, 0, 10, 5 );
		
		for(int i = 0; i <= 3;i++){
			cEstrellas.add(new BitmapField(Bitmap.getBitmapResource("star.png")));
			
		}
		
		
		
		
		/**Rendimiento*/
		HorizontalFieldManager contentRendimiento = new HorizontalFieldManager();
		
		LabelField lblRendimiento = new LabelField("RENDIMIENTO", RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER );
		lblRendimiento.setFont(fLite);	
		contentRendimiento.add(lblRendimiento);
		
		LabelField lblPercentRendimiento = new LabelField("50%", RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER );
		lblPercentRendimiento.setFont(fLite);
		lblPercentRendimiento.setMargin(1, 5, 0, 10);
		contentRendimiento.add(lblPercentRendimiento);
		

        BitmapGaugeField gaugeRendimiento = new BitmapGaugeField( gaugeBack2, gaugeProgress2, 10, 5, 7, 7, 3, 3, true );
        gaugeRendimiento.setPadding(0,5,0,0);
        //add(bitGauge2);    
          
        contentRendimiento.add(gaugeRendimiento);    
        contentRendimiento.add( new NullField( Field.FOCUSABLE ) ); 
        /**Rendimiento End*/
        
		/**Completado*/
        HorizontalFieldManager contentCompletado = new HorizontalFieldManager();
		
		LabelField lblCompletado = new LabelField("COMPLETADO", RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER );
		lblCompletado.setFont(fLite);
		//lblRestantes.setMargin(5, 10, 5, 10);
		contentCompletado.add(lblCompletado);
		
		LabelField lblPercentCompletado = new LabelField("20%", RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER );
		lblPercentCompletado.setFont(fLite);
		lblPercentCompletado.setMargin(1, 5, 0, 10);
		contentCompletado.add(lblPercentCompletado);
		
        BitmapGaugeField gaugeCompletado = new BitmapGaugeField( gaugeBack2, gaugeProgress2, 10, 2, 7, 7, 3, 3, true );
        gaugeCompletado.setPadding(0,5,0,0);
        //add(bitGauge2);    
          
        contentCompletado.add(gaugeCompletado);    
        contentCompletado.add( new NullField( Field.FOCUSABLE ) ); 
        /**Completado end*/
        
        /**Content Historial */
        
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
		
        
        
        
       /**Content Historial End */ 
        
        
        
		hContent.setMargin(10, 0, 0, 7);
		contentNivel.setMargin(10, 0, 5, 0);
        contentRendimiento.setMargin(10, 0, 5, 10);
        contentCompletado.setMargin(10, 0, 5, 10);
		_contentOne.add(contentNivel);
		_contentOne.add(cEstrellas);
        _contentOne.add(contentRendimiento);
        _contentOne.add(contentCompletado);
        _contentOne.add(hContent);
		_contentOne.setMargin(0, 0, 0, 0);
        
        /**PillButtons One End*/ 
        
        
        /**PillButtons Two*/
        _contentTwo = new FlowFieldManager();
 
        
        
            
        
        
        /**PillButtons Two End*/
        
        //-----------------------------------------------//  
        
        
         /**PillButtons Tree*/
        _contentThree = new FlowFieldManager();
       
    		_contentThree.setMargin(0, 0, 0, 0);
        
        
        pills.setSelectedField( pillOne );
        _currentBody = _contentOne;
        _bodyWrapper.add( _currentBody );
        
        
        pillOne.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	if( _currentBody != _contentOne ) {
	                _bodyWrapper.replace( _currentBody, _contentOne );
	                _currentBody = _contentOne;
            	}
            }
        } );
        
        pillTwo.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	if( _currentBody != _contentTwo ) {
	                _bodyWrapper.replace( _currentBody, _contentTwo );
	                _currentBody = _contentTwo;
            	}
            }
        } );
        
        pillThree.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	if( _currentBody != _contentThree ) {
	                _bodyWrapper.replace( _currentBody, _contentThree );
	                _currentBody = _contentThree;
            	}
            }
        } );
        
        foreground.add( _bodyWrapper );
        add( foreground );
		
       /**PillButtons end*/
    }
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
	}
	public boolean onClose() {
		pushScreenBack(new EligeHabito1());
		return true;
	}
}
