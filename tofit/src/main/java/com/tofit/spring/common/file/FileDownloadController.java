package com.tofit.spring.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController {

	private static String PROFILEIMG_REPO="D:\\KimSoYoung\\tofit\\profileImg";
	private static String PRODUCTIMG_REPO="D:\\KimSoYoung\\tofit\\productImg";
	private static String PRODUCTDIMG_REPO="D:\\KimSoYoung\\tofit\\productDImg";
   
   /* 썸네일 라이브러리 활용 */
   @RequestMapping("/download")
   public void download(@RequestParam("imageFileName") String imageFileName, HttpServletRequest request, HttpServletResponse response) throws Exception{
   
      OutputStream out= response.getOutputStream();
      String downFile=PROFILEIMG_REPO + "\\" + imageFileName;
      File file = new File(downFile); //다운로드할 파일 객체를 생성

      //브라우저 다운로드 기능으로 처리
      if(file.exists()) {
         Thumbnails.of(file).size(50, 50).outputFormat("png").toOutputStream(out);
      }else {
         return;
      }
      byte[] buffer = new byte[1024*8]; //8k 씩
      out.write(buffer);
      out.close();
   }
   
   @RequestMapping("/profile")
   public void profile(@RequestParam("profileImg") String profileImg, @RequestParam("id") String id, HttpServletResponse response) throws Exception {
      OutputStream out=response.getOutputStream();
      String path=null;
      if(profileImg==null || profileImg.equals("")) {
         path=PROFILEIMG_REPO+"\\_defaultImg\\defaultImg.jpg";
      }else {
         path=PROFILEIMG_REPO+"\\"+id+"\\"+profileImg;
      }
      File imageFile=new File(path);
      response.setHeader("Cache-Control", "no-cache");
      response.addHeader("content-disposition", "attachment;fileName="+profileImg); 
      FileInputStream fis=new FileInputStream(imageFile);
      byte[] buffer=new byte[1024*8];
      while(true) {
         int count=fis.read(buffer);
         if(count==-1) break;
         out.write(buffer,0,count); 
      }
      fis.close();
      out.close();
   }
   @RequestMapping("/product")
   public void product(@RequestParam("pImg1") String pImg1, @RequestParam("pNum") String pNum, HttpServletResponse response) throws Exception {
	   OutputStream out=response.getOutputStream();
	   String path=PRODUCTIMG_REPO+"\\"+pNum+"\\"+pImg1;
	   File imageFile=new File(path);
	   response.setHeader("Cache-Control", "no-cache");
	   response.addHeader("content-disposition", "attachment;fileName="+pImg1); 
	   FileInputStream fis=new FileInputStream(imageFile);
	   byte[] buffer=new byte[1024*8];
	   while(true) {
		   int count=fis.read(buffer);
		   if(count==-1) break;
		   out.write(buffer,0,count); 
	   }
	   fis.close();
	   out.close();
   }
   @RequestMapping("/product2")
   public void product2(@RequestParam("pImg2") String pImg2, @RequestParam("pNum") String pNum, HttpServletResponse response) throws Exception {
	   OutputStream out=response.getOutputStream();
	   String path=PRODUCTDIMG_REPO+"\\"+pNum+"\\"+pImg2;
	   File imageFile=new File(path);
	   response.setHeader("Cache-Control", "no-cache");
	   response.addHeader("content-disposition", "attachment;fileName="+pImg2); 
	   FileInputStream fis=new FileInputStream(imageFile);
	   byte[] buffer=new byte[1024*8];
	   while(true) {
		   int count=fis.read(buffer);
		   if(count==-1) break;
		   out.write(buffer,0,count); 
	   }
	   fis.close();
	   out.close();
   }
}