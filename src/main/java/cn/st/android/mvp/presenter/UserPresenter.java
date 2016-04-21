package cn.st.android.mvp.presenter;

import cn.st.android.mvp.entity.User;
import cn.st.android.mvp.model.IUserModel;
import cn.st.android.mvp.model.UserModel;
import cn.st.android.mvp.view.IUserView;

/**
 * Created by coolearth on 2016/4/21.
 */
public class UserPresenter {
    private IUserView userView;
    private IUserModel userModel;

    public UserPresenter(IUserView userView){
        this.userView=userView;
        this.userModel=new UserModel();
    }

    public void saveUser(User user){
        userModel.save(user);
    }
}
