def solution(n, control):
    a={'w':1,'s':-1,'d':10,'a':-10}
    for i in control:
        n+=a[i]
    return n
        