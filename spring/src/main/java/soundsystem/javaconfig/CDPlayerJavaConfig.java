package soundsystem.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 表明该类是一个配置类，应包含Spring应用上下文如何创建bean的细节
public class CDPlayerJavaConfig {
    @Bean // @Bean注解告诉Spring这个方法将会返回一个对象，该对象要注册为Spring应用上下文中的Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
