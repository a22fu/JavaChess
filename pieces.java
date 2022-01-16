package chess;



public class pieces{
	static piece[][] bMap = new piece[8][8];

	piece pawnW1 = new piece(0,1,true,0);
	piece pawnW2 = new piece(1,1,true,0);
	piece pawnW3 = new piece(2,1,true,0);
	piece pawnW4 = new piece(3,1,true,0);
	piece pawnW5 = new piece(4,1,true,0);
	piece pawnW6 = new piece(5,1,true,0);
	piece pawnW7 = new piece(6,1,true,0);
	piece pawnW8 = new piece(7,1,true,0);
	piece pawnB1 = new piece(0,6,false,0);
	piece pawnB2 = new piece(1,6,false,0);
	piece pawnB3 = new piece(2,6,false,0);
	piece pawnB4 = new piece(3,6,false,0);
	piece pawnB5 = new piece(4,6,false,0);
	piece pawnB6 = new piece(5,6,false,0);
	piece pawnB7 = new piece(6,6,false,0);
	piece pawnB8 = new piece(7,6,false,0);

	piece rookW1 = new piece(0,0,true,2);
	piece rookW2 = new piece(7,0,true,2);
	piece rookB1 = new piece(0,7,false,2);
	piece rookB2 = new piece(7,7,false,2);
	piece knightW1 = new piece(1,0,true,3);
	piece knightW2 = new piece(6,0,true,3);
	piece knightB1 = new piece(1,7,false,3);
	piece knightB2 = new piece(6,7,false,3);
	piece bishopW1 = new piece(2,0,true,4);
	piece bishopW2 = new piece(5,0,true,4);
	piece bishopB1 = new piece(2,7,false,4);
	piece bishopB2 = new piece(5,7,false,4);
	piece kingW = new piece(3,0,true,5);
	piece queenW = new piece(4,0,true,6);
	piece kingB = new piece(3,7,false,5);
	piece queenB = new piece(4,7,false,6);


	void pieceArray(piece setUp){
		bMap[setUp.x][setUp.y] = setUp;	

	}

	void setUp() {
		pieceArray(pawnW1);
		pieceArray(pawnW2);
		pieceArray(pawnW3);
		pieceArray(pawnW4);
		pieceArray(pawnW5);
		pieceArray(pawnW6);
		pieceArray(pawnW7);
		pieceArray(pawnW8);
		pieceArray(rookW1);
		pieceArray(rookW2);
		pieceArray(knightW1);
		pieceArray(knightW2);
		pieceArray(bishopW1);
		pieceArray(bishopW2);
		pieceArray(kingW);
		pieceArray(queenW);
		pieceArray(pawnB1);
		pieceArray(pawnB2);
		pieceArray(pawnB3);
		pieceArray(pawnB4);
		pieceArray(pawnB5);
		pieceArray(pawnB6);
		pieceArray(pawnB7);
		pieceArray(pawnB8);
		pieceArray(rookB1);
		pieceArray(rookB2);
		pieceArray(knightB1);
		pieceArray(knightB2);
		pieceArray(bishopB1);
		pieceArray(bishopB2);
		pieceArray(kingB);
		pieceArray(queenB);
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				if(bMap[i][j]==null) {
					piece empty = new piece(i,j,false,10);
					bMap[i][j] =  empty;


				}


			}
		}
	}

}

class piece {

