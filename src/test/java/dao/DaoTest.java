package dao;


import cn.hutool.core.util.RandomUtil;
import com.duxing.onlinevideo.dao.*;
import com.duxing.onlinevideo.entity.*;
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static cn.hutool.core.date.DateUtil.now;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
//@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml"})
public class DaoTest {

    @Autowired
    CourseTypeDao courseTypeDao;

    @Autowired
    BannerDao bannerDao;

    @Autowired
    CourseTopicsDao courseTopicsDao;

    @Autowired
    CourseVideoDao courseVideoDao;

    @Autowired
    ToolsItemDao toolsItemDao;

    @Autowired
    ToolsTypeDao toolsTypeDao;

    @Autowired
    UserDao userDao;

    @Test
    public void t1() {

        CourseType courseType = new CourseType();
        courseType.setFlag(1);
        courseType.setName("数据库优化");

        int code = courseTypeDao.insertCourseType(courseType);
        System.out.println(code);
    }

    @Test
    public void t2() {

        Banner banner = new Banner();
        banner.setCreateTime(new Date());
        banner.setFlag(1);
        banner.setImgUrl("url");
        banner.setTargetUrl("target");
        banner.setType(1);

        int code = bannerDao.insertBanner(banner);
        System.out.println(code);
    }

    @Test
    public void t3() {

        for (int i = 0; i < 100; i++) {
            CourseTopics courseTopics = new CourseTopics();
            courseTopics.setCreateTime(now());
            courseTopics.setTitile("Flutter从入门到进阶" + i);
            courseTopics.setCoursewareUrl("none");
            courseTopics.setIconUrl("/static/imgs/card-item.png");
            courseTopics.setFlag(1);
            courseTopics.setTopicUrl("none");
            courseTopics.setTopicIntro("一系列由易到难通用组件开发，让你学会一个基本的组件库的开发思路和技巧。" + i);
            courseTopics.setTypeId(RandomUtil.randomInt(1, 6));
            courseTopics.setViews(1000);
            courseTopics.setVipFlag(RandomUtil.randomInt(0, 2));
            int code = courseTopicsDao.insertCourseTopic(courseTopics);
            System.out.println(code);
        }


    }

    @Test
    public void t4() {
        for(int i=0;i<12;i++){
            CourseVideo courseVideo = new CourseVideo();
            courseVideo.setName("深入理解jvm"+i);
            courseVideo.setFreeView(RandomUtil.randomInt(0,2));
            courseVideo.setCreateTime(new Date());
            courseVideo.setFlag(1);
            courseVideo.setTopicId(12);
            courseVideo.setVideoUrl("//player.bilibili.com/player.html?aid=204955330&bvid=BV1ih411D7jN&cid=320054165&page=1");
            int code = courseVideoDao.insertCourseVideo(courseVideo);
            System.out.println(code);
        }

    }

    @Test
    public void t5() {
        for(int i=0;i<100;i++){
            ToolsItem toolsItem = new ToolsItem();
            toolsItem.setName("w3c文档查询"+i);
            toolsItem.setToolsUrl("http://www.w3school.com");
            toolsItem.setToolTypeId(RandomUtil.randomInt(1,4));
            toolsItem.setIconUrl("/static/imgs/card-item.png");
            int code = toolsItemDao.insertToolsItem(toolsItem);
            System.out.println(code);
        }
    }

    @Test
    public void t6() {

        ToolsType toolsType = new ToolsType();
        toolsType.setName("toolstype");

        int code = toolsTypeDao.insertToolsType(toolsType);
        System.out.println(code);
    }


    @Test
    public void t7() {

        for (int i=8;i<57;i++){
            User user = new User();
            user.setUsername("username"+i);
            user.setVipFlag(0);
            user.setMobile("13976758894");
            user.setEmail("123"+i+"@qq.com");
            user.setPassword("1234aa"+i);
            user.setCreateTime(new Date());
            user.setFalg(1);
            int code = userDao.insertUser(user);
            System.out.println(code);
        }

    }
    @Test
    public void t8(){
        PageHelper.startPage(1,16);
        List<ToolsItem> list = toolsItemDao.findToolsItemAll();
        PageInfo<ToolsItem> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getList());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getPageNum());
    }
}
