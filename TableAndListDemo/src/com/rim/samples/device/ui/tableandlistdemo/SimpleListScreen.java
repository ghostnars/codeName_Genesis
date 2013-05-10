/*
 * SimpleListScreen.java
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
import net.rim.device.api.ui.container.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.component.table.*;


/**
 * A screen presenting a typical use for the SimpleList class. Populates a list
 * with data items read from a file.
 */
public final class SimpleListScreen extends MainScreen
{
    /**
     * Creates a new SimpleListScreen object
     * 
     * @param deviceData Data read from file to be displayed in list
     */
    public SimpleListScreen(DemoStringTokenizer deviceData)
    {
        super(Manager.NO_VERTICAL_SCROLL);

        setTitle("Simple List Screen");

        add(new LabelField("BlackBerry Devices", LabelField.FIELD_HCENTER));
        add(new SeparatorField());
        
        // Get this screen's main manager (VerticalFieldManager)
        Manager mainManager = getMainManager();
        
        // Instantiate the SimpleList
        SimpleList simpleList = new SimpleList(mainManager);

        // Iterate over the string and add comma delimited strings to the list
        while(deviceData.hasMoreTokens())
        {
            deviceData.nextToken(); // Consume unwanted input
            String modelName = deviceData.nextToken().trim();
            deviceData.nextToken();
            deviceData.nextToken();
            deviceData.nextToken();

            simpleList.add(modelName);
        }
    }
}
