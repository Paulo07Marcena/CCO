package Interface;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        InterfaceExample interface01 = new InterfaceExample();
        InterfaceExample interface02 = new InterfaceExample();

        List<FirstInterface> objects = new ArrayList<>();

        objects.add(interface01);
        objects.add(interface02);

        interface01.show();
    }

    public static void onlyShow(InterfaceExample test){
        test.show();
    }
}
