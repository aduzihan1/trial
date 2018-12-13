package com.dzh.trial.trial.tryJPA.util;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GroupUtil {
    /**
     * 组合记号辅助类
     * @author xht555
     * @Create 2015-1-29 17:14:12
     */
    private class Sign {
        /**
         * 每组元素更换频率，即迭代多少次换下一个元素 */
        public int whenChg;
        /**
         * 每组元素的元素索引位置 */
        public int index;
    }

    @Test
    public void testComposite(){
        List<String> listA = new ArrayList<String>();
        listA.add("a");
        listA.add("b");
        listA.add("c");

        List<String> listB = new ArrayList<String>();
        listB.add("d");
        listB.add("e");

        List<String> listC = new ArrayList<String>();
        listC.add("f");
        listC.add("g");
        listC.add("h");

        // 这个list可以任意扩展多个
        List<List<String>> list = new ArrayList<List<String>>();
        list.add(listA);	// 3
        list.add(listB);	// 2
        list.add(listC);	// 3
        //list.add(listD);
        //list.add(listE);
        //list.add(listF);

        int iterateSize = 1;// 总迭代次数，即组合总种数
        for (int i = 0; i < list.size(); i++) {
            // 每个List的n选1选法种数
            // 有兴趣的话可以扩展n选2，n选3，... n选x
            iterateSize *= list.get(i).size();
        }

        int median = 1;	// 当前元素与左边已定元素的组合种数
        Map<Integer, Sign> indexMap = new HashMap<Integer, Sign>();
        for (int i = 0; i < list.size(); i++) {
            median *= list.get(i).size();
            Sign sign = new Sign();
            sign.index = 0;
            sign.whenChg = iterateSize/median;
            indexMap.put(i, sign);
        }

        System.out.println("条目总数: " + iterateSize);
        Set<String> sets = new HashSet<String>();

        int i = 1;	// 组合编号

        long t1 = System.currentTimeMillis();
        while (i <= iterateSize) {
            String s = "i: " + i + "\t";

            // m值可变
            for (int m = 0; m < list.size(); m++) {
                int whenChg = indexMap.get(m).whenChg; 	// 组元素更换频率
                int index = indexMap.get(m).index;		// 组元素索引位置

                s += list.get(m).get(index) + "[" + m + "," + index + "]" + " ";

                if (i%whenChg == 0) {
                    index++;
                    // 该组中的元素组合完了，按照元素索引顺序重新取出再组合
                    if (index >= list.get(m).size()) {
                        index = 0;
                    }

                    indexMap.get(m).index = index;
                }
            }

            System.out.println(s);
            sets.add(s);
            i++;
        }

        System.out.println("Set条目总数: " + sets.size());
        long t2 = System.currentTimeMillis();
        System.err.println(String.format("%s ms", t2 - t1));
    }


}
