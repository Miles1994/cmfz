package com.cmfz;


import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

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
        File file = new File("E:\\aa.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        StorePath storePath = storageClient.uploadFile(inputStream,
                file.length(), "jpg", null);
        System.out.println(storePath.getGroup() + "|" + storePath.getPath());
    }
}

