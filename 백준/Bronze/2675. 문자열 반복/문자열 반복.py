case=int(input())
for c in range(case):
    R , S =input().split()
    for ch in S:
        print(ch*int(R),end="")
    print()