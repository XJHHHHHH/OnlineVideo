package com.duxing.onlinevideo.dao;

import com.duxing.onlinevideo.entity.Banner;

import java.util.List;

public interface BannerDao {

    int insertBanner(Banner banner);

    List<Banner> findBannerByCondition();
}
