package kimBobHeaven_PastCampus.menu;

import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void addItems(MenuItem menuItem){
        items.add(menuItem);
    }

    public int getMinPrice(){
        return CalcMinPrice();
    }

    private int CalcMinPrice(){
        int minPrice = Integer.MAX_VALUE;

        for(MenuItem item : items)
            minPrice = Math.min(item.getPrice(), minPrice);

        return minPrice;
    }

    public MenuItem getMenuItem(int orderNum){
        return items.get(orderNum-1);
    }
}
