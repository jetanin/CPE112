#include <stdio.h>
#include <math.h>
#include <stdbool.h>
bool isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i <= sqrt(n); i++)
        if (n % i == 0) return false;
    return true;
}
int main() {
    int a, b;
    scanf("%d %d", &a, &b);
    bool found = false;
    for (int i = a + 1; i < b; i++) {
        if (isPrime(i)) {
            if (found) printf(" ");
            printf("%d", i);
            found = true;
        }
    }
    if (!found) printf("none");
    printf("\n");
    return 0;
}
