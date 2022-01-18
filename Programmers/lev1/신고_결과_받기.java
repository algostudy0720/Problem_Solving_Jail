package Programmers.lev1;

public class 신고_결과_받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		
		solution(id_list, report, 2);
		
	}

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[][] arr = new int[id_list.length+1][id_list.length];

        for (int i = 0; i < report.length; i++) {
        	int x = 0, y = 0;
        	String[] st = report[i].split("\\s");
        	for (int j = 0; j < id_list.length; j++) {
        		if(st[0].equals(id_list[j])) {
        			x = j;
        			break;
        		}
			}
        	
        	for (int j = 0; j < id_list.length; j++) {
        		if(st[1].equals(id_list[j])) {
        			y = j;
        			break;
        		}
			}
        	arr[x][y] = 1;
		}
        
        for (int i = 0, v = 0; i < id_list.length; i++) {
        	int total = 0;
			for (int j = 0; j < id_list.length; j++) {
				total += arr[j][i];
			}
			if(total < k) {
				for (int j = 0; j < id_list.length; j++) {
					arr[j][v] = 0;
				}
				v++;
			}
			else
				arr[id_list.length][v++] = total;
		}
        
        for (int i = 0; i < id_list.length; i++) {
        	int total = 0;
			for (int j = 0; j < id_list.length; j++) {
				total += arr[i][j];
			}
			answer[i] = total;
		}
        return answer;
    }
}
