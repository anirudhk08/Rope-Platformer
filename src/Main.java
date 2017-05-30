//import com.sun.org.apache.xpath.internal.operations.String;

import data.KeyBindings;
import menus.Window;


/**
 * This class defines the entry point into the
 * application
 */
public class Main {
    /**
     * This is the main method of the
     * rope platformer application
     * @param args - command line arguments
     */
    public static void main(String[] args) {

        /**
         * The user defined key bindings
         */
        KeyBindings k = new KeyBindings();

        /**
         * Game Window
         */
        Window w = new Window(k);



    }
}
