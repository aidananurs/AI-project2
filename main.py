# -*- coding: utf-8 -*-
from sympy import to_cnf
from belief-base import Stuff



def inputs(BB):
    print('Write input:')
    action = input()
    form = to_cnf(action)



