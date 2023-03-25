principal = float(input('Enter starting balance: '))
annual_interest = float(input('Enter annual interest rate: ')) / 100
compound_period = int(input('Number of times interest is compounded in a year: '))
number_of_years = float(input('How many years to earn interest: '))
end_balance = principal * (1 + (annual_interest / compound_period)) ** \
              (compound_period * number_of_years)

print('Your ending balance is $', format(end_balance, ',.2f'), sep='')