public class PG_양과늑대_92343 {
    static int answer;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
        System.out.println(solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}));
    }
    public static int solution(int[] info, int[][] edges){
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        answer = 0;
        dfs(info,edges,1,0,visited);

        return answer;
    }

    private static void dfs(int[] info, int[][] edges, int sheep, int wolf, boolean[] visited) {
       if(sheep <= wolf){
           return;
       }else{
           answer = Math.max(answer,sheep);
       }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if(visited[x] && !visited[y]){
                visited[y] = true;

                if(info[y] == 0){
                    dfs(info,edges,sheep+1,wolf,visited);
                }else{
                    dfs(info,edges,sheep,wolf+1,visited);
                }
                visited[y] = false;
            }
        }
    }
}
