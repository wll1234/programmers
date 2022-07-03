

class CompressString {
    // https://programmers.co.kr/learn/courses/30/lessons/60057
    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s) + " == 7");
        s = "ababcdcdababcdcd";
        System.out.println(solution(s) + " == 9");
        s = "abcabcdede";
        System.out.println(solution(s) + " == 8");
        s = "abcabcabcabcdededededede";
        System.out.println(solution(s) + " == 14");
        s = "xababcdcdababcdcd";
        System.out.println(solution(s) + " == 17");
    }

    public static int solution(String s) {
        int answer = s.length();
        int len = s.length();

        for(int split = 1; split <= len/2; split++){
            String str = s.substring(0, split);
            StringBuilder compStr = new StringBuilder();
            int cnt = 1;

            for(int i = split; ; i += split) {
                if(len < i+split) {
                    if(1 < cnt){
                        compStr.append(cnt);
                    }
                    compStr.append(str);
                    compStr.append(s.substring(i));
                    break;
                }
                String check = s.substring(i, i+split);
                if(check.equals(str)) {
                    cnt++;
                } else {
                    if(1 < cnt){
                        compStr.append(cnt);
                    }
                    compStr.append(str);
                    str = check;
                    cnt = 1;
                }
            }

            System.out.println(s + " " + split + " " + compStr);

            if(compStr.length() < answer) {
                answer = compStr.length();
            }
        }

        return answer;
    }
}