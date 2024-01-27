package HashMap.Chaining;

import java.util.LinkedList;

public class HashMap<K, V> {
    // Create a dictionary array of length 100
    LinkedList<Dictionary<K, V>>[] list;
    // Load factor
    private float lFactor = 0.5f;
    // Size of the array
    private int size;

    public HashMap(){
        list = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            list[i] = new LinkedList<>();
        }
    }

    // Add a value to the list
    public void add(K key, V value){
        int N = list.length;
        // Generate hashValue and perform hashing on it
        int index = Math.abs(key.hashCode()) % N;

        // Current load factor
        float currentLF =  size / (float) list.length;
        // Check whether the load factor cross the mark of 0.5
        if (currentLF > lFactor){
            // Then resize the list
            resize();
        }

        list[index].add(new Dictionary<K, V>(key, value));
        size++;
    }


    // Remove an element from the list
    public K remove(K key){
        int N = list.length;
        // Generate hashValue and perform hashing on it
        int index = Math.abs(key.hashCode()) % N;

        K value = null;

        // First get the linked list
        if (list[index] != null){
            for (int i = 0; i < list[index].size(); i++) {
                if (list[index].get(i).key != null && list[index].get(i).key.equals(key)){
                    value = list[index].get(i).key;
                    // then remove the element from Linked List
                    list[index].remove(i);
                    size--;
                    break;
                }
            }
        }

        return value;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        int n = 0;
        ans.append("{\n");

        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && !list[i].isEmpty()) {
                for (int j = 0; j < list[i].size(); j++) {
                    n++;
                    ans.append("\t{")
                            .append(list[i].get(j).key)
                            .append(", ")
                            .append(list[i].get(j).value)
                            .append("},\n");

//                    if (j < list[i].size() - 1) {
//                        ans.append(",\n");
//                    } else {
//                        ans.append("\n");
//                    }
                }
            } else {
                ans.append("\t{},\n");
            }
        }

        ans.append("}" + "\n size: ").append(n);

        return ans.toString();
    }

    // Get a value to the list
    public V get(K key){
        int N = list.length;
        // Generate hashValue and perform hashing on it
        int index = Math.abs(key.hashCode()) % N;

        // First get the linked list
        if (list[index] != null){
            for (int i = 0; i < list[index].size(); i++) {
                if (list[index].get(i).key != null && list[index].get(i).key.equals(key)){
                    return list[index].get(i).value;
                }
            }
        }

        return null;
    }

    private void resize() {
        int N = list.length * 2;
        LinkedList<Dictionary<K, V>>[] temp = new LinkedList[N];

        // Size need to be updated also, So reset the value of size to 0
        size = 0;
        for (int i = 0; i < N; i++) {
            /*
                We only check till the list array length because we will add all the list's value
                to temp.
             */
            if (i < list.length && list[i] != null && !list[i].isEmpty()){
                boolean isIndexEqual = false;
                for (int j = 0; j < list[i].size(); j++) {
                    K key = list[i].get(j).key;

                    // Get the hash value of the key and hashing it
                    int index = Math.abs(key.hashCode()) % N;

                    // Get the dictionary object in that position
                    Dictionary dic = list[i].get(j);

                    /*
                     If the position for that hashing value is not null and LinkedList is not empty,
                     then add the dictionary to that position. Otherwise, create a new LinkedList and
                     then add the dictionary object to that LinkedList.
                     */
                    if (temp[index] != null && !temp[index].isEmpty()){
                        temp[index].add(dic);
                    } else {
                        temp[index] = new LinkedList<>();
                        temp[index].add(dic);
                        size++;
                    }

                    /*
                        Let's say there any of the hashing index not equal to i, then we need to put another
                        LinkedList in that position, because it may be possible this position may be null in
                        the temp array.
                     */
                    if (index == i){
                        isIndexEqual = true;
                    }
                }

                if (!isIndexEqual){
                    temp[i] = new LinkedList<>();
                }
            } else {
                /*
                    Somehow In this index there may be a value because hashing index may
                    contain a LinkedList with value. So if the index is null then we will
                    add a LinkedList to this position.
                 */
                if (temp[i] == null){
                    temp[i] = new LinkedList<>();
                }
            }


        }

        list = temp;
    }





    private class Dictionary<K, V>{
        K key;
        V value;

        public Dictionary(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
