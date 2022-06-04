package com.hr.Servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserNumServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		int width=120;
		int height=60;
		BufferedImage img=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g=img.createGraphics();
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.YELLOW);
		Random rand=new Random();
		for (int i = 0; i < 15; i++) {
			int x1=rand.nextInt(width);
			int y1=rand.nextInt(width);
			int x2=rand.nextInt(width);
			int y2=rand.nextInt(width);
			g.drawLine(x1, y1, x2, y2);
		}
		
		Font f=new Font("Times New Roman",Font.BOLD,50);
		g.setFont(f);
		int red=0,green=0,blue=0;
		String code="";
		
		for (int i = 0; i < 4; i++) {
			red=rand.nextInt(255);
			green=rand.nextInt(255);
			blue=rand.nextInt(255);
			
			Color c=new Color(red,green,blue);
			g.setColor(c);
			int num=rand.nextInt(10);
			code+=num;
			g.drawString(num+"", i*20+20, 49);
		}
		
		HttpSession session=req.getSession();
		session.setAttribute("syscode", code);
		
		ServletOutputStream out=resp.getOutputStream();
		ImageIO.write(img, "jpg", out);
		
		
	}
}
