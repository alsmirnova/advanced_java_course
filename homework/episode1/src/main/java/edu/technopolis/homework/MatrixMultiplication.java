package edu.technopolis.homework;
/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixMultiplication {

    private int N,M,X,Y;
    private int [] elements;
    private int [][] result;

    public void Multiplication() {
        result = new int[N][Y];
        int iter;
        for (int j=0; j<Y; j++) {
            for (int i = 0; i < N; i++) {
                iter=-1;
                for (int k = i*M; k < M*(i+1); k++) {
                    iter++;
                    result[i][j] += elements[k] * elements[N * M + Y*iter+j];
                }
            }
        }
    }

    public void print() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<Y; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean verify(int N, int M, int X, int Y) {
        if (N<=0 || M<=0 || X<=0 || Y<=0) {
            System.out.println("Число строк и столбцов матрицы должно быть положительным!");
            return false;
        }
        else if (M!=X) {
            System.out.println("Число столбцов первой матрицы должно совпадать с числом строк второй матрицы!");
            return false;
        }
        return true;
    }

    public void Input() {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] buf= lineReader.readLine().split(" ");

            N = Integer.parseInt(buf[0]);
            M = Integer.parseInt(buf[1]);
            X = Integer.parseInt(buf[2]);
            Y = Integer.parseInt(buf[3]);

            if (verify(N,M,X,Y)) {
                elements = new int[buf.length-4];
                for (int i=4; i<buf.length; i++ ) elements[i-4]=Integer.parseInt(buf[i]);
                Multiplication();
                print();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        new MatrixMultiplication().Input();
    }
}
