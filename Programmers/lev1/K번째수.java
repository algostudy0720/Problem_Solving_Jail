package Programmers.lev1;

import java.util.Arrays;

public class K번째수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
		solution(array,commands);
	}
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
			int[] temp = new int[commands[i][1] - commands[i][0] + 1];
			for (int j = commands[i][0], v = 0; j < commands[i][0] + temp.length; j++) {
				temp[v++] = array[j-1];
			}
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2]-1];
		}
        System.out.println(Arrays.toString(answer));
        return answer;
        
    }

}
