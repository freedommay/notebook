package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller // 声明为一个控制器 组件扫描器会自动找到HomeController 也可让其带有@Component注解
public class HomeController {
    @RequestMapping(value = "/", method = GET)
    public String home() {
        return "home";  // 被Spring MVC解读为要渲染的视图名
    }
}
