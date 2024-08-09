import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 변의 길이 입력받기

			int[][] arr = new int[N][N];

			for (int r = 0; r < arr.length; r++) {
				String number = sc.next();
				for (int c = 0; c < N; c++) {
					arr[r][c] = number.charAt(c) - '0';
				}
			}
			int sum = 0; // 합을 저장할 변수 생성
			int start = N / 2;
			int end = N / 2; // 두 개 다 열 인덱스의 반부터 시작함

			for (int r = 0; r < arr.length; r++) {
				for (int c = start; c <= end; c++) {
					sum += arr[r][c];
				}
				if (r < N/2) {
					start--; //위쪽 부분 -> 시작 인덱스 앞으로, 끝인덱스 뒤로
					end++;
				}
				else {
					start++;
					end--; // 아래쪽 부분 -> 시작 인덱스 뒤로, 끝인덱스 앞으로 
				}
			}
			System.out.println("#"+test_case+" "+ sum);
		}

	}

}
