package blog.com.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import blog.com.models.entity.BlogEntity;
import blog.com.models.entity.UserEntity;
import blog.com.services.BlogService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	@Autowired
	private BlogService productService;

	@Autowired
	private HttpSession session;

	// 商品の一覧を表示する
	@GetMapping("/product/list")
	public String getProductList(Model model) {
		// セッションからログインしている人の情報を取得
		UserEntity admin = (UserEntity) session.getAttribute("admin");
		if (admin == null) {
			return "redirect:/login";
		} else {
			List<BlogEntity> productList = blogService.selectAll(admin.getAdminId());
			model.addAttribute("productList", productList);
			model.addAttribute("adminName", admin.getAdminName());
			return "product_list.html";

		}

	}

	// 商品登録画面の表示
	@GetMapping("/product/register")
	public String getProductRegisterPage(Model model) {
		UserEntity admin = (UserEntity) session.getAttribute("admin");
		if (admin == null) {
			return "redirect:/login";
		} else {
			model.addAttribute("adminName", admin.getAdminName());
			return "product_register.html";

		}
	}

	// 商品の登録のメソッド
	@PostMapping("/product/register/process")
	public String productRegister(@RequestParam String productName, @RequestParam String productCategory,
			@RequestParam MultipartFile productImage, @RequestParam String productDescription) {

		UserEntity admin = (UserEntity) session.getAttribute("admin");
		if (admin == null) {
			return "redirect:/login";
		} else {
			// ファイルの名前の取得
			/**
			 * 現在の日時情報を元に、ファイル名を作成しています。SimpleDateFormatクラスを使用して、日時のフォーマットを指定している。
			 * 具体的には、"yyyy-MM-dd-HH-mm-ss-"の形式でフォーマットされた文字列を取得している。
			 * その後、blogImageオブジェクトから元のファイル名を取得し、フォーマットされた日時文字列と連結して、fileName変数に代入
			 **/
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
					+ productImage.getOriginalFilename();
			try {
				Files.copy(productImage.getInputStream(), Path.of("src/main/resources/static/product-img/" + fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (productService.createProduct(productCategory, productDescription, fileName, productName)) {
				return "redirect:/product/list";
			} else {
				return "redirect:/product/register";
			}

		}
	}
	@GetMapping("/product/edit/{productId}")
	public String getProductEditPage(@PathVariable Long productId, Model model) {
		UserEntity admin = (UserEntity) session.getAttribute("admin");
		if (admin == null) {
			return "redirect:/login";
		} else {
			// model.addAttribute("adminName", admin.getAdminName());
			BlogEntity productList = productService.getBlogPost(productId);
			if (productList == null) {
				return "redirect:/product/list";
			} else {
				model.addAttribute("productList", productList);
			}
			return "product_edit.html";

		}
	}
	
	//更新処理をするためのメソッド
		@PostMapping("/product/edit/process")
		public String editProcess(@RequestParam Long productId,@RequestParam String productName,
				@RequestParam String productCategory,
				@RequestParam MultipartFile productImage,
				@RequestParam String productDescription) {
			UserEntity admin = (UserEntity) session.getAttribute("admin");
			if (admin == null) {
				return "redirect:/login";
			}else {
				// ファイルの名前の取得
				/**
				 * 現在の日時情報を元に、ファイル名を作成しています。SimpleDateFormatクラスを使用して、日時のフォーマットを指定している。
				 * 具体的には、"yyyy-MM-dd-HH-mm-ss-"の形式でフォーマットされた文字列を取得している。
				 * その後、blogImageオブジェクトから元のファイル名を取得し、フォーマットされた日時文字列と連結して、fileName変数に代入
				 **/
				String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
						+ productImage.getOriginalFilename();
				try {
					Files.copy(productImage.getInputStream(), Path.of("src/main/resources/static/product-img/" + fileName));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (productService.editProduct(productId, productCategory, productDescription, fileName, productName)) {
					return "redirect:/product/list";
				} else {
					return "redirect:/product/edit/"+productId;
				}

			}
			
			
			
			
		}
		
		//削除処理
		@PostMapping("/product/delete")
		public String delete(@RequestParam Long productId) {
			UserEntity admin = (UserEntity) session.getAttribute("admin");
			if (admin == null) {
				return "redirect:/login";
			}else {
				if(productService.deleteProduct(productId)) {
					return "redirect:/product/list";
				}else {
					return "redirect:/product/edit/"+productId;
				}	
			}
			
		}
}
