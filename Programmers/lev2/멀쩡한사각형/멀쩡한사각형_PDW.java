
/*
 * 접근 방식 : 기울기를 활용해서 문제를 해결하려고 했음 W*H에서 빈칸의 사각형을 뺴려고 했는데 1억 * 1억으로 넘어가서 문제가 생김 
 * 풀이 : 함수 기울기로 접근해서 더해서 해결
 */
public class 멀쩡한사각형_PDW {
    public long solution(int w, int h) {
        long answer = 0;
        for(int i=0; i<w; i++) {
            answer += (long)h*(long)i/(long)w ;
        }
        return answer * 2;
    }
}
