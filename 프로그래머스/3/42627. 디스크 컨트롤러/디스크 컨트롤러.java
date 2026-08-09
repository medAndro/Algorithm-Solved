import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		List<int[]> jobsList = Arrays.asList(jobs);
		jobsList.sort((j1, j2) -> Integer.compare(j1[0], j2[0]));
		int retrunTimeSum = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> Integer.compare(j1[1], j2[1]));
		int time = 0;
		for (int i = 0; i < jobsList.size() || !pq.isEmpty();) {
			if (pq.isEmpty() && jobsList.get(i)[0] >= time) {
				time = jobsList.get(i)[0];
			}

			for (; i < jobsList.size(); i++) {
				if (jobsList.get(i)[0] <= time) {
					pq.offer(jobsList.get(i));
				} else {
					break;
				}
			}

			int[] polledJob = pq.poll();
			time += polledJob[1];
			retrunTimeSum += time - polledJob[0];

		}

		return retrunTimeSum / jobs.length;
	}
}
