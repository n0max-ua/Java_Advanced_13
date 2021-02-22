package ua.lviv.lgs.service.impl;

import java.util.List;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.dao.impl.BucketDaoImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;

public class BucketServiceImpl implements BucketService {
	
	private static BucketServiceImpl bucketServiceImpl;
	private BucketDao bucketDao;

	private BucketServiceImpl() {
		
			bucketDao = new BucketDaoImpl();
		

	}

	public static BucketService getBucketService() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}
		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket bucket) {
		return bucketDao.create(bucket);
	}

	@Override
	public Bucket readById(Integer id) {
		return bucketDao.readById(id);
	}

	@Override
	public Bucket update(Integer id, Bucket bucket) {
		return bucketDao.update(id, bucket);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);

	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}
