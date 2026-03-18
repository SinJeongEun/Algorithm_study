package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.greedy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new TreeSet<>(); // 오름차순으로 해야 더 많이 빌려줄 수 있음.

        for (int l : lost) lostSet.add(l); // 체육복 없음
        for (int r : reserve) reserveSet.add(r); // 체육복 여벌 있음

        // 체육복 잃어버렸지만, 여벌이 있는 사람은 자신만 입을 수 있음.
        Set<Integer> both = new HashSet<>(lostSet);
        both.retainAll(reserveSet); // 교집합 추출

        lostSet.removeAll(both); // lost에서 제거 (본인 거 해결됨)
        reserveSet.removeAll(both); // reserve에서 제거 (빌려줄 수 없음)

        for(int r : reserveSet) {
            if(lostSet.contains(r-1)) lostSet.remove(r-1);
            else if(lostSet.contains(r+1)) lostSet.remove(r+1);
        }

        return n - lostSet.size();
    }
}
