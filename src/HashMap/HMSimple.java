package HashMap;

public class HMSimple {
    private int DEFAULT_SIZE = 100;
    Dictionary[] list;
    private int size;

    public HMSimple(){
        this.list = new Dictionary[DEFAULT_SIZE];
    }

    public HMSimple(int size){
        this.list = new Dictionary[size];
    }


    public void add (String key, String value){
        int N = list.length;
        // Generate hashValue and perform hashing on it
        int index = Math.abs(key.hashCode()) % N;
        list[index] = new Dictionary(key, value);
        size++;
    }

    public String delete(String key){
        int N = list.length;
        // Generate hashValue and perform hashing on it
        int index = Math.abs(key.hashCode()) % N;

        if (list[index] != null && list[index].key.equals(key)){
            Dictionary value = list[index];
            list[index] = null;
            size--;
            return value.value;
        }

        return "Not Found!";
    }

    public String get(String key){
        int N = list.length;
        // Generate hashValue and perform hashing on it
        int index = Math.abs(key.hashCode()) % N;

        if (list[index] != null && list[index].key.equals(key)){
            Dictionary value = list[index];
            return value.value;
        }

        return "Not Found!";
    }



    private class Dictionary{
        String key;
        String value;

        public Dictionary(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
