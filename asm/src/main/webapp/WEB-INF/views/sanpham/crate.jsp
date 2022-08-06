<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<form action="/cam/store" method="post">
	<div class="mt-3">
		<label for="">TÊN</label>
		<input type="text" class="form-control" name="ten">
	</div>
	<div class="mt-3">
		<label for="">LOẠI</label>
		<select name="loai" id="" class="form-select">
		<option value="Ga">Gà</option>
		<option value="Lon">Lợn</option>
		<option value="Ca">Cá</option>
		<option value="Chim">Chim</option>
		<option value="Bo">Bò</option>
		</select>
	</div>
	<div class="mt-3">
		<label for="">SỐ LƯỢNG</label>
		<input type="text" class="form-control" name="soluong">
	</div>
	<div class="mt-3">
		<label for="">TRỌNG LƯỢNG</label>
		<input type="text" class="form-control" name="trongluong">
	</div>
	<div class="mt-3">
		<label for="">HẠN SỬ DỤNG</label>
		<input type="text" class="form-control" name="hansudung">
	</div>
	<div class="mt-3">
		<label for="">HÌNH ẢNH</label>
		<input type="file" class="form-control" name="anh">
	</div>
	<div class="mt-3">
            <label for="">GIÁ</label>
            <input type="text" class="form-control" name="gia">
        </div>
	<div class="mt-3">
             <div class="row col-md-12">
                <div class="col-md-11">
                    <button type="submit" class="btn btn-primary">THÊM</button>
                    <button type="reset" class="btn btn-secondary">RESET</button>
                </div>
                <div class="col-md-1">
                    <button type="button" class="btn btn-light" >
                        <a href="/cam/index" class="text-dark">BACK</a>
                    </button>
                </div>
             </div>
        </div>
</form>