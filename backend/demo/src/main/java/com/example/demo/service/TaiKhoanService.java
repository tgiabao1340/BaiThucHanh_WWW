package com.example.demo.service;

import com.example.demo.model.TaiKhoan;

public interface TaiKhoanService {
	boolean save(TaiKhoan taikhoan);

    TaiKhoan findByTen(String ten);
}
