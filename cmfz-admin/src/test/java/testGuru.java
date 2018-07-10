import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.service.impl.GuruServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/7 17:08
 */
public class testGuru {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        GuruService gs= (GuruService) context.getBean("guruServiceImpl");
        Guru guru =new Guru();
        guru.setGuruId(UUID.randomUUID().toString().replace("-",""));
        System.out.println(gs.add(guru));
    }
}
