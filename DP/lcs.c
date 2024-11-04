// Longest Common Subsequence
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void longestcommonsubsequence(char X[], char Y[])
{
    int m = strlen(X);
    int n = strlen(Y);
    int c[m + 1][n + 1];

    for (int i = 0; i <= m; i++)
    {
        for (int j = 0; j <= n; j++)
        {
            if (i == 0 || j == 0)
            {
                c[i][j] = 0;
            }
            else if (X[i - 1] == Y[j - 1])
            {
                c[i][j] = c[i - 1][j - 1] + 1;
            }
            else
            {
                c[i][j] = (c[i - 1][j] >= c[i][j - 1]) ? c[i - 1][j] : c[i][j - 1];
            }
        }
    }
    int index = c[m][n];
    printf("%d ", index);
    char lcs[index + 1];
    lcs[index] = '\0';
    int i = m;
    int j = n;
    while (i > 0 && j > 0)
    {
        if (X[i - 1] == Y[j - 1])
        {
            lcs[index - 1] = X[i - 1];
            i--;
            j--;
            index--;
        }
        else if (c[i - 1][j] >= c[i][j - 1])
        {
            i--;
        }
        else
        {
            j--;
        }
    }
    printf("%s", lcs);
}

int main()
{
    char X[] = "ABCBDAB";
    char Y[] = "BDCABA";
    longestcommonsubsequence(X, Y);
    return 0;
}