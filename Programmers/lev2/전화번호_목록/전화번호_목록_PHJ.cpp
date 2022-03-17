#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

//greedy
bool solution(vector<string> phone_book) {
    sort(phone_book.begin(), phone_book.end());
    //for(auto i : phone_book)cout<<i<<endl;
    for(int i = 0 ; i<phone_book.size()-1 ; i++)
    {
        string str = phone_book[i]; 
        string compare = phone_book[i+1].substr(0,str.size()); //생각해보니 구지 for loop 한번 더 안돌려도..
        if(str==compare) return false;
    }
    return true;
}

/*=========================================================================================================
    효율성 실패 코드
    for(int i = 0 ; i<phone_book.size()-1 ; i++)
    {
        string str = phone_book[i];
        for(int j = i+1; j<phone_book.size() ; j++)//str이 3개면 3칸씩 잘라서 str==compare ? 반복
        {
            string compare = phone_book[j].substr(0,str.size());
            //cout<<compare<<" "<<str<<endl; 앙..j=1로해서 틀렸음..i+1이였는뎅..바부..
            if(str==compare) return false;//중복
        }
    }
 ==============================================================================================================*/
