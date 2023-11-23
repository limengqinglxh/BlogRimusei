package blog.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
//保存处理 save
	UserEntity save(UserEntity adminEntity);
	//1行だけしかレコードは取得することができない
	//SELECT * FROM admin WHERE admin_email=?
	UserEntity findByAdminEmail(String adminEmail);
	//1行だけしかレコードは取得することができない
	//SELECT * FROM admin WHERE admin_email=?And password = ?
	UserEntity findByAdminEmailAndPassword(String adminEmail,String password);
}
