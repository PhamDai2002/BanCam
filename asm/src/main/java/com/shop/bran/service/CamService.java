package com.shop.bran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.bran.entity.Cam;
import com.shop.bran.entity.CamType;
import com.shop.bran.repsitory.ICamRepository;

@Service
public class CamService {
@Autowired
 private ICamRepository rep;

public CamService(ICamRepository rep) {
	super();
	this.rep = rep;
}
 
 public  Page<Cam> getPage(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber, 5);
		return rep.findAll(pageable);
 }
 public Cam create(Cam c) {
		try {
			return rep.save(c);
		} catch (Exception e) {
			throw e;
		}
	}
	public Cam update(Cam c) {
		try {
			return rep.save(c);
		} catch (Exception e) {
			throw e;
		}
	}
	public void delete(Integer id) {
		try {
			rep.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}
	public Cam findById(Integer id) {
		try {
			 return rep.findById(id).get();
		} catch (Exception e) {
			throw  e;
		}
	}
	public Page<Cam> getByType(CamType loai,int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, 5);
		return rep.findCamByCamType(loai, pageable);
	}
	public void deleteList(List<Integer> integers) {
		List<Cam> cam = rep.findAllById(integers);
		rep.deleteAllByIdInBatch(integers);
	}
	public List<Cam> getAll() {
		return rep.findAll();
	}
	public Cam getOneCamById(Integer id) {
		return rep.getById(id);
	}
 }

