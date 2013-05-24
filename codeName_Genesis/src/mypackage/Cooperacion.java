package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class Cooperacion extends Estilos {

	/** Start Declarando Variables **/
	Bitmap imgLogo = Bitmap.getBitmapResource("logo.png");
	Bitmap bannerImage;

	int tFuente;
	Font fLite;
	Font fBold;

	/** End Declarando Variables **/

	/**
	 * Creates a new MyScreen object
	 */
	public Cooperacion() {

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
		RichTextField TituloHead = new RichTextField("COOPERAR",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE);
		TituloHead.setMargin(5, 0, 0, 0);
		head.add(TituloHead);
		setBanner(head);
		/** End Título Texto **/
		/** End Aplicando Titulo **/

		/** Start Aplicando Titulo Uno **/
		LabelField titulo1 = new LabelField("BANCO DE ALIMENTOS",
				RichTextField.FIELD_HCENTER);
		titulo1.setFont(fLite);
		titulo1.setMargin(9, 0, 0, 0);
		add(titulo1);
		/** End Titulo Uno **/

		/** Start Contenedor Principal de Información **/
		VerticalFieldManager allContentInfo = new VerticalFieldManager();
		// Background fieldColor = BackgroundFactory.createSolidBackground(Color.GRAY);
		allContentInfo.setMargin(6, 10, 0, 10);
		allContentInfo.setBackground(BackgroundFactory
				.createSolidBackground(Color.GAINSBORO));
		
		/** Start Contenedor Secundario Dos Detalle **/
		VerticalFieldManager contenido = new VerticalFieldManager();
		contenido.setMargin(0, 0, 0, 5);
		
		/** Start Texto Detalle **/
		RichTextField titulo3 = new RichTextField(
				"No existe mejor recompensa que el poder ayuda a los demás, por eso cada vez que colaboras con Banco de Alimentos refuerzas tu hábito.",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.FIELD_HCENTER);
		titulo3.setFont(fLite);
		titulo3.setMargin(8, 0, 0, 5);
		
		RichTextField titulo4 = new RichTextField(
				"Lo que es bueno para los demás siempre es bueno para ti.",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.FIELD_HCENTER);
		titulo4.setFont(fLite);
		titulo4.setMargin(8, 0, 0, 5);
		/** End Texto Detalle **/
		
		/** Start Imagen **/
		BitmapField imagenCoo = new BitmapField(
				Bitmap.getBitmapResource("Banco-de-Alimentos.png"), BitmapField.FIELD_HCENTER);
		imagenCoo.setMargin(10, 10, 10, 10);
		/** End Imagen **/
		
		HorizontalFieldManager contentDon = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER);
		
		/** Start Botón Donar **/
		ButtonField btnDon = new ButtonField("Donar",
				HorizontalFieldManager.FIELD_HCENTER);
		btnDon.setMargin(0, 0, 10, 0);
		/** End Botón Donar **/
		
		/** Start Botón Voluntariado **/
		ButtonField btnVol = new ButtonField("Voluntariado",
				HorizontalFieldManager.FIELD_HCENTER);
		btnVol.setMargin(0, 0, 10, 0);
		/** End Botón Voluntariado **/
		
		/** Start Agregando a Pantalla **/
		
		contenido.add(titulo3);
		contenido.add(titulo4);
		contenido.add(imagenCoo);
		allContentInfo.add(contenido);
		
		contentDon.add(btnDon);
		contentDon.add(btnVol);
		allContentInfo.add(contentDon);
		
		add(allContentInfo);
		/** End Agregando a Pantalla **/

	}
}
