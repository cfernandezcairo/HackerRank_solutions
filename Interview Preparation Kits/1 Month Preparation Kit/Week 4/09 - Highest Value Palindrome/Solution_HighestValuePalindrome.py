#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'highestValuePalindrome' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s
#  2. INTEGER n
#  3. INTEGER k
#

def highestValuePalindrome(s, n, k):
    # Write your code here

    # if length == 1 and can make changes
    if n==1 and k>=1:
        return '9'

    i=0
    j=n-1

    s = list(s)
    processed=[False]*n

    ## iterate string searching palindrome composition
    while i<=j:
        if s[i]==s[j]:
            pass
        else: ## not palindrome composition. make one change or return -1
            if k==0:
                return '-1'
            if s[i]>s[j]:
                s[j]=s[i]
                processed[j]=True
                k=k-1
            else:
                s[i]=s[j]
                processed[i]=True
                k=k-1
        i=i+1
        j=j-1

    ## if left any change to make, goes to maximize
    if k>0:
        i=0
        j=n-1

        ## iterate searching processed items to maximize thems
        while i<=j and k>0:
            if s[i]!='9':
                if processed[i] or processed[j]:
                    s[i]='9'
                    s[j]='9'
                    k=k-1
                else: ## make 2 changes if item is not processed and exist change posibility
                    if k>1:
                        s[i]='9'
                        s[j]='9'
                        k=k-2
            i=i+1
            j=j-1

            if i==j and k>=1:
                s[i]='9'
                break;

    return ''.join(s)


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    s = input()

    result = highestValuePalindrome(s, n, k)

    fptr.write(result + '\n')

    fptr.close()