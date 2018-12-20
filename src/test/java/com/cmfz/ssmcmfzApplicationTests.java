package com.cmfz;

import com.cmfz.entity.PageDto;
import com.cmfz.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ssmcmfzApplicationTests {
    @Resource
    BannerService bannerService;
    @Test
    public void contextLoads() {
        PageDto pageDto = bannerService.queryByPage(1, 3);
        System.out.println(pageDto);
    }

}

