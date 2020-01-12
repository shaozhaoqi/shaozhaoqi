package com.fh.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

public class AliyunOssUtil {
                                           //oss-cn-beijing.aliyuncs.com
    /*private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAI4FdUAaCgoJdMYu6pPvbp";
    private static String accessKeySecret = "qPPA6rwOsObI7a4brxAfL3r9B0w5vW";
    private static String bucketName = "sunss-filestock";*/
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";

    // accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
    // 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
    // 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
    private static String accessKeyId = "LTAI4FtYvfXqMMKtMwuL1vJV";
    private static String accessKeySecret = "NLfdVSpWvxj4uAebtrX5A5C0mxDtFA";

    // Bucket用来管理所存储Object的存储空间，详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
    private static String bucketName = "feihu-1905b";

    public static String uploadOSSFree(MultipartFile  uploadFile, String picturePath) throws IOException {
        //创建OSSClient实列
        OSS  ossClient=new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        //上传picturePath+uploadFile.getOriginalFilename()
         ossClient.putObject(bucketName,picturePath+uploadFile.getOriginalFilename(),new ByteArrayInputStream(uploadFile.getBytes()));
         //关闭client
        ossClient.shutdown();
        //设置过期时间
        Date expiration=new Date(new Date().getTime()+ 3600l * 1000 * 24 * 365 * 10);
        //取出文件上传路径
        String url = ossClient.generatePresignedUrl(bucketName, picturePath + uploadFile.getOriginalFilename(), expiration).toString();
        return url;
    }
}
