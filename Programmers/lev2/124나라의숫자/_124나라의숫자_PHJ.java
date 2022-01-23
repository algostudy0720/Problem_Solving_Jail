package 프로그래머스_01232022;
/**
 * 3진법
 * 3으로 나뉘어 떨어지면 -> 앞에 4 추가 -> n/3 & -1(for next calculation since remainder == 0)
 * else 3으로 나눴을떄의 나머지를 앞에 더함 ->n/3
 * @author User
 *
 */
public class _124나라의숫자_PHJ {

	public static void main(String[] args) {
		_124나라의숫자_PHJ s = new _124나라의숫자_PHJ();
		System.out.println(s.solution(10));
	}

	public String solution(int n) {
		String answer = "";
		// System.out.println("입력값 : "+n);
		while (n > 0) {
			if (n % 3 == 0) {
				// System.out.println("n : "+n);
				answer = "4" + answer; // 앞에 더해줘야함..
				n /= 3;
				n--;
				// System.out.println("new n : "+n);
			} else {
				answer = Integer.toString(n % 3) + answer;
				n /= 3;
			}
		}
		return answer;
	}

}
