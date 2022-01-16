package chess;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


import javax.imageio.ImageIO;
import javax.swing.*;
class square extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int squarex;
	int squarey;
	String pieceName;
	square(int x, int y, String name) {
		squarex = x;
		squarey = y;
		pieceName = name;
	}

}

public class Board {

	public JFrame f = new JFrame("Chess");
	JLabel background; //initializing variables
	JPanel panel = new JPanel();
	square empty;
	square pawnw1 = new square(0,100,"Pawn");
	square pawnw2 = new square(100,100,"Pawn");
	square pawnw3 = new square(200,100,"Pawn");
	square pawnw4 = new square(300,100,"Pawn");
	square pawnw5 = new square(400,100,"Pawn");
	square pawnw6 = new square(500,100,"Pawn");
	square pawnw7 = new square(600,100,"Pawn");
	square pawnw8 = new square(700,100,"Pawn");
	square rookw1 = new square(0,0,"Rook");
	square rookw2 = new square(700,0,"Rook");
	square knightw1 = new square(100,0,"Knight");
	square knightw2 = new square(600,0,"Knight");
	square bishopw1 = new square(200,0,"Bishop");
	square bishopw2 = new square(500,0,"Bishop");
	square kingw = new square(300,0,"King");
	square queenw = new square(400,0,"Queen");
	square pawnb1 = new square(0,600,"Pawn");
	square pawnb2 = new square(100,600,"Pawn");
	square pawnb3 = new square(200,600,"Pawn");
	square pawnb4 = new square(300,600,"Pawn");
	square pawnb5 = new square(400,600,"Pawn");
	square pawnb6 = new square(500,600,"Pawn");
	square pawnb7 = new square(600,600,"Pawn");
	square pawnb8 = new square(700,600,"Pawn");
	square rookb1 = new square(0,700,"Rook");
	square rookb2 = new square(700,700,"Rook");
	square knightb1 = new square(100,700,"Knight");
	square knightb2 = new square(600,700,"Knight");
	square bishopb1 = new square(200,700,"Bishop");
	square bishopb2 = new square(500,700,"Bishop");
	square kingb = new square(300,700,"King");
	square queenb = new square(400,700,"Queen");
	square moving;
	boolean turn = false;
	boolean clicked = false;
	void setPieceW(final square setUp) {  ///setUp the piece positions,
		setUp.setBounds(setUp.squarex,setUp.squarey,100,100);
		if(setUp.pieceName=="Pawn") {
		
			InputStream url = getClass().getResourceAsStream("/blackP.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}if(setUp.pieceName=="Knight") {
			InputStream url = getClass().getResourceAsStream("/blackKn.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}if(setUp.pieceName=="Rook") {
			InputStream url = getClass().getResourceAsStream("/blackR.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}if(setUp.pieceName=="Bishop") {
			InputStream url = getClass().getResourceAsStream("/blackB.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}if(setUp.pieceName=="King") {
			InputStream url = getClass().getResourceAsStream("/blackK.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}if(setUp.pieceName=="Queen") {
			InputStream url = getClass().getResourceAsStream("/blackQ.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		setUp.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

				if (clicked) {
					Point p = MouseInfo.getPointerInfo().getLocation();
					int oldx = moving.squarex/100;
					int oldy = moving.squarey/100;
					if(turn==pieces.bMap[oldx][oldy].white) {
						piece temp = pieces.bMap[oldx][oldy];	


						boolean[][] check = temp.Checkmove(oldx, oldy);
						if(check[(p.x-7-(p.x-7)%100)/100][(p.y-27 - (p.y-27)%100)/100]) {

							moving.squarex=p.x-7 - (p.x-7)%100;
							moving.squarey= p.y-27 - (p.y-27)%100;
							panel.remove(setUp);
							moving.setBounds(moving.squarex,moving.squarey,100,100);
							pieces.bMap[moving.squarex/100][moving.squarey/100] = temp;
							piece empty = new piece(oldx,oldy,false,10);
							pieces.bMap[oldx][oldy]=empty;
							clicked = false;	
							if(turn==false) {
								turn=true;
							}else {
								turn=false;
							}					}
					}
				}else {
					clicked = true;
					moving = setUp;
				}
			}
		});
		panel.add(setUp);
	}
	void setPieceB(final square setUp) {  ///setUp the piece positions,
		setUp.setBounds(setUp.squarex,setUp.squarey,100,100);
		if(setUp.pieceName=="Pawn") {
			InputStream url = getClass().getResourceAsStream("/whiteP.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}if(setUp.pieceName=="Knight") {
			InputStream url = getClass().getResourceAsStream("/whiteKn.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
}
		if(setUp.pieceName=="Rook") {
			InputStream url = getClass().getResourceAsStream("/whiteR.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}if(setUp.pieceName=="Bishop") {
			InputStream url = getClass().getResourceAsStream("/whiteB.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}if(setUp.pieceName=="King") {
			InputStream url = getClass().getResourceAsStream("/whiteK.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}if(setUp.pieceName=="Queen") {
			InputStream url = getClass().getResourceAsStream("/whiteQ.png");
		    Image image;
			try {
				image = ImageIO.read(url);
				setUp.setIcon(new ImageIcon(image));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	setUp.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

				if (clicked) {
					Point p = MouseInfo.getPointerInfo().getLocation();
					int oldx = moving.squarex/100;
					int oldy = moving.squarey/100;
					if(turn==pieces.bMap[oldx][oldy].white) {

						piece temp = pieces.bMap[oldx][oldy];	


						boolean[][] check = temp.Checkmove(oldx, oldy);
						if(check[(p.x-7-(p.x-7)%100)/100][(p.y-27 - (p.y-27)%100)/100]) {

							moving.squarex=p.x-7 - (p.x-7)%100;
							moving.squarey= p.y-27 - (p.y-27)%100;
							panel.remove(setUp);
							moving.setBounds(moving.squarex,moving.squarey,100,100);
							pieces.bMap[moving.squarex/100][moving.squarey/100] = temp;
							piece empty = new piece(oldx,oldy,false,10);
							pieces.bMap[oldx][oldy]=empty;
							clicked = false;
							if(turn==false) {
								turn=true;
							}else {
								turn=false;
							}					}
					}
				}else {
					clicked = true;
					moving = setUp;
				}
			}
		});
		panel.add(setUp);
	}

	void createBoard() {
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		///SET UP PAWN1
		setPieceW(pawnw1);
		setPieceW(pawnw2);
		setPieceW(pawnw3);
		setPieceW(pawnw4);
		setPieceW(pawnw5);
		setPieceW(pawnw6);
		setPieceW(pawnw7);
		setPieceW(pawnw8);
		setPieceW(rookw1);
		setPieceW(rookw2);
		setPieceW(knightw1);
		setPieceW(knightw2);
		setPieceW(bishopw1);
		setPieceW(bishopw2);
		setPieceW(kingw);
		setPieceW(queenw);
		setPieceB(pawnb1);
		setPieceB(pawnb2);
		setPieceB(pawnb3);
		setPieceB(pawnb4);
		setPieceB(pawnb5);
		setPieceB(pawnb6);
		setPieceB(pawnb7);
		setPieceB(pawnb8);
		setPieceB(rookb1);
		setPieceB(rookb2);
		setPieceB(knightb1);
		setPieceB(knightb2);
		setPieceB(bishopb1);
		setPieceB(bishopb2);
		setPieceB(kingb);
		setPieceB(queenb);




		///CODE TO MOVE PIECES
		panel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (clicked) {
					Point p = MouseInfo.getPointerInfo().getLocation();
					int oldx = moving.squarex/100;
					int oldy = moving.squarey/100;
					if(turn==pieces.bMap[oldx][oldy].white) {

						piece temp = pieces.bMap[oldx][oldy];	


						boolean[][] check = temp.Checkmove(oldx, oldy);
						if(check[(p.x-7-(p.x-7)%100)/100][(p.y-27 - (p.y-27)%100)/100]) {

							moving.squarex=p.x-7 - (p.x-7)%100;
							moving.squarey= p.y-27 - (p.y-27)%100;
							moving.setBounds(moving.squarex,moving.squarey,100,100);
							pieces.bMap[moving.squarex/100][moving.squarey/100] = temp;
							piece empty = new piece(oldx,oldy,false,10);
							pieces.bMap[oldx][oldy]=empty;
							if(turn==false) {
								turn=true;
							}else {
								turn=false;
							}
						}
					}else {

					}
					clicked = false;

				}
			}
		});
		///
		///









		panel.setSize(800,800);
		panel.setLayout(null);
		panel.setOpaque(false);

		
		JLabel background = new JLabel();
		InputStream url = getClass().getResourceAsStream("/CHESS.png");
	    Image image;
		try {
			image = ImageIO.read(url);
			background.setIcon(new ImageIcon(image));
			background.setHorizontalAlignment(SwingConstants.LEFT);

			background.setSize(800,800);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		
		f.add(panel);

		f.add(background);		

		
		f.pack();

	}
	public static void main(String[] args) {
		Board board = new Board();
		board.createBoard();
		pieces p = new pieces();
		p.setUp();

	}




}
