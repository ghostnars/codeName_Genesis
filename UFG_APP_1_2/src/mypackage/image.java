package mypackage;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.TransitionContext;
import net.rim.device.api.ui.Ui;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.UiEngineInstance;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.MainScreen;



 public class image extends Metodos {
		private static final int HORZ_SCROLL_FACTOR	= 10;
		private static final int VERT_SCROLL_FACTOR	= 10;

		Bitmap bitmap;
		int left = 0;
		int top = 0;
		int maxLeft = 0;
		int maxTop = 0;
		
		public image() {
			bitmap = Bitmap.getBitmapResource("pinconfig.png");
			
			if (bitmap == null) {
				UiApplication.getUiApplication().invokeLater(new Runnable() {
					public void run() {
						Dialog.alert("Failed to load image");
						System.exit(0);
					}
				});
				return;
			}
			
			if (bitmap.getWidth() > Graphics.getScreenWidth()) {
				maxLeft = bitmap.getWidth() - Graphics.getScreenWidth();
			}
			
			if (bitmap.getHeight() > Graphics.getScreenHeight()) {
				maxTop = bitmap.getHeight() - Graphics.getScreenHeight();
			}
		}
		
		protected void paint(Graphics graphics) {
			if (bitmap != null) {
				graphics.drawBitmap(0, 0, Graphics.getScreenWidth(), Graphics.getScreenHeight(),
						bitmap, left, top);
			}
		}
		
		protected boolean navigationMovement(int dx, int dy, int status, int time) {
			left += (dx * HORZ_SCROLL_FACTOR);
			top += (dy * VERT_SCROLL_FACTOR);

			if (left < 0) left = 0;
			if (top < 0) top = 0;
			if (left > maxLeft) left = maxLeft;
			if (top > maxTop) top = maxTop;

			invalidate();

			return true;
		}
		public boolean onClose() {
			TransitionContext transition = new TransitionContext(TransitionContext.TRANSITION_SLIDE);
	        transition.setIntAttribute(TransitionContext.ATTR_DURATION, 300);
	        transition.setIntAttribute(TransitionContext.ATTR_DIRECTION, TransitionContext.DIRECTION_RIGHT);
	        transition.setIntAttribute(TransitionContext.ATTR_STYLE, TransitionContext.STYLE_PUSH);
	        UiEngineInstance engine = Ui.getUiEngineInstance();
	        engine.setTransition(this, null, UiEngineInstance.TRIGGER_PUSH, transition);
			openScreen(new principal());
			return true;
		}


		public void fieldChanged(Field field, int context) {
			// TODO Auto-generated method stub
			
		}


}
