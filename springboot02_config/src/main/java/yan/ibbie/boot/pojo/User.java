package yan.ibbie.boot.pojo;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component  //声明为组件
@ConfigurationProperties(prefix = "user") //与配置绑定
@Getter //生成getter方法
@Setter //生成setter方法
@AllArgsConstructor //生成全部参数构造器
@NoArgsConstructor //生成无参构造器
@ToString //重写toString方法
@EqualsAndHashCode //重写equals和hashCode
public class User {
    private String username;
    private Boolean boss;
    private Date birthday;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animals;
    private Map<String,Object> score;
    private Set<Double> salaries;
    private Map<String,List<Pet>> allPets;
}
