#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {

    vector<int> answer;
    vector<vector<int>> map(rows, vector<int>(columns,0));//nxm vector init
    int cnt = 1;

    //init map
    for(int i = 0 ; i < rows ; i ++)
    {
        for(int j = 0 ; j < columns ; j ++)
        {
           map[i][j] = cnt++;
        }
    }


    //queries
    for(int i = 0 ; i < queries.size() ; i ++)
    {
        int x1 = queries[i][0] -1;
        int y1 = queries[i][1] -1;
        int x2 = queries[i][2] -1;
        int y2 = queries[i][3] -1;
        
        vector<int> min;
        
        //맨 위 가로 ->
        int temp = map[x1][y2]; //오버라이딩
        min.push_back(map[x1][y1]); 
        
        for(int c1 = y2 ; c1>y1 ; c1--)
        {
            min.push_back(map[x1][c1]);
            map[x1][c1] = map[x1][c1-1];
        } 
        
        int temp2 = map[x2][y2];//꼭짓점
        min.push_back(temp2);
        
        //오른쪽 세로
        for(int r1 = x2; r1>x1 ;  r1--)
        {
            map[r1][y2] = map[r1-1][y2];
            min.push_back(map[r1][y2]);
        }
        map[x1+1][y2] = temp;
        
        //아래 가로
        temp = map[x2][y1];
        min.push_back(temp);
        
        for(int c1 =y1; c1<y2;c1++)
        {
            map[x2][c1] = map[x2][c1+1]; 
            min.push_back(map[x2][c1]);
        }
        map[x2][y2-1] = temp2;
        min.push_back(temp2);

        //왼쪽 위방향 세로
        for(int r1 = x1; r1<x2-1;r1++)
        {
           map[r1][y1] = map[r1+1][y1];
           min.push_back(map[r1][y1]);
        }
        map[x2-1][y1] = temp ;
        
        
        //min
        sort(min.begin(), min.end()); //일부러 헤더 추가 안하려고 벡터에 넣었는데 sort도 알고리즘이 필요하다...
        answer.push_back(min[0]);
        min.clear();
          
    }
     
    return answer;
}