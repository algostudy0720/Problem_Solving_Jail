package 프로그래머스_01232022;

import java.util.Arrays;

public class 기능개발_PHJ {

	public static void main(String[] args) {
		기능개발_PHJ s = new 기능개발_PHJ();
		int [] p = {93, 30, 55};
		int [] speed = {1, 30, 5};
		System.out.println(Arrays.toString(s.solution(p,speed)));
	}
/**
 * 진도가 100이 ㄹ때 서비스에 반영
 * 93 30 55 & 1 30 5->
 * 1. (100-93)7일간 작업 후 배포, 
 * 	  (100-30=70/30%)(나머지 있는경우 없는경우)3일간 작업 후 배포 after day7,  45/5=9 -> 9일간 작업 후 배포
 * => 7일째에 2개의 기능, 9일째에 1개의 기능 =>[2,1]
 * @param progress
 * @param speeds
 * @return
 */
	public static int[] solution(int[] progress, int[] speeds) {
		
		int q= 0;//몫 나머지
		/*작업일수 계산*/
		for(int i = 0 ; i <progress.length ; i++) {
			q = (100 - progress[i])/speeds[i];
			//System.out.println("몫: "+q);
			if((100-progress[i])%speeds[i]!=0) q+=1;
			progress[i] = q;//days에 다시 작업일만 집어넣는다.
		}
		/*작업이 끝났는지 확인*/
		int end_date = progress[0];
		int[] count_work = new int[progress.length];//한날 끝나는 작업수 카운트
		int day = 0;
		count_work[0]=1;//가장 첫 작업은 항상 첫날 끝남
		
		//7 3 9인 경우 : 
		for(int i = 1;i<progress.length; i++) {
			if(end_date>=progress[i]) {//이전날 끝내야하는 작업에 소요되는 시간이 현재 작업보다 많음 -> 같은날 끝낼 수 있다!
				count_work[day]++;
			}
			else {//이전 작업은 끝났는데 아직 현재 작업이 안끝남 
				day++;
				count_work[day]++;
				end_date = progress[i];//마지막 작업에 소요된 시간 업데이트
			}
		}
		/*정답 배열 사이즈 얻기*/
		int size = 0;
		for(int i = 0 ; i<progress.length; i++) {
			if(count_work[i]!=0)size++;
			else break;
		}

		/*배열  복사*/
		int [] answer = new int [size];
		for(int i = 0 ; i<size; i++) {
			answer[i] = count_work[i];
		}
		
		return answer;
	}

}
