package cote;

import java.util.HashSet;
import java.util.Set;

public class PathFinding {
    public boolean solution(int N, int[] A, int[] B) {
        // 간선들을 저장하기 위한 Set
        Set<String> edges = new HashSet<>();

        // 주어진 간선들을 "작은 정점, 큰 정점" 형태로 저장
        for (int i = 0; i < A.length; i++) {
            int a = Math.min(A[i], B[i]);
            int b = Math.max(A[i], B[i]);
            edges.add(a + "," + b);
        }

        // 1번부터 N번까지의 연속된 정점들이 직접 연결되어 있는지 확인
        for (int i = 1; i < N; i++) {
            String edge = i + "," + (i + 1);
            if (!edges.contains(edge)) {
                return false; // 필요한 직접 연결이 없으면 false 반환
            }
        }

        return true; // 모든 연결이 확인되면 true 반환
    }
}
