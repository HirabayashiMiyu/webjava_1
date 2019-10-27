package jp.co.systena.tigerscave.Shopping.application.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import jp.co.systena.tigerscave.Shopping.application.model.Item;

@Service
public class ListService {

  public Map<Integer, Item> getItemList(){
    Item shoes = new Item(00000, "スニーカー", 7000);
    Item shirt = new Item(00001, "シャツ", 3000);
    Item pants = new Item(00002, "パンツ", 5000);

    Map<Integer, Item> itemMap = new HashMap<>();
    itemMap.put(shoes.getItemId(), shoes);
    itemMap.put(shirt.getItemId(), shirt);
    itemMap.put(pants.getItemId(), pants);
    return itemMap;
  }
}
