<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>


<div class="bg-info row col-md-12 ">
	<div class="col-md-6">
		<h3 class="text-left mt-3">DANH SÁCH</h3>
	</div>
	<div class="col-md-4 mt-2">

		<!-- <input type="text" class="form-control" name="tk">
		<a href="/cam/timkiem">
		<button class="bg-white">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
				fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
               <path
					d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
            </svg>
            Tìm kiếm
		</button>
		</a> -->
		<form class="row" role="search" action="type" method="get">
			<div class="col-md-7">
				<select name="loai" class="form-select">
					<option value="all">All</option>
				    <c:forEach var="loai" items="${loaiCams }">
						<option value="${loai}">${loai}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-5">

				<button class="btn btn-outline-danger" type="submit">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
               <path
							d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
            </svg>
					TÌM KIẾM
				</button>
			</div>
		</form>
	</div>
	<div class="col-md-2 mt-3 ">
		<button class="bg-danger" id="xoasp">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
				fill="currentColor" class="bi bi-dash-circle" viewBox="0 0 16 16">
				<path
					d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
				<path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z" />
			  </svg>
			XOÁ
		</button>
		<a href="/cam/create">
			<button class="bg-success">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
					<path
						d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
					<path
						d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z" />
				  </svg>
				THÊM
			</button>
		</a>
	</div>
</div>
<table class="table table-bordered table-striped border border-dark border=1 mt-3"ng-app="myapp" ng-controller="myController">
	<thead>
		<tr>
		<th scope="col">
        <div>
          <input type="checkbox" ng-model="selectAll">
        </div>
      </th>
		    <th>TÊN</th>
		    <th>LOẠI</th>
		    <th>SỐ LƯỢNG</th>
			<th>TRỌNG LƯỢNG</th>
			<th>HẠN SỬ DỤNG</th>
			<th>HÌNH ẢNH</th>
			<th>GIÁ</th>
			<th colspan="2"><th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${lists.getContent()}" var="c">
			<tr>
			<th scope="row">
       <div>
          <input type="checkbox" name="select" value="${c.id }" ng-checked="selectAll">
        </div>
      </th>
				<td>${c.ten}</td>
				<td>${c.loai}</td>
				<td>${c.soluong}</td>
				<td>${c.trongluong}</td>
				<td><fmt:formatDate value="${c.hansudung}" pattern="dd/MM/yyyy" /></td>
				<td>${c.anh}</td>
				<td>${c.gia}</td>
				<td>
				<a href="/cam/edit?id=${c.id}">
				<button>SỬA</button>
				</a></td>
				<td><a href="/cam/delete?id=${c.id}">
				<button>XOÁ</button>
				</a></td>
			</tr>
		</c:forEach>
	</tbody> 
</table>
   <a href="/cam/create">
	       <button>THÊM</button>
	</a>
<c:if test="${lists.getNumber()>0 }">
	<a href="/cam/index?pageNumber=${lists.getNumber()-1}"><button
			class="btn btn-primary">PRE</button></a>
</c:if>
<label for="">${lists.getNumber() +1}</label>
<c:if test="${lists.getNumber()<lists.getTotalPages()-1 }">
	<a href="/cam/index?pageNumber=${lists.getNumber()+1}"><button
			class="btn btn-primary">NEXT</button></a>
</c:if>
<script>
		var app = angular.module("myapp", []);
		app.controller("myController", function($scope) {
			$scope.selectAll = false;
			$scope.select = function() {
				$scope.selectAll = true;
				console.log($scope.selectAll);
			}
		});
	</script>

