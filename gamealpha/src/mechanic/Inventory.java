package mechanic;

import items.Item;

public class Inventory {
    public Item[] ItemList;
    public int size;
    public Inventory(int size){
        this.size = size;
        ItemList = new Item[size];
    }

    public Item click(Item item, int slot){
       if(item==null){
           if(ItemList[slot]==null){
               return null;
           }else{
               return ItemList[slot];
           }
       }else{
           if(ItemList[slot]==null){
               ItemList[slot]=item;
               return null;
           }else{
               Item temp = ItemList[slot];
               ItemList[slot] = item;
               return temp;
           }
       }
    }
    public Item Get(int slot){
        return ItemList[slot];
    }
}
