package noticias;

import java.io.IOException;

import mypackage.Metodos;
import mypackage.Noticias;
import mypackage.calendar;
import mypackage.login;
import mypackage.mision;
import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.browser.field2.BrowserFieldConfig;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.decor.BackgroundFactory;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;
import org.xmlpull.v1.XmlPullParserException;

import com.twmacinta.util.Autenticacion;

import estilos.BitmapButtonField;

public  class noticia extends Metodos  
{
	BitmapButtonField bts1 , bts2 , bts3 , bts4, bts5;
	String matanga = Autenticacion.getConnectionString();
	String ServiceUrl = "http://www.ufg.edu.sv/ws/noticias.php"; 
	String ServiceNamespace = "http://www.ufg.edu.sv"; 
	String methodName = "contenido";
	BrowserField img1;
	
	public  noticia(String pagina,String idn) {
		ServiceUrl=ServiceUrl+matanga;
		setTitle("Noticia");
		getMainManager().setBackground(BackgroundFactory.createSolidBackground(0x43a2f1));
		
		SoapObject rpc = new SoapObject(ServiceNamespace, methodName);
        rpc.addProperty("idn", idn);
        rpc.addProperty("pagina", pagina);
		   
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
        envelope.bodyOut = rpc;  
        envelope.dotNet = true;
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
		
        HttpTransport ht = new HttpTransport(ServiceUrl);
        ht.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        ht.debug = true;
        
        String result 	= "";
        String res		= "";
        String titulo 	= "";
        String fecha	= "";
        String texto 	= "";
        String galeria 	= "";
        String contenido= "";
        String imagen1  = "";
        String imagen2  = "";
        String imagen3  = "";
        String imagen4  = "";
        String imagen5  = "";
        	
		try {
			ht.call(ServiceUrl + "/" + methodName, envelope);
			result =  envelope.getResponse().toString();
			/**Bitmap borderBitmap = Bitmap.getBitmapResource("numbergrade.png");
			VerticalFieldManager Panel1 = new VerticalFieldManager(Field.FIELD_HCENTER | Field.USE_ALL_WIDTH);
			Panel1.setBorder(BorderFactory.createBitmapBorder(new XYEdges(12,12,12,12), borderBitmap));*/
			
			res = result.substring(10, result.length()-1);
			char letra;
			String oracion1="";
			String oracion2="";
			for(int i=0; i < res.length(); i++){
				if(res.charAt(i)=='&'){
					oracion1 =res.substring(0,i);        
                    oracion2 =res.substring(i+8,res.length());
                    letra=res.charAt(i+1);
                    res=oracion1+letra+oracion2;
                }                                        
            }
			for(int k=0;k<=res.length()-1;k++){
				if (res.charAt(k)== ';'){
					if (titulo == ""){
						titulo = contenido;
						contenido = "";
						titulo = titulo.substring(7, titulo.length());
					}else if (fecha == ""){
						fecha = contenido;
						contenido = "";
						fecha = fecha.substring(7, fecha.length());
					}else if (texto == ""){
						texto = contenido;
						contenido = "";
						if (texto.length() == 7) {
							texto = "SIN TEXTO";	
						}else{
							texto = texto.substring(7, texto.length());
						}
					}else if (galeria == ""){
						galeria = contenido;
						contenido = "";
						galeria = galeria.substring(9, galeria.length());
					}
				}else{
					contenido = contenido + res.charAt(k);
				}
			}
			
			contenido = "";
			galeria = galeria.substring(1, galeria.length()-1);
				for(int l=0;l<=galeria.length()-1;l++){
					if (galeria.charAt(l)== ','){
						if (imagen1 == ""){
							imagen1 = "<img src='"+contenido+"'/><br/>";
							contenido = "";
						}else if (imagen2 == ""){
							imagen2 = "<img src='"+contenido.substring(2, contenido.length())+"'/><br/>";
							contenido = "";
						}else if (imagen3 == ""){
							imagen3 = "<img src='"+contenido+"'/><br/>";
							contenido = "";
						}else if (imagen4 == ""){
							imagen4 = "<img src='"+contenido+"'/><br/>";
							contenido = "";
						}else if (imagen5 == ""){
							imagen5 = "<img src='"+contenido+"'/><br/>";
							contenido = "";
						}
					}
					contenido = contenido + galeria.charAt(l);
				}
			if (imagen1 == ""){
				imagen1 = "<img src='"+contenido+"'/><br/>";
				contenido = "";
			}else if (imagen2 == ""){
				imagen2 = "<img src='"+contenido.substring(2, contenido.length())+"'/><br/>";
				contenido = "";
			}else if (imagen3 == ""){
				imagen3 = "<img src='"+contenido+"'/><br/>";
				contenido = "";
			}else if (imagen4 == ""){
				imagen4 = "<img src='"+contenido+"'/><br/>";
				contenido = "";
			}else if (imagen5 == ""){
				imagen5 = "<img src='"+contenido+"'/><br/>";
				contenido = "";
			}
			
			BrowserFieldConfig myBrowserFieldConfig = new BrowserFieldConfig();
			myBrowserFieldConfig.setProperty(BrowserFieldConfig.NAVIGATION_MODE, BrowserFieldConfig.NAVIGATION_MODE_POINTER);
			img1 = new BrowserField(myBrowserFieldConfig);
			
			img1.displayContent("<html><body style='background-color:#43a2f1;'>"+imagen1+imagen2+imagen3+imagen4+imagen5+"</body></html>", "http://localhost");
			img1.setPadding(0,0,-2,-2);
			//Panel1.add(img1);
			//add(Panel1);
			add(img1);
		} catch (SoapFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
}
	public boolean onClose() {
		//force the app to quit
		openScreen(new Noticias());
		return true ;
	}
}