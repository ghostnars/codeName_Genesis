package eligeHabito;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
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
public class EligeHabito2 extends Estilos {

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
	public EligeHabito2() {

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
		RichTextField TituloHead = new RichTextField("ELIGE UN HÁBITO",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.NON_FOCUSABLE);
		TituloHead.setMargin(5, 0, 0, 0);
		head.add(TituloHead);
		setBanner(head);
		/** End Título Texto **/
		/** End Aplicando Titulo **/

		/** Start Aplicando Titulo Uno **/
		LabelField titulo1 = new LabelField("COMER MÁS FRUTA",
				RichTextField.FIELD_HCENTER);
		titulo1.setFont(fLite);
		titulo1.setMargin(9, 0, 0, 0);
		add(titulo1);
		/** End Titulo Uno **/

		/** Start Aplicando Subtitulo **/
		LabelField subtitulo = new LabelField(
				"BUENO PARA TI, MEJOR PARA LOS DEMÁS",
				RichTextField.FIELD_HCENTER);
		subtitulo.setFont(fLite);
		subtitulo.setMargin(5, 0, 0, 0);
		add(subtitulo);
		/** End Aplicando Subtitulo **/

		/** Start Contenedor Principal de Información **/
		VerticalFieldManager allContentInfo = new VerticalFieldManager();
		// Background fieldColor = BackgroundFactory.createSolidBackground(Color.GRAY);
		allContentInfo.setMargin(6, 10, 0, 10);
		allContentInfo.setBackground(BackgroundFactory
				.createSolidBackground(Color.GAINSBORO));

		/** Start Contenedor Secundario Uno Detalle **/
		HorizontalFieldManager informacion = new HorizontalFieldManager(
				HorizontalFieldManager.USE_ALL_WIDTH
						| HorizontalFieldManager.FIELD_HCENTER
						| HorizontalFieldManager.FIELD_VCENTER);
		
		/** Start Imagen **/
		BitmapField imagen1 = new BitmapField(
				Bitmap.getBitmapResource("imgMewe_320.png"));
		imagen1.setMargin(6, 10, 0, 10);
		/** End Imagen **/
		
		/** Start Contenedor Secundario Dos Detalle **/
		VerticalFieldManager contenido = new VerticalFieldManager();
		contenido.setMargin(0, 0, 0, 5);
		
		/** Start Texto Detalle **/
		RichTextField titulo3 = new RichTextField(
				"BUENO PARA TI, MEJOR PARA LOS,BUENO PARA TI, MEJOR PARA LOS BUENO PARA TI, MEJOR PARA LOS BUENO PARA TI, MEJOR PARA LOS",
				RichTextField.TEXT_ALIGN_HCENTER | RichTextField.FIELD_HCENTER);
		titulo3.setFont(fLite);
		titulo3.setMargin(8, 0, 0, 5);
		/** End Texto Detalle **/
		
		/** Start Botón Siguiente **/
		ButtonField btnNext = new ButtonField("Siguiente",HorizontalFieldManager.FIELD_HCENTER);
		btnNext.setChangeListener( new FieldChangeListener( ) {
            public void fieldChanged( Field field, int context ) {
            	pushScreen(new EligeHabito3());        	
            }
        });
		btnNext.setMargin(0, 0, 10, 0);
		/** End Botón Siguiente **/
		
		/** Start Agregando a Pantalla **/
		informacion.add(imagen1);
		contenido.add(titulo3);
		informacion.add(contenido);

		allContentInfo.add(informacion);
		allContentInfo.add(btnNext);
		add(allContentInfo);
		/** End Agregando a Pantalla **/

	}
	public boolean onClose() {
		pushScreenBack(new EligeHabito1());
		return true;
	}
}
