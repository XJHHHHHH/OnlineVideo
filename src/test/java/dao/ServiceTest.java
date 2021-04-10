package dao;

import com.duxing.onlinevideo.entity.CourseTopics;
import com.duxing.onlinevideo.service.CourseTopicsService;
import com.duxing.onlinevideo.service.UserService;
import com.duxing.onlinevideo.service.impl.MailSenderServiceImpl;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class ServiceTest {


    @Autowired
    UserService userService;

    @Autowired
    MailSenderServiceImpl mailSenderServiceImpl;


    @Autowired
    CourseTopicsService courseTopicService;

    @Test
    public void t4(){
        PageInfo<CourseTopics> list = courseTopicService.getIndexNewestTopic();
        System.out.println(list.getSize());
    }


    @Test
    public void t3() {
        PageInfo<CourseTopics> list = courseTopicService.getIndexCourseTopic(4);
        //是否有上一页
        System.out.println(list.isHasPreviousPage());
        //当前页记录数据个数
        System.out.println(list.getPageSize());
        //所有页记录 总条数
        System.out.println(list.getTotal());
        //是否有下一页
        System.out.println(list.isHasNextPage());
        //数据个数
        System.out.println(list.getSize());
        //是否是第一页
        System.out.println(list.isIsFirstPage());
        //是否为最后一页
        System.out.println(list.isIsLastPage());

    }




    @Test
    public void t1() {

        System.out.println(userService.existEmail("123@qq.com"));
    }

    @Test
    public void t2() {

        try {
            mailSenderServiceImpl.sendHtmlEmail("3295855373@qq.com","test","test");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
