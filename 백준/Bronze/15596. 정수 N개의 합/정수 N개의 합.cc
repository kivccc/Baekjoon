#include <vector>
long long sum(std::vector<int> &a) {
	long long ans = 0;
       for (std::vector<int>::size_type i = 0; i < a.size(); i++)
    {
        ans += a[i];
    }
	return ans;
}
