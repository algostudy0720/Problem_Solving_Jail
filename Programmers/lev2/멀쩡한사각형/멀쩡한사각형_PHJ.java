package 프로그래머스_01182022;
/**
 * 프로그래머스 레벨 2 멀쩡한 사각형
 * @author 박혜준
 * 접근 방식 : 일차함수
 * y = 12/8 x 임을 고려 -> 영역을 더해나감
 */
public class 멀쩡한사각형 {

	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}
	/**
	 * 함수
	 * @param w
	 * @param h
	 * @return
	 */
	public static long solution(int x, int y) {
        long answer = 0;
        for (int i = 0; i < x; i++) {// axis ->
            answer += y * i / x;	 //그래프 영역 더해준다
        }
        return answer * 2; //그래프 윗부분도 더함
    }

}
