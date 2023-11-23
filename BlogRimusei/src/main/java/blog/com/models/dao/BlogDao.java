package blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.BlogEntity;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface BlogDao extends JpaRepository<BlogEntity, Long> {
//保存処理　save
	BlogEntity save(BlogEntity productEntity);
	//商品一覧の情報取得　SELECT * FROM products
	List<BlogEntity>findAll();
	//1行だけの取得
	//SELECT * FROM product WHERE product_id=?
	BlogEntity findByProductId(Long productId);
	//1行だけの取得
		//SELECT * FROM product WHERE product_Name=?
	BlogEntity findByProductName(String productName);
	//削除のメソッド　productId
	int deleteByProductId(Long productId);
	
}
