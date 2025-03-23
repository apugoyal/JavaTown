import java.util.HashSet;

public class SlidingWindow {
    
    //Find the Longest Substring Without Repeating Characters

    String find1(String input) throws IllegalArgumentException {

        //input validations
        if(input == null) {
            throw new IllegalArgumentException();
        }

        String result = null;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<input.length(); i++) {
            //IMPORTANT - how get string from char!
            String ch = Character.toString(input.charAt(i));

            if(sb.toString().contains(ch)) {
                if(result != null) {
                    if (result.length() < sb.toString().length()) {
                        result = sb.toString();
                        sb = new StringBuilder();
                    }
                } else {
                    result = sb.toString();
                    sb = new StringBuilder();
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
            //System.out.println(result + " "+ sb);
        }

        if (result == null || result.length() < sb.toString().length()) {
            result = sb.toString();
        }

        //return result
        return result;
    }

    String findUsingHashSet(String input) {
        
        int left = 0;
        String result = null;
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int right = 0; right < input.length(); right++) {
            while(set.contains(Character.toString(input.charAt(right)))) {
                sb.append(Character.toString(input.charAt(left)));
                set.remove(Character.toString(input.charAt(left)));
                left++;
            }
            set.add(Character.toString(input.charAt(right)));
        }


        return result;
    }

    public static void main(String[] args) {
        SlidingWindow obj = new SlidingWindow();
        System.out.println(obj.find1("abcdefgabcd"));
        System.out.println(obj.findUsingHashSet("abcdefgabcd"));     
    }
}
