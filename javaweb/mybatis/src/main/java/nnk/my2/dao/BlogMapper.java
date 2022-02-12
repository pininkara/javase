// 2022/2/12 12:58

package nnk.my2.dao;

import nnk.my2.pojo.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    @Insert("insert into blog(id,title,author,create_time,views) " +
            "value (#{id},#{title},#{author},#{createTime},#{views})")
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询第一二三的博客
    List<Blog> queryBlogForeach(Map map);
}
