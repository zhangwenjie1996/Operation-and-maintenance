package ig.zeus.data;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016-12-05.
 */
public class UploadFile {
    /**
     * 多文件文件上传
     * upfile 前台文件流
     * path 文件路径   如 file/test/test
     * 返回值: 若多个文件则多个文件名字  存库是使用path+/filename
     */
    public static List<String> upload(CommonsMultipartFile[] upfiles, String path) {
        List<String> fileNames = new ArrayList<>();
        OutputStream os = null;
        InputStream is = null;
        try {
            String basePath = UploadFile.class.getClassLoader().getResource("/").toString();
            //开发路径   file:/D:/idea_workspace/work/Zeus/src/zeus.web/target/web/WEB-INF/classes/
            //发布路径  file:/D:/idea_workspace/apache-tomcat-7.0.70/webapps/ROOT/WEB-INF/classes/
            basePath = basePath.substring(6, basePath.length());
            File file = new File(basePath);
            basePath = file.getParentFile().getParentFile().getParentFile().getParent();
            String newPath;
            if (path.startsWith("/") || path.startsWith("\\")) {
                newPath = basePath + path;
            } else {
                newPath = basePath + "/" + path;
            }
            File file2 = new File(newPath);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            for (CommonsMultipartFile upfile : upfiles) {
                String oldName = upfile.getOriginalFilename();
                String fileType = oldName.substring(oldName.lastIndexOf("."), oldName.length());
                String newName = UUID.randomUUID().toString().replace("-", "");
                os = new FileOutputStream(newPath + newName + fileType);
                fileNames.add(oldName + "_" + path+newName + fileType);
                is = upfile.getInputStream();
                int temp;
                while ((temp = is.read()) != (-1)) {
                    os.write(temp);
                }
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileNames;
    }
//newName 自定义path+新名字
    public static InputStream downLoad(String path) {
        InputStream is = null;
        String basePath = UploadFile.class.getClassLoader().getResource("/").toString();
        //开发路径   file:/D:/idea_workspace/work/Zeus/src/zeus.web/target/web/WEB-INF/classes/
        //发布路径  file:/D:/idea_workspace/apache-tomcat-7.0.70/webapps/ROOT/WEB-INF/classes/
        basePath = basePath.substring(6, basePath.length());
        File file=new File(basePath);
        basePath = file.getParentFile().getParentFile().getParentFile().getParent();
        String newPath = basePath + path;
        if (newPath.startsWith("/") || path.startsWith("\\")) {
            newPath = basePath + path;
        } else {
            newPath = basePath + "/" + path;
        }
        try {
            is = new FileInputStream(newPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }
}
