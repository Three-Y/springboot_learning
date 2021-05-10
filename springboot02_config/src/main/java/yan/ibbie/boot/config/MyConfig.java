package yan.ibbie.boot.config;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import yan.ibbie.boot.pojo.Master;
import yan.ibbie.boot.pojo.Pet;

/**
 * @Configuration 声明为一个配置类，注：当前类也是一个组件
 *                proxyBeanMethods属性，代理bean的方法，默认值为true
 *                      Full模式(proxyBeanMethods=true)：
 *                          当前配置类的对象，是CGLIB增强后的代理对象
 *                          每次调用配置类的方法时，它会检查容器中是否存在所要获取的对象
 *                          运行起来较慢
 *                          假如存在组件依赖，要保证组件依赖的组件是容器中的组件，则需要使用Full模式
 *                      Lite模式(proxyBeanMethods=false)：
 *                          当前配置类的对象，不是CGLIB增强后的代理对象
 *                          每次调用配置类的方法时，它都生成一个新的对象
 *                          运行起来较快
 * @Bean 默认方法名是bean id，返回类型是bean类型，返回值是容器中的实例
 *       可用@Bean自定义bean id，注：此时方法名就不是bean id了
 *       默认都是单例
 * @Import 导入指定类型的组件，springboot会调用其无参构造器创建其实例对象放到容器中
 *         自动创建的组件的组件名是指定类型的全类名
 * @Conditional 条件装配，满足指定条件才配置组件
 */
@Import({DBHelper.class,Pet.class})
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean //声明一个bean，方法名是bean id，返回类型就是组件类型，返回值就是容器中的实例
    public Master master666(){
        return new Master();
    }
//    @Bean
//    @ConditionalOnBean(name = "master222") //存在名为master222的bena才创建
//    public Pet pet111(){
//        return new Pet("肥猫");
//    }
//    @Bean
//    @ConditionalOnBean(name = "master666") //存在名为master666的bena才创建
//    public Pet pet222(){
//        return new Pet("肥猫");
//    }

//    @Bean //组件依赖
//    public Master master666(){
//        Master m = new Master();
//        m.setPet(pet888()); //master组件依赖了pet组件
//        return new Master();
//    }

    //@Bean("tom") //可以使用@Bean设置bean id
    @Bean
    public Pet pet888(){
        return new Pet("肥猫");
    }

}
