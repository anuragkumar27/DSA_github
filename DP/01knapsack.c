#include <stdio.h>
#include <stdlib.h>

void knapsack(int val[], int wt[], int W, int n)
{
    int dp[n + 1][W];
    for (int i = 0; i <= n; i++)
    {
        for (int w = 0; w <= W; w++)
        {
            if (i == 0 || w == 0)
            {
                dp[i][w] = 0;
            }
            else if (wt[i - 1] <= w)
            {
                dp[i][w] = (dp[i - 1][w] >= dp[i - 1][w - wt[i - 1]] + val[i - 1]) ? dp[i - 1][w] : dp[i - 1][w - wt[i - 1]] + val[i - 1];
            }
            else
            {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }
    printf("%d ", dp[n][W]);
}

int main()
{
    int val[] = {60, 100, 120};
    int wt[] = {10, 20, 30};
    int W = 50;
    int n = sizeof(val) / sizeof(val[0]);
    knapsack(val, wt, W, n);
}