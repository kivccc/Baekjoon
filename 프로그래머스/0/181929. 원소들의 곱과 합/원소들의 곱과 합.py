def solution(num_list):
    a=1
    b=0
    for i in num_list:
        a*=i
    return (a<sum(num_list)**2)*1