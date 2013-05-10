/*
 * BBRTM.java
 *
 *
 * This product uses the Remember The Milk API but is not endorsed or certified by Remember The Milk.
 */

package org.emerick.rtm;

import net.rim.blackberry.api.browser.Browser;
import net.rim.blackberry.api.browser.BrowserSession;
import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;
import net.rim.device.api.ui.UiApplication;

import org.emerick.rtm.net.RTMAPI;
import org.emerick.rtm.ui.screens.ErrorScreen;
import org.emerick.rtm.ui.screens.HomeScreen;

/**
 * 
 */
final public class BBRTM extends UiApplication{
    
    //org.emerick.rtm.BBRTM
    private static final long KEY = 0x6f57cce61b297d28L;
    
    private RTM rtm;
    
    public static void main(String[] args)
    {    
       BBRTM bbrtm = new BBRTM();
       
       bbrtm.enterEventDispatcher();
    }
    
    public BBRTM()
    {
        String token = "";
        AuthenticationData data = new AuthenticationData();        
               
        try {
            PersistentObject record = PersistentStore.getPersistentObject(KEY);
            data = (AuthenticationData) record.getContents();
            if( data == null)
            {
                data = new AuthenticationData();
                data.authToken = data.frob = "";
            }
            
            if(data.frob.length() == 0)
            {
                RTMAPI api = new RTMAPI("968d8045c952707d8d13f5187a93cb9f", "ODg5ZDhlMjkxNGJiYzkxZg==");
                data.frob = api.getFrob();
                data.authToken = "";
                record.setContents(data);
                record.commit();
                BrowserSession bs = Browser.getDefaultSession();
                bs.displayPage(api.getAuthURL(data.frob));
                System.exit(0);
            }
            else if ( data.authToken.length() == 0 )
            {
                RTMAPI api = new RTMAPI("968d8045c952707d8d13f5187a93cb9f", "ODg5ZDhlMjkxNGJiYzkxZg==");
                data.authToken = api.getAuthToken(data.frob);
                rtm = new RTM(data.authToken);
                token = data.authToken;
                record.setContents(data);
                record.commit();
            }
            else
            {
                // set the auth token
                rtm = new RTM(data.authToken);
                token = data.authToken;
            }
            
             pushScreen(new HomeScreen(rtm));
        }
        catch(Exception e)
        {
            if(! e.getMessage().equals("Out of Coverage"))
            {
                PersistentObject record = PersistentStore.getPersistentObject(KEY);
                record.setContents(null);
                record.commit();
            }
            pushScreen(new ErrorScreen("BBRTM", e, data.authToken));
        }
    }
} 
