def solution(arr):
    answer=0
    while True:
        tmp=arr.copy()
        flag=False
        for idx,val in enumerate(arr):
            if(val>=50 and val %2 ==0 ):
                arr[idx]=arr[idx]//2
                flag=True
            elif(val<50 and val% 2):
                arr[idx]=arr[idx]*2+1   
                flag=True
        answer+=1
        if(flag):
            continue
        if(tmp==arr):
            return answer-1
        