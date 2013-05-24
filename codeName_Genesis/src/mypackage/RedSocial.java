package mypackage;

import java.util.Vector;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.samples.toolkit.ui.component.ListStyleButtonField;
import com.samples.toolkit.ui.container.ListStyleButtonSet;

import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class RedSocial extends Estilos{

	/** Start Declarando Variables **/
	Bitmap imgLogo = Bitmap.getBitmapResource("logo.png");
	Bitmap bannerImage;
	Bitmap fb = Bitmap.getBitmapResource("fb.png");
	Bitmap tw = Bitmap.getBitmapResource("tw.png");

	int tFuente;
	Font fLite;
	Font fBold;
	
	/** End Declarando Variables **/

	/**
	 * Creates a new MyScreen object
	 */
	public RedSocial() {
		
		//getMainManager().setBackground(BackgroundFactory.createSolidBackground(Color.BLACK));

		/** Start Definiendo bannerImage Para Diferente Resoluci�n De Pantalla **/
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
		/** End Resoluci�n De Pantalla **/

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

		/** Start T�tulo Texto **/
		RichTextField TituloHead = new RichTextField("Ajustes",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE);
		TituloHead.setMargin(5, 0, 0, 0);
		head.add(TituloHead);
		setBanner(head);
		/** End T�tulo Texto **/
		/** End Aplicando Titulo **/
		
				
		VerticalFieldManager allContentRedSocial = new VerticalFieldManager();
		
		ListStyleButtonSet buttonSet = new ListStyleButtonSet();
		buttonSet.setMargin(10,4,4,4);
	       
        ListStyleButtonField RedSocial = new ListStyleButtonField( "Facebook", fb );        
        buttonSet.add( RedSocial );
        RedSocial.setChangeListener(new FieldChangeListener() {			
			public void fieldChanged(Field field, int context) {
				Status.show("Tu perfil", 1000);
			}
		});
        
        RedSocial = new ListStyleButtonField( "Twitter", tw );
        buttonSet.add( RedSocial );
        RedSocial.setChangeListener(new FieldChangeListener() {			
			public void fieldChanged(Field field, int context) {
				Status.show("Redes", 1000);
			}
		});
        		
		/** Start Agregando a Pantalla **/
       	
        allContentRedSocial.add(buttonSet);
       	add(allContentRedSocial);
       	      
       	/** End Agregando a Pantalla **/
       	
	}

}
