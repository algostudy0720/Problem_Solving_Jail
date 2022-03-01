#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>

using namespace std;
/*
조합 구하기 (2개 이상)
ACD 111 110 101 011 ....
    maps maxcnt
*/

unordered_map<string,int> combi_map;//조합, 주문 횟수
int cnt[27];//index = 길이, element= 최대 cnt
vector<pair<string, int>> menu;//조합, 길이

/*string : 조합, int : cnt 횟수*/
bool compare(pair<string, int> a , pair<string,int>b){
    return a.second>b.second;
}

void dfs(string order , string result, int index, int depth){
    if(result.size()  == depth ) 
    {
        if(depth>=2)combi_map[result]++;
    }
    for(int i = index ; i<order.size() ; i++)
    {
        result.push_back(order[i]);
        dfs(order, result, i+1 ,depth +1 );
        result.pop_back();
    }
    
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    //모든 원소에 대해 dfs 로 보내봄
    for(auto o : orders)
    {
        sort(o.begin(), o.end()) ;//ABC CBA
        dfs(o,"",0,0);    
    }
    ///for(auto s : combi_map) cout<<s.first<<" "<<s.second<<endl;
    
    //sort
    vector<pair<string,int>>sorted;
    for(auto s : combi_map)  if(s.second>1) sorted.push_back({s.first, s.second});//최소 두명 이상 사야함
    sort(sorted.begin(), sorted.end(), compare);//cnt순으로 정렬
    //for(auto s : sorted) cout<<s.first<<" "<<s.second<<endl;
    
    //course 에 대해 가장 많이 먹은 요리
    for(auto c : course)
    {
        int max = 0;//가장 많이 주문cnt
        for(auto s : sorted)
        {
            if(s.first.size()==c)
            {
                if(max == 0)
                {
                    answer.push_back(s.first);//어차피 가장 많이 오더한게 들어감
                    max = s.second;//s.second에는 cnt가 담겨있음
                }
                else if(max == s.second)
                {
                    answer.push_back(s.first);
                }
                else break;//내림차순이라 작아지면 cut
            }
        }
    }
    
  //  for(auto a : answer) cout<<a<<endl;
    
    sort(answer.begin(), answer.end());
    return answer;
}
