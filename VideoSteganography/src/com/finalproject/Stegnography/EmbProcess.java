package com.finalproject.Stegnography;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

  //this class embeds and de-embeds a document with a video file.
public class EmbProcess {
    String embfilename;
    // embedding a document/file behind a video so that even when the file is intercepted,
    //the intereceptor will not know there is hidden information behind the video.
    public String emb(String s, String s1)
    {
        try{
        File file = new File(s);
        File file1 = new File(s1);
        String des = System.getProperty("user.home")+"/Desktop/SteganFile/";
                File fi=new File(des, "EmbeddedFile");
                fi.mkdirs();
        File tempo = new File(fi , file.getName());
        if(tempo.exists()){
            tempo.delete();
        }
        FileInputStream fileinputstream = new FileInputStream(s);
        FileOutputStream fileoutputstream = new FileOutputStream(tempo);
        byte abyte0[] = new byte[8];
        int i;
        int k;
        for(k = 0; (i = fileinputstream.read(abyte0, 0, 8)) > 0; k = i)
            fileoutputstream.write(abyte0, 0, i);
        fileinputstream.close();
        for(int l = 1; l <= 8 - k; l++)
            fileoutputstream.write(65);

        fileoutputstream.write("DATAFILE".getBytes(), 0, 8);
        System.out.println("File name==="+file1.getName());
        StringBuilder stringbuffer = new StringBuilder(file1.getName());
        stringbuffer.setLength(50);
        fileoutputstream.write(stringbuffer.toString().getBytes(), 0, 50);
        fileinputstream = new FileInputStream(s1);
        int j;
        while((j = fileinputstream.read(abyte0, 0, 8)) > 0) 
            fileoutputstream.write(abyte0, 0, j);
        fileinputstream.close();
        fileoutputstream.close(); 
        embfilename = tempo.toString();
        }
        catch(IOException e){
            embfilename="";
        }
        return embfilename;
    }
    
    
   // de-embedding a document from a video file for onwards processing after it has been received by
    //the right receipient.
    public String demb(String s)
    {
        boolean flag;
        String demfile = "";
        try
        {
            File file = new File(s);
            String outpath=s.substring(0, s.lastIndexOf("\\")+1);
            FileInputStream fileinputstream = new FileInputStream(s);
            char c = '\b';
            byte abyte0[] = new byte[c];
            String s1 = "";
            int i;
            
            while((i = fileinputstream.read(abyte0, 0, c)) > 0) 
            {
                s1 = new String(abyte0);
                if(s1.equals("DATAFILE"))
                    break;
            }
            if(!s1.equals("DATAFILE"))
            {
                flag=false;
                fileinputstream.close();
                return demfile;
            }
            abyte0 = new byte[50];
            fileinputstream.read(abyte0, 0, 50);
            s1 = new String(abyte0);
            String s2 = s1.trim();
            String fpath = s2;
            System.out.println("fpath------"+fpath);
            String des = System.getProperty("user.home")+"/Desktop/SteganFile/";
                File fi=new File(des, "DeembeddedFile");
                fi.mkdirs();
                File filedem = new File(fi,fpath);
                if(filedem.exists()){
                    filedem.delete();
                }
                filedem.toString();
            FileOutputStream fileoutputstream = new FileOutputStream(filedem);
            c = '\u5000';
            abyte0 = new byte[c];
            while((i = fileinputstream.read(abyte0, 0, c)) > 0) 
                fileoutputstream.write(abyte0, 0, i);
            fileinputstream.close();
            fileoutputstream.close();
            demfile=fi.toString()+File.separator+fpath;
        }
        catch(IOException exception)
        {
            demfile="";
            System.out.println(exception);
        }
        return demfile;
    }

}
