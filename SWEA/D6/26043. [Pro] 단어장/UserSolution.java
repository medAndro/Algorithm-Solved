import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

class UserSolution {

	static class Word {
		String mWord; // 해당 단어
		int mImportance; // 중요도
		int inputIdx; // 등록 순서

		public Word(String mWord, int mImportance, int inputIdx) {
			super();
			this.mWord = mWord;
			this.mImportance = mImportance;
			this.inputIdx = inputIdx;
		}

	}

	static class CharWord {
		Word word;
		private PriorityQueue<Word> pq;
		Word reverceDictWord;
		PriorityQueue<Word> reversePq;
		HashMap<Character, CharWord> lowerDic;

		public CharWord() {
			super();
			this.pq = getEmptyPq();
			this.lowerDic = new HashMap<>();
		}

		void add(String word, int chIdx, int importance, int inputIdx) {
			Word w = new Word(word, importance, inputIdx++);
			if (chIdx + 1 == word.length()) {
				this.word = w;
			}

			if (reverceDictWord == null) {
				reverceDictWord = w;
			} else {

				int cmp = w.mWord.compareTo(reverceDictWord.mWord);

				if (cmp > 0) {
					reverceDictWord = w;
				}
			}

			pq.add(w);
		}

		int pageCnt() {
			return pq.size();
		}

	}

	static PriorityQueue<Word> getEmptyPq() {
		return new PriorityQueue<Word>((a, b) -> {
			int impCompare = Integer.compare(b.mImportance, a.mImportance); // 단어중 중요도가 가장 높은것
			if (impCompare == 0) {
				return Integer.compare(a.inputIdx, b.inputIdx); // 중요도 같으면 가장 먼저 등록된것
			} else {
				return impCompare;
			}
		});
	}

	HashMap<Character, CharWord> rootDic;

	int mInputIdx;
	int mCurrentPage;

	public void init() {
		mInputIdx = 0;

		rootDic = new HashMap<>();

		CharWord aCharWord = new CharWord();
		aCharWord.add("a", 0, 1, mInputIdx++);
		rootDic.put('a', aCharWord);
		mCurrentPage = 1;

		return;
	}

	int getPageNum(String mWord) {
		int pageNum = 1;

//		if (mWord.equals("ab")) {
//			System.out.println();
//		}

		HashMap<Character, CharWord> dic = this.rootDic;
		char start = 'a';

		for (int idx = 0; idx < mWord.length();) {
			char target = mWord.charAt(idx);

			if (start == target) {
				if (idx != mWord.length() - 1) {
					if (dic.get(start).word != null) {
						pageNum++;
					}
					dic = dic.get(start).lowerDic;
					start = 'a';
					idx++;
				} else {
					break;
				}

			} else { // 앞 캐릭터 페이지 사이즈 다더하기
				CharWord cw = dic.get(start);
				if (cw != null) {
					pageNum += dic.get(start).pageCnt();

				}

				start++;
			}
		}

		return pageNum;
	}

	CharWord searchWord(String mWord) {

		HashMap<Character, CharWord> dic = this.rootDic;

		for (int idx = 0; idx < mWord.length(); idx++) {
			char target = mWord.charAt(idx);

			if (dic.containsKey(target)) {
				if (idx == mWord.length() - 1) {
					return dic.get(target);
				}
				dic = dic.get(target).lowerDic;
			} else {
				return null;
			}
		}

		return null;
	}

	String getWordByPage(int targetPageNum) {
		int pageNum = 0;

		HashMap<Character, CharWord> dic = this.rootDic;
		char start = 'a';

		while (true) {
			if (dic.containsKey(start)) {
				CharWord cw = dic.get(start);
				int charPageCnt = cw.pageCnt();

				if (pageNum + charPageCnt == targetPageNum) {
					return dic.get(start).reverceDictWord.mWord;

				} else if (pageNum + charPageCnt > targetPageNum) {
					if (pageNum + 1 == targetPageNum && cw.word != null) {
						return cw.word.mWord;
					}
					if (cw.word != null) {
						pageNum++;
					}
					dic = cw.lowerDic;
					start = 'a';

				} else if (pageNum + charPageCnt < targetPageNum) {
					pageNum += charPageCnt;
					start++;
				}
			} else {
				start++;

			}
		}
	}

	public Solution.PAGE add(String mWord, int mImportance) {
		Solution.PAGE res = new Solution.PAGE();
		res.no = -1;

		HashMap<Character, CharWord> dic = this.rootDic;

		for (int idx = 0; idx < mWord.length(); idx++) {
			char ch = mWord.charAt(idx);
			mInputIdx++;

			if (dic.containsKey(ch)) {
				CharWord aCharWord = dic.get(ch);
				aCharWord.add(mWord, idx, mImportance, mInputIdx);
			} else {
				CharWord aCharWord = new CharWord();
				aCharWord.add(mWord, idx, mImportance, mInputIdx);
				dic.put(ch, aCharWord);
			}

			dic = dic.get(ch).lowerDic;
		}

		mCurrentPage = getPageNum(mWord);

		res.word = mWord;
		res.no = mCurrentPage;

//		System.out.println("ADD : " + res);
		return res;
	}

	public Solution.PAGE move(int mDir) {
		Solution.PAGE res = new Solution.PAGE();

		mCurrentPage += mDir;
		res.no = mCurrentPage;
		res.word = getWordByPage(mCurrentPage);

//		System.out.println("MOV : " + res);
		return res;
	}

	public Solution.PAGE search(String mStr) {
		Solution.PAGE res = new Solution.PAGE();
		res.no = -1;

		CharWord cw = searchWord(mStr);

		if (cw == null) {
//			System.out.println("SCH : " + res);
			return res;
		} else if (cw.word == null) {
			res.word = cw.pq.peek().mWord;

		} else {
			res.word = cw.word.mWord;

		}
		mCurrentPage = getPageNum(res.word);
		res.no = mCurrentPage;

//		System.out.println("SCH : " + res);
		return res;
	}

	public Solution.PAGE go(int mNo) {
		Solution.PAGE res = new Solution.PAGE();

		mCurrentPage = mNo;
		res.no = mCurrentPage;
		res.word = getWordByPage(mCurrentPage);
//		System.out.println("GOO : " + res);
		return res;
	}
}