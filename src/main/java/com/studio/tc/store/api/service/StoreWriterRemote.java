package com.studio.tc.store.api.service;

import com.studio.tc.store.api.bean.ApiQuery;
import com.studio.tc.store.api.bean.ApiResponse;

import java.util.List;

/**
 * Created by chuanqiao.wu on 2015/3/4.
 */
public interface StoreWriterRemote<T> {

    ApiResponse<List<T>> create(String apiId, List<T> value);

    ApiResponse<List<T>> delete(String apiId, ApiQuery query);

    ApiResponse<List<T>> modify(String apiId, ApiQuery query, T value);
}
