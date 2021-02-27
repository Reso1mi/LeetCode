import java.util.*;

public class FindNumOfValidWords1178 {
    public static void main(String[] args) {

    }

    //2^26
    public List<Integer> findNumOfValidWords3(String[] words, String[] puzzles) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //50*10^5
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            int key = 0;
            for (int j = 0; j < word.length; j++) {
                key |= 1<<(word[j]-'a');
            }
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        //枚举puzzles[i]的子集 10^4*2^7*7
        //word包含puzz的第一个字母 & puzz包含word所有字母
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            char[] puzz = puzzles[i].toCharArray();
            int cnt = 0;
            //枚举子集复杂度: 2^n*n (n为puzz[i]长度)
            for (int s = 0; s < (1<<puzz.length); s++) {
                int key = 0;
                //puzz[0]必选
                if ((s&1)!=1) continue;
                for (int k = 0; k < puzz.length; k++) {
                    if (((s>>>k)&1)==1) {
                        key |= 1<<(puzz[k]-'a');
                    }
                }
                cnt += map.getOrDefault(key, 0);
            }
            res.add(cnt);
        }
        return res;
    }

    //更优的枚举二进制子集的方法
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //50*10^5
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            int key = 0;
            for (int j = 0; j < word.length; j++) {
                key |= 1<<(word[j]-'a');
            }
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        //word包含puzz的第一个字母 & puzz包含word所有字母
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            char[] puzz = puzzles[i].toCharArray();
            int cnt = 0, mask = 0;
            for (int j = 1; j < puzz.length; j++) {
                mask |= (1<<(puzz[j]-'a'));
            }
            //枚举子集复杂度: 2^k (k为mask中1的个数)
            int sub = mask;
            do {
                cnt += map.getOrDefault(sub|(1<<(puzz[0]-'a')), 0);
                sub = (sub-1) & mask;
            } while (sub != mask);
            res.add(cnt);
        }
        return res;
    }

    //s = 101
    //1. sub = 101
    //2. sub = 100 & 101 = 100
    //3. sub = 011 & 101 = 001
    //4. sub = 000 & 101 = 000
    //5. sub = 111 & 101 = 101 (取反全为1，回到mask)
    
    // 错误超时解法
    // public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     //50*10^5
    //     for (int i = 0; i < words.length; i++) {
    //         char[] word = words[i].toCharArray();
    //         int key = 0;
    //         for (int j = 0; j < word.length; j++) {
    //             key |= 1<<(word[j]-'a');
    //         }
    //         map.put(key, map.getOrDefault(key, 0)+1);
    //     }
    //     //枚举puzzles[i]的子集 10^4*2^7*7
    //     //word包含puzz的第一个字母 & puzz包含word所有字母
    //     List<Integer> res = new ArrayList<>();
    //     for (int i = 0; i < puzzles.length; i++) {
    //         char[] puzz = puzzles[i].toCharArray();
    //         int cnt = 0, mask = 0;
    //         for (int j = 1; j < puzz.length; j++) {
    //             mask |= (1<<(puzz[j]-'a'));
    //         }
    //         //~~枚举子集复杂度: 2^n (n为puzz[i]长度)~~ 删除
    //         //枚举子集复杂度: 2^n (n为26)
    //         for (int s = 0; s <= mask; s++) {
    //             if ((s|mask) == mask) {
    //                 cnt += map.getOrDefault(s|(1<<(puzz[0]-'a')), 0);
    //             }
    //         }
    //         res.add(cnt);
    //     }
    //     return res;
    // }
    
}