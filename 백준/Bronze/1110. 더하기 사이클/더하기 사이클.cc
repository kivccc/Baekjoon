#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main()
{
	int a;
	int b;
	scanf("%d", &a);
	b = a;
	int count = 0;
	do
	{
		int k;
		if (b < 10)
			 k = b * 10;
		else
			 k = b;
		int c =( k / 10 + k % 10)%10;//1
		b = (b % 10) * 10 + c;//11
		count++;
	} while (a!=b);
	printf("%d", count);
}