#include <iostream>
#include<vector>
#include<algorithm>
#include <iterator>
#include<math.h>
using namespace std;

int main()
{
	int a, b;
	cin >> a >> b;
	vector<int> arr;
	if (int(sqrt(a)) * int(sqrt(a)) < a) // 60 -> 7*7=49 < 60
		for (int i =int(sqrt(a)) + 1; i * i <= b; i++)// i=8,9,10
			arr.push_back(i * i);
	else								// 64 -> 8910
		for (int i = int(sqrt(a)); i * i <= b; i++)// i=8,9,10
			arr.push_back(i *i);
	
	if (arr.size() > 0)
	{
		int sum = 0;
		for (int i = 0; i < arr.size(); i++)
			sum += arr[i];
		cout << sum << endl << arr[0];
	}
	else
		cout << "-1";

}