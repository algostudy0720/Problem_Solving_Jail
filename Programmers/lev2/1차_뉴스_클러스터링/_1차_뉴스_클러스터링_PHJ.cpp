#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

/* 03/03/2022 8:35~ 9:35*/
using namespace std;

/*
str1 : France -> return {FR, RA, AN, NC, CE}
set을 사용했는데..다중 집합때문에 vector로 수정
*/
 vector<string> str(string str1){
    vector<string> group;
    for(int i = 0 ; i< str1.size()-1 ; i++)
    {
         if(str1[i] <65 || str1[i+1]<65 || str1[i] >90 || str1[i+1]>90) continue;
         string temp="";
         temp.push_back(str1[i]);
         temp.push_back(str1[i+1]);
         group.push_back(temp);
    }
    return group;
}

/*Intersection 개수*/
int intersect(vector<string>A, vector<string>B){
    int cnt = 0;
    for(int i = 0 ; i<A.size() ; i++)
    {
        auto it = find(B.begin(), B.end(),A[i]);
        if(it != B.end())//같은 원소 find(index넘어가는애는 x)
        {
            cnt++;
            B.erase(it);
        }
    }
    //cout<<"교집..합.."<<cnt<<endl;
    return cnt;
}
    
int solution(string str1, string str2) {
    int answer = 0;

    //모든 문자열 대문자로 통일
    for(char &c : str2) c = toupper(c);
    for(char &c : str1) c = toupper(c);
    
    vector<string> A = str(str1);
    vector<string> B = str(str2);
    
    // for(auto a : A) cout<<a<<" ";
    // cout<<endl;
    // for(auto b : B) cout<<b<<" ";
    
    int i = intersect(A,B);
    int u = A.size() + B.size()-i;
    
    //cout<<"합집합 크기 : "<<u<<endl;
    double result = 0.0;
    
    if(u==0) return 1*65536;//공집합
    else result = ((double)i/(double)u) * 65536;
  
    return (int)result;
}
