package brute_force._14500_테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr1;
    public static int[][] arr2;
    public static int[][] arr3;
    public static int[][] arr4;
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr1 = new int[N][M];
        arr2 = new int[M][N];
        arr3 = new int[N][M];
        arr4 = new int[M][N];

        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr1[i][j] = num;
                arr2[j][N-1-i] = num;
                arr3[N-1-i][M-1-j] = num;
                arr4[M-1-j][i] = num;
            }
        }

        max = Math.max(max, checkTetrominor1());
        max = Math.max(max, checkTetrominor2());
        max = Math.max(max, checkTetrominor3());
        max = Math.max(max, checkTetrominor4());
        max = Math.max(max, checkTetrominor5());

        System.out.println(max);
    }

    private static int checkTetrominor1() {
        int[] x = {0, 0, 0};
        int[] y = {1, 1, 1};
        return searchArrayAndFindMaxNum(x, y, false);
    }

    private static int checkTetrominor2() {
        int[] x = {1, 1, 0};
        int[] y = {0, 0, 1};
        return searchArrayAndFindMaxNum(x, y, false);
    }

    private static int checkTetrominor3() {
        int[] x = {1, 0, -1};
        int[] y = {0, 1, 0};
        return searchArrayAndFindMaxNum(x, y, false);
    }

    private static int checkTetrominor4() {
        int[] x = {1, 0, 1};
        int[] y = {0, 1, 0};
        return searchArrayAndFindMaxNum(x, y, false);
    }

    private static int checkTetrominor5() {
        int[] x = {0, 1, 0};
        int[] y = {1, 0, 1};
        return searchArrayAndFindMaxNum(x, y, true);
    }

    private static int searchArrayAndFindMaxNum(int[] x, int[] y, boolean tetrominor5) {
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int sum = arr1[i][j];
                for(int k=0; k<x.length; k++) {
                    int nextX = x[k] + i;
                    int nextY = y[k] + j;

                    if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                        sum += arr1[nextX][nextY];

                        if(tetrominor5) {
                            for(int l=1; l<=2; l++) {
                                int upValue = x[l] + i;
                                int downValue = y[l] + j;

                                if(upValue >= 0 && upValue < N && downValue >= 0 && downValue < M) {
                                    sum += arr1[upValue][downValue];
                                } else {
                                    sum = 0;
                                    break;
                                }
                            }
                        }
                    } else {
                        sum = 0;
                        break;
                    }
                }
                max = Math.max(max, sum);
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                int sum = arr2[i][j];
                for(int k=0; k<x.length; k++) {
                    int nextX = x[k] + i;
                    int nextY = y[k] + j;

                    if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                        sum += arr2[nextX][nextY];

                        if(tetrominor5) {
                            for(int l=1; l<=2; l++) {
                                int upValue = x[l] + i;
                                int downValue = y[l] + j;

                                if(upValue >= 0 && upValue < N && downValue >= 0 && downValue < M) {
                                    sum += arr1[upValue][downValue];
                                } else {
                                    sum = 0;
                                    break;
                                }
                            }
                        }
                    } else {
                        sum = 0;
                        break;
                    }
                }
                max = Math.max(max, sum);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int sum = arr3[i][j];
                for(int k=0; k<x.length; k++) {
                    int nextX = x[k] + i;
                    int nextY = y[k] + j;

                    if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                        sum += arr3[nextX][nextY];

                        if(tetrominor5) {
                            for(int l=1; l<=2; l++) {
                                int upValue = x[l] + i;
                                int downValue = y[l] + j;

                                if(upValue >= 0 && upValue < N && downValue >= 0 && downValue < M) {
                                    sum += arr1[upValue][downValue];
                                } else {
                                    sum = 0;
                                    break;
                                }
                            }
                        }
                    } else {
                        sum = 0;
                        break;
                    }
                }
                max = Math.max(max, sum);
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                int sum = arr4[i][j];
                for(int k=0; k<x.length; k++) {
                    int nextX = x[k] + i;
                    int nextY = y[k] + j;

                    if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                        sum += arr4[nextX][nextY];

                        if(tetrominor5) {
                            for(int l=1; l<=2; l++) {
                                int upValue = x[l] + i;
                                int downValue = y[l] + j;

                                if(upValue >= 0 && upValue < N && downValue >= 0 && downValue < M) {
                                    sum += arr1[upValue][downValue];
                                } else {
                                    sum = 0;
                                    break;
                                }
                            }
                        }
                    } else {
                        sum = 0;
                        break;
                    }
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
