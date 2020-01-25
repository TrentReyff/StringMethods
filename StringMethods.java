package stringmethods;

import java.util.Random;

/**
 * Title: String Methods
 * Description: methods given a string
 * @author Trent Reyff   Date: 6/4/19
 */
public class StringMethods
{

    public static void main(String[] args)
    {
        // Call each method to demonstrate it's functionality
        System.out.println(isPalindrome("abc d!!#cb123a"));
        System.out.println(reverse("reverse"));
        System.out.println(jumble("reverse"));
        System.out.println(swapPairs("reverse"));
        System.out.println(countVowels("missasseppssa"));
        System.out.println(countConsonants("missasseppssa"));
        System.out.println(allDigits("123456"));
        System.out.println(allAlpha("alphanumeric"));
        System.out.println(stripVowels("missasseppssa"));
        System.out.println(stripConsonants("missasseppssa"));
        System.out.println(replace("mississippi", 'i', 'o'));
        System.out.println(countChar("mississippi", 's'));
        System.out.println(multiString("blargle"));
        System.out.println(lowerCase("I'm Not Shouting"));
        System.out.println(upperCase("I'm Not Shouting!"));
        System.out.println(findInStr("find the missing dissing listing", "sing"));
        System.out.println(findInStr("find the missing dissing listing", 'n'));
        System.out.println(findInStrLast("find the missing dissing listing", "sing"));
        System.out.println(findInStrLast("find the missing dissing listing", 'n'));
        System.out.println(inOrder(42, 24, 86));
    }

