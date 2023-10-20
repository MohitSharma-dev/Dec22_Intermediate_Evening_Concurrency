package Factory;

import Factory.Components.Button.AndroidButton;
import Factory.Components.Button.Button;
import Factory.Components.Button.IOSButton;
import Factory.Components.Dropdown.Dropdown;
import Factory.Components.Menu.Menu;

public class IOSUIFactory implements UIFactory{
    @Override
    public Dropdown createDropdown() {
        return null;
    }

    @Override
    public IOSButton createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return null;
    }
}
