#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
bool compare(vector<int>v1, vector<int>v2){
    return v1.size() < v2.size();
}
vector<int> solution(string s) {
    vector<int> answer;
    vector<int> temp;
    vector<vector<int>>tuples;
    string str="";
    
    for(int i = 0 ; i<s.size()-1 ; i++)
    {
        if(s[i]=='{')
        {
            //초기화
            str = "";
            temp.clear();
        }
         else if(s[i]=='}')
         {
              temp.push_back(stoi(str));
              tuples.push_back(temp);
         }
        else if (s[i]==',')
        {
            if(s[i+1]=='}')continue;
            else
            {
                temp.push_back(stoi(str));
                str = "";//초기화
            }
        }
        else
        {
            str += s[i];
        }
    }
    
    sort(tuples.begin(), tuples.end(),compare);
    answer.push_back(tuples[0][0]);//첫번째 원소
    
    for(int i = 1 ; i< tuples.size() ; i++)
    {
        for(int j = 0 ; j<tuples[i].size() ; j++)
        {
            //cout<<tuples[i][j]<<" ";
            if(find(answer.begin(),answer.end(),tuples[i][j])==answer.end())//끝까지 못찾음
            {
                answer.push_back(tuples[i][j]);
            }
        }
        //cout<<endl;
    }

    return answer;
}
