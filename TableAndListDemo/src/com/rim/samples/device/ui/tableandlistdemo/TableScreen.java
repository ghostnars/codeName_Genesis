/*
 * TableScreen.java
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
import net.rim.device.api.ui.decor.*;
import net.rim.device.api.system.*;
import net.rim.device.api.ui.component.table.*;


/**
 * This sample demonstrates the use of the Table and List API to create a table
 * displaying a list of BlackBerry Smartphone devices. Formatting is specified
 * using a DataTemplate. Styles are stored in a RegionStyles object and can be
 * adjusted programmatically.
 */
public final class TableScreen extends MainScreen
{
    private RegionStyles _style;
    private TableModel _tableModel;
    private TableView _tableView;
    private TableController _controller;    

    private static final int NUM_ROWS = 4;    
    private static final int NUM_COLUMNS = 3;
    private static final int IMAGE_WIDTH = 50;


    /**
     * Creates a new TableScreen object
     * 
     * @param deviceData Data read from file to be displayed in table
     */
    public TableScreen(DemoStringTokenizer deviceData)
    {
        super(Manager.NO_VERTICAL_SCROLL);

        setTitle("Table Screen");

        
        
        _tableModel = new TableModel();

        // Set up view and controller
        _tableView = new TableView(_tableModel);
        _tableView.setDataTemplateFocus(BackgroundFactory.createLinearGradientBackground(Color.WHITE, Color.WHITE, Color.BLUEVIOLET, Color.BLUEVIOLET));
        _controller = new TableController(_tableModel, _tableView);
        _tableView.setController(_controller);

        setStyle();

        add(new LabelField("BlackBerry Devices", LabelField.FIELD_HCENTER));

        add(new SeparatorField());

        add(_tableView);

        // Populate the list
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

            // Add data to the TableModel            
            _tableModel.addRow(new Object[] {bitmap, displayName.toString(), os, year, interfaces});
        }
    }



    /**
     * Creates and displays a new TableView with a user-defined style
     */
    public void setStyle()
    {
        // Specify a data template for each item describing a block with four rows and
        // two columns. Create a region so that the image will be displayed across
        // four rows.
        DataTemplate dataTemplate = new DataTemplate(_tableView, NUM_ROWS, NUM_COLUMNS)
        {
            /**
             * @see DataTemplate#getDataFields(int)
             */
            public Field[] getDataFields(int modelRowIndex)
            {
                Object[] data = (Object[]) _tableModel.getRow(modelRowIndex);
                Field[] fields = new Field[data.length];
                for(int i = 0; i < data.length; i++)
                {
                    if(data[i] instanceof Bitmap)
                    {
                        fields[i] = new BitmapField((Bitmap) data[i]);
                    }
                    else if(data[i] instanceof String)
                    {
                        fields[i] = new LabelField(data[i], Field.FOCUSABLE);
                    }
                    else
                    {
                        fields[i] = (Field) data[i];
                    }
                }

                return fields;
            }
        };

        dataTemplate.createRegion(new XYRect(0, 1, 1, 3), _style);

        // Set the style and apply it to the data template via the setRowProperties() method
        dataTemplate.createRegion(new XYRect(0, 0, 2, 1), _style);
        dataTemplate.setRowProperties(0, new TemplateRowProperties(Font.getDefault().getHeight() + 
            (_style.getBorder() == null ? 0 : _style.getBorder().getTop() + _style.getBorder().getBottom()) +
            (_style.getMargin() == null ? 0 : _style.getMargin().top + _style.getMargin().bottom)));

        for(int i = 1; i < NUM_ROWS; i++)
        {
            dataTemplate.createRegion(new XYRect(1, i, 1, 1), _style);
            dataTemplate.setRowProperties(i, new TemplateRowProperties(Font.getDefault().getHeight() +
                (_style.getBorder() == null ? 0 : _style.getBorder().getTop() + _style.getBorder().getBottom()) +
                (_style.getMargin() == null ? 0 : _style.getMargin().top + _style.getMargin().bottom)));
        }

        // Calculate and programmatically set the width of the image section of the table
        int width = IMAGE_WIDTH + (_style.getBorder() == null ? 0 : _style.getBorder().getTop() + _style.getBorder().getBottom()) +
            (_style.getMargin() == null ? 0 : _style.getMargin().top + _style.getMargin().bottom);
        dataTemplate.setColumnProperties(0, new TemplateColumnProperties(width));

        // Set the width of the text portion of the table
        dataTemplate.setColumnProperties(1, new TemplateColumnProperties(Display.getWidth() - width));

        // Apply the template to the view
        _tableView.setDataTemplate(dataTemplate);
        dataTemplate.useFixedHeight(true);
    }
}
