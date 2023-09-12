package com.tofit.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter{

   
   
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      try {
         String viewName = getViewName(request);
         request.setAttribute("viewName", viewName);
//         Boolean getSI =(Boolean) getSessionId(request);
//         System.out.println(getSI);
//         request.setAttribute("getSI", getSI);
      } catch (Exception e) {
         System.out.println("���ͼ�Ʈ ���� ���� �߻�");
         e.printStackTrace();
      }
      return true;
   }

   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
      
      super.postHandle(request, response, handler, modelAndView);
   }

   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
      
      super.afterCompletion(request, response, handler, ex);
   }
   
//   private boolean getSessionId(HttpServletRequest request) throws Exception {
//      boolean isLogon=false;
//         HttpSession session=request.getSession(false); // false �߰� �ʿ�
//         if(session!=null) {
//        	isLogon=(Boolean)session.getAttribute("isLogon");
//         }
//   return isLogon;
//   }
   

   //getViewName
      private String getViewName(HttpServletRequest request) throws Exception{
         String contextPath = request.getContextPath();
         String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
         if(uri == null || uri.trim().equals("")) {
            uri=request.getRequestURI();
         }
         int begin =0, end;
         if(!((contextPath == null) || "".equals(contextPath))) {
            begin = contextPath.length();
         }
         if(uri.indexOf(";") != -1) {
            end = uri.indexOf(";");
         }else if(uri.indexOf("?") != -1) {
            end = uri.indexOf("?");
         }else {
            end = uri.length();
         }
         String fileName = uri.substring(begin,end);
         if(fileName.lastIndexOf(".")!= -1) {
            fileName=fileName.substring(0,fileName.lastIndexOf("."));
         }
         if(fileName.lastIndexOf("/") != -1) {
            fileName=fileName.substring(fileName.lastIndexOf("/", 1), fileName.length());
         }
         return fileName;
      }
}