package Feed;

import java.util.Vector;

import mypackage.Home;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.ListStyleButtonField;

import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class Feed2 extends Estilos implements FieldChangeListener{

	/** Start Declarando Variables **/
	Bitmap imgLogo = Bitmap.getBitmapResource("logo.png");
	Bitmap bannerImage;
	Bitmap bordes = Bitmap.getBitmapResource("bordes.png");

	int tFuente;
	Font fLite;
	Font fBold;
	
	Vector lista = new Vector();

	/** End Declarando Variables **/

	/**
	 * Creates a new MyScreen object
	 */
	public Feed2() {
		
		//getMainManager().setBackground(BackgroundFactory.createSolidBackground(Color.BLACK));

		/** Start Definiendo bannerImage Para Diferente Resolución De Pantalla **/
		if (Display.getWidth() == 320) {
			bannerImage = Bitmap.getBitmapResource("head_320.png");
			tFuente = 15;
		}
		if (Display.getWidth() == 360) {
			bannerImage = Bitmap.getBitmapResource("titulo_360.png");
			tFuente = 25;
		}
		if (Display.getWidth() == 480) {
			bannerImage = Bitmap.getBitmapResource("titulo_480.png");
			tFuente = 28;
		}
		if (Display.getWidth() == 640)

		{
			bannerImage = Bitmap.getBitmapResource("head_640.png");

			tFuente = 30;
		}
		/** End Resolución De Pantalla **/

		/** Start Aplicando tamanio de letra a variables fBold y fLite **/
		try {
			FontFamily ffFont = FontFamily.forName("Arial");
			fBold = ffFont.getFont(Font.BOLD, tFuente);

			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente - 2);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		/** End Aplicando tamanio **/

		/** Start Aplicando Titulo de Pantalla Top Banner **/
		HorizontalFieldManager head = new HorizontalFieldManager(
				HorizontalFieldManager.FIELD_HCENTER
						| HorizontalFieldManager.FIELD_VCENTER) {
			public int getPreferredWidth() {
				return bannerImage.getWidth();
			}

			public int getPreferredHeight() {
				return bannerImage.getHeight();
			}

			protected void sublayout(int maxWidth, int maxHeight) {
				super.sublayout(getPreferredWidth(), getPreferredHeight());
				setExtent(getPreferredWidth(), getPreferredHeight());
			}
		};
		head.setBackground(BackgroundFactory
				.createBitmapBackground(bannerImage));

		/** Start Título Texto **/
		RichTextField TituloHead = new RichTextField("Feed",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE);
		TituloHead.setMargin(5, 0, 0, 0);
		head.add(TituloHead);
		setBanner(head);
		/** End Título Texto **/
		/** End Aplicando Titulo **/
		
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
		ButtonField btnSearch = new ButtonField("Buscar",
				ButtonField.FIELD_VCENTER);
		/** End Botón Siguiente **/
		
		/** End Block Search Text **/
		
		VerticalFieldManager allContentList = new VerticalFieldManager();
		allContentList.setBackground(BackgroundFactory.createSolidBackground(Color.DARKGRAY));
		
		ListStyleButtonField lsbListTodos = new ListStyleButtonField("  "+"Todos", null);
		lsbListTodos.setChangeListener(new FieldChangeListener() {			
			public void fieldChanged(Field field, int context) {
				Status.show("hola", 1000);
			}
		});
		lsbListTodos.setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));
		lsbListTodos.setMargin(1,1,1,1);
		
		ListStyleButtonField lsbListTu = new ListStyleButtonField("  "+"Tú", null);
		lsbListTu.setChangeListener(new FieldChangeListener() {			
			public void fieldChanged(Field field, int context) {
				Status.show("hola", 1000);
			}
		});
		lsbListTu.setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));
		lsbListTu.setMargin(1,1,1,1);
		
		ListStyleButtonField lsbListAmigos = new ListStyleButtonField("  "+"Tus Amigos", null);
		lsbListAmigos.setChangeListener(new FieldChangeListener() {			
			public void fieldChanged(Field field, int context) {
				Status.show("hola", 1000);
			}
		});
		lsbListAmigos.setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));
		lsbListAmigos.setMargin(1,1,1,1);
		
		ListStyleButtonField lsbListOrangina = new ListStyleButtonField("  "+"Orangina", null);
		lsbListOrangina.setChangeListener(new FieldChangeListener() {			
			public void fieldChanged(Field field, int context) {
				Status.show("hola", 1000);
			}
		});
		lsbListOrangina.setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));
		lsbListOrangina.setMargin(1,1,1,1);
		
		VerticalFieldManager contentHabitos = new VerticalFieldManager(VerticalFieldManager.USE_ALL_WIDTH);
		contentHabitos.setBackground(BackgroundFactory.createSolidBackground(Color.DARKGRAY));
		
		LabelField lbfHabito = new LabelField("HÁBITOS", LabelField.FIELD_HCENTER);
		lbfHabito.setMargin(10,0,10,0);
		
		/** Start Agregando a Pantalla **/
		contentSearch.add(txtSearch);
		allContentSearch.add(contentSearch);
		allContentSearch.add(btnSearch);
       	add(allContentSearch);
       	
       	allContentList.add(lsbListTodos);
       	allContentList.add(lsbListTu);
       	allContentList.add(lsbListAmigos);
       	allContentList.add(lsbListOrangina);
       	add(allContentList);
       	
       	contentHabitos.add(lbfHabito);
       	add(contentHabitos);       
       	/** End Agregando a Pantalla **/
       	
       	for (int i=0; i<5; i++){
			VerticalFieldManager cListHabitos = new VerticalFieldManager();
			cListHabitos.setBackground(BackgroundFactory.createSolidBackground(Color.DARKGRAY));
			lista.addElement(new ListStyleButtonField("Hola"+i, null));
			((Field) lista.elementAt(i)).setBackground(BackgroundFactory.createSolidBackground(Color.WHITE));
			((Field) lista.elementAt(i)).setChangeListener(this);
			((Field) lista.elementAt(i)).setMargin(1,1,0,1);
			cListHabitos.add((Field) lista.elementAt(i));
			add(cListHabitos);
		}
		

	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
	}
	public boolean onClose() {
		pushScreenBack(new Feed1());
		return true;
	}
}
