

package com.server;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeGenerator 
{

	 public static void generateQRCodeImage(File qrFile, String qrCodeText, int size,String fileType) throws WriterException, IOException 
	 {
		  // Create the ByteMatrix for the QR-Code that encodes the given String
		  Hashtable hintMap = new Hashtable();
		  hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		  QRCodeWriter qrCodeWriter = new QRCodeWriter();
		  BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText,
		    BarcodeFormat.QR_CODE, size, size, hintMap);
		  // Make the BufferedImage that are to hold the QRCode
		  int matrixWidth = byteMatrix.getWidth();
		  BufferedImage image = new BufferedImage(matrixWidth, matrixWidth,BufferedImage.TYPE_INT_RGB);
		  image.createGraphics();
		
		  Graphics2D graphics = (Graphics2D) image.getGraphics();
		  graphics.setColor(Color.WHITE);
		  graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		  // Paint and save the image using the ByteMatrix
		  graphics.setColor(Color.BLACK);
		
		  for (int i = 0; i < matrixWidth; i++)
		  {
			   for (int j = 0; j < matrixWidth; j++) 
			   {
			    if (byteMatrix.get(i, j)) 
				    {
				     graphics.fillRect(i, j, 1, 1);
				    }
			   }
		  }
		  ImageIO.write(image, fileType, qrFile);
	 }
 
 /* Testing The Development */
 public static void main(String[] args) throws WriterException, IOException 
 {
	  
	  //String qrCodeText = "http://www.google.co.in";
      //String filePath = "Files/qr_code.png";
	  
	 
	  //String qrCodeText = "http://www.dhsinformatics.com/images/logo.gif";
	  //String filePath = "Files/dhs_logo_qr_code.png";
	  
	  String qrCodeText = "http://www.dhsinformatics.com/images/map-kormngla.gif";
	  String filePath = "Files/dhs_map_qr_code.png";
	  
	  int size = 125;//Version 27 //Size Of QR Code=(((V-1)*4)+21), where V is the QR code version 
	  String fileType = "png";
	  File qrFile = new File(filePath);
	  generateQRCodeImage(qrFile, qrCodeText, size, fileType);
	  System.out.println("DONE");
 }
}