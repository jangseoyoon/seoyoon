package com.sy.magicsquare;
import java.util.Scanner;
public class oddMagic { 
 
 int col;
 int row;
 int count;
 static int[][] oddSquare;
 int squareSize;
 
 public int Initalize(int n){
  col = n - 1;
  row = (n/2 + 1) - 1;
  count = 1;
  squareSize = n*n;
  oddSquare = new int[n][n];
  
  return n;
  
 }
 
 public void execSquare(int num) {
  Initalize(num);
    
  oddSquare[col][row] = count; //3*2
  count++;
  
  for(int i=0; i<squareSize-1; i++) {
   
   col++;
   row++; //4*3
   
   if(col <= num-1 && row > num-1){
    row = 0;
   } else if(col > num-1 && row <= num-1) {
    col = 0;
   } else if(col > num-1 && row > num-1) {
    col--;
    row--;
    col--;
   } else if(oddSquare[col][row] != 0) {
    col--;
    row--;
    col--;
   }
   oddSquare[col][row] = count++;
  }
  
 }
 
 public static void main(String[] args) {
  oddMagic om = new oddMagic();
  System.out.print("������ �Է��Ͻÿ� (0�� 1�� �ƴ� Ȧ��) : ");
  
  //���� �Է¹���
  Scanner scanner = new Scanner(System.in);
  int num = Integer.parseInt(scanner.nextLine());
  
  //0,1,¦���� �ƴϾ����
  if ((num / 2 != 0) && (num != 1) && (num%2 != 0)) {
   om.execSquare(num);
   
   System.out.println(num + " X " + num + " ������ �Դϴ�." );
   System.out.println("����, ����, �밢�� ������ ���Ǵ� ���� "+ ((num*(num*num + 1))/2) +"�Դϴ�.");
   System.out.println();
   
   //�迭 ���
   for (int i = 0; i < num; i++) {
    for (int j = 0; j < num; j++) {
     System.out.format("%3d", oddSquare[i][j]);
    }
    System.out.println();
   }
  } else {
   System.out.println("�߸� �Է��ϼ̽��ϴ�.");
  }
 } 
}