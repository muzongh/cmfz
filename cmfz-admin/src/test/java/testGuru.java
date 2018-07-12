import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.service.impl.GuruServiceImpl;
import com.baizhi.cmfz.service.impl.ManagerServiceImpl;
import org.apache.shiro.crypto.hash.Md5Hash;
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
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerDao managerServiceImpl = (ManagerDao) classPathXmlApplicationContext.getBean("managerDao");
        System.out.println(managerServiceImpl.selectRolesByManName("zs"));
        System.out.println(managerServiceImpl.selectPermissionsByName("zs"));
    }
}
