package notas;
import java.util.Vector;

import mypackage.Metodos;
import mypackage.materias;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import ws.WsMovilSoap_Stub;

import com.twmacinta.util.Autenticacion;

import estilos.BitmapButtonField;

public class notas1 extends Metodos{
	
		Vector elements = new Vector();
		Bitmap imglab,imgfondo,imgpar,imgnotafinal;
		VerticalFieldManager m2,contentlab,contentpar,elementolab,elementopar,m,m3 , m4 , m5, m6;
		BitmapButtonField bt5 ;
		String carnet="";
		String code="";
		String userufg="";
		String pwdufg="";
		String value="";
		String token = "";
		Autenticacion verificar = new Autenticacion();
	public notas1(String Carnet , String Code,int a, String user, String pwdus){
		
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK));       
		
		
		
			try{ 
				imglab = Bitmap.getBitmapResource("lab.png");
				imgpar = Bitmap.getBitmapResource("parcial.png");
				imgfondo = Bitmap.getBitmapResource("fondoblue.png");
				imgnotafinal = Bitmap.getBitmapResource("fondomaterias.png");
    		
				carnet = Carnet;
				code = Code;
				userufg = user;
				pwdufg  = pwdus;
    		
				WsMovilSoap_Stub service= new WsMovilSoap_Stub();    		
				ws.ArrayOfAsignaturaInscrita result = service.recuperarAsignaturasInscritas(carnet, code);
				setTitle(result.getAsignaturaInscrita()[a].getNombreAsignatura());
				
				HorizontalFieldManager notaslab = new HorizontalFieldManager(Field.FIELD_RIGHT);
				
				contentlab = new VerticalFieldManager(Field.FIELD_LEFT);
				contentlab.setBackground(BackgroundFactory.createBitmapBackground(imglab));
				contentlab.setPadding(200,100,0,0); 
				contentlab.setMargin(0, 5, 5, 5);
				
	    	    

	            GridFieldManager gridlab = new GridFieldManager(5,3,0); 
	            
	            gridlab.add(new WLabelField("Laboratorio 1:"), FIELD_LEFT );
	            gridlab.add(new WLabelField("  "), FIELD_LEFT);
	            gridlab.add(new WLabelField(" "+result.getAsignaturaInscrita()[a].getEvaluaciones().getLaboratorio1()), FIELD_RIGHT);
	            
	            gridlab.add(new WLabelField("Laboratorio 2:"), FIELD_LEFT);
	            gridlab.add(new WLabelField("  "), FIELD_LEFT);
	            gridlab.add(new WLabelField(" "+result.getAsignaturaInscrita()[a].getEvaluaciones().getLaboratorio2()), FIELD_RIGHT);
	                  
	            gridlab.add(new WLabelField("Laboratorio 3:"), FIELD_LEFT);
	            gridlab.add(new WLabelField("  "), FIELD_LEFT);
	            gridlab.add(new WLabelField(" "+result.getAsignaturaInscrita()[a].getEvaluaciones().getLaboratorio3()), FIELD_RIGHT);
	            
	            gridlab.add(new WLabelField("Laboratorio 4:"), FIELD_LEFT);
	            gridlab.add(new WLabelField("  "), FIELD_LEFT);
	            gridlab.add(new WLabelField(" "+result.getAsignaturaInscrita()[a].getEvaluaciones().getLaboratorio4()), FIELD_RIGHT);
	            
	            gridlab.add(new WRichTextField(" Promedio:"), FIELD_LEFT);
	            gridlab.add(new WLabelField("   "), FIELD_LEFT);
	            gridlab.add(new WLabelField(" "+result.getAsignaturaInscrita()[a].getEvaluaciones().getPromedioLaboratorios()), FIELD_RIGHT);
	            
	            gridlab.setMargin(10, 10, 8, 10);
	            gridlab.setColumnPadding(18);
	            gridlab.setRowPadding(15);
	    		 
	    		
	    		elementolab = new VerticalFieldManager(Field.FIELD_RIGHT);
	    		elementolab.setBorder(BorderFactory.createBitmapBorder(new XYEdges(1,1,1,1), imgfondo));
	    		elementolab.add(gridlab);
	    		elementolab.setMargin(0,5,0,5);
	    		notaslab.setMargin(10,0,0,0);
	    		notaslab.add(contentlab);
	    		notaslab.add(elementolab);
				add(notaslab);
				
				
				HorizontalFieldManager notaspar = new HorizontalFieldManager(Field.FIELD_RIGHT);
				
				contentpar = new VerticalFieldManager(Field.FIELD_LEFT);
				contentpar.setBackground(BackgroundFactory.createBitmapBackground(imgpar));
				contentpar.setPadding(200,100,0,0); 
				contentpar.setMargin(0, 5, 5, 5);
				
	    	    
				
				  GridFieldManager grid = new GridFieldManager(5,3,0); 

		            grid.add(new WLabelField(" Parcial 1:"), FIELD_LEFT );
		            grid.add(new WLabelField("          "), FIELD_LEFT );
		            grid.add(new WLabelField(""+result.getAsignaturaInscrita()[a].getEvaluaciones().getPruebaObjetiva1()), FIELD_RIGHT);
		            
		            grid.add(new WLabelField(" Parcial 2:"), FIELD_LEFT);
		            grid.add(new WLabelField("          "), FIELD_LEFT );
		            grid.add(new WLabelField(""+result.getAsignaturaInscrita()[a].getEvaluaciones().getPruebaObjetiva2()), FIELD_RIGHT);
		                  
		            grid.add(new WLabelField(" Parcial 3:"), FIELD_LEFT);
		            grid.add(new WLabelField("          "), FIELD_LEFT );
		            grid.add(new WLabelField(""+result.getAsignaturaInscrita()[a].getEvaluaciones().getPruebaObjetiva3()), FIELD_RIGHT);
		            
		            grid.add(new WLabelField(" Parcial 4:"), FIELD_LEFT);
		            grid.add(new WLabelField("          "), FIELD_LEFT );
		            grid.add(new WLabelField(""+result.getAsignaturaInscrita()[a].getEvaluaciones().getPruebaObjetiva4()), FIELD_RIGHT);
		            
		            grid.add(new WRichTextField(" Promedio:"), FIELD_LEFT);
		            grid.add(new WLabelField("      "), FIELD_LEFT );
		            grid.add(new WLabelField(""+result.getAsignaturaInscrita()[a].getEvaluaciones().getPromedioPruebasObjetivas()), FIELD_RIGHT);
		            
		            grid.setMargin(10, 10, 8, 10);
		            grid.setColumnPadding(20);
		            grid.setRowPadding(15);
	        
		            elementopar = new VerticalFieldManager(Field.FIELD_RIGHT);
		            elementopar.setBorder(BorderFactory.createBitmapBorder(new XYEdges(1,1,1,1), imgfondo));
		            elementopar.add(grid);
		            elementopar.setMargin(0,5,0,5);
				  
		    		notaspar.add(contentpar);
		    		notaspar.add(elementopar);
					add(notaspar);   		
	    		
					token = verificar.validar(userufg, pwdufg);
	    		
	            
				m6 = new VerticalFieldManager(Field.USE_ALL_WIDTH);
				m6.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,1,5,30), imgnotafinal));
	    		WRichTextField notafinal = new WRichTextField("Nota Final :                       " + result.getAsignaturaInscrita()[a].getEvaluaciones().getNotaFinal());		    	    
		    	m6.setMargin(0, 5, 5, 5);
	    		m6.add(notafinal);
	    		add(m6);
	    		
	    		
	    	    
	    	    
			}catch(Exception z ){    			    	
			}
		}	

	

	public void fieldChanged(Field field, int context) {
			// TODO Auto-generated method stub
	
		}
	
	public boolean onClose() {
		TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 300);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
    	openScreen(new materias(token, code, userufg, pwdufg));
        return true;
	}
}