package mypackage;


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
import estilos.Estilos.ContentTuPerfilH;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class TuPerfil extends Estilos {

	/** Start Declarando Variables **/
	Bitmap imgLogo = Bitmap.getBitmapResource("logo.png");
	Bitmap bannerImage;
	Bitmap bordes = Bitmap.getBitmapResource("bordes.png");
	
	Bitmap switch_left = Bitmap.getBitmapResource("switch_left_mujer.png");
    Bitmap switch_right = Bitmap.getBitmapResource("switch_right_hombre.png");
    Bitmap switch_left_focus = Bitmap.getBitmapResource("switch_left_focus_mujer.png");
    Bitmap switch_right_focus = Bitmap.getBitmapResource("switch_right_focus_hombre.png");

	int tFuente;
	Font fLite;
	Font fBold;

	/** End Declarando Variables **/

	/**
	 * Creates a new MyScreen object
	 */
	public TuPerfil() {

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
		RichTextField TituloHead = new RichTextField("Tú Perfil",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE);
		TituloHead.setMargin(5, 0, 0, 0);
		head.add(TituloHead);
		setBanner(head);
		/** End Título Texto **/
		/** End Aplicando Titulo **/

		VerticalFieldManager allContentPerfil = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
		allContentPerfil.setMargin(5,5,5,5);

		ContentTuPerfil contentUser = new ContentTuPerfil(20);		
		contentUser.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,
				12, 12, 12), bordes));
		BasicEditField txtUser = new BasicEditField("Usuario ", "", 15,
				BasicEditField.FILTER_DEFAULT);
		
		
		ContentTuPerfil contentPw = new ContentTuPerfil(20);				
		contentPw.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,
				12, 12, 12), bordes));
		PasswordEditField txtPw = new PasswordEditField("Contraseña ", "", 6,
				PasswordEditField.FILTER_DEFAULT);
		
		ContentTuPerfil contentEmail = new ContentTuPerfil(20);		
		contentEmail.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,
				12, 12, 12), bordes));
		EmailAddressEditField txtEmail = new EmailAddressEditField("Email ", "", 30,
				EmailAddressEditField.FILTER_DEFAULT);
		
		ContentTuPerfilH contentGen = new ContentTuPerfilH(20,ContentTuPerfilH.FIELD_HCENTER);		
		contentGen.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,
				12, 12, 12), bordes));
		LabelField lblGen = new LabelField("Género", LabelField.FIELD_LEFT);
		LabeledSwitch switchGen = new LabeledSwitch(switch_left, switch_right, switch_left_focus, switch_right_focus, "Mujer", "Hombre", true );
		switchGen.setFont(fLite);
        JustifiedHorizontalFieldManager jhfGen = new JustifiedHorizontalFieldManager( new LabelField( "" ), switchGen, false, (USE_ALL_WIDTH/2)+(USE_ALL_WIDTH/4) | JustifiedHorizontalFieldManager.FIELD_HCENTER );
        jhfGen.setMargin(0,0,0,10);

		/** Start Agregando a Pantalla **/

		contentUser.add(txtUser);
		allContentPerfil.add(contentUser);
		contentPw.add(txtPw);
		allContentPerfil.add(contentPw);
		contentEmail.add(txtEmail);
		allContentPerfil.add(contentEmail);
		contentGen.add(lblGen);
		contentGen.add(jhfGen);
		allContentPerfil.add(contentGen);
		add(allContentPerfil);

		/** End Agregando a Pantalla **/

	}

}
