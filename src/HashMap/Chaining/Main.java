package HashMap.Chaining;

public class Main {
    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.add("Prite", "Favourite food is poochka");
//        map.add("Ridoy", "Favourite food is fruit");
//        map.add("Neel", "Favourite food is jam");
//        map.add("Nishan", "Favourite food is chicken");
//        System.out.println(map.get("Prite"));
//        System.out.println(map.get("Ridoy"));
        HashMap<String, Integer> list = new HashMap<>();

//        for (int i = 0; i < 1000; i++) {
//            list.add("" + 'K' + i, i + 1);
//        }
//
//        System.out.println(list.get("K999"));
//        list.remove("K999");
//        System.out.println(list);

        list.add("Prite", 90);
        list.add("Ridoy", 90);
        list.add("Alice", 85);
        list.add("Bob", 92);
        list.add("Eva", 88);
        list.add("John", 95);
        list.add("Sophia", 87);
        list.add("Daniel", 91);
        list.add("Olivia", 89);
        list.add("Michael", 94);
        list.add("Emma", 86);
        list.add("David", 93);
        list.add("Ava", 84);
        list.add("Matthew", 96);
        list.add("Isabella", 82);
        list.add("Liam", 97);
        list.add("Mia", 83);
        list.add("Benjamin", 98);
        list.add("Emily", 81);
        list.add("Lucas", 99);
        list.add("Sofia", 80);

        System.out.println("Prite Got: " + list.get("Prite"));
        System.out.println("Ridoy Got: " + list.get("Ridoy"));

    }
}
