package jp.co.systena.tigerscave.Shopping;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingController {

  @RequestMapping("/")
  String home() {
    return "Hello World";
  }
  public static void main(String[] args) {
    SpringApplication.run(ApplicationContext.class, args);
  }
}
