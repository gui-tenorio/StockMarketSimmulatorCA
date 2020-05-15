import data.SetUpDBData;
import data.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetUpDBData setData = new SetUpDBData();
        Menu menu = new Menu();
        setData.getItReady();
        menu.StartMenu(setData);
	}
}