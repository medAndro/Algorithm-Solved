import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;

class Solution {
	int n;
	int r;
	int[] dist;
	int[] weak;
	int answer = -1;

	public int solution(int n, int[] weak, int[] dist) {
		this.n = n;
		dist = Arrays.stream(dist).map(i -> -i).sorted().map(i -> -i).toArray();
		this.dist = dist;
		this.weak = weak;

		for (this.r = 1; this.r <= dist.length; this.r++) {
			int[] result = new int[r];
			boolean[] used = new boolean[dist.length];
			perm(0, result, used);

		}
		return answer;
	}

	void perm(int depth, int[] result, boolean[] used) {
		if (depth == r) {
			if (isCoverWeak(result)) {
				answer = r;
			}
			return;
		}

		for (int i = 0; i < dist.length && answer == -1; i++) {
			if (used[i])
				continue;

			used[i] = true;
			result[depth] = dist[i];
			perm(depth + 1, result, used);
			used[i] = false;
		}

	}

	boolean isCoverWeak(int[] partDist) {
		int[] weakGap = new int[weak.length];
		for (int sp = 0; sp < this.weak.length; sp++) {
			int first = 0;
			for (int i = 0; i < this.weak.length; i++) {
				if (i == 0) {
					first = weak[(sp + i) % this.weak.length];
				}
				weakGap[i] = weak[(sp + i) % this.weak.length] - first;

				if (weakGap[i] < 0) {
					weakGap[i] += n;
				}
			}

			for (int i = this.weak.length - 1; i >= 1; i--) {
				weakGap[i] -= weakGap[i - 1];
			}

			int sum = 0;
			int partDistIdx = 0;
			boolean ispossible = true;
			for (int gapIdx = 0; gapIdx < weakGap.length; gapIdx++) {
				sum += weakGap[gapIdx];
				if (partDist[partDistIdx] < sum) {
					sum = 0;
					partDistIdx++;
					if (partDist.length == partDistIdx) {
						ispossible = false;
						break;
					}
				}
			}
			if (ispossible) {
				return true;
			}
		}
		return false;
	}
}