#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <sstream>

//start : 8:37pm
//+-* or -*+ 조합 문제 : 최대 상금  return
using namespace std;

vector<char>operation={'+','-','*'};//사용된 연산자를 담을 set
vector<char>priority;
vector<bool>visited={false,false,false};
vector<long long>numbers;
vector<char> operators;
long long maxVal = 0;//이게 원인....ㅇㅁㅇ...

//숫자와 문자 분리
void init(string str){
    string num;
    for(int i = 0 ; i<str.length() ; i++)
    {
        if(isdigit(str[i])==0)//숫자가 아님
        {
            numbers.push_back(stoll(num));//여태까지 만들었던 숫자 저장
            operators.push_back(str[i]);//연산자도 저장
            num = "";//초기화
        }
        else num+=str[i];
    }
    numbers.push_back(stoll(num));//마지막 숫자 push
}

long long calculate(long long a, long long b, char op){
    if(op=='+')return a+b;
    else if (op=='-') return a-b;
    else return a*b;
}

//어차피 연산자가 세개니까 모든 조합 구하면..아니 우선순위 어카냐구..
void perm(int depth){
    if(depth == 3){
        vector<char> opCopy = operators;//지워야해서 copy함
        vector<long long>numCopy = numbers;
        
        for(int i = 0 ; i<priority.size() ; i++)
        {
            for(int j = 0 ; j<opCopy.size() ; j++)
            {
                if(priority[i]==opCopy[j])//찾음
                {
                    long long Result = calculate(numCopy[j], numCopy[j + 1], priority[i]);
                    numCopy[j] = Result;
                    numCopy.erase(numCopy.begin() + j + 1);
                    opCopy.erase(opCopy.begin() + j);
                    j--;
                }
            }
        }
        maxVal = maxVal < abs(numCopy[0]) ? abs(numCopy[0]) : maxVal;
        return;
    }
    for(int i = 0 ; i<3 ; i++){
        if(visited[i])continue;
        visited[i] = true;
        priority.push_back(operation[i]);
        perm(depth+1);
        visited[i] = false;
        priority.pop_back();
        
    }
}

long long solution(string expression) {
    init(expression);//초기화
    perm(0);//permutation
    return maxVal;
}
