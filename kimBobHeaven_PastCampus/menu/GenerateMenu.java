package kimBobHeaven_PastCampus.menu;

import java.util.ArrayList;
import java.util.List;

public class GenerateMenu {

    public List<MenuItem> setMenu(){
        // 사용자가 직접 입력하도록 나중에 로직 변경하기
        // 지금은 초기값으로
        List<MenuItem> items = new ArrayList<>();

        String[] menuName = {"김밥", "라면", "떡볶이", "돈까스"};
        int[] menuPrice = {2500, 3000, 4000, 5000};

        for (int i = 0; i < menuName.length; i++)
            items.add(new MenuItem(menuName[i], menuPrice[i]));

        return items;
    }
}
