package jp.co.systena.tigerscave.Shopping.application.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.Shopping.application.model.Item;
import jp.co.systena.tigerscave.Shopping.application.service.ListService;

@Controller
public class ShoppingController {
  @Autowired
  ListService listService;

  @RequestMapping(value="/itemlist", method = RequestMethod.GET)          // URLとのマッピング
  public ModelAndView list(ModelAndView mav) {
    Map<Integer, Item> map = listService.getItemList();
    mav.addObject("items", map);
    // Viewのテンプレート名を設定
    mav.setViewName("ListView");
    return mav;

  }

}
