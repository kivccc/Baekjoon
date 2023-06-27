#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int a, b;
	scanf("%d", &a);
	scanf("%d", &b);

	printf("%d\n", a * (b % 10));
	printf("%d\n", a * (((b % 100)-(b%10))/10));
	printf("%d\n", a * (b-(b%100))/100);
	printf("%d", a * (b % 10) + (a * (((b % 100) - (b % 10)) / 10)) * 10 + (a * (b - (b % 100)) / 100) * 100);





}