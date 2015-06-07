"""The simplest stuff - recursive addition"""

def sumList(a):
    if not a:
        return 0
    if len(a) == 1:
        return a[0]
    else:
        return a[0] + sumList(a[1:])

if __name__ == '__main__':
    print(sumList([]))
    print(sumList([1,2,3]))
    print(sumList([-1,-2,-3]))
