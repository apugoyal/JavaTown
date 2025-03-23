import java.util.LinkedHashMap;

public class FirstNonRepeatingCharacter {
    
    String findFirstNonRepeatingCharacter(String input) {

        if(input == null) {
            throw new IllegalArgumentException();
        }

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(); 

        for(int i=0; i<input.length(); i++) {
            String key = input.substring(i, i+1);
            if(map.get(key) != null) {
                int value = map.get(key);
                if(value >= 1)
                    map.remove(key);
            } else {
                map.put(key, 1);
            }
        }

        return map.firstEntry().getKey();
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();
        System.out.println(obj.findFirstNonRepeatingCharacter("apurva"));
    }
}
