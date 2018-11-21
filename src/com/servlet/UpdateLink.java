//package com.servlet;
//
//import com.dao.UserDao;
//import com.dao.UserDaolmpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
/**
 * 对对对，凉的就是这么彻底，不需要从网页获取数据进行的更新
 */
//public class UpdateLink extends HttpServlet {
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
//    }
//    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        int Id = Integer.parseInt(id);
//        String used = request.getParameter("used");
//        int Used = Integer.parseInt(used);
//        String link = request.getParameter("link");
//        String AddDate = request.getParameter("AddDate");
//        String LastDate = request.getParameter("LastDate");
//        String spare = request.getParameter("spare");
////        System.out.println(userId);
//        UserDao ud = new UserDaolmpl();
//        if (ud.update(Id,link,Used,AddDate,LastDate,spare)){
//            request.setAttribute("xiaoxi","更新成功");
//            request.getRequestDispatcher("/index.jsp").forward(request,response);
//        }else{
//            response.sendRedirect("/index.jsp");
//        }
//    }
//}