    /**
     * Private helper method that strips out spaces and non-characters
     * @param str
     * @return string with only characters
     */
    private static String charactersOnly(String str)
    {
        String newStr = "";
        int x;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90)
            {
                x = str.charAt(i) + 32;
                newStr += (char) (x);
            }
            else if (str.charAt(i) >= 97 && str.charAt(i) <= 122)
            {
                newStr += str.charAt(i);
            }

        }
        return newStr;
    }

    /**
     * Private helper method that checks to see if a character is a digit
     * @param c
     * @return true if character is a number   false otherwise
     */
    private static boolean isDigit(char c)
    {
        return c >= 48 && c <= 57;
    }

    /**
     * Private helper method that makes an uppercase letter lowercase
     * @param c
     * @return the character in lowercase
     */
    private static char toLower(char c)
    {
        if (c >= 65 && c <= 90)
        {
            c += 32;
        }
        return c;
    }

    /**
     * Private helper method that makes a lowercase letter uppercase
     * @param c
     * @return the character in uppercase
     */
    private static char toUpper(char c)
    {
        if (c >= 97 && c <= 122)
        {
            c -= 32;
        }
        return c;
    }

    /**
     * Private helper method that checks to see if a character is a vowel
     * @param c
     * @return true if the character is a,e,i,o or u
     */
    private static boolean isVowell(char c)
    {
        c = toLower(c);
        if (c >= 97 && c <= 122)
        {
            if (c == 97 || c == 101 || c == 105 || c == 111 || c == 117)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Private helper method that checks to see if a character is a consonant
     * @param c
     * @return true if character is a letter but not a vowel
     */
    private static boolean isConsonant(char c)
    {
        c = toLower(c);
        if (c >= 97 && c <= 122)
        {
            if (isVowell(c) == false)
                return true;
        }
        return false;
    }

    /**
     * Private help method that checks if two strings are equal
     * @param str1
     * @param str2
     * @return true if both strings are the same
     */
    private static boolean equals(String str1, String str2)
    {
        if (str1.length() != str2.length())
        {
            return false;
        }
        for (int i = 0; i < str1.length(); i++)
        {
            if (str1.charAt(i) != str2.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * isPalindrome accepts a string and returns true if the string is
     * a palindrome, otherwise returns false; should ignore spaces,
     * punctuation and case (upper and lower are the same).
     * So, the following ARE palindromes:
     * "Never odd or even.”,
     * “Cigar? Toss it in a can. It is so tragic.”,
     * “A man, a plan, a canal: Panama.”
     */
    public static boolean isPalindrome(String str)
    {
        str = charactersOnly(str);
        String newStr = reverse(str);
        return newStr.equals(str);
    }

    /**
     * reverse accepts a string and returns a string that is the
     * reverse of the original
     *
     * @param str
     * @return reversed representation of str
     */
    public static String reverse(String str)
    {
        String newStr = "";
        for (int i = str.length() - 1; i >= 0; i--)
        {
            newStr += str.charAt(i);
        }
        return newStr;
    }

    /**
     * jumble accepts a string and returns a jumbled version of the
     * original: for this method, jumbled means that two randomly chosen
     * characters other than the first and last characters of the string
     * are swapped;  this method must use the class, Random (see chapter 5).
     * Examples of what this method might do:
     * “fist” returns “fsit”,
     * “much” returns “mcuh”
     *
     * @param str string to be jumbled
     */
    public static String jumble(String str)
    {
        String newStr = "";
        int count = 0;
        int a = new Random().nextInt(str.length() - 2) + 1;
        int b;
        char c;
        if (str.length() >= 4)
        {
            do
            {
                b = new Random().nextInt(str.length() - 2) + 1;
                count ++;
            } while ((a == b || str.charAt(a) == str.charAt(b)) && count < 10);
            for (int j = 0; j < str.length(); j++)
            {
                if (j == a)
                    newStr += str.charAt(b);
                else if (j == b)
                    newStr += str.charAt(a);
                else
                    newStr += str.charAt(j);
            }
            return newStr;
        }
        return str;
    }

    /**
     * swapPairs accepts a string and returns a string that has adjacent pairs of the original string swapped; for strings of odd length, leave the last character unchanged.  Examples:
     * IN:  examples   OUT: xemalpse
     * IN:  count      OUT: ocnut
     */
    public static String swapPairs(String str)
    {
        String newStr = "";
        for (int i = 1; i < str.length(); i += 2)
            for (int j = i - 1; j <= i; j++)
                if (j != i)
                    newStr += str.charAt(i);
                else
                    newStr += str.charAt(j - 1);
        if (str.length() % 2 != 0)
            newStr += str.charAt(str.length() - 1);
        return newStr;
    }

    /**
     * countVowels accepts a string of any characters and returns
     * the number of vowels in the string. (aeiou)
     *
     * @param str
     * @return integer count of vowels in str
     */
    public static int countVowels(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (isVowell(str.charAt(i)) == true)
                count++;
        return count;
    }

    /**
     * countConsonants accepts a string of any characters and
     * returns the number of consonants in the string
     *
     * @param str
     * @return integer count of consonants in str
     */
    public static int countConsonants(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (isConsonant(str.charAt(i)) == true)
                count++;
        return count;
    }

    /**
     * allDigits accepts a string and returns true if every character
     * is a digit, otherwise false
     *
     * @param str
     * @return true of all digits, false otherwise
     */
    public static boolean allDigits(String str)
    {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) < 48 || str.charAt(i) > 57)
                return false;
        return true;
    }

    /**
     * allAlpha accepts a string and returns true if every character
     * is a letter (either case), otherwise false
     *
     * @param str
     * @return true if all alpha, false otherwise
     */
    public static boolean allAlpha(String str)
    {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) < 65 || (str.charAt(i) > 90 && str.charAt(i) < 97) || str.charAt(i) > 122)
                return false;
        return true;
    }

    /**
     * stripVowels accepts a string and returns the string with no
     * vowels.
     * Example:  IN: s-cat=tered   OUT: s-ct=trd
     *
     * @param str
     * @return str with no vowels to be found
     */
    public static String stripVowels(String str)
    {
        String newStr = "";
        for (int i = 0; i < str.length(); i++)
            if (isVowell(str.charAt(i)) == false)
                newStr += str.charAt(i);
        return newStr;
    }


    /**
     * stripConsonants accepts a string and returns the string with
     * no consonants.
     * Example:  IN: s_cat$tered
     * OUT: _a$ee
     */
    public static String stripConsonants(String str)
    {
        String newStr = "";
        for (int i = 0; i < str.length(); i++)
            if (isConsonant(str.charAt(i)) == false)
                newStr += str.charAt(i);
        return newStr;
    }

    /**
     * replace accepts a string and two characters, returns the
     * string with all occurrences of char1 replaced by char2.
     * Example:
     * IN: mississippi, i, o   OUT: mossossoppo
     *
     * @param str
     * @param c1
     * @param c2
     * @return str with all instance of c1 replaced with c2
     */
    public static String replace(String str, char c1, char c2)
    {
        String newStr = "";
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == c1)
                newStr += c2;
            else
                newStr += str.charAt(i);
        return newStr;
    }

    /**
     * countChar accepts a string and a character, returns the number
     * of occurences of the character in the string.
     * Example:   IN:  m.is_si-ssi=pp!i,   i   OUT: 4
     *
     * @param str
     * @param c
     * @return integer count of c in str
     */
    public static int countChar(String str, char c)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == c)
                count++;
        return count;
    }

    /**
     * multiString accepts a string and returns a string with
     * repeated characters: the first character is repeated
     * string-length times, the second character is repeated one
     * less time, until the last character is included only once
     * (not repeated).
     * Example:
     * IN: test    OUT: tttteeesst
     * IN: sentence  OUT: sssssssseeeeeeennnnnnttttteeeennncce
     *
     * @param str
     * @return revised string
     */
    public static String multiString(String str)
    {
        String newStr = "";
        int a = str.length();
        for (int i = 0; i < str.length(); i++)
        {
            for (int j = 0; j < a; j++)
            {
                newStr += str.charAt(i);
            }
            a--;
        }
        return newStr;
    }

    /**
     * lowerCase accepts a string and returns the string in all
     * lowercase; do not use the String class’s toLowerCase method,
     * do not use the Character class method either.
     *
     * @param str
     * @return str in all lower case
     */
    public static String lowerCase(String str)
    {
        String newStr = "";
        for (int i = 0; i < str.length(); i++)
            newStr += toLower(str.charAt(i));
        return newStr;
    }

    /**
     * upperCase accepts a string and returns the string in all uppercase;
     * do not use the String class’s toLowerCase method, do not use the
     * Character class method either.
     *
     * @param str
     * @return str in all upper case
     */
    public static String upperCase(String str)
    {
        String newStr = "";
        for (int i = 0; i < str.length(); i++)
            newStr += toUpper(str.charAt(i));
        return newStr;
    }

    /**
     * findInStr accepts two strings and returns the character
     * index of the position where the second string begins in the
     * first; returns -1 if the second string does not appear in
     * the first.
     * Examples:
     * IN: mississippi  ss  	OUT: 2
     * IN: superlative zzl  	 	OUT: -1
     *
     * @param s1
     * @param s2
     * @return index of s2 in s1
     */
    public static int findInStr(String s1, String s2)
    {
        int i = 0;
        int count;
        int position = -1;
        do {
            count = 0;
            if (s1.charAt(i) == s2.charAt(0)) {
                for (int j = 0; j < s2.length(); j++) {
                    if (s1.charAt(j + i) == s2.charAt(j))
                        count++;
                }
            }
            if (count == s2.length())
                position = i;
            i++;
        } while (i < s1.length() && position == -1);
        return position;
    }

    /**
     * findInStr is an overloaded version of previous method,
     * accepts a string and a character, returns the index of the
     * position where the character first appears in the string;
     * returns -1 if the character does not appear in the string.
     * Examples:
     * IN: dazzling z    	OUT: 2
     * IN: superlative z   	OUT: -1
     *
     * @param s1
     * @param c
     * @return
     */
    public static int findInStr(String s1, char c)
    {
        int position = -1;
        int i = 0;
        do
        {
            if (s1.charAt(i) == c)
                position = i;
            i++;
        } while (i < s1.length() && position == -1);
        return position;
    }

    /**
     * findInStrLast accepts two strings and returns the character
     * index of the rightmost position where the second string
     * begins in the first; returns -1 if the second string does
     * not appear in the first.
     * Examples:
     * IN: mississippi  ss   	 	OUT: 5
     * IN: superlative zzl  	 	OUT: -1
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int findInStrLast(String s1, String s2)
    {
        int a, b;
        int count;
        int position = -1;
        for (int i = 0; i < s1.length(); i++)
        {
            count = 0;
            if (s1.charAt(i) == s2.charAt(0))
            {
                for (int j = 0; j < s2.length(); j++)
                {
                    if (s1.charAt(j + i) == s2.charAt(j))
                        count++;
                }
            }
            if (count == s2.length())
                position = i;
        }
        return position;
    }

    /**
     * findInStrLast is an overloaded version of previous method,
     * accepts a string and a character, returns the index of the
     * rightmost position where the character first appears in the
     * string; returns -1 if the character does not appear in the string.
     * Examples:
     * IN: dazzling  z
     * OUT: 3
     * IN: superlative z
     * OUT: -1
     *
     * @param s1
     * @param c
     * @return revised String
     */
    public static int findInStrLast(String s1, char c)
    {
        int position = -1;
        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) == c)
                position = i;
        }
        return position;
    }

    /**
     * inOrder accepts 3 integers and returns a string containing the three
     * integers in ascending order separated by a single space between
     * the first two and another single space between the second and third.
     * Examples:
     * 1, 2, 3 returns “1 2 3”;
     * 199, 8, 23 returns “8 23 199” .
     *
     * @param a
     * @param b
     * @param c
     * @return String representation of numbers in order
     */

    public static String inOrder(int a, int b, int c)
    {
        String newStr = "";
        if (a < b)
        {
            if (a < c)
            {
                if (b < c)
                    newStr += a + " " + b + " " + c;
                else
                    newStr += a + " " + b + " " + c;
            }
            else
                newStr += c + " " + a + " " + b;

        }
        else
         {
                if (a < c)
                    newStr += b + " " + a + " " + c;
                else if (b < c)
                    newStr += b + " " + c + " " + a;
                else
                    newStr += c + " " + b + " " + a;
         }
        return newStr;
    }
}
