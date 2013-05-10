/*
 * DemoStringTokenizer.java
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


/**
 * A class which encapsulates and parses a String delimited by commas 
 */
public class DemoStringTokenizer 
{
    private int _currentPosition;
    private int _maxPosition;
    private String _str;
    private String _delimiter;        
        

   /**
    * Creates a new DemoStringTokenizer object
    * @param str The string to be parsed
    */
    public DemoStringTokenizer(String str)
    {
        // Initialize members
        _currentPosition = 0;
        _str = str;
        _delimiter = ",";    
        _maxPosition = str.length();          
    }   
    
    
   /**
    * Tests whether there are more tokens available from this tokenizer's string
    * @return True if there is at least one token in the string after the current position, otherwise false
    */
    boolean hasMoreTokens()
    {
        return _currentPosition < _maxPosition;
    }
    
    
   /**
    * Returns the next token from this string tokenizer
    * @return The next token from this string tokenizer or null if there are no more tokens
    */
    String nextToken()
    {
        if (_currentPosition >= _maxPosition)
        {
            return null;
        }
        int start = _currentPosition;        
        
        _currentPosition = _str.indexOf(_delimiter, start);
        
        if(_currentPosition == -1)
        {
            _currentPosition = _maxPosition;
        }
        
        _currentPosition += 1;
        
        return _str.substring(start, _currentPosition - 1);
    }   
}
