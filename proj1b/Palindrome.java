public class Palindrome {
    public Deque<Character>wordToDeque(String word) {
        Deque<Character> dqCh = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++) {
            dqCh.addLast(word.charAt(i));
        }
        return dqCh;
    }

    public boolean isPalindrome(String word) {
        if(word.isEmpty() || word.length() == 1) {
            return true;
        } else {
            Deque<Character> LLDq = wordToDeque(word);
            boolean identifier = true;
            while (LLDq.size() > 1) {
                Character firCh = LLDq.removeFirst(), lasCh = LLDq.removeLast();
                if (!firCh.equals(lasCh)) {
                    return false;
                }
            }
            return true;
        }

    }

}
