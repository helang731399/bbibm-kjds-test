package com.bbibm.memo.util;

import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.stereotype.Component;
import org.xmlpull.v1.XmlPullParserException;
import sun.net.www.content.image.png;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class FileUpdate {

    public void get(String filePath) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidArgumentException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException, RegionConflictException {
        try {
            MinioClient minioClient = new MinioClient("http://127.0.0.1:9000", "minioadmin", "minioadmin");
            boolean bool=minioClient.bucketExists("memo");
            if(!bool)
            {
                System.out.println("新建bucket成功！");
                minioClient.makeBucket("memo");
            }
            minioClient.putObject("memo","MemoPicture",filePath);
            System.out.printf("上传Minio成功！");
        } catch (InvalidEndpointException e) {
            e.printStackTrace();
        } catch (InvalidPortException e) {
            e.printStackTrace();
        }
    }
}
