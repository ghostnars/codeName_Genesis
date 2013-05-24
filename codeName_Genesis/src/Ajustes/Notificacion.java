package Ajustes;


import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.LabeledSwitch;
import com.samples.toolkit.ui.container.JustifiedHorizontalFieldManager;

import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class Notificacion extends Estilos {

	/** Start Declarando Variables **/
	Bitmap imgLogo = Bitmap.getBitmapResource("logo.png");
	Bitmap bannerImage;
	Bitmap bordes = Bitmap.getBitmapResource("bordes.png");
	
	Bitmap switch_left = Bitmap.getBitmapResource("switch_left1.png");
    Bitmap switch_right = Bitmap.getBitmapResource("switch_right1.png");
    Bitmap switch_left_focus = Bitmap.getBitmapResource("switch_left_focus1.png");
    Bitmap switch_right_focus = Bitmap.getBitmapResource("switch_right_focus1.png");

	int tFuente;
	Font fLite;
	Font fBold;

	/** End Declarando Variables **/

	/**
	 * Creates a new MyScreen object
	 */
	public Notificacion() {

		// getMainManager().setBackground(BackgroundFactory.createSolidBackground(Color.BLACK));

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
		RichTextField TituloHead = new RichTextField("Notificaciones",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE);
		TituloHead.setMargin(5, 0, 0, 0);
		head.add(TituloHead);
		setBanner(head);
		/** End Título Texto **/
		/** End Aplicando Titulo **/

		VerticalFieldManager allContentNot = new VerticalFieldManager();
		allContentNot.setMargin(5,5,5,5);
		
		//HorizontalFieldManager allContentApp = new HorizontalFieldManager();
		
		ContentTuPerfilH contentApp = new ContentTuPerfilH(20,ContentTuPerfilH.FIELD_HCENTER);		
		contentApp.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,
				12, 12, 12), bordes));
		
		ContentNotH contentT1 = new ContentNotH(230,20,HorizontalFieldManager.FIELD_LEFT);
		LabelField lblApp = new LabelField("Aplicación");
		
		ContentNotH contentSwitch = new ContentNotH(75,20,ContentNotH.FIELD_RIGHT);
		LabeledSwitch switchApp = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "", "", true );
		switchApp.setFont(fLite);
        JustifiedHorizontalFieldManager jhfApp = new JustifiedHorizontalFieldManager( new LabelField( "" ), switchApp, false, (USE_ALL_WIDTH/2)+(USE_ALL_WIDTH/4));
        jhfApp.setMargin(0,0,0,10);
		
		ContentTuPerfilH contentFeed = new ContentTuPerfilH(20,ContentTuPerfilH.FIELD_HCENTER);		
		contentFeed.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,
				12, 12, 12), bordes));
		
		ContentNotH contentT2 = new ContentNotH(230,20,ContentNotH.FIELD_RIGHT);
		LabelField lblFeed = new LabelField("Feed", LabelField.FIELD_LEFT);
		
		ContentNotH contentSwitch2 = new ContentNotH(75,20,ContentNotH.FIELD_RIGHT);
		LabeledSwitch switchFeed = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "", "", true );
		switchFeed.setFont(fLite);
        JustifiedHorizontalFieldManager jhfFeed = new JustifiedHorizontalFieldManager( new LabelField( "" ), switchFeed, false, (USE_ALL_WIDTH/2)+(USE_ALL_WIDTH/4) | JustifiedHorizontalFieldManager.FIELD_HCENTER );
        jhfFeed.setMargin(0,0,0,10);
		
		ContentTuPerfilH contentFollow = new ContentTuPerfilH(20,ContentTuPerfilH.FIELD_HCENTER);		
		contentFollow.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,
				12, 12, 12), bordes));
		
		ContentNotH contentT3 = new ContentNotH(230,20,ContentNotH.FIELD_RIGHT);
		LabelField lblFollow = new LabelField("Seguidores", LabelField.FIELD_LEFT);
		
		ContentNotH contentSwitch3 = new ContentNotH(75,20,ContentNotH.FIELD_RIGHT);
		LabeledSwitch switchFollow = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "", "", true );
		switchFollow.setFont(fLite);
        JustifiedHorizontalFieldManager jhfFollow = new JustifiedHorizontalFieldManager( new LabelField( "" ), switchFollow, false, (USE_ALL_WIDTH/2)+(USE_ALL_WIDTH/4) | JustifiedHorizontalFieldManager.FIELD_HCENTER );
        jhfFollow.setMargin(0,0,0,10);
		
		ContentTuPerfilH contentCome = new ContentTuPerfilH(20,ContentTuPerfilH.FIELD_HCENTER);		
		contentCome.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,
				12, 12, 12), bordes));
		
		ContentNotH contentT4 = new ContentNotH(230,20,ContentNotH.FIELD_RIGHT);
		LabelField lblCome = new LabelField("Vamos", LabelField.FIELD_LEFT);
		
		ContentNotH contentSwitch4 = new ContentNotH(75,20,ContentNotH.FIELD_RIGHT);
		LabeledSwitch switchCome = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "", "", true );
		switchCome.setFont(fLite);
        JustifiedHorizontalFieldManager jhfCome = new JustifiedHorizontalFieldManager( new LabelField( "" ), switchCome, false, (USE_ALL_WIDTH/2)+(USE_ALL_WIDTH/4) | JustifiedHorizontalFieldManager.FIELD_HCENTER );
        jhfCome.setMargin(0,0,0,10);

		/** Start Agregando a Pantalla **/
        
        contentT1.add(lblApp);
        contentApp.add(contentT1);
        contentSwitch.add(jhfApp);
        contentApp.add(contentSwitch);
        allContentNot.add(contentApp);
        
        contentT2.add(lblFeed);
        contentFeed.add(contentT2);
        contentSwitch2.add(jhfFeed);
        contentFeed.add(contentSwitch2);
        allContentNot.add(contentFeed);
        
        contentT3.add(lblFollow);
        contentFollow.add(contentT3);
        contentSwitch3.add(jhfFollow);
        contentFollow.add(contentSwitch3);
        allContentNot.add(contentFollow);
        
        contentT4.add(lblCome);
        contentCome.add(contentT4);
        contentSwitch4.add(jhfCome);
        contentCome.add(contentSwitch4);
        allContentNot.add(contentCome);
        
		add(allContentNot);

		/** End Agregando a Pantalla **/

	}

}
