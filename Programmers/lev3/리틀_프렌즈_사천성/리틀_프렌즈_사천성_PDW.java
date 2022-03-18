package programmers;
import java.util.*;
public class 리틀_프렌즈_사천성_PDW {
    static int N = 0;
    static int M = 0;
    static char[][] map = {};
    String answer = "";
    static ArrayList<Character> list;
    static HashMap<Character, Node[]> hm;
    class Node {
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public String solution(int m, int n, String[] board) {
        String answer = "";
        list = new ArrayList<>();
        hm = new HashMap<>();
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        for(int i=0; i<N; i++){
            String data = board[i];
            for(int j=0; j<M; j++){
                map[i][j] = data.charAt(j);
                char ch = map[i][j];
                if(ch == '.' || ch == '*') continue;
                if(list.contains(ch)){
                    hm.get(ch)[1] = new Node(i,j);
                }else{
                    list.add(ch);
                    hm.put(ch, new Node[2]);
                    hm.get(ch)[0] = new Node(i,j);
                }
            }
        }
        Collections.sort(list);

        int idx = 0;
        while(list.size() > 0){
            if(idx == list.size()) {
                return "IMPOSSIBLE";
            }
            char ch = list.get(idx);
            Node[] nodes = hm.get(ch);
            int r1 = nodes[0].x;
            int c1 = nodes[0].y;
            int r2 = nodes[1].x;
            int c2 = nodes[1].y;
            if(c1 > c2) { // - |   , | -
                if((rowCheck(r1, c2, c1,ch) && colCheck(c2,r1,r2,ch))
                   || (colCheck(c1,r1,r2,ch) && rowCheck(r2,c2,c1,ch))
                  ){
                    char c = list.remove(idx);
                    answer += c;
                    map[r1][c1] = '.';
                    map[r2][c2] = '.';
                    idx =0;
                }else{
                        idx++;
                }
            }else{
                if((rowCheck(r1, c1, c2,ch) && colCheck(c2,r1,r2,ch))
                   || (colCheck(c1,r1,r2,ch) && rowCheck(r2,c1,c2,ch))
                  ){
                    char c = list.remove(idx);
                    answer += c;
                    map[r1][c1] = '.';
                    map[r2][c2] = '.';
                    idx =0;
                } else{
                           idx++;
                }
            }
            
        }
   
        return answer;
    }
    public boolean rowCheck(int r, int c1 , int c2,char ch){
        for(int i = c1; i<=c2; i++){
            if(map[r][i] != '.' && map[r][i] != ch) return false;
        }
        return true;
    }
    public boolean colCheck(int c , int r1, int r2, char ch){
        for(int i = r1; i<=r2; i++){
            if(map[i][c] != '.' && map[i][c] != ch) return false;
        }
        return true;
        
    }
}
