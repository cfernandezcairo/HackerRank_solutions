#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'flippingBits' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts LONG_INTEGER n as parameter.
#

def flippingBits(n):
    # Write your code here
    return n

def flippingBits_testgebruiktami1(n):
    max_ = -1 + 2**32
    return max_ - n

def flippingBits_matt558(n):
    return n ^ (2 ** 32 - 1)

def flippingBits_snekparti(n):
    # Write your code here
    mask = 2**32 - 1
    return n ^ mask

def flippingBits_bernardmwambua12(n):
    binary_n = "{0:b}".format(n)
    inverse_s = ''
    bin_32 = binary_n.zfill(32)
    for i in list(bin_32):
        if i == '0':
            inverse_s += '1' 
        else:
            inverse_s += '0' 
    return(int(inverse_s, 2))

if __name__ == '__main__':
    fptr = sys.stdout

    q = int(input().strip())

    for q_itr in range(q):
        n = int(input().strip())

        result = flippingBits(n)

        fptr.write(str(result) + '\n')

    fptr.close()
