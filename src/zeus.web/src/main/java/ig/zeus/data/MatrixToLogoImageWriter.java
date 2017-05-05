package ig.zeus.data;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.Random;
import java.util.UUID;

/**
 * 生成二维码
 * 解析二维码
 * Created by wxf on 2016-11-23.
 */
public class MatrixToLogoImageWriter {
    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static  int QRCODE_SIZE = 256;
    // LOGO宽度
    private static final int WIDTH = 60;
    // LOGO高度
    private static final int HEIGHT = 60;

    private static BufferedImage createImage(String content, String imgPath,
                                             boolean needCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height+50,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = height; y < height+50; y++) {
                image.setRGB(x, y, 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
        MatrixToLogoImageWriter.insertImage(image, imgPath, needCompress);
        return image;
    }

    /**
     * 插入LOGO
     *
     * @param source
     *            二维码图片
     * @param imgPath
     *            LOGO图片地址
     * @param needCompress
     *            是否压缩
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String imgPath,
                                    boolean needCompress) throws Exception {
        File file = new File(imgPath);
        if (!file.exists()) {
            System.err.println(""+imgPath+"   该文件不存在！");
            return;
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param imgPath
     *            LOGO地址
     * @param destPath
     *            存放目录
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath,
                              boolean needCompress) throws Exception {
        BufferedImage image = MatrixToLogoImageWriter.createImage(content, imgPath,
                needCompress);
        mkdirs(destPath);
        String file = new Random().nextInt(99999999)+".jpg";
        ImageIO.write(image, FORMAT_NAME, new File(destPath+"/"+file));
    }

    public static void encodeText(String content,String[] strs,String destPath,int fontStyle,Color color,int fontSize ,String fileName) throws Exception{
        BufferedImage image = MatrixToLogoImageWriter.createImage(content, null,false);
        mkdirs(destPath);
        if(fileName==null||"".equals(fileName)){
            fileName= UUID.randomUUID().toString();
        }
        //String file = new Random().nextInt(99999999)+".jpg";
        ImageIO.write(image, FORMAT_NAME, new File(destPath + "/" + fileName+".jpg"));
        pressText(strs,new File(destPath + "/" + fileName+".jpg"),fontStyle,color,fontSize);
    }
    /**
     * 给二维码图片加上文字
     * @param pressTexts 文字数组
     * @param qrFile  二维码文件
     * @param fontStyle
     * @param color
     * @param fontSize
     */
    public static void pressText(String [] pressTexts, File qrFile, int fontStyle, Color color, int fontSize) throws Exception {
        Image src = ImageIO.read(qrFile);
        int imageW = src.getWidth(null);
        int imageH = src.getHeight(null);
        BufferedImage image = new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        g.drawImage(src, 0, 0, imageW, imageH, null);
        //设置画笔的颜色
        g.setColor(color);
        //设置字体
        Font font = new Font("宋体", fontStyle, fontSize);
        //FontMetrics metrics = g.getFontMetrics(font);
        for(String s:pressTexts){
            s = new String(s.getBytes(),"utf-8");
            int startX=10;
            QRCODE_SIZE +=fontSize;
            int startY=QRCODE_SIZE;
            g.setFont(font);
            g.drawString(s, startX, startY);
        }
        g.dispose();
        FileOutputStream out = new FileOutputStream(qrFile);
        ImageIO.write(image, "JPEG", out);
        out.close();
    }
    /**
     * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
     * @author lanyuan
     * Email: mmm333zzz520@163.com
     * @date 2013-12-11 上午10:16:36
     * @param destPath 存放目录
     */
    public static void mkdirs(String destPath) {
        File file =new File(destPath);
        //当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param imgPath
     *            LOGO地址
     * @param destPath
     *            存储地址
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath)
            throws Exception {
        MatrixToLogoImageWriter.encode(content, imgPath, destPath, false);
    }

    /**
     * 生成二维码
     *
     * @param content
     *            内容
     * @param destPath
     *            存储地址
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String destPath,
                              boolean needCompress) throws Exception {
        MatrixToLogoImageWriter.encode(content, null, destPath, needCompress);
    }

    /**
     * 生成二维码
     *
     * @param content
     *            内容
     * @param destPath
     *            存储地址
     * @throws Exception
     */
    public static void encode(String content, String destPath) throws Exception {
        MatrixToLogoImageWriter.encode(content, null, destPath, false);
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param imgPath
     *            LOGO地址
     * @param output
     *            输出流
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String imgPath,
                              ByteArrayOutputStream output, boolean needCompress) throws Exception {
        BufferedImage image = MatrixToLogoImageWriter.createImage(content, imgPath,
                needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }

    /**
     * 生成二维码
     *
     * @param content
     *            内容
     * @param output
     *            输出流
     * @throws Exception
     */
    public static void encode(String content, ByteArrayOutputStream output)
            throws Exception {
        MatrixToLogoImageWriter.encode(content, null, output, false);
    }

    /**
     * 解析二维码
     *
     * @param file
     *            二维码图片
     * @return
     * @throws Exception
     */
    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
                image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    /**
     * 解析二维码
     *
     * @param path
     *            二维码图片地址
     * @return
     * @throws Exception
     */
    public static String decode(String path) throws Exception {
        return MatrixToLogoImageWriter.decode(new File(path));
    }
}
