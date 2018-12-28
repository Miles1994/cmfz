package com.cmfz;


import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

import io.goeasy.GoEasy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ssmcmfzApplicationTests {
    @Resource
    private FastFileStorageClient storageClient;

    @Test
    public void testPoi() throws FileNotFoundException {
        File file1 = new File("E:\\cc.jpg");
        File file2 = new File("E:\\bb.jpg");
        File file3 = new File("E:\\aa.jpg");
        File file4 = new File("E:\\aa.jpg");
        File file5 = new File("E:\\aa.jpg");
        File file6 = new File("E:\\aa.jpg");
        FileInputStream inputStream1 = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);
        FileInputStream inputStream3 = new FileInputStream(file3);
        FileInputStream inputStream4 = new FileInputStream(file4);
        FileInputStream inputStream5 = new FileInputStream(file5);
        FileInputStream inputStream6 = new FileInputStream(file6);
        StorePath storePath1 = storageClient.uploadFile(inputStream1,file1.length(), "jpg", null);
        StorePath storePath2 = storageClient.uploadFile(inputStream2,file2.length(), "jpg", null);
        StorePath storePath3 = storageClient.uploadFile(inputStream3,file3.length(), "jpg", null);
        StorePath storePath4 = storageClient.uploadFile(inputStream4,file4.length(), "jpg", null);
        StorePath storePath5 = storageClient.uploadFile(inputStream5,file5.length(), "jpg", null);
        StorePath storePath6 = storageClient.uploadFile(inputStream6,file6.length(), "jpg", null);
        System.out.println(storePath1.getGroup() + "|" + storePath1.getPath());
        System.out.println(storePath2.getGroup() + "|" + storePath2.getPath());
        System.out.println(storePath3.getGroup() + "|" + storePath3.getPath());
        System.out.println(storePath4.getGroup() + "|" + storePath4.getPath());
        System.out.println(storePath5.getGroup() + "|" + storePath5.getPath());
        System.out.println(storePath6.getGroup() + "|" + storePath6.getPath());
    }

    @Test
    public void testGoEasy(){
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io","BC-e7f30516a3d540fbae7de5a03c654ee4");
        goEasy.publish("goEasy","This is GoEasy");
    }
}

