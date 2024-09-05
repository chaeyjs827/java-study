package cote;

import java.util.HashSet;
import java.util.Set;

public class SeatingArragement {
    public int solution(int N, String S) {
        // 예약된 좌석을 저장할 Set
        Set<String> reservedSeats = new HashSet<>();
        if (!S.isEmpty()) {
            // 예약된 좌석들을 분리하여 Set에 추가
            String[] seats = S.split(" ");
            for (String seat : seats) {
                reservedSeats.add(seat);
            }
        }

        int maxFamilies = 0; // 최대 앉힐 수 있는 가족 수

        // 각 줄마다 가족이 앉을 수 있는지 확인
        for (int row = 1; row <= N; row++) {
            boolean left = !reservedSeats.contains(row + "B") && !reservedSeats.contains(row + "C")
                    && !reservedSeats.contains(row + "D") && !reservedSeats.contains(row + "E");

            boolean middle = !reservedSeats.contains(row + "D") && !reservedSeats.contains(row + "E")
                    && !reservedSeats.contains(row + "F") && !reservedSeats.contains(row + "G");

            boolean right = !reservedSeats.contains(row + "F") && !reservedSeats.contains(row + "G")
                    && !reservedSeats.contains(row + "H") && !reservedSeats.contains(row + "J");

            // 가능한 가족의 수 계산
            if (left && right) {
                maxFamilies += 2; // 왼쪽과 오른쪽이 비어 있으면 두 가족 가능
            } else if (left || middle || right) {
                maxFamilies += 1; // 세 그룹 중 하나만 비어 있어도 한 가족 가능
            }
        }

        return maxFamilies; // 전체 가능한 가족 수 반환
    }
}
