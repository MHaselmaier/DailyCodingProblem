import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TreeDictionary
{
	private Map<Character, TreeDictionary> children = new HashMap<>();
	private Set<String> words = new TreeSet<>();
	
	public void enterWord(String... words)
	{
		for (String word: words)
		{
			if (null == word || word.isEmpty() || this.words.contains(word))
				return;
			
			enterWord(word, 0);
		}
	}
	
	private void enterWord(String word, int index)
	{		
		this.words.add(word);
		if (word.length() <= index)
			return;
		
		char currentChar = word.charAt(index);
		if ('a' > currentChar || 'z' < currentChar)
		{
			enterWord(word, index + 1);
			return;
		}
		
		if (this.children.containsKey(currentChar))
		{
			this.children.get(currentChar).enterWord(word, index + 1);
		}
		else
		{
			TreeDictionary newChild = new TreeDictionary();
			newChild.enterWord(word, index + 1);
			this.children.put(currentChar, newChild);
		}
	}
	
	public Set<String> completeWord(String word)
	{
		if (null == word)
			return this.words;
		
		return completeWord(word.toLowerCase(), 0);
	}
	
	private Set<String> completeWord(String word, int index)
	{
		if (word.length() <= index)
			return this.words;
		
		char currentChar = word.charAt(index);
		if ('a' > currentChar || 'z' < currentChar)
			return completeWord(word, index + 1);
		
		TreeDictionary child = this.children.get(currentChar);
		if (null == child)
			return this.words;
		return child.completeWord(word, index + 1);
	}
}