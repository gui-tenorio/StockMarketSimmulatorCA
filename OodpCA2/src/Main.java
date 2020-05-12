import data.Menu;
import data.SetUpDBData;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetUpDBData setData = new SetUpDBData();
        Menu menu = new Menu();
        menu.StartMenu(setData);
	}
}