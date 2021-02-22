package ua.lviv.lgs.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private static ProductServiceImpl productServiceImpl;
	private ProductDao productDao;

	private ProductServiceImpl() {
		
			productDao = new ProductDaoImpl();
		
	}

	public static ProductService getProductService() {
		if (productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}
		return productServiceImpl;
	}

	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product readById(Integer id) {

		return productDao.readById(id);
	}

	@Override
	public Product update(Integer id, Product product) {
		return productDao.update(id, product);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);

	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	@Override
	public Map<Integer, Product> readAllMap() {
		return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
	}

}
