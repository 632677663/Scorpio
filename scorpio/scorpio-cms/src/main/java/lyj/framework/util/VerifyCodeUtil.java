package lyj.framework.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import org.apache.log4j.Logger;

/**
 * 
 * @ClassName: VerifyCodeUtil
 * @Description: 验证码工具类
 * @author lyj
 * @date 2017年6月23日 下午2:35:05
 */
public class VerifyCodeUtil {
    
    private static Logger logger = Logger.getLogger(VerifyCodeUtil.class);

    private Random random = new Random();
    // 随机产生的字符串
    private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // 图片宽
    private int width = 85;
    // 图片高
    private int height = 26;
    // 干扰线数量
    private int lineSize = 10;
    // 随机产生字符数量
    private int stringNum = 4;
    // 字体大小
    private int fontSize = 18;
    // 颜色最大取值
    private static int MAX_COLOR_NUMBER = 255;
    // 颜色最小取值
    private static int MIN_COLOR_NUMBER = 50;
    // 第一个字符的x轴位置
    private int FIRST_STRING_POSITION = 13;
    // 字符的y轴位置
    private int STRING_Y_POSITION = 16;

    /**
     * 获得随机颜色
     * 
     * @return 随机颜色
     */
    private Color getRandColor() {

        int r = MIN_COLOR_NUMBER + random.nextInt(MAX_COLOR_NUMBER - MIN_COLOR_NUMBER);

        int g = MIN_COLOR_NUMBER + random.nextInt(MAX_COLOR_NUMBER - MIN_COLOR_NUMBER);

        int b = MIN_COLOR_NUMBER + random.nextInt(MAX_COLOR_NUMBER - MIN_COLOR_NUMBER);

        return new Color(r, g, b);
    }

    /**
     * 绘制干扰线
     * 
     * @param g
     *            画笔
     */
    private void drowLine(Graphics g) {

        int x1 = random.nextInt(width);

        int y1 = random.nextInt(height);

        int x2 = random.nextInt(width / 2);

        int y2 = random.nextInt(height / 2);

        g.drawLine(x1, y1, x2, y2);

    }

    /**
     * 绘制验证码
     * 
     * @param g
     *            画笔
     * @return 验证码字符串
     */
    private String drowString(Graphics g) {

        StringBuffer buff = new StringBuffer();

        for (int i = 0; i < stringNum; i++) {
            
            g.setFont(new Font("Arial", Font.PLAIN, fontSize));
            
            String str = getRandomString();

            buff.append(str);

            g.setColor(getRandColor());

            g.drawString(str, FIRST_STRING_POSITION * i, STRING_Y_POSITION);

        }
        return buff.toString();
    }

    /**
     * 获取随机字符
     * 
     * @return 随机字符
     */
    private String getRandomString() {

        int n = random.nextInt(randString.length());

        return String.valueOf(randString.charAt(n));

    }

    /**
     * 获取字体
     * 
     * @return
     */
    private Font getFont() {

        return new Font("new font", Font.ROMAN_BASELINE, fontSize);

    }

    public void getRandCode(HttpServletRequest request, HttpServletResponse response, String key) {
        
        logger.info("===验证码生成开始===");
        
        // 图片缓存区
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        // 画笔
        Graphics g = image.getGraphics();
        // 填充范围从(0,0)到(width,height)的矩形
        g.fillRect(0, 0, width, height);
        // 设置字体
        g.setFont(getFont());
        logger.info("===绘制干扰线===");
        // 绘制干扰线
        for (int i = 0; i < lineSize; i++) {
            // 设置颜色
            g.setColor(getRandColor());
            drowLine(g);
        }
        // 绘制字符,返回验证码
        String randomCode = drowString(g);
        // 绑定验证码到session
        request.getSession().setAttribute(key, randomCode);

        g.dispose();

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            ImageIO.write(image, "png", out);

            out.close();

            response.setHeader("content-length", out.size() + "");

            response.getOutputStream().write(out.toByteArray());
            
            logger.info("===验证码生成完成===");
            
        } catch (IOException e) {

            logger.error("===验证码生成异常===",e);

        } finally {
            try {
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (Exception e) {
                logger.error("===关闭response流失败===",e);
            }

        }

    }

}
