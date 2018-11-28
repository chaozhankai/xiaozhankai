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
 * @author xiaozhankai
 * date 2018/11/28
 * 逻辑修改，防止刷新
 */

public class RefreshPrevent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        UserDao userDao = new UserDaolmpl();
        // 获取数据库信息，存到里面
        List<Eleme> getLink = userDao.getLink();
        // 向request域中以键值对的形式存放信息，名字为getLink内容为getLink
        req.setAttribute("getLink",getLink);
        // 2018/10/16增加库存信息的显示,把余量也发送到request域里面
        int remain = getLink.size()-1;
        System.out.println(remain);
        req.setAttribute("remain",remain);
        req.getRequestDispatcher("/GetHongBao.jsp").forward(req,resp);
//        resp.sendRedirect("/GetHongBao.jsp");
    }

}
