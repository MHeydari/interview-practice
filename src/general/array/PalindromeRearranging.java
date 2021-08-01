/*
 Given a string, find out if its characters can be rearranged to form a palindrome.
 ******************************
 A string that doesn't changed when reversed (it reads the same backward and forward).
    Examples:
    "eye" is a palindrome
    "noon" is a palindrome
    "decaf faced" is a palindrome
    "taco cat" is not a palindrome (backwards it spells "tac ocat")
    "racecars" is not a palindrome (backwards it spells "sracecar")
 ******************************

Example
For inputString = "aabb", the output should be
palindromeRearranging(inputString) = true
*/

package general.array;

public class PalindromeRearranging {
     int UnMatchCount(Character[] a) {
        int unmatch = 0;
        boolean matchFound;
        for (int i = 0; i < a.length - 1; i++) {
            matchFound = false;
            if (a[i] == null) continue;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == null) continue;
                if (a[i] == a[j]) {
                    matchFound = true;
                    a[i] = null;
                    a[j] = null;
                    break;
                }
            }
            if(!matchFound){unmatch = unmatch + 1;}
        }
        return unmatch;
    }

    public boolean palindromeRearranging(String inputString) {
        Character[] inp =
                inputString.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        int unc = UnMatchCount(inp);
        System.out.print("UnMatchCount = " + unc);
        if(inp.length % 2 == 0){
            return unc == 0;

        }
        return (unc <= 1);
    }
}
