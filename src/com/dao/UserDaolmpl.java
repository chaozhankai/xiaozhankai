package com.dao;

import com.entity.Eleme;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 新建UserDaoImpl.java     实现UserDao接口及其方法
 *
 */

public class UserDaolmpl implements UserDao{

    // 用来获取数据库的信息，并且把相应信息存入到List中，每一个都和Eleme下面的一个属性对应
    @Override
    public List<Eleme> getLink() {
        List<Eleme> list = new ArrayList<Eleme>();
        try {
            DBconn.init(); // 连接数据库
            // sql语句，按id从小到大的顺序查找used为0的数据，还未修改防止恶意注入
            ResultSet rs = DBconn.selectSql("select *from eleme where used = 0 order by id asc ");
            while (rs.next()){
                Eleme eleme = new Eleme();
                eleme.setId(rs.getInt("id"));
                eleme.setLink(rs.getString("link"));
                eleme.setUsed(rs.getInt("used"));
                // 记录了对应的每一条数据
                list.add(eleme);
            }
            DBconn.closeConn();
            // 调用更新方法，这里解决了之前获取链接的同时不能更新的问题，不需要手动更新了
            UserDao userDao = new UserDaolmpl();
            userDao.usedToOne();
            return list;

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    // 实现used从0变成1的更新
    @Override
    public boolean usedToOne() {
        boolean flag = false;
        DBconn.init();
        // sql语句，按照id从小到大的顺序把第一个used=0的数据的used置为1，limit 1，限制只更新一条数据
        String sql = "update eleme set used = 1 where used = 0 order by id asc limit 1";
        int i = DBconn.addUpdDel(sql);
        if (i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    // 未使用的方法，删除对应数据，未实现，没必要删除
    @Override
    public boolean delete(int id) {
        return false;
    }

    // 未使用的方法，更新数据，现在已遗弃，因为此方法是获取界面传入的值来更新，我们不需要传入，也没值来让他更新，舍弃
    @Override
    public boolean update(int id, String link, int used, String AddDate, String LastDate, String spare) {
        boolean flag = false;
        DBconn.init();
        String sql = "update eleme set used = 1 where used = 0 order by id asc limit 1";
        int i = DBconn.addUpdDel(sql);
        if (i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

}
