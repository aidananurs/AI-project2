from sympy import to_cnf, SympifyError
#from belief-base import Stuff


# def inputs(BB):
#     print('Write input:')
#     action = input()
#     form = to_cnf(action)
    
#     print('Select action:')
#     action = input()
#     action = action.lower()

print(
"""Possible actions:
rv: Revision
cd: Caluclate degree of belief of given formula
cl: Clear the belief base
di: Display current belief base
en: End program
"""
    )

end = False

while end == False:
    enter = input()
    if enter == 'rv':
        print('<Revision>')
        print('Enter a formula:')
        formula = input()
        try:
            formula = to_cnf(formula)
            print('Select order (real number from 0 to 1):')
            order = input()
            #bb.revise(formula, float(order))
        except SympifyError:
            print('Invalid formula')
        except ValueError:
            print('Order has to be a real number from 0 to 1')
        print()

    elif enter == 'cd':
        print('<Caluclate degree of belief of given formula>')
        print('Enter a formula:')
        formula = input()
        try:
            print(formula)
            #formula = to_cnf(formula)
            #print(bb.degree(formula))
        except SympifyError:
            print('<Invalid formula>')
        print()

    elif enter == 'cl':
        #bb.clear()
        print('<Clear the belief base>')
        print()

    elif enter == 'di':
        print('<Display current belief base>')
        #print(bb)
        print()
        
    elif enter == 'end':
        end = True

    else:
        print('<Invalid input>')
        print()



