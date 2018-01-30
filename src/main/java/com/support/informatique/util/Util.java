package com.support.informatique.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Util {

	public static byte[] getImage(File file) {
	      
	      if(file.exists()){
	         try {
	            BufferedImage bufferedImage=ImageIO.read(file);
	            ByteArrayOutputStream byteOutStream=new ByteArrayOutputStream();
	            ImageIO.write(bufferedImage, "jpg", byteOutStream);
	            return byteOutStream.toByteArray();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	      return null;
	   }
	public static void saveImage(InputStream stream) {
	      File file = new File("output.png");
	      try(FileOutputStream outputStream = new FileOutputStream(file)) {
	         BufferedImage bufferedImage = ImageIO.read(stream);
	         ImageIO.write(bufferedImage, "png", outputStream);
	         System.out.println("Image file location: "+file.getCanonicalPath());
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	 public static <E> List<E> toList(Iterable<E> iterable) {
		    if(iterable instanceof List) {
		      return (List<E>) iterable;
		    }
		    ArrayList<E> list = new ArrayList<E>();
		    if(iterable != null) {
		      for(E e: iterable) {
		        list.add(e);
		      }
		    }
		    return list;
		  }
}
