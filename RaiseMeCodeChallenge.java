/**
 *  Raise.me Coding Challenge
 */
public class RaiseMeCodeChallenge {

    public static void main(String[] args) {
        System.out.println(substrIndex("Francisco","San Francisco"));
        System.out.println(capitalize("1st thing"));
        System.out.println(endsWith("Hello World,World"));
    }

    static int substrIndex (String needle, String haystack) {
        if(needle == null || haystack == null || needle.length() == 0 || haystack.length() == 0) return -1;
        for(int i = 0; i < haystack.length(); ++i) {
            if(needle.length() + i > haystack.length()) return -1;
            int tmp = i;

            for(int j = 0; j < needle.length(); ++j) {
                if(needle.charAt(j) == haystack.charAt(tmp)) {
                    if(j == needle.length() - 1) return i;
                    tmp++;
                } else break;
            }
        }
        return -1;
    }

    static String capitalize(String sentence) {
        String[] ca = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ca.length - 1; ++i) {
            sb.append(ca[i].substring(0,1).toUpperCase());
            sb.append(ca[i].substring(1) + " ");
        }
        sb.append(ca[ca.length-1].substring(0,1).toUpperCase());
        sb.append(ca[ca.length-1].substring(1));

        sentence = sb.toString();
        return sentence;
    }

    static boolean endsWith(String sentence) {
        String[] sa = sentence.split(",");
        String haystack = sa[0];
        String needle = sa[1];
        if(haystack.substring(haystack.length() - needle.length()).equals(needle)) return true;
        return false;
    }

}
