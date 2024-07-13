Before we gonna start solving dynamic programming questions, we better understand where to use it.So,basically in dp(Dynamic Programming), we solve recursive problem optimally.It's a optimal approach of solving recursive problem.By using dp,we avoid repeatative coding for same input and output.

# How we do so--->
   Basically we use an array to store the result of smaller input,so whenever we face the same input again in recursion stack instead of calculating the whole output, we just get the result from the array.

# How to Indentify-->
  When we face a problem,we can first check for, whether it can be solved using recursion.After making the recursion tree, we can then go for, whether there present any subproblem which occuring more than one time.
  If we found so, then we can definately go for the use of dp.
