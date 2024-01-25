package HashMap;

public class HMSimpleMain {
    public static void main(String[] args) {
        HMSimple map = new HMSimple();
        map.add("Prite", "Favourite food is poochka");
        map.add("Ridoy", "Favourite food is fruit");
        map.add("Neel", "Favourite food is jam");
        map.add("Nishan", "Favourite food is chicken");
        System.out.println(map.get("Prite"));
        System.out.println(map.get("Ridoy"));
    }
}
