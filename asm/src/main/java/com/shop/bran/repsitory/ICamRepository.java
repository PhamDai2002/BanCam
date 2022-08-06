package com.shop.bran.repsitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.bran.entity.Cam;
import com.shop.bran.entity.CamType;

public interface ICamRepository extends JpaRepository<Cam, Integer>{
	
	@Query("select dp from Cam dp where dp.loai =:name")
	public Page<Cam> findCamByCamType(@Param("name") CamType loai,Pageable pageable);

	@Query("select dp from Cam dp where dp.ten like %:name%")
	public List<Cam> findCamByTenLike(@Param("name")String name);
}
