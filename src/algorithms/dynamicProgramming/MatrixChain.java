package algorithms.dynamicProgramming;

public class MatrixChain {
    public static int[][] matrixChain(int[] d){
        int n = d.length - 1; //number of matrices
        int [][] N = new int[n][n]; //n by n matrix every entry is '0'
        for (int i = 1; i < n; i++){
            for (int j = 0; j < n; j++){
                int k = j + i;

                N[k][j] = Integer.MAX_VALUE;
                for (int l = j; l < k; l++){
                    N[j][k] = Math.min(N[j][k], N[j][l] + N[l+1][k] + d[j]*d[l+1]*d[k+1]);
                }
            }
        }
        return N;
    }
}
