#include <string>
#include <vector>

using namespace std;
/*문자열 u가 올바른 문자열인지 bool 값으로 반환*/
bool correct(string u)
{
    int flag = 0;
    for(int i = 0 ; i<u.size() ;i ++)
    {
        if(u[i]=='(')flag++;
        else flag--;
        if(flag<0)return false;
    }
    return true;
}

/*재귀 
return w
*/
string rec(string w)
{
    string u = "";
    string v = "";
    
    //1. 입력이 빈 문자열인 경우 빈 문자열 반환
    if(w=="")return "";
    //2.u : 균형잡힌 문자열,더이상 분리 x v=빈 문자열가능
    int cnt1 = 0;
    int cnt2 = 0;
    
    for(int i = 0  ; i< w.size(); i++)
    {
        if(w[i]=='(') cnt1 ++;
        else cnt2++;
        if(cnt1==cnt2)
        {
            u = w.substr(0 , i+1); //균형잡힌 문자열
            v = w.substr(i+1); //나머지 문자열
            break;//stops
        }
    }
    //u가 올바른 문자열이라면 재귀
    if(correct(u)) 
    {
        v = rec(v);//1단계부터 다시 
        return u+v; //수행한 문자열을 u를 이어 붙인 후 반환
    }
    else
    {
        //빈 문자열에 첫번째 문자로 '('를 붙임
        string str = "(";
        //문자열 v에 대해 1단계부터 재귀하고 결과를 str에 붙임
        str+=rec(v);
        //')' 다시 붙임
        str+= ')';
        //u의 첫 번째 &  마지막 문자 제거하고, 나머지 문자열의 괄호 방향 뒤집어서 뒤에 붙임
        u.erase(0,1);
        u.erase(u.size()-1 , 1);
        for (char &ch : u) ch = ch == '(' ? ')' : '(';
        // 생성된 문자열 반환
        return str + u;
    }
}

string solution(string p) {
    return rec(p);
}
