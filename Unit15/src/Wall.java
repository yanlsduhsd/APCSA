import java.awt.Color;

public class Wall extends Block {
	public Wall() {
		super(0,0,10,525, Color.BLACK);
	}
	public Wall(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}
}