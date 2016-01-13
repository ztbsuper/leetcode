package leetcode;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.
*/
public class Leetcode151 {
    @Test
    public void tc1() throws Exception {
        String given = "the sky is blue";
        String expect = "blue is sky the";
        assertThat(way_3(given)).isEqualTo(expect);
    }

    @Test
    public void tc2() throws Exception {

        String given = " ";
        String expect = "";
        assertThat(way_3(given)).isEqualTo(expect);
    }

    @Test
    public void tc3() throws Exception {
        String given = "";
        String expect = "";
        assertThat(way_3(given)).isEqualTo(expect);
    }

    @Test
    public void tc4() throws Exception {
        String given = "    ";
        String expect = "";
        assertThat(way_3(given)).isEqualTo(expect);
    }

    @Test
    public void tc5() throws Exception {
        String given = "   a   b ";
        String expect = "b a";
        assertThat(way_3(given)).isEqualTo(expect);
    }

    @Test
    public void tc6() throws Exception {
        String given = "a";
        String expect = "a";
        assertThat(way_3(given)).isEqualTo(expect);
    }

    /*
    *   直接用正则切出词语,然后生成反向即可, 使用StringBuilder速度快于直接String
    *
    * */
    private String way_1(String s) {
        if (s.trim().equals("")) {
            return "";
        }
        String[] split = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i > 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.append(split[0]).toString();
    }


    /*
    *   速度慢, 应该都消耗在了对象Word创建上, Word有before Link. 遍历char, 保存扫描的非0x20char, 最后通过before link来输出
    *
    * */
    private String way_2(String s) {
        char[] chars = s.toCharArray();
        String x = "";
        Word last = new Word("");
        for (char c : chars) {
            if (c == 0x20) {
                if (x.length() > 0) {
                    Word current = new Word(x);
                    current.setBefore(last);
                    last = current;
                    x = "";
                }
            } else {
                x += c;
            }
        }
        Word current = x.length() > 0 ? new Word(last, x) : last;
        if (current.isFirst()) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        while (!current.isFirst()) {
            sb.append(current.getWord());
            if (!current.getBefore().getWord().equals("")) {
                sb.append(" ");
            }
            current = current.getBefore();
        }
        return sb.toString();
    }

    class Word {
        private Word before;
        private String word;

        public Word(Word before, String word) {
            this.before = before;
            this.word = word;
        }

        public Word(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }

        public Word getBefore() {
            return before;
        }

        public void setBefore(Word before) {
            this.before = before;
        }

        public boolean isFirst() {
            return before == null;
        }

    }


    /*
    *   解法通过两个stringbuiler, 一个扫描char[]输入, 读到0X20 append到负责输出上.
    *   尝试过insert(0, char)和reverse append,效率上没差别
    * */
    private String way_3(String s) {
        char[] chars = s.toCharArray();
        StringBuilder scanner = new StringBuilder("");
        StringBuilder printer = new StringBuilder("");
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 0x20) {
                if (scanner.length() > 0) {
                    if (printer.length() > 0) {
                        printer.append(" ");
                    }
                    printer.append(scanner.toString());
                }
                scanner.delete(0, scanner.length());
            } else {
                scanner.insert(0, chars[i]);
            }
        }

        if (scanner.length() > 0) {
            if (printer.length() > 0) {
                printer.append(" ");
            }
            printer.append(scanner.toString());
        }
        return printer.toString();

    }

}
