#include<iostream>
using namespace std;
int main()
{
	int length;
	cin >> length;
	int* arr = new int[length];
	for (int i = 0; i < length; i++)
	{
		cin >> arr[i];
	}

	int min = arr[0], max = arr[0];
	for (int i = 0; i < length; i++)
	{
		if (min >= arr[i])
			min = arr[i];
		if (max <= arr[i])
			max = arr[i];
	}
	cout << min << " " << max;
}