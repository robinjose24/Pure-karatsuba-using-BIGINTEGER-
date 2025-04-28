# Pure Karatsuba Multiplication in Java
--------------------------------------------------------------------
This repository contains two Java programs that implement pure Karatsuba multiplication for multiplying very large numbers using BigInteger.
It also includes manual multiplication (schoolbook method) for comparison.

There are two versions:

karatBig.java — Basic Karatsuba vs Normal Multiplication (without benchmarking loop)

karatBigBench.java — Karatsuba vs Normal Multiplication (with benchmarking by running each 10 times)

# ✨ Files

# File Name	Description
karatBig.java	Simple Karatsuba vs Normal Multiplication with timing for single execution.
karatBigBench.java	Same as above, but each method runs 10 times and averages the timing (basic benchmarking).
# 📋 How It Works
Karatsuba Algorithm:
Efficient divide-and-conquer algorithm to multiply large numbers faster than O(n²).

Normal Multiplication:
Simulates the classic school method (manual multiplication).

Benchmarking (in karatBigBench):
Each multiplication method is run 10 times and the average time is calculated.

# 🛠️ How to Run
Compile the Java file:
javac karatBig.java
or

javac karatBigBench.java
Run the program:

java karatBig
or

java karatBigBench
/----------------------------------------------------------------
## Input:

First line: a large number (can be any number of digits)

Second line: another large number

## Output:

Displays the result of Karatsuba multiplication.

Displays the result of Normal multiplication.

Displays the time taken (in milliseconds) by both methods.

🧠 Example
## Input:

3141592653589793238462643383279502884197169399375105820974944592
2718281828459045235360287471352662497757247093699959574966967627
## Output (Sample):

Karatsuba Multiply Result:
853973422267356706546355086954657449503488853576511496187960112
Time taken: 1.23 milliseconds

Normal Multiply Result:
853973422267356706546355086954657449503488853576511496187960112
Time taken: 3.45 milliseconds
/-----------------------------------------------------------------
# 📈 Notes
The Karatsuba algorithm becomes significantly faster compared to normal multiplication as input size grows larger.

karatBigBench gives a slightly more stable timing by averaging over 10 runs.

BigInteger objects are handled properly by constructing new instances (new BigInteger("0")) rather than nulls.

/-----------------------------------------------------------------
STILL ITS SLOWER THAN THE TRADITIONAL MULTIPLICATION SINCE I HAVENT ADDED THRESHOLD, 
THIS ONE IS PURE KARATSUBA ALGORITHM
THIS DOES ITS ALGO IMPLEMENTATION EVEN FOR SMALLER NUMBER
/----------------------------------------------------------------
# 📚 References
Karatsuba algorithm - Wikipedia

Java's BigInteger class documentation
