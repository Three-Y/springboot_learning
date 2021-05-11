package yan.ibbie.boot;

import ch.qos.logback.core.db.DBHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import yan.ibbie.boot.config.MyConfig;
import yan.ibbie.boot.pojo.Master;
import yan.ibbie.boot.pojo.Pet;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApplication.class);

        Master m1 = (Master) applicationContext.getBean("master666");
        System.out.println(m1);

        Pet p1 = (Pet) applicationContext.getBean("pet888");
        Pet p2 = (Pet) applicationContext.getBean("pet888");
        System.out.println(p1==p2); //true，默认单例模式

//        Pet tom = (Pet) applicationContext.getBean("tom");
//        System.out.println(tom);

        //配置类本身也是一个组件
        MyConfig myConfig = applicationContext.getBean(MyConfig.class);
        System.out.println(myConfig); //yan.ibbie.boot.config.MyConfig$$EnhancerBySpringCGLIB$$3a490c7a@91c4a3f
        /**
         * 当用取到的配置类组件直接调用里面用于声明bean的方法
         * 并且@Configuration(proxyBeanMethods = true)时
         * 拿到的仍然是容器中的实例
         * 因为此时的myConfig是CGLIB增强后的代理对象，它会检查容器中是否存在所要获取的对象
         */
        Master m2 = myConfig.master666();
        Pet p3 = myConfig.pet888();
        System.out.println(m1==m2); //true
        System.out.println(p1==p3); //true

        String[] beanNames1 = applicationContext.getBeanNamesForType(Pet.class);
        for (String name:beanNames1) {
            System.out.println(name);
            //yan.ibbie.boot.pojo.Pet
            //pet888
        }
        String[] beanNames2 = applicationContext.getBeanNamesForType(DBHelper.class);
        for (String name:beanNames2) {
            System.out.println(name); //ch.qos.logback.core.db.DBHelper
        }

        //条件装配
        System.out.println(applicationContext.containsBean("pet222")); //true
        System.out.println(applicationContext.containsBean("pet666")); //false

        //调用beans.xml中配置的bean
        System.out.println(applicationContext.getBean("kitty")); //Pet{name='Kitty'}
        System.out.println(applicationContext.getBean("ibbie")); //Master{name='Ibbie', pet=Pet{name='Kitty'}}

        //通过配置文件注入属性
        System.out.println(applicationContext.getBean("car")); //Car{brand='ABC', price=123456.78}
    }
}
