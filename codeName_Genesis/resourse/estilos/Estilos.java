package estilos;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Screen;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public abstract class Estilos extends MainScreen{
	
		Estilos prevScreen ;
	
	public Estilos(){
		
	}
	
	
    public void pushScreen( Screen toPush ) 
    {
    	TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_WIPE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 500);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_LEFT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		UiApplication.getUiApplication().popScreen(this);
		UiApplication.getUiApplication().pushScreen(toPush);
    }

    public void pushScreenBack( Screen toPush ) 
    {
    	TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_WIPE);
        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 500);
        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
        UiEngineInstance engine = Ui.getUiEngineInstance();
        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
		UiApplication.getUiApplication().popScreen(this);
		UiApplication.getUiApplication().pushScreen(toPush);
    } 
    
	public class WRichTextField extends RichTextField
	{
		public WRichTextField(String string)
		{
			super(string);
		}
		
		public void paint(Graphics g)
		{      
			g.setColor(Color.WHITE);
			super.paint(g);
		}
	}
	
	public class ColorLabel extends LabelField
	{
		private int color;
		public ColorLabel(String string,int style)
		{
			super(string);
			this.color =  style;
		}
		
		public void paint(Graphics g)
		{      
			g.setColor(color);
			super.paint(g);
		}
	}
	public class CustomVertical extends VerticalFieldManager
	{
		
		private int Alto;
		private int Ancho;
		public CustomVertical(int Alto, int Ancho)
		{
			super();
			this.Alto = Alto;
			this.Ancho = Ancho;
		}

	        public int getPreferredWidth()
	        {
	            return Ancho;
	        }
	        public int getPreferredHeight()
	        {
	            return Alto;
	        }  
	        protected void sublayout( int maxWidth, int maxHeight )
	        {
	            super.sublayout(getPreferredWidth(), getPreferredHeight());
	            setExtent(getPreferredWidth(), getPreferredHeight());
	        }
	    };
	    
	    public class CustomHorizontal extends HorizontalFieldManager
		{
	    	
			private int Alto;
			private int Ancho;
			public CustomHorizontal(int Ancho, int Alto)
			{
				
				//super();
				super( USE_ALL_WIDTH | Field.FOCUSABLE );
				this.Alto = Alto;
				this.Ancho = Ancho;
				
			}

		        public int getPreferredWidth()
		        {
		            return Ancho;
		        }
		        public int getPreferredHeight()
		        {
		            return Alto;
		        }  
		        protected void sublayout( int maxWidth, int maxHeight )
		        {
		            super.sublayout(getPreferredWidth(), getPreferredHeight());
		            setExtent(getPreferredWidth(), getPreferredHeight());
		        }
		 };
		 

	    public class HorizontalField extends HorizontalFieldManager
		{
	    	
			private int Ancho;
			private int Alto;
			
			public HorizontalField(int Ancho, int Alto, long Style)
			{
				
				//super();
				super(Style);
				this.Ancho = Ancho;
				this.Alto = Alto;
				
				
			}

		        public int getPreferredWidth()
		        {
		            return Ancho;
		        }
		        public int getPreferredHeight()
		        {
		            return Alto;
		        }  
		        protected void sublayout( int maxWidth, int maxHeight )
		        {
		            super.sublayout(getPreferredWidth(), getPreferredHeight());
		            setExtent(getPreferredWidth(), getPreferredHeight());
		        }
		 };
	    public class VerticalField extends VerticalFieldManager
		{
	    	
			private int Ancho;
			private int Alto;
			
			public VerticalField(int Ancho, int Alto, long Style)
			{
				
				//super();
				super(Style);
				this.Ancho = Ancho;
				this.Alto = Alto;
				
				
			}

		        public int getPreferredWidth()
		        {
		            return Ancho;
		        }
		        public int getPreferredHeight()
		        {
		            return Alto;
		        }  
		        protected void sublayout( int maxWidth, int maxHeight )
		        {
		            super.sublayout(getPreferredWidth(), getPreferredHeight());
		            setExtent(getPreferredWidth(), getPreferredHeight());
		        }
		 };
		 
		 
			/** Start @JosueLopez TuPerfil.java form **/
			
			public class ContentTuPerfil extends VerticalFieldManager
			{
				
				private int Alto;
				public ContentTuPerfil(int Alto)
				{
					super();
					this.Alto = Alto;
				}
				
				public int getPreferredWidth()
			       {
			           return Display.getWidth()-35;
			       }
			       public int getPreferredHeight()
			       {
			           return Alto;
			       }  
			       protected void sublayout( int maxWidth, int maxHeight )
			       {
			           super.sublayout(getPreferredWidth(), getPreferredHeight());
			           setExtent(getPreferredWidth(), getPreferredHeight());
			       }
			}
			
			public class ContentTuPerfilH extends HorizontalFieldManager
			{
				
				private int Alto;
				public ContentTuPerfilH(int Alto, long Style)
				{
					super(Style);
					this.Alto = Alto;
				}
				
				public int getPreferredWidth()
			       {
			           return Display.getWidth()-35;
			       }
			       public int getPreferredHeight()
			       {
			           return Alto;
			       }  
			       protected void sublayout( int maxWidth, int maxHeight )
			       {
			           super.sublayout(getPreferredWidth(), getPreferredHeight());
			           setExtent(getPreferredWidth(), getPreferredHeight());
			       }
			}
			
			public class ContentNotH extends HorizontalFieldManager
			{
				private int Ancho;		
				private int Alto;
				public ContentNotH(int Ancho, int Alto, long Style)
				{
					super(Style);
					this.Ancho = Ancho;
					this.Alto = Alto;			
				}
				
				public int getPreferredWidth()
			       {
			           return Ancho;
			       }
			       public int getPreferredHeight()
			       {
			           return Alto;
			       }  
			       protected void sublayout( int maxWidth, int maxHeight )
			       {
			           super.sublayout(getPreferredWidth(), getPreferredHeight());
			           setExtent(getPreferredWidth(), getPreferredHeight());
			       }
			}
			
			/** End @JosueLopez TuPerfil.java form **/
}	
	
