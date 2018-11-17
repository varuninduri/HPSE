# HPSE
Find Shortest path distance between cities
Description:
Given a set of cities and distance between every pair of cities, the problem is to find the shortest possible route that visits every city exactly once and returns to the starting point
Design:
Solution Can Be Obtained using following algorithm approaches 
	brute-force
	dynamic programming approach
	dijkstra
	held karp
Held Karp is a dynamic programming algorithm used to efficiently solve the shortest distance path. 
By applying the divide-and-conquer principle, Held Karp calculates the path cost of subsets of increasing length
The dynamic programming procedure of the Held–Karp algorithm takes advantage of the following property of the Shortest distance problem: Every subpath of a path of minimum distance is itself of minimum distance.

So essentially, instead of checking all solutions in a naive "top-down", brute force approach (of every possible permutation), we instead use a "bottom-up" approach where all the intermediate information required to solve the problem is developed once and once only. The initial step is the very smallest subpath. Every time we move up to solve a larger subpath, we are able to look up the solutions to all the smaller subpath problems which have already been computed. The time savings come because all of the smaller subproblems have already been solved and these savings compound exponentially (at each greater subpath level). But no "paths are removed" from the calculations–at the end of the procedure all of the subproblems will have been solved. The obvious drawback is that a very large memory size may be required to store all the intermediate results.

In summary, the time savings of the Held–Karp algorithm follow from the fact that it never duplicates solving the solution to any subset (combination) of the cities. But the brute force approach will re compute the solution to any given subset combination many times.
