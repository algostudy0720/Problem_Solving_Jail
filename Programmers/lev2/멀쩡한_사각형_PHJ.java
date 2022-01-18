package 프로그래머스_01182022;
/**
 * 프로그래머스 레벨 2
 * @author 박혜준
 * 문제 접근 방식 : 일차함수
 *
 */
public class 멀쩡한_사각형_PHJ {

	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}
	/**
	 * 함수 : 기울기가 12/8 인 일차함수-> y = 12/8x;
	 * @param w
	 * @param h
	 * @return
	 */
	public static long solution(int x, int y) {//내편의성을위해..w->x로 h->y로 수정했다
        long answer = 0;
        for (int i = 0; i < x; i++) {// ->
            answer += y * i / x;	 //그래프 영역 더해준다
        }
        return answer * 2; //그래프 윗부분도 더함
    }

}
