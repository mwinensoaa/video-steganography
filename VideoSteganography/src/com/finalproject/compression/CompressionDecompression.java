
package com.finalproject.compression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

     //this class is compressing and decompressing a relatively large file if the need be.
public class CompressionDecompression {
    
           //compressing a file
       public void compress(File file, File destination)throws IOException
       {     
          FileInputStream fileInputStream = null;     
          FileOutputStream fileOutputStream;
      try {
           fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(destination);          
             DeflaterOutputStream deflatorOutputStream = new DeflaterOutputStream(fileOutputStream);
              int data;
              while ((data = fileInputStream.read()) != -1)
              {
                  deflatorOutputStream.write(data);
                  deflatorOutputStream.flush();
              }
              //close the file
              deflatorOutputStream.finish();
              fileInputStream.close();
              deflatorOutputStream.close();
              fileOutputStream.close();   
    } catch (FileNotFoundException ex) {
        
    } catch (IOException ex) {
        
    } finally {
        try {
            fileInputStream.close();
        } catch (IOException ex) {
            
        }
    }
}
       
         //decompressing  a file
  public  void Idecompress(File source, File destination) throws IOException
    {
      FileInputStream fileInputStream = null;
      FileOutputStream fileOutputStream;
    try {
        fileInputStream = new FileInputStream(source);
        fileOutputStream = new FileOutputStream(destination);     
              InflaterInputStream inflatorInputStream = new InflaterInputStream(fileInputStream );
              int data;
              while((data = inflatorInputStream.read())!=-1)
              {
                  fileOutputStream.write(data);
                  fileOutputStream.flush();
              }
              //close the files
              fileOutputStream.close();
              inflatorInputStream.close();
              fileOutputStream.close();
          
    } catch (FileNotFoundException ex) {
        
    } catch (IOException ex) {
      
    } finally {
        try {
         fileInputStream.close();
        } catch (IOException ex) {
            
        }
    }
    }
}
