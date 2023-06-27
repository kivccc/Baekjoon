#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int a,b;
	scanf("%d %d", &a,&b);
	int c;
	scanf("%d",&c);
	if (b + c >= 60)
	{
		int k = (b + c)/60;//85면 1
		if (a +k >= 24)// 00으로 너어가면
		{
			printf("%d %d", a + k - 24, b+c-k*60);
		}
		else
			printf("%d %d", a + k, b + c - k * 60);


	}
	else
		printf("%d %d", a, b + c);


}