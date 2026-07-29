import java.util.*;

class Job {
	public int no;
	public int callTime;
	public int workLen;
	public int workStartTime;

	public Job(int no, int callTime, int workLen) {
		super();
		this.no = no;
		this.callTime = callTime;
		this.workLen = workLen;

	}

	public int workEndTime() {
		return workStartTime + workLen;
	}

	@Override
	public String toString() {
		return "Job [no=" + no + ", callTime=" + callTime + ", workLen=" + workLen + "]";
	}

}

class Solution {
	public int solution(int[][] jobs) {
		List<Integer> answerTimes = new ArrayList<Integer>();

		List<Job> jobsList = new ArrayList<Job>(jobs.length);

		// 작업시간이 짧은것, 요청시각이 빠른것, 번호가 작은것 순서
		PriorityQueue<Job> pq = new PriorityQueue<Job>((j1, j2) -> {
			int workLen = Integer.compare(j1.workLen, j2.workLen);
			if (workLen != 0)
				return workLen;
			int callTime = Integer.compare(j1.callTime, j2.callTime);
			if (callTime != 0)
				return callTime;
			return Integer.compare(j1.no, j2.no);
		}

		);

		for (int i = 0; i < jobs.length; i++) {
			jobsList.add(new Job(i, jobs[i][0], jobs[i][1]));
		}
		jobsList.sort((j1, j2) -> Integer.compare(j1.callTime, j2.callTime));

		int currentTime = 0;
		Job workingJob = null;
		for (int i = 0; answerTimes.size() < jobsList.size();) {
			if (i < jobsList.size() && jobsList.get(i).callTime == currentTime) {
				pq.offer(jobsList.get(i++));
				continue;
			} else if (workingJob == null && !pq.isEmpty()) {
				Job j = pq.poll();

				if (currentTime < j.callTime) {
					currentTime = j.callTime;
				}

				j.workStartTime = currentTime;
				workingJob = j;
				continue;
			} else if (workingJob != null && workingJob.workEndTime() == currentTime) {
				answerTimes.add(workingJob.workEndTime() - workingJob.callTime);
				workingJob = null;
				continue;
			}

			if (i < jobsList.size() && workingJob != null) {
				currentTime = Math.min(workingJob.workEndTime(), jobsList.get(i).callTime);
			} else if (i < jobsList.size() && workingJob == null) {
				currentTime = jobsList.get(i).callTime;
			} else if (i >= jobsList.size() && workingJob != null) {
				currentTime = workingJob.workEndTime();
			}

		}

		return answerTimes.stream().mapToInt(i -> i).sum() / answerTimes.size();
	}
}
