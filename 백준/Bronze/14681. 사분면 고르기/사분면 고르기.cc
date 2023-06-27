#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int a,b;
	scanf("%d", &a);
	scanf("%d", &b);

	if (a * b > 0){
		if (a > 0)
			printf("1");
		else
			printf("3");

	}
	else {
		if (a > 0)
			printf("4");
		else
			printf("2");
	}

}