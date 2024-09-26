package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.domain.Movie;
import com.jpa.repo.MovieDAO;

@Service
public class MovieService {
	
	@Autowired
	private MovieDAO dao;
	
	public void change(Movie vo) {
		dao.save(vo); // save메서드 : id가 없다 - 추가, id가 있다 - 수정 (save메서드는 추가,수정 모두 가능)
	}
	
	public List<Movie> viewAll(){
		return dao.findAll();
	}
	
	public Movie view(int id) {
		return dao.findById(id).orElse(null);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
}
