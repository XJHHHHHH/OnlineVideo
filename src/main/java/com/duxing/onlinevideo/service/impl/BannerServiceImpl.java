package com.duxing.onlinevideo.service.impl;

import com.duxing.onlinevideo.dao.BannerDao;
import com.duxing.onlinevideo.entity.Banner;
import com.duxing.onlinevideo.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerDao bannerDao;

    @Override
    public List<Banner> findBannerByCondition() {
        return bannerDao.findBannerByCondition();
    }
}
