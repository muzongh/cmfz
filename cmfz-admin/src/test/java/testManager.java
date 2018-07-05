import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/5 13:47
 */
public class testManager {
    @Test
    public void man(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao md= (ManagerDao) context.getBean("managerDao");
        Manager man=md.selectByName("zs");
        man.setManagerPassword("123456");
        System.out.println(md.updateById(man));
    }
}
