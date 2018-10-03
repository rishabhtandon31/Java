
public class MatrixMultiplication {

	public static void main(String[] args) {
		int [][]matrix1={{1,2},{3,4}};
		int [][]matrix2={{1,2,3},{4,5,6}};
		int i,j,k;
		int [][]matrix3=new int[2][3];
		for(i=0;i<2;i++){
			for(j=0;j<3;j++){
				for(k=0;k<2;k++){
					matrix3[i][j] +=matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		for(i=0;i<2;i++){
			for(j=0;j<3;j++){
				System.out.print(matrix3[i][j]+"		");
			}
			System.out.println();
		}
	}

}
