package mypackage;

import java.io.IOException;
import java.util.Vector;

import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.browser.field2.BrowserFieldConfig;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import noticias.noticia;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;
import org.xmlpull.v1.XmlPullParserException;

import com.twmacinta.util.Autenticacion;

import estilos.BitmapButtonField;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public  class Noticias extends Metodos  
{
    /**
     * Creates a new MyScreen object
     */	
	BitmapButtonField att;
	String matanga = Autenticacion.getConnectionString();
	String ServiceUrl = "http://www.ufg.edu.sv/ws/noticias.php"; 
	String ServiceNamespace = "http://www.ufg.edu.sv"; 
	String methodName = "titulos";
	Vector bb=new Vector();
	BrowserField img1;
	RichTextField titt;
	Vector idnn = new Vector();	
	Vector pagg = new Vector();	
	
	public Noticias() {
    	
        setTitle("Noticias");
        getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK)); 

       

	    	ServiceUrl=ServiceUrl+matanga;
        SoapObject rpc = new SoapObject(ServiceNamespace, methodName);
        rpc.addProperty("titulo", "1");
		   
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
        envelope.bodyOut = rpc;  
        envelope.dotNet = true;
        envelope.encodingStyle = SoapSerializationEnvelope.ENC;
		
        HttpTransport ht = new HttpTransport(ServiceUrl);
        ht.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        ht.debug = true;
			       
        Vector result = new Vector();
		String res	= null;
	    String res2	= null;
	    String titulo = "";
	    String miniatura = "";
	    String contenido = "";
	    String fecha = "";
	    String fechaactividad="";
	    String idn="";
	    String pagina="";
	    
	    
	    	//Dialog. alert (matanga);
	    	
	    	//Dialog. alert (ServiceUrl);
	    try {
			ht.call(ServiceUrl + "/" + methodName, envelope);	
			result =  (Vector) envelope.getResponse(); 
			//Dialog. alert (result.toString());
			for (int j=0;j<=result.size()-1;j++){
				if(j<=4){
				Bitmap borderBitmap = Bitmap.getBitmapResource("barra_nota.png");
				VerticalFieldManager Panel1 = new VerticalFieldManager(Field.FIELD_HCENTER | Field.USE_ALL_WIDTH);
				Panel1.setBorder(BorderFactory.createBitmapBorder(new XYEdges(1,1,1,1), borderBitmap));
				Panel1.setMargin(5, 5, 0, 5);
				res = result.elementAt(j).toString();
				
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
				res2 = res.substring(7, res.length()-1);
				for(int k=0;k<=res2.length()-1;k++){
					if (res2.charAt(k)== ';'){
						if (titulo == ""){
							titulo = contenido;
							contenido = "";
							titulo = titulo.substring(7, titulo.length());
						}else if (miniatura == ""){
							miniatura = contenido;
							contenido = "";
							miniatura = miniatura.substring(11, miniatura.length());
						}else if (fecha == ""){
							fecha = contenido;
							contenido = "";
							fecha = fecha.substring(7, fecha.length());
						}else if (fechaactividad == ""){
							fechaactividad = contenido;
							contenido = "";
							fechaactividad = fechaactividad.substring(16, fechaactividad.length());	
						}else if (idn == ""){
							idn = contenido;
							contenido = "";
							idn = idn.substring(5, idn.length());
							
						}else if (pagina == ""){
							pagina = contenido;
							contenido = "";
							pagina = pagina.substring(8, pagina.length());
						}
					}else{
						contenido = contenido + res2.charAt(k);
					}
				}
				idnn.addElement(idn);
				pagg.addElement(pagina);
				
				BrowserFieldConfig myBrowserFieldConfig = new BrowserFieldConfig();
				myBrowserFieldConfig.setProperty(BrowserFieldConfig.NAVIGATION_MODE, BrowserFieldConfig.NAVIGATION_MODE_NONE);
				img1 = new BrowserField(myBrowserFieldConfig);
				img1.displayContent("<html><body style='background:#43a2f1;'><img src='"+miniatura+"'width='91' height='66' style='float:left;'/><label style='color:#fff;float:right;width:180px;font-size:0.8em;height:50px;'>"+titulo+"</label></body></html>", "http://localhost");									 	
				
				bb.addElement(new BitmapButtonField(Bitmap.getBitmapResource("barraflecha.png"), Bitmap.getBitmapResource("barraflecha1.png"),Field.FIELD_RIGHT ));					
				((Field) bb.elementAt(j)).setChangeListener(this);
				Panel1.add(img1);
				Panel1.add((Field) bb.elementAt(j));
				
				add(Panel1);
				img1 = null;
				titulo = "";
				miniatura = "";
				contenido = "";
				idn = "";
				fecha="";
				fechaactividad="";
				pagina="";
			}	
						
		} 
		
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Cierra If del Matanga
	  }
   
  
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub		
		if( bb.elementAt(0)== field ){
			openScreen(new noticia(pagg.elementAt(0).toString(),idnn.elementAt(0).toString()));
		}else if( bb.elementAt(1)== field ){
			openScreen(new noticia(pagg.elementAt(1).toString(),idnn.elementAt(1).toString()));
		}else if( bb.elementAt(2)== field ){
			openScreen(new noticia(pagg.elementAt(2).toString(),idnn.elementAt(2).toString()));
		}else if( bb.elementAt(3)== field ){
			openScreen(new noticia(pagg.elementAt(3).toString(),idnn.elementAt(3).toString()));
		}else if( bb.elementAt(4)== field ){
			openScreen(new noticia(pagg.elementAt(4).toString(),idnn.elementAt(4).toString()));
		}else if( bb.elementAt(5)== field ){
			openScreen(new noticia(pagg.elementAt(5).toString(),idnn.elementAt(5).toString()));
		}else if( bb.elementAt(6)== field ){
			openScreen(new noticia(pagg.elementAt(5).toString(),idnn.elementAt(6).toString()));
		}		
	}

	public boolean onClose() {
		//force the app to quit
		TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 600);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		openScreen(new principal());
		return true ;
	}
}