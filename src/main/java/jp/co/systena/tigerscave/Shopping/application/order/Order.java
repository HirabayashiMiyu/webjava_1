package jp.co.systena.tigerscave.Shopping.application.order;

public class Order {
  private int itemId;

  public Order(int itemId) {
    this.itemId = itemId;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  private int num =1;

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }
}


