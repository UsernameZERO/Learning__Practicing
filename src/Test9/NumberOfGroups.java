package Test9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberOfGroups {
    /*
    You are given an array A of strings.
    An operation on string S is defined as swapping of any two even indexed characters
    of S, or any two odd indexed characters of S.
    Two strings S and T are called compatible with each other, if by performing any number
    of operations on S, S can be made equal to T.
    For example, S="noddy" and T="ddnoy" are compatible to each other because we make
    following operations "noddy" -> "dondy" -> "ddnoy" that swaps S[0] with S[2] and then S[1] with S[3].

    Now, a group of compatible strings from A is a non empty subset of A such that:

    1. Each pair of strings in the group are compatible.
    2. The group is the largest size possible (i.e. there is no other string in the array,
    which is compatible with all the stings of the group)

    Sample Input 1:
                    6
                    pqrs
                    rqps
                    psrq
                    noddy
                    ddnoy
                    nydod
    Sample Output 1:
                    3
    Explanation:

    One group is ["pqrs", "rqps", "psrq"], as all are pairwise compatible.
    The other two groups are ["noddy", "ddnoy"] and ["nydod"].
    Note that in particular, "nydod" is not compatible to "noddy".

    Sample Input 2:
                    6
                    abc
                    acb
                    cba
                    cab
                    bac
                    bca
    Sample Output 2:
                     3

    You have to return the number of such groups in the array A.
     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String[] grp = new String[n];
        for (int i=0;i<grp.length;i++){
            grp[i] = s.nextLine();
        }
        String even ="",odd ="";

        Set ss = new HashSet();

        for (String solo : grp ){
            for (int i=0;i<solo.length();i++){
                if (i%2==0){
                    even+=solo.charAt(i);
                }
                odd+=solo.charAt(i);
            }
            char[] od = odd.toCharArray();
            char[] ev = even.toCharArray();
            Arrays.sort(od);
            Arrays.sort(ev);
            ss.add(new String(ev)+new String(od));

            even="";
            odd="";
        }
        System.out.println(ss.size());
    }
}
