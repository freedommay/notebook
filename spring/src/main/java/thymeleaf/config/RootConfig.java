package thymeleaf.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;


@Configuration
@ComponentScan(basePackages={"spittr"},
    excludeFilters={
        @Filter(type=FilterType.CUSTOM, value= RootConfig.WebPackage.class)
    })
public class RootConfig {
  public static class WebPackage extends RegexPatternTypeFilter {
    public WebPackage() {
      super(Pattern.compile("thymeleaf\\.web"));
    }    
  }
}
