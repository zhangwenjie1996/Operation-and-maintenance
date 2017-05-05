package ig.archer;

import java.awt.Color;

import ig.zeus.data.MatrixToLogoImageWriter;
import junit.framework.TestCase;

/**
 * Created by Administrator on 2016-11-23.
 */
public class ZXingTest extends TestCase {

    public void test01() throws Exception{
        //MatrixToLogoImageWriter.encode("http://www.baidu.com","F:\\ss");
//        String ss = MatrixToLogoImageWriter.decode(new File("F:\\ss\\69956712.jpg"));
//        System.out.println(ss+"=======================");
        String [] strs = {"百度:123","谷歌:123"};
        MatrixToLogoImageWriter.encodeText("你好",strs,"E:",6, Color.BLACK, 18,"");
    }
}
