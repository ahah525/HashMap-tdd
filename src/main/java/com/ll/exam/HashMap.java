package com.ll.exam;

import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> {
    private Object keys[];
    private Object values[];
    private int size;

    public HashMap() {
        keys = new Object[2];
        values = new Object[2];
        size = 0;
    }

    // HashMap 사이즈 반환
    public int size() {
        return size;
    }

    // (key, value) 삽입/수정
    public void put(K key, V value) {
        int idx = indexOfKey(key);

        if (idx == -1) {
            sizeUp();
            // 키가 없으면 새로 삽입
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            // 키가 있으면 덮어쓰기
            values[idx] = value;
        }
    }

    // key로 value 조회
    public V get(K key) {
        int idx = indexOfKey(key);
        // 키가 없으면 null 반환
        if (idx == -1) {
            return null;
        }
        return (V) values[idx];
    }

    // key로 (key, value) 삭제
    public void remove(K key) {
        int idx = indexOfKey(key);
        // 키가 있을 때만 삭제
        if (idx != -1) {
            // 앞으로 땡겨오기
            for (int i = idx + 1; i < size; i++) {
                keys[i - 1] = keys[i];
                values[i - 1] = values[i];
            }
            size--;
        }
    }

    // HashMap의 모든 key를 set으로 리턴
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<K>();
        for (int i = 0; i < size; i++) {
            keySet.add((K) keys[i]);
        }
        return keySet;
    }

    // 해당 key가 HashMap에 있는지 여부 리턴
    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key))
                return true;
        }
        return false;
    }

    // 해당 key의 인덱스 리턴
    public int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if(keys[i].equals(key))
                return i;
        }
        return -1;
    }

    // 내부 배열이 꽉차면, 내부 배열 크기 2배 늘리기
    public void sizeUp() {
        if (size >= keys.length) {
            Object[] newKeys = new Object[size * 2];
            Object[] newValues = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newKeys[i] = keys[i];
                newValues[i] = values[i];
            }
            System.out.println("내부 배열의 사이즈가 증가: " + keys.length + " -> " + newKeys.length);
            keys = newKeys;
            values = newValues;
        }
    }
}
