package com.servlet;

import com.dao.UserDao;
import com.dao.UserDaolmpl;
import com.entity.Eleme;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 实现了servlet接口的类,交互式的浏览和修改数据，生成动态web内容
 * 获取数据并且更新
 * 目前未加同步锁
 */
public class ReturnLink extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post比较安全不容易乱码，这里就直接调用了
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDaolmpl();
        // 获取数据库信息，存到里面
        List<Eleme> getLink = userDao.getLink();
        // 向request域中以键值对的形式存放信息，名字为getLink内容为getLink
        request.setAttribute("getLink",getLink);
        // 2018/10/16增加库存信息的显示,把余量也发送到request域里面
        int remain = getLink.size()-1;
        System.out.println(remain);
        request.setAttribute("remain",remain);
        // 转发到GetHongBao.jsp，让它去处理
        request.getRequestDispatcher("/GetHongBao.jsp").forward(request,response);
//        这个方法同样实现了获取数据的时候进行更新，但是我们在UserDaolmpl中已经实现了
//        UserDao ud = new UserDaolmpl();
//        if (ud.usedToOne()){
//            System.out.println("新写的doPost执行");
////            request.getRequestDispatcher("/index.jsp").forward(request,response);
//        }
    }
}
