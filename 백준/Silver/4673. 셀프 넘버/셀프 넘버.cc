#include <iostream>
#include<vector>
#include<algorithm>
#include <iterator>
using namespace std;

int self(int a)
{
	int sum = 0;
	vector<int> arr;
	arr.push_back(a);//321

	while (a /10>0)
	{
		arr.push_back(a % 10);//321 1 2
		a = a / 10;
	}
	arr.push_back(a);
	for (vector<int>::size_type i = 0; i < arr.size(); i++)
		sum += arr[i];
	return sum;
}
int main()
{
	vector<int> not_selfnumber;
	for (int i = 1; i <= 10000; i++)
	{
		not_selfnumber.push_back(self(i));
	}
	sort(not_selfnumber.begin(), not_selfnumber.end());
	cout << "1" << endl;
	for (int i = 0; i < not_selfnumber.size() - 1; i++)
		if (not_selfnumber[i + 1] - not_selfnumber[i] >= 2 && not_selfnumber[i] <= 10000)
			cout<< not_selfnumber[i] + 1 << endl;


}
