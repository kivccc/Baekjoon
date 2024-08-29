def solution(arr):
    answer=0
    while True:
        tmp=arr.copy()
        for idx,val in enumerate(arr):
            if(val>=50 and val %2 ==0 ):
                arr[idx]=arr[idx]//2
            elif(val<50 and val% 2):
                arr[idx]=arr[idx]*2+1         
        answer+=1
        if(tmp==arr):
            return answer-1
        