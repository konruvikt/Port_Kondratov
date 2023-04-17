package org.example;

import java.util.*;

public class Port {

    private final String[] indexes;

    private final int[][] numIndexes;

    private final Set<List<Integer>> uniqueArrays;

    public String[] getIndexes() {
        return indexes;
    }

    public int[][] getNumIndexes() {
        return numIndexes;
    }

    public Set<List<Integer>> getUniqueArrays() {
        return uniqueArrays;
    }

    public Port(String[] indexes) {
        this.indexes = indexes;
        this.numIndexes = this.numIndexes();
        this.uniqueArrays = this.uniqueArrays();
    }

    /**
     * Метод, преобразовывающий массив строк indexes в массив последовательностей чисел
     */
    private int[][] numIndexes() {
        int[][] answerArray = new int[this.indexes.length][];
        for (int i = 0; i < this.indexes.length; i++) {
            answerArray[i] = stringToIntArray(this.indexes[i]);
        }
        return answerArray;
    }

    /**
     * Метод, возвращающий всевозможные уникальные упорядоченные группы элементов полученных массивов чисел
     */
    private Set<List<Integer>> uniqueArrays() {
        int numberOfVariants = this.numberOfVariants(numIndexes);
        Set<List<Integer>> answerList = new LinkedHashSet<>();
        Random random = new Random();
        while (answerList.size() < numberOfVariants) {
            int[] randomIndexes = new int[numIndexes.length];
            for (int i = 0; i < numIndexes.length; i++) {
                randomIndexes[i] = random.nextInt(numIndexes[i].length);
            }
            List<Integer> sequence = new ArrayList<>();
            for (int i = 0; i < randomIndexes.length; i++) {
                sequence.add(numIndexes[i][randomIndexes[i]]);
            }
            answerList.add(sequence);
        }
        return answerList;
    }

    /**
     * Метод преобразует строку в заданном формате в соответствующий массив чисел
     * Допускается, что на вход переданы корректные данные, и каждая строка не пустая
     */
    private static int[] stringToIntArray(String input) {
        String[] strArray = input.split(",");
        List<Integer> answerList = new ArrayList<>();
        for (String s : strArray) {
            if (s.contains("-")) {
                String[] temArray = s.split("-");
                for (int i = Integer.parseInt(temArray[0]); i <= Integer.parseInt(temArray[1]); i++) {
                    answerList.add(i);
                }
                break;
            }
            answerList.add(Integer.parseInt(s));
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Метод подсчитывает количество возможных уникальных последовательностей
     */
    private int numberOfVariants(int[][] array) {
        int answer = 1;
        for (int[] ints : array) {
            answer *= ints.length;
        }
        return answer;
    }
}
