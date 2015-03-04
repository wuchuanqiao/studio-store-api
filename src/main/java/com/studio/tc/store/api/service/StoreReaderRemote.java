package com.studio.tc.store.api.service;

import com.studio.tc.store.api.bean.ApiQuery;
import com.studio.tc.store.api.bean.ApiResponse;

import java.util.List;

/**
 * Created by chuanqiao.wu on 2015/3/4.
 */
public interface StoreReaderRemote<T> {
    ApiResponse<List<T>> query(String appId, ApiQuery query);

    ApiResponse<Integer> count(String appId, ApiQuery query);
}
