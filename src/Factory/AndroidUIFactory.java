package Factory;

import Factory.Components.Button.AndroidButton;
import Factory.Components.Button.Button;
import Factory.Components.Dropdown.Dropdown;
import Factory.Components.Menu.Menu;

public class AndroidUIFactory implements UIFactory{
    @Override
    public AndroidButton createButton() {
        return new AndroidButton();
    }

    @Override
    public Dropdown createDropdown() {
        return null;
    }

    @Override
    public Menu createMenu() {
        return null;
    }
}
