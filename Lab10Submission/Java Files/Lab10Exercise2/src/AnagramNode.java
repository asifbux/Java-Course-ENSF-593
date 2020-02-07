

public class AnagramNode implements Comparable<AnagramNode> {
	private String word;
	private AnagramNode next;
	
	public AnagramNode(String word) {
		setWord(word);
		setNext(null);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public AnagramNode getNext() {
		return next;
	}

	public void setNext(AnagramNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return word;
	}
	
	@Override
	public int compareTo(AnagramNode an) {
		return getWord().compareToIgnoreCase(an.getWord());
	}
}
