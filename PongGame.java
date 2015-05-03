package Pong;

import apcs.Window;

public class PongGame {
	
	static int ball_x;
	static int ball_y;
	static double x_speed;
	static int y_speed;
	static int paddle_1;
	static int paddle_2;
	static int score_1;
	static int score_2;

	public static void main(String[] args) {
		ball_x = 250;
		ball_y = 250;
		paddle_1 = 250;
		paddle_2 = 250;
		score_1 = 0;
		score_2 = 0;
		x_speed = 3;
		y_speed = 3;
		
		while (true)
		{
			draw();
			step();
			PaddleMove();
			BallBounce();
		}
	}
	public static void draw()
	{
		//background
		Window.out.background("black");
		
		//setting things up
		Window.out.color("white");
		Window.out.circle(ball_x, ball_y, 10);
		Window.out.rectangle(30, paddle_1, 40, 200);
		Window.out.rectangle(470, paddle_2, 40, 200);
		
		//scores
		Window.out.print(score_1, 200, 50);
		Window.out.print(score_2, 300, 50);
		
		//line down the middle
		for (int y = 10; y <= 490; y = y + 40)
		{
			Window.out.rectangle(250, y, 10, 20);
		}
		
		Window.frame();
	}
	public static void step()
	{
		ball_x = (int) (ball_x + x_speed);
		ball_y = ball_y + y_speed;
		if (ball_y > 490)
		{
			ball_y = 490;
			y_speed = -y_speed;
		}
		if (ball_y < 10)
		{
			ball_y = 10;
			y_speed = -y_speed;
		}
		if (ball_x < 10)
		{
			ball_x = 250;
			ball_y = 250;
			x_speed = 3;
			paddle_1 = 250;
			paddle_2 = 250;
			score_2 = score_2 + 1;
			Window.frame();
			Window.sleep(2000);
		}
		if (ball_x > 490)
		{
			ball_x = 250;
			ball_y = 250;
			x_speed = -3;
			paddle_1 = 250;
			paddle_2 = 250;
			score_1 = score_1 + 1;
			Window.frame();
			Window.sleep(2000);
		}
	}
	public static void PaddleMove()
	{
		if (Window.key.pressed("w") && paddle_1 > 100)
		{
			paddle_1 -= 3;
		}
		if (Window.key.pressed("s") && paddle_1 < 400)
		{
			paddle_1 += 3;
		}
		if (Window.key.pressed("up") && paddle_2 > 100)
		{
			paddle_2 -= 3;
		}
		if (Window.key.pressed("down") && paddle_2 < 400)
		{
			paddle_2 += 3;
		}
		
	}
	public static void BallBounce()
	{
		if (ball_x < 50 || ball_x > 450)
		{
			if (Math.abs(ball_y - (paddle_1 - 100)) < 10)
			{
				ball_y = paddle_1 - 110;
				y_speed = -y_speed;
			}
			if (Math.abs(ball_y - (paddle_1 + 100)) < 10)
			{
				ball_y = paddle_1 + 110;
				y_speed = -y_speed;
			}
			if (Math.abs(ball_y - (paddle_2 - 100)) < 10)
			{
				ball_y = paddle_2 - 110;
				y_speed = -y_speed;
			}
			if (Math.abs(ball_y - (paddle_2 + 100)) < 10)
			{
				ball_y = paddle_2 + 110;
				y_speed = -y_speed;
			}
		}
		if (ball_x < 50 && Math.abs(ball_y - paddle_1) < 100)
		{
			ball_x = 50;
			x_speed = x_speed * -1.1;
		}
		if (ball_x > 450 && Math.abs(ball_y - paddle_2) < 100)
		{
			ball_x = 450;
			x_speed = -1.1 * x_speed;
		}
	}

}
