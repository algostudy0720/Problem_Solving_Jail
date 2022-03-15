#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
int N,M;
bool visited[501][501][4] = {false};//방문 배열 - 일단 모든 방향으로 쏴야하니까
vector<string> map;

vector<int> dx = {-1,1,0,0};//상하좌우
vector<int> dy = {0,0,-1,1};

/*회전하는 함수, 새 direction return*/
int changeDirection(char c, int dir){
   // cout<<"방향 전환"<<endl;
    if(c=='R')//우회전
    {
        if(dir == 0 )return 3; //상 -> 우
        else if (dir == 1)return 2; //하 -> 좌
        else if (dir == 2)return 0; //좌 -> 상
        else if (dir == 3) return 1; //우 -> 하
    }
    else//좌회전
    {
        if(dir == 0)return 2; //상 -> 좌
        else if (dir==1)return 3;// 하 -> 우
        else if (dir==2)return 1; //좌 -> 하
        else if (dir==3) return 0; //우 ->  상
    }
}


/*범위가 max보다 크면 0으로 리셋(다시시작), 0보다 작아지면 max-1*/
int checkRange(int pos, int max){
    if(pos<0) return max-1;
    else if (pos == max) return 0;
    else return pos;
}

/*이동 거리 return 함수*/
int simulation(int x, int y ,int dir){
    int distance = 0;
    while(true){
        if(visited[x][y][dir])break; //이미 방문 -> ends
        distance++;
        visited[x][y][dir] = true;//방문처리

        if(map[x][y]!='S') dir = changeDirection(map[x][y],dir);//직진이 아닐 경우 회전-> 방향 바꿈

        x = x + dx[dir];
        y = y + dy[dir];

        //범위 check
        x = checkRange(x,N);
        y = checkRange(y,M);
    }
    
    return distance;
}

vector<int> solution(vector<string> grid) {
    vector<int> answer;
    N = grid.size();
    M = grid[0].length();
    map = grid;//deep copy
    
    for(int i = 0 ; i<N ; i++){
        for(int j = 0; j<M ; j++){
            for(int d= 0 ; d<4 ; d++){//사방
             if(!visited[i][j][d]) answer.push_back(simulation(i,j,d));//x,y,방향, 이동 거리 return
            }
        }
    }
    sort(answer.begin(), answer.end());
    return answer;
}
