package builder;

import observer.Item;

public class StandardItemBuilder extends ItemBuilder {
    private Item item;

    @Override
    public void buildItem(){
        item = new Item();
    }

    @Override
    public void buildName(String name){
        item.setName(name);
    }

    @Override
    public void buildBrand(String brand){
        item.setBrand(brand);
    }

    @Override
    public void buildPrice(Double price){
        item.setPrice(price);
    }

    @Override
    public Item getItem(){
        return item;
    }
}
