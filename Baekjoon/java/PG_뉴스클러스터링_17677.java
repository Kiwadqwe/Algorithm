import java.util.*;

public class PG_뉴스클러스터링_17677 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE","french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
    public static int solution(String str1, String str2){
        int answer = 0;
        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);

        List<String> union = new ArrayList<>();
        for (int i = 0; i < str1.length()-1; i++) {
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1)))
                union.add(str1.charAt(i)+""+str1.charAt(i+1));
        }

        List<String> iters = new ArrayList<>();
        for (int i = 0; i < str1.length()-1; i++) {
            if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1)))
                iters.add(str2.charAt(i)+""+str2.charAt(i+1));
        }

        List<String> copy = List.copyOf(iters);

        iters.retainAll(union);
        union.addAll(copy);

        return (int) Math.floor((double)iters.size() / union.size() * 65536);
    }
}
