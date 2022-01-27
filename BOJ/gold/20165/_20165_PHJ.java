package 백준_01272022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 골드_20165_인내의도미노장인호석
 * 접근 방식 : 
 * 큐로 받아서 도미노 따로 관리
 * 연쇄 작업이니까..큐로 처리하는게 맞지 않을까..
 * boolmap(dynamic) 과 len map(static) 따로 관리
 */
public class _20165_PHJ {
	public static class Domino {
		int x;
		int y;
		int length;
		Domino(int x, int y ,int length){
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	
static int N,M,R;
static Queue<Domino> attack = new LinkedList<>();

static int [] dx = {0,0,1,-1};//동서남북
static int [] dy = {1,-1,0,0};
static boolean [][] status;
static int [][] dominos;


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		dominos = new int[N+1][M+1];
		status = new boolean[N+1][M+1];
		
		//map input
		for(int i = 1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j<=M ;j ++) {
				dominos[i][j] = Integer.parseInt(st.nextToken());
				status[i][j] = true;
			}
		}
		// commands input
		for(int i = 1 ; i<=2*R; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(i%2==1) { //공격인 경우
				String ip = st.nextToken();
				attack(x,y,ip);//공격 메서드로 가서 큐로 시뮬
			}
			else defense(x,y);
		}
		System.out.println(score);
		print();
	}
	static int score= 0;

	/**
	 * 쓰러지지 않은 도미노는 세울필요 없다..
	 * @param x, y
	 */
	private static void defense(int x, int  y) {
		if(!status[x][y])status[x][y] = true;
	}
	
	/**
	 * 
	 * @param x,y - 쓰러지는 도미노의 시작 좌표
	 * @param direction -  쓰러지는 방향
	 * cnt로  쓰러진 도미노 횟수 관리
	 * 현재 받아온 도미노가 쓰러저있는지 아닌지 확인 --> 안쓰러져 있는 경우 : 쓰러뜨리면서  큐에 더함
	 * 큐에 쌓인 도미노들 -> 연쇄작업용 -> 위 과정 반복
	 */
	private static void attack (int x, int y, String direction) {
		int d = -1, cnt = 0;
		if(direction.equals("E")) d = 0;
		else if(direction.equals("W")) d = 1;
		else if(direction.equals("S")) d = 2;
		else if(direction.equals("N")) d = 3;
		
		if(status[x][y]) {
			int len = dominos[x][y];
			cnt = 1;
			status[x][y] = false;
			for(int i = 0 ; i<len-1 ; i++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx<=0||ny<=0||nx>N||ny>M)break;//범위 out -> stop
				if(status[nx][ny]) {// 다음 도미노는 안쓰러저 있는 상태
					attack.add(new Domino(nx,ny, dominos[nx][ny]));//쓰러뜨릴 도미노들 큐에 ㄱ
					cnt++;//숫자 ++
					status[nx][ny] = false;//쓰러뜨림
				}
				//현재 이동한 위치에서 계속하기 위해 x,y업뎃
				x = nx;
				y = ny;
			}
		}
		//위에서 쓰러뜨릴 도미노들 받아옴 -> 연쇄 작업 처리 : 과정은 위와 같음
		while(!attack.isEmpty()) {
			Domino a = attack.poll();
			x = a.x;
			y = a.y;
			int length = a.length;
//			System.out.println("연쇄작업중인 도미노 : "+a.x+", "+a.y+" 의 "+dominos[a.x][a.y]);
			for(int i = 0 ; i< length-1 ; i++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
//				System.out.println("쓰러지는중 범위 : "+nx+", "+ny);
				if(nx<=0||ny<=0||nx>N||ny>M)break;//범위 out -> stop
				if(status[nx][ny]) { //안쓰러진 도미노
					attack.add(new Domino(nx,ny,dominos[nx][ny]));//새좌표와 길이
					cnt++;//쓰러뜨린 횟수 ++(연쇄작업 중)
					status[nx][ny] = false;//방문처리
				}
				x = nx; // for continuous operation
				y = ny;
			}
		}
		score += cnt;//현 라운드 점수  합산
		//print();
	}

	/**
	 * utilities
	 */
	private static void print() {
		for(int i = 1 ; i<=N ; i++) {
			for(int j = 1; j<=M ; j++) {
	//			if(status[i][j]) {System.out.print(dominos[i][j]+"  ");}
				if(status[i][j]) {System.out.print("S ");}
				else System.out.print("F ");
			}
			System.out.println();
		}
		//System.out.println("----------------------------");
	}

}
