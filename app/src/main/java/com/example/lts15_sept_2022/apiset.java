package com.example.lts15_sept_2022;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiset
{
    @FormUrlEncoded
    @POST("login_maker.php")
    Call<responsemodel> verifyuser(
                @Field("e_mail") String email ,
                @Field("pass") String password
                )  ;
}
