/**   Problem statement
You are given a string ‘S’ and a set of words named ‘Dictionary’. You can perform the operation of breaking the given string 'S', in any possible way and divide the given string into any number of subparts. Your task is to break the given string 'S', such that all the subparts are present in the Dictionary. You just need to tell the minimum number of times you need to break the string 'S' in order to accomplish the above task.

Note:
1. If string 'S' is already present in the dictionary, then you don’t need to break the string and you can print 0 in such cases.
2. If it is impossible to complete the given task, then print -1.
3. All the characters of string 'S' and words inside the Dictionary only contain Uppercased English Alphabets.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 50
1 <= N <= 10^4
1 <= |S| <= 50
1 <= |word[i]| <= 50
‘A’ <= S[i] <= ‘Z’

Where |S| denotes the length of the given string, |word[i]| denotes the length of the ith word in the Dictionary.
It is guaranteed that all the words in the dictionary consist of only uppercase English alphabets from ‘A’ to ‘Z’.

Time Limit: 1 sec.
Sample Input 1:
1
CODESTUDIO
5
COD
CODE
ESTU
DIO
STUDIO
Sample Output 1:
1
Explanation of sample input 1:
We can break “CODESTUDIO” once and get subparts as “CODE” and “STUDIO”.
Sample Input 2:
1
BREAKME
3
BROKE
ME
BREAKM
Sample Output 2:
-1
Explanation of sample input 2:
Since there is no way by which we can break the given string and their subparts will be present in the Dictionary.
  **/




SOLUTION : ---
  EX  - S= "HELLO"
  Dictionary= set  of  words  in string .
  len(S) -->  6
    
  Algorithm Steps
    Input Reading:
* Read the number of test cases T.
* For each test case, read the string S and the dictionary of words.
     First case check 
  --> Check if the Entire String is in the Dictionary:
  --> If S is in the dictionary, print 0 and continue to the next test case.
     Second case  when  all  words  are  not  present  : -
  --> Try to Break the String at Every Possible Position:
  --> Loop through each possible break point in the string S (from index 1 to S.length() - 1).
  --> For each break point, split the string into two parts: leftPart and rightPart.
  --> Check if both leftPart and rightPart are in the dictionary.
  --> If both parts are found in the dictionary, print 1 and continue to the next test case.
      Handle the Case Where No Valid Break is Found :-
  --> If no valid break is found after checking all positions, print -1.

  


  import java.util.*; // import  utility  package 

public class StringBreaker {
    public static int minBreaks(String S, Set<String> dictionary) { // minBreaks  function with  string input  set<string>  to store  every  word  after  breaking  complete  string in  dictionary .
        // If the entire string is in the dictionary, no breaks are needed
        if (dictionary.contains(S)) { //  set  of words  contains  in the  string  given 
            return 0; //  0 done .
        }

        // Try to break the string at every possible position
        for (int i = 1; i < S.length(); i++) {  looping  from  1  to  len(string)
            String leftPart = S.substring(0, i); left_word  from 0 to 1  at  first 
            String rightPart = S.substring(i); starts  from  first  letter  at  index 1 , as  index 0  is  ' " ' which  is  also  a  string  element .
 
            // Check if both parts are in the dictionary
            if (dictionary.contains(leftPart) && dictionary.contains(rightPart)) { // if  both  leftpart  and  rightpart  are  breaked  and  are  present  in string , then  1  is  output .
                return 1; // Only one break needed
            }
        }

        // If no valid break is found, return -1
        return -1;                                   otherwise  -1 
    }
 
    public static void main(String[] args) {  //  driver code .
        Scanner scanner = new Scanner(System.in);  // user inp
        int T = scanner.nextInt(); // testcase inp as integer 
        while (T-- > 0) { //  checking  T  from 50 cases  by  decreasing , greater  than  0 .
            String S = scanner.next(); // STRING  inp  "HELLO"
            int N = scanner.nextInt(); // length(STRING) as  inp . (6)
            Set<String> dictionary = new HashSet<>();  //  set of  string words  named  dictionary  stored  in hash set  which  removes  duplicates  and  can  access  contains method  directly   to  check  for  sub-strings .
            for (int i = 0; i < N; i++) { 
                dictionary.add(scanner.next());  // adding  string  words  in dictionary .
            }
            System.out.println(minBreaks(S, dictionary));  // calling  the  breaking  function  to  print  the  output .
        }
        scanner.close(); //  finally  closing  the  input  methodology .
    }
}

