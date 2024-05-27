# [Silver IV] Siblings - 16850 

[문제 링크](https://www.acmicpc.net/problem/16850) 

### 성능 요약

메모리: 111088 KB, 시간: 568 ms

### 분류

분류 없음

### 제출 일자

2024년 5월 27일 19:32:06

### 문제 설명

<p>You probably know who your siblings are. After all, you usually grow up in the same environment as your siblings. But everyone has heard stories of siblings separated at a young age, who then found each other after many years. Finding siblings would of course be much easier if one were given complete information on the parents of every person in the world. Then, all it would take is a program to go through and find people who share a parent. Since there is some ambiguity with respect to half-siblings (sharing one parent, but not both), we will here focus only on women, and declare two women siblings (sisters) if they have the same mother. You will be given, for each woman, who her mother is. The goal is to compute how many pairs of sisters there are.</p>

### 입력 

 <p>The first line is the number K of input data sets, followed by K data sets, each of the following form:</p>

<p>The first line is the number 0 ≤ n ≤ 10, 000, 000 of women in the data set. This is followed by n integers, distributed over one or more lines. The i<sup>th</sup> integer gives you the index of the mother of i, which is some number j < i. If the mother is listed as number 0, this means we do not know i’s mother; as far as your program is concerned, this means that i has no mother.</p>

### 출력 

 <p>For each data set, output “Data Set x:” on a line by itself, where x is its number. Then, output the number of pairs of sisters in the data set.</p>

<p>Each data set should be followed by a blank line.</p>

