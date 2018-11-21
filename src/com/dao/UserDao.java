package com.dao;
import com.entity.Eleme;
import java.util.List;

/**
 * 在dao下新建一个UserDao接口  以及对应的方法实现类 规范开发
 * 注释供参考，实际都以笔记为准
 */

public interface UserDao {
    List<Eleme> getLink(); // 返回红包链接信息
    boolean delete(int id); // 根据id删除数据
    boolean update(int id,String link,int used
            ,String AddDate,String LastDate,String spare); // 更新链接信息,已弃用
    boolean usedToOne(); // 之前的更新有问题，现在直接换一种方法来实现好了。
}
