package jp.co.systena.tigerscave.Shopping.application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.Shopping.application.cart.Cart;
import jp.co.systena.tigerscave.Shopping.application.form.ListForm;
import jp.co.systena.tigerscave.Shopping.application.model.Item;
import jp.co.systena.tigerscave.Shopping.application.order.Order;
import jp.co.systena.tigerscave.Shopping.application.service.ListService;

@Controller
public class ShoppingController {
  // private static final Map<Integer, Item> map = new HashMap<>();

  @Autowired
  ListService listService;
  @Autowired
  HttpSession session;

  @RequestMapping(value = "/itemlist", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView list(ModelAndView mav) {
    Map<Integer, Item> map = listService.getItemList();
    mav.addObject("items", map);
    mav.addObject("itemid", new ListForm());
    // Viewのテンプレート名を設定
    mav.setViewName("ListView");
    return mav;
  }

  @RequestMapping(value = "/cartview", method = RequestMethod.POST)
  public ModelAndView itemIdView(@ModelAttribute ListForm listForm, ModelAndView mav) {
    Cart cart = (Cart) session.getAttribute("cartItem");
    session.removeAttribute("cartItem");

    Order order = new Order(listForm.getItemId());
    if (cart == null) {
      cart = new Cart();
    }


    cart.addOrder(order);
    session.setAttribute("cartItem", cart);
    mav.addObject(cart);

    List<Item> itemList = new ArrayList<Item>();
    Map<Integer, Item> map = listService.getItemList();
    Map<Integer, Integer> numMap = new HashMap<>();
    for (Order orderList : cart.getOrderList()) {
      numMap.put(orderList.getItemId(), orderList.getNum());
      Item item = map.get(orderList.getItemId());
      itemList.add(item);
    }
    mav.addObject("numMap", numMap);

    mav.addObject("list", itemList);
    mav.setViewName("CartView");
    return mav;
  }

}
