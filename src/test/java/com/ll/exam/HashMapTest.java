package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    @Test
    void 클래스가_존재한다() {
        HashMap map = new HashMap();
    }

    @Test
    void 제너릭이_가능하다() {
        HashMap<String, Integer> map = new HashMap<>();
    }

    @Test
    void put() {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("철수", 22);
    }

    @Test
    void get() {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("철수", 22);
        int age = ages.get("철수");

        assertEquals(22, age);
    }

    @Test
    void _2nd_get() {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("철수", 22);
        ages.put("영희", 25);
        assertEquals(22, ages.get("철수"));
        assertEquals(25, ages.get("영희"));
    }

    @Test
    void put__데이터_수정() {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("철수", 22);
        ages.put("영희", 25);
        ages.put("영희", 27);

        assertEquals(27, ages.get("영희"));
    }

    @Test
    void remove() {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("철수", 22);
        assertEquals(1, ages.size());

        ages.put("영희", 25);
        assertEquals(2, ages.size());

        ages.remove("영희");

        assertEquals(1, ages.size());

        ages.remove("철수");
        assertEquals(0, ages.size());
    }

    @Test
    void keySet() {
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("철수", 22);
        ages.put("영희", 25);

        Set<String> keySet = ages.keySet();
        assertTrue(keySet.contains("철수"));
        assertTrue(keySet.contains("영희"));
    }

    @Test
    void 원숭이_맵() {
        HashMap<String, 원숭이> monkeys = new HashMap<>();

        원숭이 a원숭이_키키 = new 원숭이("키키");
        원숭이 a원숭이_코코 = new 원숭이("코코");

        monkeys.put("키키", a원숭이_키키);
        monkeys.put("코코", a원숭이_코코);

        assertEquals(monkeys.get("키키"), a원숭이_키키);
        assertEquals(monkeys.get("코코"), a원숭이_코코);
    }

    @Test
    void 다양한_종류의_객체들의_맵() {
        HashMap<String, Object> monkeys = new HashMap<>();

        monkeys.put("원숭이_키키", new 원숭이("키키"));
        monkeys.put("사람_존", new 사람("존"));

        원숭이 a원숭이_키키 = (원숭이) monkeys.get("원숭이_키키");
        사람 a사람_존 = (사람) monkeys.get("사람_존");

        a원숭이_키키.묘기를_부리다();
        a사람_존.말하다();
    }
}

class 사람 {
    private String name;

    public 사람(String name) {
        this.name = name;
    }

    void 말하다() {
        System.out.println("사람이 말합니다.");
    }
}

class 원숭이 {
    private String name;

    public 원숭이(String name) {
        this.name = name;
    }

    void 묘기를_부리다() {
        System.out.println("원숭이가 묘기를 부립니다.");
    }
}