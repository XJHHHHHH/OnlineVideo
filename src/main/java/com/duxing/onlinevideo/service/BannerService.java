package com.duxing.onlinevideo.service;

import com.duxing.onlinevideo.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> findBannerByCondition();
}
