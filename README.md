# Lab_5.Regex
This is a branch of the [Java-BSU](https://github.com/KoAlexandra13/Java-BSU/) repository.


## Lab 5 - **Regular expressions**.

Variant 2.

# Problem
Read data from the file ( > =6 test lines). 

Write the results to the file. Use the following classes: FileReader, FileWriter, BufferedReader, BufferedWriter.


Write a regular expression to determine if the string is GUID with or without parentheses. Where a GUID is a line of 8, 4, 4, 4, 4, 12 hexadecimal digits separated by a dash.
#### Correct expressions: 
{e02fa0e4-01ad-090A-c130-0d05a0008ba0}
e02fd0e4-00fd-090A-ca30-0d00a0038ba0
#### Incorrect expressions: 

02fa0e4-01ad-090A-c130-0d05a0008ba0}
e02fd0e400fd090Aca300d00a0038ba0
