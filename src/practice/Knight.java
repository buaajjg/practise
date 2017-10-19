package practice;

public class Knight {

	public static void main(String[] args) {
		int x=7;
		int y=7;
		int startX=0;
		int startY=0;
		int endX=0;
		int endY=6;
		Knight k=new Knight();
		int [][] block={{2,3},{3,2},{3,3},{3,4},{4,3}};
		System.out.println(k.adventure(x, y, startX, startY, endX, endY, block));
		

	}
	public int adventure(int x,int y,int startX,int startY,int endX,int endY,int[][] block){
		if(x>1000||y>1000||x<=0||y<=0||startX>x-1||endX>x-1||startY>y-1||endY>y-1
				||startX<0||startY<0||endX<0||endY<0){
			return -1;
		}
		if(startX==endX&&startY==endY){
			return 0;
		}
		int[][] table= new int[x][y];
		for(int i=0;i<block.length;i++){
			table[block[i][0]][block[i][1]]=-1;
		}
		int step=1;
		table[startX][startY]=step;
		boolean flag=true;
		out:
		while(flag){
			flag=false;
			for(int i=0;i<x;i++){
				for(int k=0;k<y;k++){
					if(table[i][k]==step){
						
						flag=true;
						step(table,step+1,i,k);
						if(table[endX][endY]!=0){
							break out;
						}
						
					}
				}
				
			}
			
			step++;
			
		}
		for(int [] ele:table){
			for(int e:ele){
				System.out.print(e+"  ");
			}
			System.out.println();
		}
		if(table[endX][endY]!=0){
			return table[endX][endY]-1;
		}
		return -1;
	}
	public void step(int [][] table,int step,int startX,int startY){
		
		
		if(startX>0&&startY>1&&table[startX-1][startY-2]==0){
			table[startX-1][startY-2]=step;
		}
		if(startX>1&&startY>0&&table[startX-2][startY-1]==0){
			table[startX-2][startY-1]=step;
		}
		if(startX>1&&startY<table[0].length-1&&table[startX-2][startY+1]==0){
			table[startX-2][startY+1]=step;
		}
		if(startX>0&&startY<table[0].length-2&&table[startX-1][startY+2]==0){
			table[startX-1][startY+2]=step;
		}
		if(startX<table.length-1&&startY<table[0].length-2&&table[startX+1][startY+2]==0){
			table[startX+1][startY+2]=step;
		}
		if(startX<table.length-2&&startY<table[0].length-1&&table[startX+2][startY+1]==0){
			table[startX+2][startY+1]=step;
		}
		if(startX<table.length-2&&startY>0&&table[startX+2][startY-1]==0){
			table[startX+2][startY-1]=step;
		}
		if(startX<table.length-1&&startY>1&&table[startX+1][startY-2]==0){
			table[startX+1][startY-2]=step;
		}
		
	}
}
