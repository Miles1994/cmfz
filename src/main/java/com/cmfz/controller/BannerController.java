package com.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.cmfz.entity.Banner;
import com.cmfz.entity.PageDto;
import com.cmfz.service.BannerService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Administrator
 * @Title: BannerController
 * @ProjectName demo
 * @Date 2018-12-20--14:41
 */
@RestController
@RequestMapping("/ban")
public class BannerController {
    @Resource
    private BannerService bannerService;

    //分页显示数据

    @RequestMapping("queryByPage")
    @ResponseBody
    public PageDto queryByPage(Integer page, Integer rows) {
        PageDto pageDto = bannerService.queryByPage(page, rows);
        return pageDto;
    }


    //修改

    @RequestMapping("update")
    public String update(Banner banner) {
        bannerService.update(banner);
        return "";
    }

    //删除

    @RequestMapping("delete")
    public String delete(Banner banner) {
        bannerService.delete(banner);
        return "";
    }

    //添加

    @RequestMapping("add")
    public String add(Banner banner, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        banner.setImg_path(fileName);
        banner.setStatus("N");
        bannerService.add(banner);
        // 文件上传后的路径
        String filePath = "E:\\MyIdeaProject\\ssmcmfz\\src\\main\\webapp\\image";
        File dest = new File(filePath + "/" + fileName);
        file.transferTo(dest);
        return "";
    }

    //导出数据

    @RequestMapping("export")
    public void export(HttpServletResponse response, HttpSession session) {
        List<Banner> banners = bannerService.queryAll();
        String realPath = session.getServletContext().getRealPath("/image");
        for (Banner banner : banners) {
            //将下载路径设置为绝对路径
            String img_path = banner.getImg_path();
            banner.setImg_path(realPath + "/" + img_path);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("轮播图详情", "轮播图"),
                Banner.class, banners);
        try {
            String name = URLEncoder.encode("轮播图.xls", "UTF-8");
            //设置响应头
            response.setHeader("content-disposition", "attachment;filename=" + name);
            //设置响应类型
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
