package practice;

import java.util.Scanner;

//简单的约瑟夫环求解
public class Josephus {
  static final int Num=41;    //总人数
  static final int KillMan=3;        //自杀者报数
  //约瑟夫环算法
  static void josephus(int alive){
      int []man = new int[Num];
      int count=1;
      int i=0,pos=-1;
      while(count<=Num){
          do{
              pos=(pos+1)%Num;   //环处理
              if(man[pos]==0)   //只有没自杀的人才不等于0
                  i++;
              if(i==KillMan){   //该人自杀
                  i=0;
                  break;
              }            
          }while(true);
          man[pos]=count;
          System.out.printf("第%2d个人自杀！约瑟夫环编号为%2d",pos+1,man[pos]);
          if(count%2==1){
              System.out.printf("->");
          }else{
              System.out.printf("->\n");   //输出换行
          }
          count++;
      }
      System.out.println();
      System.out.printf("这%d个需要存活的人的初始位置应该排在以下序号：\n",alive);
      alive = Num - alive;
      for(i=0;i<Num;i++){
          if(man[i]>alive)
              System.out.printf("初始编号：%d,约瑟夫环编号：%d\n", i+1,man[i]);
      }
      System.out.println();
  }
  public static void main(String[] args){
      int alive;
      System.out.print("约瑟夫环问题求解！\n");
      System.out.print("请输入需要留存的人的数量：");
      Scanner input = new Scanner(System.in);
      alive = input.nextInt();
      josephus(alive);
  }
}