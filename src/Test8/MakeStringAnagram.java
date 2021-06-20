package Test8;

import java.net.FileNameMap;
import java.util.Scanner;

public class MakeStringAnagram {
/*
    Given two strings S1 and S2, find and return the minimum number of deletions
    to be made (total count of deletions in both strings) in order to make the
    strings anagram.
    Anagram of a string is a string which is its permutation.

    For example "bbaa" and "abab" are anagrams of each other but
    "bbaa" and "aaab" are not.

    Input Format :
        Line 1 : String1
        Line 2 : String2
    Output Format :
        Number of deletions required
    Contraints :
        1<= Length of string <=10^4
    Sample Input 1 :
        cde
        abc
    Sample Output 1 :
        4
    Sample Input 2 :
        aab
        aba
    Sample Output 2 :
        0
 */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1=s.nextLine();
        String s2=s.nextLine();
        System.out.println(makeAnagram(s1,s2));
    }
    final static int CHARS = 26;
    public static int makeAnagram(String str1,String str2){
//       char[] ch1 = s1.toCharArray();
//       char[] ch2 = s2.toCharArray();
//       int cnt=0,temp=0;
//       for (int i =0;i<ch1.length;i++){
//           for (int j =0;j<ch2.length;j++){
//               if (ch1[i]== ch2[j]){
//                   cnt++;
//               }
//
//           }
//           if (cnt==0){
//               ch1[i]='0';
//               temp++;
//           }
//           cnt=0;
//       }
//    return temp;
//    }
        int arr[] = new int[CHARS];
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i) - 'a']--;
        }

        int ans = 0;
        for (int i = 0; i < CHARS; i++) {
            ans += Math.abs(arr[i]);
        }
        return ans;
    }
}
