def solution(arr, queries):
    a=[]
    for s,e,k in queries:
        low=1000000
        for i in range(s,e+1):
            if(arr[i]>k and arr[i]<low):
                low=arr[i]
        if(low==1000000):
            a.append(-1)
        else:
            a.append(low)
    return a
                