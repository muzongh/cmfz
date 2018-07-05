import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/5 11:26
 */
public class testMenu {
    @Test
    public void parent(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuDao md=(MenuDao)context.getBean("menuDao");
        List<Menu> menus = md.selectParent();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
