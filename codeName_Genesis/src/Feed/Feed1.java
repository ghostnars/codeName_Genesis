package Feed;

import java.util.Vector;

import mypackage.Home;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.NullField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.FlowFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.AutoScaleImageField;
import com.samples.toolkit.ui.component.BitmapGaugeField;
import com.samples.toolkit.ui.component.ListStyleButtonField;
import com.samples.toolkit.ui.component.PillButtonField;
import com.samples.toolkit.ui.component.RatingField;
import com.samples.toolkit.ui.container.NegativeMarginVerticalFieldManager;
import com.samples.toolkit.ui.container.PillButtonSet;

import estilos.Estilos;
import estilos.Estilos.CustomHorizontal;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class Feed1 extends Estilos implements FieldChangeListener
{
	Bitmap caret = Bitmap.getBitmapResource( "chevron_right_black_15x22.png" );
	Bitmap imgLogo = Bitmap.getBitmapResource( "icon.png" );
    Bitmap bordes = Bitmap.getBitmapResource("bordes.png");
    EncodedImage normalImage = EncodedImage.getEncodedImageResource( "imgMewe1.png" );
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
    public Feed1()
    {        
    	
    	if (Display.getWidth() == 320)
		{
    		bannerImage = Bitmap.getBitmapResource("head_320.png");
			btnNuevo 	= Bitmap.getBitmapResource("3btn_nuevo_640.png");
			btnNuevo1 	= Bitmap.getBitmapResource("3btn_nuevo1_640.png");
			
			btnYa 	= Bitmap.getBitmapResource("3btn_ya_640.png");
			btnYa1 	= Bitmap.getBitmapResource("3btn_ya1_640.png");
			
		
			
			tFuente = 17;
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
		
		/** Start Block Search Text **/
		HorizontalFieldManager allContentSearch = new HorizontalFieldManager(){
		public int getPreferredWidth() {
		return Display.getWidth();
		}

		public int getPreferredHeight() {
		return 45;
		}

		protected void sublayout(int maxWidth, int maxHeight) {
		super.sublayout(getPreferredWidth(), getPreferredHeight());
		setExtent(getPreferredWidth(), getPreferredHeight());
		}
		};
		allContentSearch.setBackground(BackgroundFactory.createSolidBackground(Color.DARKGRAY));

		VerticalFieldManager contentSearch = new VerticalFieldManager(VerticalFieldManager.FIELD_VCENTER){
		public int getPreferredWidth() {
		return 200;
		}

		public int getPreferredHeight() {
		return 20;
		}

		protected void sublayout(int maxWidth, int maxHeight) {
		super.sublayout(getPreferredWidth(), getPreferredHeight());
		setExtent(getPreferredWidth(), getPreferredHeight());
		}
		};
		contentSearch.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), bordes));
		BasicEditField txtSearch = new BasicEditField("", "", 30,BasicEditField.FILTER_DEFAULT);

		/** Start Botón Siguiente **/
		ButtonField btnSearch = new ButtonField("Post",ButtonField.FIELD_VCENTER);
		/** End Botón Siguiente **/
		contentSearch.add(txtSearch);
		allContentSearch.add(contentSearch);
		allContentSearch.add(btnSearch);
		add(allContentSearch);
		/** End Block Search Text **/
		
		
        for(int i = 0; i < 15; i++ ){ 
        VerticalFieldManager cFondo = new VerticalFieldManager();
        cFondo.setBackground(BackgroundFactory.createSolidBackground(Color.DARKGRAY));
        

         HorizontalField cLista = new HorizontalField(Display.getWidth(),50,Field.NON_FOCUSABLE | HorizontalField.FIELD_VCENTER);
         
         cLista.setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));
         
         /**resize image*/
         CustomHorizontal vfmanager2 = new CustomHorizontal(50,50);  
         field2 = new AutoScaleImageField( normalImage, normalImage,  style );
         vfmanager2.add( field2 );
    	/**resize image end*/
        VerticalField Contenido = new VerticalField(190,50,Field.FIELD_LEFT);
        
        ColorLabel lblContenido = new ColorLabel("Nacho ha conseguido la medalla Comer más fruta",Color.BLACK);  
        lblContenido.setFont(fLite);
        ColorLabel lblHora		= new ColorLabel("Hace 10 minutos",Color.DARKGRAY);	
        lblHora.setFont(fLite);
		
	    lista.addElement(new ListStyleButtonField( null, i+"\n"+"¡Vamos!", null,ListStyleButtonField.FIELD_RIGHT|ListStyleButtonField.FIELD_HCENTER|ListStyleButtonField.FIELD_VCENTER){
            public int getPreferredWidth(){return 80;}
            public int getPreferredHeight(){return 50;}
            public void layout( int maxWidth, int maxHeight )
            {
            super.layout(getPreferredWidth(),getPreferredHeight());
            setExtent(getPreferredWidth(),getPreferredHeight());
            }
         });
	    ((Field) lista.elementAt(i)).setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));
    	((Field) lista.elementAt(i)).setChangeListener(this);
    	((Field) lista.elementAt(i)).setMargin(0,0,0,1);
    	cLista.add( vfmanager2 );
    	Contenido.add(lblContenido);
    	Contenido.add(lblHora);
    	cLista.add(Contenido);
    	cLista.add((Field) lista.elementAt(i));
    	cLista.setMargin(0,1,1,1);
    	
    	cFondo.add(cLista);
    	add(cFondo);
        }   
		
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
