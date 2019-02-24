package soundsystem.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {CDPlayer.class}) // 在Spring中启用组件扫描
// 该方式为通过注解进行配置，寻找带有@Component注解的类
public class CDPlayerAutoConfig {
}
