#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

int main() {
    int n;
    std::cin >> n;

    std::vector<long> A(n), B(n), C(n), D(n);

    for (int i = 0; i < n; ++i) {
        std::cin >> A[i] >> B[i] >> C[i] >> D[i];
    }

    std::vector<long> AB, CD;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            AB.push_back(A[i] + B[j]);
            CD.push_back(C[i] + D[j]);
        }
    }

    std::sort(AB.begin(), AB.end());
    std::sort(CD.begin(), CD.end());

    long answer = 0;

    for (long i : AB) {
        long findNum = -i;
        answer += std::upper_bound(CD.begin(), CD.end(), findNum) - std::lower_bound(CD.begin(), CD.end(), findNum);
    }

    std::cout << answer << std::endl;

    return 0;
}
