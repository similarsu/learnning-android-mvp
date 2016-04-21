package cn.st.android.mvp.model;

import android.util.Log;

import cn.st.android.mvp.entity.User;

/**
 * Created by coolearth on 2016/4/21.
 */
public class UserModel implements IUserModel{
    @Override
    public void save(User user) {
        Log.i("UserModel","保存数据");
    }
}
