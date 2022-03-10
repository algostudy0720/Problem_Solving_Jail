#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

/*사이즈로 배열 sort*/
bool compare(vector<int>v1, vector<int>v2){
    return v1.size() < v2.size();
}
vector<int> solution(string s) {
    vector<int> answer;
    vector<int> temp;//tuples배열 안에 들어갈 int 배열
    vector<vector<int>>tuples;
    string str="";//temp 배열 안에 들어갈 숫자용 스트링
    
    for(int i = 0 ; i<s.size()-1 ; i++)
    {
        if(s[i]=='{') //초기화
        {
            str = "";
            temp.clear();
        }
         else if(s[i]=='}') //배열에 추가
         {
              temp.push_back(stoi(str)); //stoi함수로 str을 숫자로 변환
              tuples.push_back(temp);   //tuples에 만들어진 int 배열을 push
         }
        else if (s[i]==',')
        {
            if(s[i+1]=='}')continue; //숫자간 콤마가 아닐 경우
            else                     //숫자 사이의 콤마일 경우
            {
                temp.push_back(stoi(str)); //만들어놨던 str값을 temp배열에 푸쉬
                str = "";//str 초기화
            }
        }
        else
        {
            str += s[i]; //str에 현재 원소를 더해서 숫자 만들기
        }
    }
    
    sort(tuples.begin(), tuples.end(),compare);//sort
    answer.push_back(tuples[0][0]);//첫번째 원소 추가
    
    for(int i = 1 ; i< tuples.size() ; i++)
    {
        for(int j = 0 ; j<tuples[i].size() ; j++)
        {
            //cout<<tuples[i][j]<<" ";
            if(find(answer.begin(),answer.end(),tuples[i][j])==answer.end())//끝까지 못찾은 경우
            {
                answer.push_back(tuples[i][j]);/
            }
        }
        //cout<<endl;
    }

    return answer;
}
