#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int a, b, c;
	scanf("%d %d %d", &a, &b, &c);

	if (a == b && a == c) //3동일
	{
		printf("%d", 10000 + 1000 * a);
	}
	else //3동일하지않은경우(2개같거나,다다름)
	{
		if (a == b)//ab동일
			printf("%d", 1000 + a * 100);
		else if(a==c)//ac동일
			printf("%d", 1000 + a * 100);
		else if(b==c)//bc동일
			printf("%d", 1000 + b * 100);
		else//3개다다름
		{
			if (a > b && a > c)//a가 제일큼
				printf("%d", a * 100);
			else if (b > a && b>c)//b가 제일큼
				printf("%d", b * 100);
			else//c가 제일큼
				printf("%d", c * 100);
		}
	}
}