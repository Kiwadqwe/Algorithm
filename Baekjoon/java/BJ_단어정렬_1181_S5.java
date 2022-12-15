import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_단어정렬_1181_S5 {


//    public static class Point implements Comparable<Point>{
//        int l;
//        String word;
//
//        public Point(int l, String word){
//            this.l = l;
//            this.word = word;
//        }
//
//        @Override
//        public int compareTo(Point point) {
//            if(this.l == point.l){
//                return this.word.compareTo(point.word);
//            }
//
//            return this.l-point.l;
//        }
//    }

    public static class Point implements Comparable<Point>{
        String word;

        public Point(String word){
            this.word = word;
        }

        @Override
        public int compareTo(Point point) {
            if(this.word.length() == point.word.length()){
                return this.word.compareTo(point.word);
            }

            return this.word.length()-point.word.length();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String[] array = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = st.nextToken();
        }

        System.out.println(solution(N,array));
    }

    public static String solution(int N, String[] array){
        List<Point> list = new ArrayList<>();

        for(String a: array){
            list.add(new Point(a));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0).word).append("\n");

        for (int i = 1; i < list.size(); i++) {
            if(!list.get(i-1).word.equals(list.get(i).word)){
                sb.append(list.get(i).word).append("\n");
            }
        }

        return sb.toString();
    }
}
