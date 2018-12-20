package com.cmfz.service;

import com.cmfz.entity.Banner;
import com.cmfz.entity.PageDto;
import com.cmfz.mapper.BannerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @Title: BannerServiceImpl
 * @ProjectName demo
 * @Date 2018-12-20--14:40
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    //分页查询

    @Override
    public PageDto queryByPage(Integer curPage, Integer pageSize) {
        PageDto pd = new PageDto();
        pd.setTotal(bannerMapper.totalCount());
        pd.setRows(bannerMapper.queryByPage(curPage, pageSize));
        return pd;
    }

    //修改

    @Override
    public void update(Banner banner) {
        Banner banner2 = new Banner();
        banner2.setStatus(banner.getStatus());
        banner2.setId(banner.getId());
        bannerMapper.updateByPrimaryKeySelective(banner2);
    }

    //删除

    @Override
    public void delete(Banner banner) {
        Banner banner1 = new Banner();
        banner1.setId(banner.getId());
        bannerMapper.deleteByPrimaryKey(banner1);
    }

    //添加

    @Override
    public void add(Banner banner) {

        bannerMapper.insertSelective(banner);
    }
}
