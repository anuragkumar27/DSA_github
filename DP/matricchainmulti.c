// MATRIX CHAIN MULTIPLICATION
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void printparens(int n, int s[n][n], int i, int j)
{
    if (i == j)
    {
        printf("A%d", i);
    }
    else
    {
        printf("(");
        printparens(n, s, i, s[i][j]);
        printparens(n, s, s[i][j] + 1, j);
        printf(")");
    }
}

void matrixchainmulti(int p[], int n)
{
    int m[n + 1][n + 1];
    int s[n + 1][n + 1];

    for (int i = 0; i <= n; i++)
    {
        m[i][i] = 0;
    }

    for (int l = 2; l <= n; l++)
    {
        for (int i = 1; i <= n - l + 1; i++)
        {
            int j = i + l - 1;
            m[i][j] = INT_MAX;
            for (int k = i; k < j; k++)
            {
                int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                if (q < m[i][j])
                {
                    m[i][j] = q;
                    s[i][j] = k;
                }
            }
        }
    }
    printf("%d ", m[1][n]);
    printparens(n + 1, s, 1, n);
}

int main()
{
    int n;
    printf("Enter the number of matrix : ");
    scanf("%d", &n);
    int p[n + 1];
    printf("Enter the dimensions : ");
    for (int i = 0; i <= n; i++)
    {
        scanf("%d", &p[i]);
    }
    matrixchainmulti(p, n);
}