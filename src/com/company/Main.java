package com.company;

import java.util.*;

public class Main {

  public static void main(String[] args) throws java.lang.Exception {
    Map<Integer, String> words = new HashMap();
    String text =
        new String(
            "Ты пишешь мне письма такие печальные, И в каждой странице я сплошное молчание. Простые я ответы, увидимся снова, "
                + "Заклеив конверты, я каждое слово.Ты уйдешь и не посмотришь вслед. А я бегу на красный свет.");
    List<Integer> wordCount = new ArrayList<Integer>();
    int i = 0;
    for (String retval : text.split(" ")) { // Убирпем пробелы
      for (String retval1 : retval.split("\\.")) { // Убирпем точки
        for (String retval2 : retval1.split("\\,")) { // Убираем запятые
          if (words.containsValue(retval2)) { // Поиск повторв
            hashMap(wordCount, words, retval2); // Изменение кольчества повторяемых слов
          } else {
            words.put(i, retval2); // Добваление новых слов
            wordCount.add(1);
            i++;
          }
        }
      }
    }
    for (int num = 0; num < wordCount.size(); num++) {
      System.out.print(wordCount.get(num) + " ");
      System.out.println(words.get(num));
    }
  }

  public static void hashMap(List<Integer> integers, Map<Integer, String> map, String sort) {
    Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
    for (Map.Entry<Integer, String> pair : entrySet) {
      if (sort.equals(pair.getValue())) { // Поиск ключа и изменение количества
        int s = pair.getKey();
        int num = integers.get(s);
        integers.set(s, num + 1);
      }
    }
  }
}
