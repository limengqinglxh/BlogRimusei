package blog.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.BlogDao;
import blog.com.models.entity.BlogEntity;
@Service
public class BlogService {
	@Autowired
	private BlogDao productDao;

//商品一覧の部分のメソッド
//ログインしている人のadminId=null
//null
//productDao.findAll();
	public List<BlogEntity> selectAll(Long adminId) {
		if (adminId == null) {
			return null;
		} else {
			return productDao.findAll();
		}
	}
	
	//商品登録のメソッド
	//商品の名前がテーブルに存在しない場合
	//商品の登録処理
	//true
	//false
	
	public boolean createProduct(String category,String description,String image,String name) {
		if(productDao.findByProductName(name)==null) {
			productDao.save(new BlogEntity(category,description,image,name));
			return true;
		}else {
			return false;
		}
	}
	
	//编集する情報を表示
	public BlogEntity getProductPost(Long productId) {
		if(productId == null) {
			return null;
		}else {
			return productDao.findByProductId(productId);
		}
	}
	//編集した内容を保存するメソッド
		//product_id == null false
		//更新処理をして、true
		public boolean editProduct(Long productId,String productCategory,
				String productDescription,String productImage,String productName) {
			if(productId == null) {
				return false;
			}else {
				//更新処理
				productDao.save(new BlogEntity(productId,productCategory,productDescription,productImage,productName));
			    return true;
			}
		}
		
		//削除するメソッド
		//productId == null false
		//削除処理 true
		public boolean deleteProduct(Long productId) {
			if(productId == null) {
				return false;
			}else {
				productDao.deleteByProductId(productId);
				return true;
			}
		}



}
