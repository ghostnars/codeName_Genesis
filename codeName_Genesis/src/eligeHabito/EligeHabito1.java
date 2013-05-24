package eligeHabito;

import java.util.Vector;

import mypackage.Home;
import mypackage.foregroundManager;
import mypackage.statsHabitos;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.FlowFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import net.rim.device.api.ui.image.Image;
import net.rim.device.api.ui.image.ImageFactory;

import com.samples.toolkit.ui.component.AutoScaleImageField;
import com.samples.toolkit.ui.component.ListStyleButtonField;
import com.samples.toolkit.ui.component.PillButtonField;
import com.samples.toolkit.ui.container.ListStyleButtonSet;
import com.samples.toolkit.ui.container.NegativeMarginVerticalFieldManager;
import com.samples.toolkit.ui.container.PillButtonSet;

import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class EligeHabito1 extends Estilos implements FieldChangeListener
{
	Bitmap caret = Bitmap.getBitmapResource( "chevron_right_black_15x22.png" );
	Bitmap imgLogo = Bitmap.getBitmapResource( "icon.png" );
    Bitmap bordes = Bitmap.getBitmapResource("bordes.png");
    EncodedImage normalImage = EncodedImage.getEncodedImageResource( "imgMewe1.png" );
	Bitmap bannerImage;
	long style = Field.FOCUSABLE | AutoScaleImageField.REDUCE_TO_WIDTH | AutoScaleImageField.REDUCE_TO_WIDTH;
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
	Vector lista1 = new Vector();
	Vector lista2 = new Vector();
	
	//private VerticalFieldManager vfmanager;
	/**
     * Creates a new MyScreen object
     */
    public EligeHabito1()
    {        
    	
    	if (Display.getWidth() == 320)
		{
    		bannerImage = Bitmap.getBitmapResource("head_320.png");
			btnNuevo 	= Bitmap.getBitmapResource("3btn_nuevo_640.png");
			btnNuevo1 	= Bitmap.getBitmapResource("3btn_nuevo1_640.png");
			
			btnYa 	= Bitmap.getBitmapResource("3btn_ya_640.png");
			btnYa1 	= Bitmap.getBitmapResource("3btn_ya1_640.png");
			
			tFuente = 20;
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
		HorizontalField head = new HorizontalField(bannerImage.getWidth(),bannerImage.getHeight(),HorizontalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_VCENTER);	
        head.setBackground(BackgroundFactory.createBitmapBackground(bannerImage));
		head.add(new RichTextField("CREAR CUENTA" , RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE));
		setBanner(head);
		//End Banner
		
	  	MenuItem elementoMenu = new MenuItem("Iniciar Nuevo Hábito", 113, 3){
			public void run(){
				pushScreen( new EligeHabito2());
	        }
	  	};
	  	Image menuIcon3 = ImageFactory.createImage(Bitmap.getBitmapResource("imgMewe.png"));
	  	elementoMenu.setIcon(menuIcon3);
	  	addMenuItem(elementoMenu);
	  	
		/**PillButtons*/
		
		Manager foreground = new foregroundManager();
        
        PillButtonSet pills = new PillButtonSet();
        PillButtonField pillOne = new PillButtonField( "ACTUALES" );
        PillButtonField pillTwo = new PillButtonField( "COMPLETADOS" );
        PillButtonField pillThree = new PillButtonField( "TODOS" );
        pills.add( pillOne );
        pills.add( pillTwo );
        pills.add( pillThree );
        pills.setMargin( 0, 0, 0, 0 );
        foreground.add( pills );
        
        
        _bodyWrapper = new NegativeMarginVerticalFieldManager( USE_ALL_WIDTH );
        /**PillButtons One*/ 
        _contentOne = new ListStyleButtonSet();
       // _contentOne.add( new ListStyleButtonField( imgLogo,"Home",null, 0 ) ); 
        for(int i = 0; i < 3; i++ ){       
        VerticalFieldManager vfmanager = new VerticalFieldManager(Field.NON_FOCUSABLE){
             public int getPreferredWidth(){return 50;}
             public int getPreferredHeight(){return 50;}  
             protected void sublayout( int maxWidth, int maxHeight )
             {
             super.sublayout(getPreferredWidth(), getPreferredHeight());
             setExtent(getPreferredWidth(), getPreferredHeight());
             }
         };  
         field = new AutoScaleImageField( normalImage, normalImage, style );
         vfmanager.add( field );	
    	
        	
		HorizontalFieldManager hfmLista = new HorizontalFieldManager(Field.FIELD_VCENTER){
            public int getPreferredWidth(){return Display.getWidth()-24;}
            public int getPreferredHeight(){return 50;}  
            protected void sublayout( int maxWidth, int maxHeight )
            {
            super.sublayout(getPreferredWidth(), getPreferredHeight());
            setExtent(getPreferredWidth(), getPreferredHeight());
            }
        };  
		hfmLista.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
		hfmLista.setMargin(0, 0, 0, 0);
		
	    lista.addElement(new ListStyleButtonField( null, "COMER MAS FRUTA"+"\n"+"75%"+"\t"+"13500"+" Puntos", caret,0){
            public int getPreferredWidth(){return Display.getWidth()-30;}
            public int getPreferredHeight(){return 50;}
            public void layout( int maxWidth, int maxHeight )
            {
            super.layout(getPreferredWidth(),getPreferredHeight());
            setExtent(getPreferredWidth(),getPreferredHeight());
            }
         });
 
	    ((Field) lista.elementAt(i)).setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	pushScreen(new statsHabitos());        	
            }
        });
    	hfmLista.add( vfmanager );
		hfmLista.add((Field) lista.elementAt(i));
		//hfmContent.add(campo);
		_contentOne.add(hfmLista);
		_contentOne.setMargin(0, 0, 0, 0);
        }    
        /**PillButtons One End*/ 
        
        
        /**PillButtons Two*/
        _contentTwo = new ListStyleButtonSet();
        for(int j = 0; j < 10; j++ ){       
            VerticalField vfmanager1 = new VerticalField(50,50,0);  
             field1 = new AutoScaleImageField( normalImage, normalImage, style );
             vfmanager1.add( field1 );	
        	
            	
    		HorizontalField hfmLista1 = new HorizontalField(Display.getWidth()-24,50,Field.FIELD_VCENTER); 
    		hfmLista1.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
    		hfmLista1.setMargin(0, 0, 0, 0);
    		
    	    lista1.addElement(new ListStyleButtonField( null, "COMER MAS FRUTA"+"\n"+"100%"+"\t"+"13500"+" Puntos", caret,0){
                public int getPreferredWidth(){return Display.getWidth()-30;}
                public int getPreferredHeight(){return 50;}
                public void layout( int maxWidth, int maxHeight )
                {
                super.layout(getPreferredWidth(),getPreferredHeight());
                setExtent(getPreferredWidth(),getPreferredHeight());
                }
             });
     
        	((Field) lista1.elementAt(j)).setChangeListener(this);
        	hfmLista1.add( vfmanager1 );
    		hfmLista1.add((Field) lista1.elementAt(j));
    		//hfmContent.add(campo);
    		_contentTwo.add(hfmLista1);
            _contentTwo.setMargin(0, 0, 0, 0);
            }
        
        
        /**PillButtons Two End*/
        
        //-----------------------------------------------//  
        
        
         /**PillButtons Tree*/
        _contentThree = new FlowFieldManager();
        for(int k = 0; k < 2; k++ ){       
            CustomHorizontal vfmanager2 = new CustomHorizontal(60,60);  
             field2 = new AutoScaleImageField( normalImage, normalImage, style );
             vfmanager2.add( field2 );	
        	
            	
    		HorizontalField hfmLista2 = new HorizontalField(Display.getWidth()-24,50,Field.FIELD_VCENTER); 
    		hfmLista2.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
    		hfmLista2.setMargin(0, 0, 0, 0);
    		
    	    lista2.addElement(new ListStyleButtonField( null, "COMER MAS FRUTA"+"\n"+"2%"+"\t"+"13500"+" Puntos", caret,0){
                public int getPreferredWidth(){return Display.getWidth()-30;}
                public int getPreferredHeight(){return 50;}
                public void layout( int maxWidth, int maxHeight )
                {
                super.layout(getPreferredWidth(),getPreferredHeight());
                setExtent(getPreferredWidth(),getPreferredHeight());
                }
             });
    	    ((Field) lista2.elementAt(k)).setChangeListener( new FieldChangeListener( ) {
                public void fieldChanged( Field field, int context ) {
                	pushScreen(new EligeHabito2());        	
                }
            });
        	hfmLista2.add( vfmanager2 );
    		hfmLista2.add((Field) lista2.elementAt(k));
    		//hfmContent.add(campo);
    		_contentThree.add(hfmLista2);
    		_contentThree.setMargin(0, 0, 0, 0);
        }
        
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
		pushScreenBack(new Home());
		return true;
	}
}
