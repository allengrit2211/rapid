package ${basepackagecore}.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/***
 * 分页
 */
public class ServiceLocator implements ApplicationContextAware {


    private static ApplicationContext applicationContext;

    public static Object getBean(String id) {
        Object object = null;
        object = applicationContext.getBean(id);
        return object;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}