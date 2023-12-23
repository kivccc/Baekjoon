#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main()
{
    vector<string> v;
    string str;
    getline(cin,str);
    while(str.compare("#")){
        v.push_back(str);
        getline(cin,str);
    }
    string tmp;
    int mo_cnt=0;
    for(int i=0;i<v.size();i++){
        tmp=v[i];
        for(int j=0;j<tmp.size();j++){
            char c=tmp[j];
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'
            ||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
                mo_cnt++;
        }
        cout<<mo_cnt<<endl;
        mo_cnt=0;
    }
}