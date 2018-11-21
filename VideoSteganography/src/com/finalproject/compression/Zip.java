package com.finalproject.compression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;



public class Zip {
    

    public void zipFile(File sourceFile) throws IOException
    {
    try{     
              
              //File source = new File(sourceFile);
          String name = getFileNameWithoutExtension(sourceFile);
             String des = System.getProperty("user.home")+"/Desktop/SteganFile/";
                File fi=new File(des, "zipped files");
                fi.mkdirs();
        File tempo = new File(fi , name+".zip");
        if(tempo.exists()){
            tempo.delete();
        }
            FileOutputStream fos = new FileOutputStream(tempo);
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            FileInputStream fis = new FileInputStream(sourceFile);
            ZipEntry zipEntry = new ZipEntry(sourceFile + sourceFile.getName());
            zipOut.putNextEntry(zipEntry);
            final byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) > 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
        }
    catch(IOException e)
    {}
    }
    
    public String getFileNameWithoutExtension(File file) {
      String nameWithoutExtension = null;
     // File file = new File(fileName);
  int index = file.getName().lastIndexOf('.');
      if (index>0&& index <= file.getName().length() - 2 ) {
      nameWithoutExtension = file.getName().substring(0, index);
      }  
    return nameWithoutExtension;
    }
  
    
 
    }

