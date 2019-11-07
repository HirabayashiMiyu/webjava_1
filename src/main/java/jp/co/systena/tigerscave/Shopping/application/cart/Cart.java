package jp.co.systena.tigerscave.Shopping.application.cart;

import java.util.ArrayList;
import java.util.List;
import jp.co.systena.tigerscave.Shopping.application.order.Order;

public class Cart {
  private List<Order> orderList = new ArrayList<Order>();

  public List<Order> getOrderList() {
    return orderList;
  }

  public void addOrder(Order orderItem) {
    for (Order order : orderList) {
      if (order.getItemId() == orderItem.getItemId()) {
        order.setNum(order.getNum() + 1);
        return;
      }
    }
    orderList.add(orderItem);

  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }

  public void deleteOrder(int itemId) {
//ここに何か書くと思う
  }
}
