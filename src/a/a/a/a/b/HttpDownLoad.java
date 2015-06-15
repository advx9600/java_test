package a.a.a.a.b;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpDownLoad {
	public static void one(){
		String urlMainF= "http://f1.w.hjfile.cn/doc/touch_m/biaori/";
		String urlLessionF= "3-%d-%d";
		String mp3NameF = "Lesson%d.mp3";
		String saveDir = "C:/Users/Administrator/Desktop/temp/autio_process/two";
		for (int i=0;i<24;i++){
			String mp3Name = String.format(mp3NameF, i+1);
			String url = urlMainF+String.format(urlLessionF, i/6*6+1,i/6*6+6)+"/"+mp3Name;
			System.out.println(url);
			String saveFile = saveDir + "/"+mp3Name;
			if (!httpDownload(url,saveFile)){
				System.out.println("saveFile:"+saveFile+"  failed!");
				break;
			}
		}
	}
	public static boolean httpDownload(String httpUrl,String saveFile){  
	       // ÏÂÔØÍøÂçÎÄ¼þ  
	       int bytesum = 0;  
	       int byteread = 0;  
	  
	       URL url = null;  
	    try {
	        url = new URL(httpUrl);  
	    } catch (MalformedURLException e1) {  
	        // TODO Auto-generated catch block  
	        e1.printStackTrace();  
	        return false;  
	    }  
	  
	       try {  
	           URLConnection conn = url.openConnection();  
	           InputStream inStream = conn.getInputStream();  
	           FileOutputStream fs = new FileOutputStream(saveFile);  
	  
	           byte[] buffer = new byte[1204];  
	           while ((byteread = inStream.read(buffer)) != -1) {  
	               bytesum += byteread;  
//	               System.out.println(bytesum);  
	               fs.write(buffer, 0, byteread);  
	           }  
	           return true;  
	       } catch (FileNotFoundException e) {  
	           e.printStackTrace();  
	           return false;  
	       } catch (IOException e) {  
	           e.printStackTrace();  
	           return false;  
	       }  
	}
}
