import java.awt.*;

public class Ball {
	
	int x = 0;
	int y = 130;
	int dx = 1;
	int dy = 1;
	int diameter = 100;
	
	private BouncingBallGame game;
	
	public Ball(BouncingBallGame game){
		this.game = game;
	}
	
	public void move(){
		int toRemove = game.detectHit();
		if (game.detectCollision()){
			dy = -1;
		}
		if (toRemove >= 0){
			dy = 1;
			game.north.removeBlock(toRemove);
		}
		if (x + dx < 0)
			dx = 1;
		if (x + dx > game.getWidth() - diameter)
			dx = -1;
		if (y + dy < 0)
			dy = 1;
		if (y + dy > game.getHeight() - diameter)
			dy = -1;
		
		x = x + dx;
		y = y + dy;
		
		if (y >= game.getHeight()-diameter){
			game.gameOver();
		}
	}
	
	public void paint(Graphics2D g){
		g.setColor(Color.red);
		g.fillOval(x, y, diameter, diameter);
	}
	
	public Rectangle getRectangle(){
		return new Rectangle(x,y,diameter,diameter);
	}
}
