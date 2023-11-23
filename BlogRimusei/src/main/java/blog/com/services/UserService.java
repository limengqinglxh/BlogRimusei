package blog.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.UserDao;
import blog.com.models.entity.UserEntity;


@Service
public class UserService {
	@Autowired
	private UserDao adminDao;

//保存处理のメソッド
	//存在していない場合は登録true
	//既にテーブルに入力されたメールが存在指定たら登録しないfalse
	public boolean createAdmin(String name,String email,String password) {
		if(userDao.findByAdminEmail(email)==null) {
			userDao.save(new UserEntity(email,name,password));
			return true;
		}else {
			return false;
		}
	}
	//ログイン处理メソッド
	//もし 入力したEmailとpasswordがテーブル内に存在指定た場合
	//そのログインしている人のテーブルの情報をLoginContorllerに渡してsessionに保存する
	//そうでない場合ログインしている人は存在しない　null
	
	public UserEntity checkLogin(String email,String password) {
		//DBに接続して入力したEmailとpassword変数に保存
		UserEntity adminEntity = userDao.findByAdminEmailAndPassword(email, password);
		if(adminEntity == null) {
			return null;
		}else {
			return adminEntity;
		}
	}
	}


