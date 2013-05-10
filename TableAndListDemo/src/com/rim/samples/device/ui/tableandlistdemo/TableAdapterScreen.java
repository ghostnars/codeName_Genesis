/*
 * TableAdapterScreen.java
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

import java.util.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.decor.*;
import net.rim.device.api.system.*;
import net.rim.device.api.ui.component.table.*;


/**
 * A screen demonstrating the use of the Table and List API to display data held
 * in a non-table data structure in table format.
 */
public final class TableAdapterScreen extends MainScreen
{
    private DeviceTableModelAdapter _tableModel;
    private Vector _devices;

    private static final int NUM_ROWS = 1;
    private static final int ROW_HEIGHT = 50;
    private static final int NUM_COLUMNS = 3;


    /**
     * Creates a new TableAdapterScreen object
     * 
     * @param deviceData Data read from file to be displayed in table
     */
    public TableAdapterScreen(DemoStringTokenizer deviceData)
    {
        super(Manager.NO_VERTICAL_SCROLL);

        setTitle("Table Adapter Screen");

        add(new LabelField("BlackBerry Devices", LabelField.FIELD_HCENTER));
        add(new SeparatorField());

        _devices = new Vector();

        _tableModel = new DeviceTableModelAdapter();

        // Add data to adapter
        while(deviceData.hasMoreTokens())
        {
            String modelNumber = deviceData.nextToken().trim();
            String modelName = deviceData.nextToken().trim();
            deviceData.nextToken(); // Consume unwanted input
            Bitmap bitmap = Bitmap.getBitmapResource(modelNumber + ".png");
            deviceData.nextToken();
            deviceData.nextToken();

            Object[] row = {modelName, modelNumber, bitmap};

            _tableModel.addRow(row);
        }

        // Set up table view and controller
        TableView tableView = new TableView(_tableModel);
        tableView.setDataTemplateFocus(BackgroundFactory.createLinearGradientBackground(Color.WHITE, Color.WHITE, Color.BLUEVIOLET, Color.BLUEVIOLET));
        TableController tableController = new TableController(_tableModel, tableView);
        tableController.setFocusPolicy(TableController.ROW_FOCUS);
        tableView.setController(tableController);

        // Specify a simple data template for displaying 3 columns
        DataTemplate dataTemplate = new DataTemplate(tableView, NUM_ROWS, NUM_COLUMNS)
        {
            /**
             * @see DataTemplate#getDataFields(int)
             */
            public Field[] getDataFields(int modelRowIndex)
            {
                Object[] data = (Object[]) (_tableModel.getRow(modelRowIndex));
                Field[] fields = {new BitmapField((Bitmap) data[0]), new LabelField((String) data[1]), new LabelField((String) data[2])};
                return fields;
            }
        };

        dataTemplate.useFixedHeight(true);

        // Define regions and row height
        dataTemplate.setRowProperties(0, new TemplateRowProperties(ROW_HEIGHT));
        for(int i = 0; i < NUM_COLUMNS; i++)
        {
            dataTemplate.createRegion(new XYRect(i, 0, 1, 1));
            dataTemplate.setColumnProperties(i, new TemplateColumnProperties(Display.getWidth() / NUM_COLUMNS));
        }

        // Apply the template to the view
        tableView.setDataTemplate(dataTemplate);

        add(tableView);
    }

    /**
     * A class encapsulating name, model number and <code>Bitmap</code> image
     * for a BlackBerry Device.
     */
    private final static class BlackBerryDevice
    {
        private String _name;
        private String _model;
        private Bitmap _image;


        /**
         * Creates a new BlackBerryDevice object
         * 
         * @param name The name of the device
         * @param model The model number of the device
         * @param image An image of the device
         */
        BlackBerryDevice(String name, String model, Bitmap image)
        {
            _name = name;
            _model = model;
            _image = image;
        }


        /**
         * Retrieves the device name
         * 
         * @return The name of the device
         */
        public String getName()
        {
            return _name;
        }


        /**
         * Retrieves the device model
         * 
         * @return The model of the device
         */
        public String getModel()
        {
            return _model;
        }


        /**
         * Retrieves the device image
         * 
         * @return The image for the device
         */
        public Bitmap getImage()
        {
            return _image;
        }
    }

    /**
     * Adapter for displaying BlackBerryDevice objects in a table format
     */
    private class DeviceTableModelAdapter extends TableModelAdapter
    {
        /**
         * @see net.rim.device.api.ui.component.table.TableModelAdapter#getNumberOfRows()
         */
        public int getNumberOfRows()
        {
            return _devices.size();
        }


        /**
         * @see net.rim.device.api.ui.component.table.TableModelAdapter#getNumberOfColumns()
         */
        public int getNumberOfColumns()
        {
            return NUM_COLUMNS;
        }


        /**
         * @see net.rim.device.api.ui.component.table.TableModelAdapter#doAddRow(Object)
         */
        protected boolean doAddRow(Object row)
        {
            Object[] arrayRow = (Object[]) row;
            _devices.addElement(new BlackBerryDevice((String) arrayRow[0], (String) arrayRow[1], (Bitmap) arrayRow[2]));
            return true;
        }


        /**
         * @see net.rim.device.api.ui.component.table.TableModelAdapter#doGetRow(int)
         */
        protected Object doGetRow(int index)
        {
            BlackBerryDevice device = (BlackBerryDevice) _devices.elementAt(index);
            Object[] row = {device.getImage(), device.getModel(), device.getName()};
            return row;
        }
    }
}
