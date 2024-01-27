package HashMap.OpenAddressing;


public class HashMap<K, V> {
    Dictionary<K, V>[] list;
    private int size;

    public HashMap(){
        list = new Dictionary[10];
    }


    // Add A Dictionary value (Add Method)
    public void add(K key, V value){
        // Load Factor constant
        float lFactor = 0.5f;

        // Current load factor of my list
        float cLFactor = size / (float) list.length;

        if (lFactor < cLFactor){
            resize();
        }

        // Get the Hashing value of the key
        int hashVal = hashValue(key);

        // Get the free index
        int index = freeIndex(list, hashVal, list.length);

        list[index] = new Dictionary<>(key, value);
        size++;
    }

    // Remove an item from list
    public V remove(K key){
        // Get the hash value
        int hashVal = hashValue(key);

        // Get the index
        int index = getIndex(hashVal, key);

        V val = null;
        if (0 <= index){
            val = list[index].value;
            list[index] = null;
        }

        return val;
    }

    public V get(K key){
        // Get the hash value
        int hashVal = hashValue(key);

        // Get the index
        int index = getIndex(hashVal, key);

        V val = null;
        if (0 <= index){
            val = list[index].value;
        }

        return val;
    }

    // To string method
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        str.append("{");
        for (int i = 0; i < list.length; i++) {
            str.append("\t{");

            // If this block has value then just add it
            if (list[i] != null){
                str.append(list[i].key)
                        .append(", ")
                        .append(list[i].value);

            }

            // if i == N - 1 then we don't want "}," in our str
            if (i < list.length - 1){
                str.append("},\n");
            } else {
                str.append("}\n");
            }

        }

        str.append("} ");

        return str.toString();
    }


    // Get any particular Value

    private int getIndex(int hashValue, K key){
        // Length of the list
        int N = list.length;
        int i = 0;

        while (i < N){
            // Calculate probing index
            int probe = (hashValue + i) % N;

            if (list[probe] != null && list[probe].key.equals(key)){
                return probe;
            }

            i++;
        }

        return -1;
    }

    private int freeIndex(Dictionary<K, V>[] list, int hashVal, int length) {
        int i = 0;
        int probe = 0;

        while (i < length){
            // Calculate probing index
            probe = (hashVal + i) % length;

            if (list[probe] == null){
                break;
            }

            i++;
        }

        return probe;
    }

    private int hashValue(K key) {
        return Math.abs(key.hashCode());
    }

    private void resize() {
        // Get the size of list
        int N = list.length;

        // Create a temp list of doubled size
        Dictionary<K, V> [] temp = new Dictionary[2 * N];
        // Reset the size
        size = 0;

        // Find the all the element that are in list and put it to temp
        for (int i = 0; i < N; i++) {
            if (list[i] != null){
                // Key in that position
                K key = list[i].key;

                // Get the hashing value of the key
                int hashVal = hashValue(key);

                // Get the free index of the temp array to put the value
                int index = freeIndex(temp, hashVal, 2 * N);

                temp[index] = list[i];
                size++;
            }
        }

        // Reset the pointer list to temp
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