	boolean white;
	int x;
	int y;
	boolean taken = false;
	int type;
	public piece(int x, int y, boolean white, int type){
		this.x = x;
		this.y = y;
		this.white = white;
		this.type = type;
	}
	boolean[][] Checkmove(int x, int y) {
		boolean[][] pMoves = new boolean[8][8];

		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				pMoves[i][j]=false;

			}
		}
		if(pieces.bMap[x][y].type==5) {
			if(x<7&y<7) {
				if(pieces.bMap[x+1][y+1].type==10|pieces.bMap[x+1][y+1].white!=pieces.bMap[x][y].white) {
					pMoves[x+1][y+1]=true;
				}
			}if(x<7) {
				if(pieces.bMap[x+1][y].type==10|pieces.bMap[x+1][y].white!=pieces.bMap[x][y].white) {
					pMoves[x+1][y]=true;
				}
			}if(x<7&y>0) {
				if(pieces.bMap[x+1][y-1].type==10|pieces.bMap[x+1][y-1].white!=pieces.bMap[x][y].white) {
					pMoves[x+1][y-1]=true;
				}
			}if(y>0) {
				if(pieces.bMap[x][y-1].type==10|pieces.bMap[x][y-1].white!=pieces.bMap[x][y].white) {
					pMoves[x][y-1]=true;
				}
			}if(x>0&y>0) {
				if(pieces.bMap[x-1][y-1].type==10|pieces.bMap[x-1][y-1].white!=pieces.bMap[x][y].white) {
					pMoves[x-1][y-1]=true;
				}
			}if(x>0) {
				if(pieces.bMap[x-1][y].type==10|pieces.bMap[x-1][y].white!=pieces.bMap[x][y].white) {
					pMoves[x-1][y]=true;
				}
			}if(x>0&y<7) {
				if(pieces.bMap[x-1][y+1].type==10|pieces.bMap[x-1][y+1].white!=pieces.bMap[x][y].white) {
					pMoves[x-1][y+1]=true;
				}
			}if(y<7) {
				if(pieces.bMap[x][y+1].type==10|pieces.bMap[x][y+1].white!=pieces.bMap[x][y].white) {
					pMoves[x][y+1]=true;
				}
			}

		}	
		if(pieces.bMap[x][y].type==3) {
			if(x<6&y<7) {
				if(pieces.bMap[x+2][y+1].type==10|pieces.bMap[x+2][y+1].white!=pieces.bMap[x][y].white) {
					pMoves[x+2][y+1]=true;
				}
			}if(x<6&y>0) {
				if(pieces.bMap[x+2][y-1].type==10|pieces.bMap[x+2][y-1].white!=pieces.bMap[x][y].white) {
					pMoves[x+2][y-1]=true;
				}
			}if(x<7&y<6) {
				if(pieces.bMap[x+1][y+2].type==10|pieces.bMap[x+1][y+2].white!=pieces.bMap[x][y].white) {
					pMoves[x+1][y+2]=true;
				}
			}if(x>0&y<6) {
				if(pieces.bMap[x-1][y+2].type==10|pieces.bMap[x-1][y+2].white!=pieces.bMap[x][y].white) {
					pMoves[x-1][y+2]=true;
				}
			}if(x>1&y<7) {
				if(pieces.bMap[x-2][y+1].type==10|pieces.bMap[x-2][y+1].white!=pieces.bMap[x][y].white) {
					pMoves[x-2][y+1]=true;
				}
			}if(x>1&y>0) {
				if(pieces.bMap[x-2][y-1].type==10|pieces.bMap[x-2][y-1].white!=pieces.bMap[x][y].white) {
					pMoves[x-2][y-1]=true;
				}
			}if(x>0&y>1) {
				if(pieces.bMap[x-1][y-2].type==10|pieces.bMap[x-1][y-2].white!=pieces.bMap[x][y].white) {
					pMoves[x-1][y-2]=true;
				}
			}if(x<7&y>1) {
				if(pieces.bMap[x+1][y-2].type==10|pieces.bMap[x+1][y-2].white!=pieces.bMap[x][y].white) {
					pMoves[x+1][y-2]=true;
				}
			}
		}
		if(pieces.bMap[x][y].type==2) {
			for (int i=1;i<8-x;i++) {
				if(pieces.bMap[x+i][y].type==10) {
					pMoves[x+i][y]=true;
				}else if(pieces.bMap[x+i][y].white!=pieces.bMap[x][y].white){
					pMoves[x+i][y]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<8-y;i++) {
				if(pieces.bMap[x][y+i].type==10) {
					pMoves[x][y+i]=true;
				}else if(pieces.bMap[x][y+i].white!=pieces.bMap[x][y].white){
					pMoves[x][y+i]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<x+1;i++) {
				if(pieces.bMap[x-i][y].type==10) {
					pMoves[x-i][y]=true;
				}else if(pieces.bMap[x-i][y].white!=pieces.bMap[x][y].white){
					pMoves[x-i][y]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<y+1;i++) {
				if(pieces.bMap[x][y-i].type==10) {
					pMoves[x][y-i]=true;
				}else if(pieces.bMap[x][y-i].white!=pieces.bMap[x][y].white){
					pMoves[x][y-i]=true;
					break;
				}else {
					break;
				}
			}

		}if(pieces.bMap[x][y].type==4) {
			for (int i=1;i<8;i++) {
				if(x+i==8|y+i==8) {
					break;
				}else if(pieces.bMap[x+i][y+i].type==10) {
					pMoves[x+i][y+i]=true;
				}else if(pieces.bMap[x+i][y+i].white!=pieces.bMap[x][y].white){
					pMoves[x+i][y+i]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<8;i++) {
				if(x+i==8|y-i==-1) {
					break;
				}else if(pieces.bMap[x+i][y-i].type==10) {
					pMoves[x+i][y-i]=true;
				}else if(pieces.bMap[x+i][y-i].white!=pieces.bMap[x][y].white){
					pMoves[x+i][y-i]=true;
					break;
				}else 
					break;
			}
		for (int i=1;i<8;i++) {
			if(x-i==-1|y-i==-1) {
				break;
			}else if(pieces.bMap[x-i][y-i].type==10) {
				pMoves[x-i][y-i]=true;
			}else if(pieces.bMap[x-i][y-i].white!=pieces.bMap[x][y].white){
				pMoves[x-i][y-i]=true;
				break;
			}else {
				break;
			}
		}for (int i=1;i<8;i++) {
			if(x-i==-1|y+i==8) {
				break;
			}else if(pieces.bMap[x-i][y+i].type==10) {
				pMoves[x-i][y+i]=true;
			}else if(pieces.bMap[x-i][y+i].white!=pieces.bMap[x][y].white){
				pMoves[x-i][y+i]=true;
				break;
			}else {
				break;
			}
		}}
		if(pieces.bMap[x][y].type==6) {
			for (int i=1;i<8;i++) {
				if(x+i==8|y+i==8) {
					break;
				}else if(pieces.bMap[x+i][y+i].type==10) {
					pMoves[x+i][y+i]=true;
				}else if(pieces.bMap[x+i][y+i].white!=pieces.bMap[x][y].white){
					pMoves[x+i][y+i]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<8;i++) {
				if(x+i==8|y-i==-1) {
					break;
				}else if(pieces.bMap[x+i][y-i].type==10) {
					pMoves[x+i][y-i]=true;
				}else if(pieces.bMap[x+i][y-i].white!=pieces.bMap[x][y].white){
					pMoves[x+i][y-i]=true;
					break;
				}else 
					break;
			}for (int i=1;i<8;i++) {
				if(x-i==-1|y-i==-1) {
					break;
				}else if(pieces.bMap[x-i][y-i].type==10) {
					pMoves[x-i][y-i]=true;
				}else if(pieces.bMap[x-i][y-i].white!=pieces.bMap[x][y].white){
					pMoves[x-i][y-i]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<8;i++) {
				if(x-i==-1|y+i==8) {
					break;
				}else if(pieces.bMap[x-i][y+i].type==10) {
					pMoves[x-i][y+i]=true;
				}else if(pieces.bMap[x-i][y+i].white!=pieces.bMap[x][y].white){
					pMoves[x-i][y+i]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<8-x;i++) {
				if(pieces.bMap[x+i][y].type==10) {
					pMoves[x+i][y]=true;
				}else if(pieces.bMap[x+i][y].white!=pieces.bMap[x][y].white){
					pMoves[x+i][y]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<8-y;i++) {
				if(pieces.bMap[x][y+i].type==10) {
					pMoves[x][y+i]=true;
				}else if(pieces.bMap[x][y+i].white!=pieces.bMap[x][y].white){
					pMoves[x][y+i]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<x+1;i++) {
				if(pieces.bMap[x-i][y].type==10) {
					pMoves[x-i][y]=true;
				}else if(pieces.bMap[x-i][y].white!=pieces.bMap[x][y].white){
					pMoves[x-i][y]=true;
					break;
				}else {
					break;
				}
			}for (int i=1;i<y+1;i++) {
				if(pieces.bMap[x][y-i].type==10) {
					pMoves[x][y-i]=true;
				}else if(pieces.bMap[x][y-i].white!=pieces.bMap[x][y].white){
					pMoves[x][y-i]=true;
					break;
				}else {
					break;
				}
			}
		}

		if(pieces.bMap[x][y].type==0&pieces.bMap[x][y].white==true){
			if(y==1) {
				if(pieces.bMap[x][y+2].type==10) {

					pMoves[x][y+2]=true;
				}
			}if (y+1<8) {
				if(pieces.bMap[x][y+1].type==10) {
					pMoves[x][y+1]=true;

				}if(x<7) {

					if(pieces.bMap[x][y].white!=pieces.bMap[x+1][y+1].white&pieces.bMap[x+1][y+1].type!=10) {
						pMoves[x+1][y+1]=true;
					}
				}if(x>0) {

					if(pieces.bMap[x][y].white!=pieces.bMap[x-1][y+1].white&pieces.bMap[x-1][y+1].type!=10) {
						pMoves[x-1][y+1]=true;
					}
				}
			}
		}if(pieces.bMap[x][y].type==0&pieces.bMap[x][y].white==false){
			if(y==6) {
				if(pieces.bMap[x][y-2].type==10) {

					pMoves[x][y-2]=true;
				}
			}
			if (y>0) {
				if(pieces.bMap[x][y-1].type==10) {
					pMoves[x][y-1]=true;
				}
				if(x<7) {
					if(pieces.bMap[x][y].white!=pieces.bMap[x+1][y-1].white&pieces.bMap[x+1][y-1].type!=10) {
						pMoves[x+1][y-1]=true;

					}
				}if(x>0) {
					if(pieces.bMap[x][y].white!=pieces.bMap[x-1][y-1].white&pieces.bMap[x-1][y-1].type!=10) {
						pMoves[x-1][y-1]=true;
					}
				}
			}
		}	


		return pMoves;

	}

	public static void main(String[] args) {
		pieces pi = new pieces();
		pi.setUp();


	}
}
