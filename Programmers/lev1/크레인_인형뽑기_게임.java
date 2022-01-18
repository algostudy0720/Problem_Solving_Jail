package Programmers.lev1;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		solution(board, moves);
	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				int temp = board[j][moves[i]-1];
				if(temp != 0) {
					if(!st.isEmpty() && st.peek() == temp) {
						board[j][moves[i]-1] = 0;
						answer += 2;
						st.pop();
						break;
					}
					else {
						st.push(temp);
						board[j][moves[i]-1] = 0;
						break;
					}
				}
			}
		}
        
        System.out.println(answer);
        return answer;
    }
}
