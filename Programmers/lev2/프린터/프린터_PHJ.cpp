#include <string>
#include <vector>
#include <queue>
#include <cstdio> //less
#include <iostream>

using namespace std;

int solution(vector<int> priorities, int location) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int answer = 1;
    int key = priorities[location];
    //PQ생성
    priority_queue<int, vector<int>, less<int>> pq; //내림차순 pq
    
    //1. pq에 내림차순으로 정렬
    for(auto i : priorities) pq.push(i);
    
   // while(!pq.empty()){cout<<pq.top()<<" "; pq.pop();}
    //2. location 찾기
    while(!pq.empty()){
       for(int i = 0 ; i<priorities.size() ; i++)//priority배열
       {
           if(priorities[i] == pq.top()) //맨 앞의 큐와 현재 우선순위가 같으면
           {
               if(i == location)return answer; //인덱스와 given이 일치하면 찾음
                pq.pop();//같지않다면pq큐에서 제거
                answer++; //count값 증가
           }
       }
    }
    return answer;
}
