package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.SanPham;

public interface SanPhamRepository extends CrudRepository<SanPham, String> {

}
