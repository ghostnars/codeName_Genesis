/*
 * RichListScreen.java
 *
 * Copyright © 1998-2011 Research In Motion Ltd.
 * 
 * Note: For the sake of simplicity, this sample application may not leverage
 * resource bundles and resource strings.  However, it is STRONGLY recommended
 * that application developers make use of the localization features available
 * within the BlackBerry development platform to ensure a seamless application
 * experience across a variety of languages and geographies.  For more information
 * on localizing your application, please refer to the BlackBerry Java Development
 * Environment Development Guide associated with this release.
 */

package com.rim.samples.device.ui.tableandlistdemo;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.system.*;
import net.rim.device.api.ui.component.table.*;


/**
 * Screen demonstrating the use of the RichList object. Displays a list of
 * BlackBerry Smartphone devices with complex formatting and accompanying images.
 */
public final class RichListScreen extends MainScreen
{
    /**
     * Creates a new RichListScreen object
     * 
     * @param deviceData Data read from file to be displayed in list
     */
    public RichListScreen(DemoStringTokenizer deviceData)
    {
        super(Manager.NO_VERTICAL_SCROLL);

        setTitle("Rich List Screen");

        add(new LabelField("BlackBerry Devices", LabelField.FIELD_HCENTER));
        add(new SeparatorField());

        // Get this screen's main manager (VerticalFieldManager)
        Manager mainManager = getMainManager();

        // Create a RichList which will be added to the provided manager
        RichList richList = new RichList(mainManager, true, 4, 0);

        // Populate the RichList with data from text file
        while(deviceData.hasMoreTokens())
        {
            String modelNumber = deviceData.nextToken().trim();

            StringBuffer displayName = new StringBuffer(modelNumber);

            String modelName = deviceData.nextToken().trim();
            if(!modelName.equals(modelNumber))
            {
                displayName.append(" (");
                displayName.append(modelName);
                displayName.append(")");
            }

            String os = deviceData.nextToken().trim();
            String imageFileName = modelNumber + ".png";
            Bitmap bitmap = Bitmap.getBitmapResource(imageFileName);
            String year = deviceData.nextToken().trim();
            String interfaces = deviceData.nextToken().trim();

            // Add data to the RichList
            richList.add(new Object[] {bitmap, displayName.toString(), os, year, interfaces});
        }
    }
}
