import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/7 17:08
 */
public class testGuru {
    @Test
    public void guru(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        GuruDao gd= (GuruDao) context.getBean("guruDao");
        List<Guru> gurus = gd.selectByContains("大", 1, 2);
        for (Guru guru : gurus) {
            System.out.println(guru);
        }
    }
}
