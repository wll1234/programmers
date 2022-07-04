import java.util.*;

class WordConvert {
    // https://programmers.co.kr/learn/courses/30/lessons/43163
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log","cog"};
        System.out.println(solution(begin, target, words) + " == 4");
        words = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin, target, words) + " == 0");
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, begin, new boolean[words.length]));

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(target.equals(node.word)) {
                answer = node.cnt;
                break;
            }
            boolean[] chkArr = node.check;
            for(int i = 0; i < words.length; i++) {
                if(chkArr[i] == false) {
                    String word = words[i];
                    char[] wordChars = word.toCharArray();
                    char[] nodeChars = node.word.toCharArray();
                    int score = 0;
                    for(int j = 0; j < wordChars.length; j++){
                        if(wordChars[j] != nodeChars[j]) {
                            score++;
                        }
                    }
                    if(score == 1) {
                        boolean[] tmpChkArr = chkArr.clone();
                        tmpChkArr[i] = true;
                        q.add(new Node(node.cnt+1, word, tmpChkArr));
                    }
                }
            }
        }

        return answer;
    }

    public static class Node {
        int cnt;
        String word;
        boolean[] check;

        Node(int cnt, String word, boolean[] check) {
            this.cnt = cnt;
            this.word = word;
            this.check = check;
        }
    }

}