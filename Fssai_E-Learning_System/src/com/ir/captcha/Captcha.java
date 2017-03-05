package com.ir.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
* Servlet implementation class Captcha
*/
public class Captcha extends HttpServlet {
                private static final long serialVersionUID = 1L;
 
                private int height = 45;
                private int width = 140;
                public static final String CAPTCHA_KEY = "pms_captcha_key";
 
                /**
                * @see HttpServlet#HttpServlet()
                */
                public Captcha() {
                                super();
                                // TODO Auto-generated constructor stub
                }
 
                /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
                *      response)
                */
                protected void doGet(HttpServletRequest request,
                                                HttpServletResponse response) throws ServletException, IOException {
                                // Expire response
                                response.setHeader("Cache-Control", "no-cache");
                                response.setDateHeader("Expires", 0);
                                response.setHeader("Pragma", "no-cache");
                                response.setDateHeader("Max-Age", 0);
                                BufferedImage image = new BufferedImage(width, height,
                                                                BufferedImage.TYPE_INT_RGB);
                               
                                Graphics2D graphics2D = image.createGraphics();
                                graphics2D.setColor(new Color(0.8667f, 0.8667f, 0.8667f));
                                graphics2D.fillRect(0, 0, width, height);
                                //graphics2D.setComposite(AlphaComposite.SrcOver);
                               
                                //graphics2D.setBackground(Color.CYAN);
                                //Hashtable map = new Hashtable();
                                Random r = new Random();
                                String token = Long.toString(Math.abs(r.nextLong()), 36);
                                String ch = token.substring(0, 5);
                                Color c1 = new Color(0.6662f, 0.1111f, 0.2134f);
                                Color c2 = new Color(0.1662f, 0.4569f, 0.8232f);
                                GradientPaint gp = new GradientPaint(30, 30, c1, 15, 25, c2,
                                                                true);
                                graphics2D.setPaint(gp);
                                Font font = new Font("Comic Sans Serif", Font.CENTER_BASELINE, 26);
                                graphics2D.setFont(font);
                                graphics2D.drawString(ch, 15, 25);
                                //graphics2D.setColor(Color.DARK_GRAY);
                                graphics2D.dispose();
                                HttpSession session = request.getSession(true);
                                session.setAttribute(CAPTCHA_KEY, ch);
                               
                                OutputStream outputStream = response.getOutputStream();
                               
                                ImageIO.write(image, "jpeg", outputStream);
                                outputStream.close();
                                System.out.println(session.getAttribute(CAPTCHA_KEY));
                }
}
