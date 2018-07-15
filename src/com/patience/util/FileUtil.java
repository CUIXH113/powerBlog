package com.patience.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 文件工具类
 * @author Administrator
 *
 */
public class FileUtil {

    public static final Log logger = LogFactory.getLog(FileUtil.class);
 
    /**
     * 删除文件 通过 文件类型和名字
     * @param fileStyle
     * @param fileName
     */
    public static void deleteFile(String pathStr) {
         
        Path path = Paths.get(pathStr);
        try {
            Files.delete(path);
            logger.info(String.format("成功删除文件， 文件信息：%s", pathStr));
        } catch (IOException e) {
            logger.error(String.format("删除文件失败：文件信息：%s", pathStr));
            e.printStackTrace();
        }
    }
    /**
     * 移动文件到新目录，如果存在同名的则替换
     * @param sourcePathStr
     * @param togetPathStr
     * @param fileName
     */
    public static void moveFileToAnotherDirectory(String sourcePathStr, String togetPathStr, String fileName) {
        Path sourcePath = Paths.get(sourcePathStr);
        Path togetPath = Paths.get(togetPathStr);
        
        try {
            Files.move(sourcePath, togetPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            logger.info(String.format("成功移动文件， 源目录：%s；目标目录%s", sourcePathStr, togetPathStr));
        } catch (IOException e) {
            logger.error(String.format("移动文件失败， 源目录：%s；目标目录%s", sourcePathStr, togetPathStr));
            e.printStackTrace();
        }
    }
    /**
     * 更改文件名
     * @param filePathStr
     * @param newName
     */
    public static void renameFile(String filePathStr, String newName) {
        Path filePath = Paths.get(filePathStr);
        try {
            Files.move(filePath, filePath.resolveSibling(newName));
            logger.info(String.format("更改文件成功， 文件路径:%s, 新名字：%s", filePathStr, newName));
        } catch (IOException e) {
            logger.error(String.format("更改文件失败， 文件路径:%s, 新名字：%s", filePathStr, newName));
            e.printStackTrace();
        }
    }
}
