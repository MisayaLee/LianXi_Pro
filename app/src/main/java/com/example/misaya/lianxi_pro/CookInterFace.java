package com.example.misaya.lianxi_pro;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Misaya on 2018/6/25.
 */

public interface CookInterFace {
    @GET("dish_list.php?stage_id=1&limit=20&page=12")
    Call<CookBean>getData();
}
