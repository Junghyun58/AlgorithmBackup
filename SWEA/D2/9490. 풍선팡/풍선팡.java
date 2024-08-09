import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

  		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 행(r)
			int M = sc.nextInt(); // 열(c)

			int[][] arr = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 배열 입력받기

			int[] dr = new int[] { -1, 1, 0, 0 };
			int[] dc = new int[] {  0, 0, -1, 1 }; // 상,하,좌,우
			int nextdr = 0; // r + dr[i]
			int nextdc = 0; // c + dc[i]

			int sum = 0; // 합한 값을 넣어줄 변수
			int max = 0; // 최댓값을 담을 변수
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					sum =0;
					int num = arr[r][c]; // 해당 위치의 값을 넣어주는 변수
					for (int i = 0; i < dc.length; i++) {
						nextdr = r + dr[i];
						nextdc = c + dc[i];
						if (nextdr >= 0 && nextdc >= 0 && nextdr < N && nextdc < M) {
							sum += arr[nextdr][nextdc];

							for (int j = 1; j < num; j++) {
								// num의 횟수만큼 돌려줄건데,
								// 이미 nextdr에 한 횟수는 포함되어있기 때문에 j가 1부터 시작
								
									nextdr += dr[i];
									nextdc += dc[i];
									if (nextdr >= 0 && nextdc >= 0 && nextdr < N && nextdc < M) {
									sum += arr[nextdr][nextdc];
								}
							}
						}

					}
					sum = sum + num;
					if (sum > max)
						max = sum;
				}
			}
			System.out.println("#" + test_case + " "+ max);
		}
	}
}