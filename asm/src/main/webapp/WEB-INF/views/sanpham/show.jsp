<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${!empty lists}">
	<div class="d-flex p-3 row justify-content-between">
		<c:forEach items="${lists }" var="p">
			<c:if test="${p.soluong > 0}">
				<div class="col-xl-3 col-lg-3 col-sm-4">
					<div class="card">
						<div class="m-4">
							<img src="/anhcam/${p.anh }" height="232px" width="157px"
								class="card-img-top" alt="...">
						</div>
						<hr>
						<div class="card-body" style="height: 220px">
							<h5 class="card-title">${p.ten }</h5>
							<p class="card-text text-warning">
								<c:choose>
									<c:when test="${p.gia<=150000 }">
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star text-dark"></i>
									</c:when>
									<c:when test="${p.gia>=200000 }">
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
									</c:when>
									<c:otherwise>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star"></i>
										<i class="fa-solid fa-star-half-stroke"></i>
									</c:otherwise>
								</c:choose>
							</p>
							<p class="card-text">
								SỐ HÀNG CÒN LẠI:
								<fmt:setLocale value="en_US" />
								<fmt:formatNumber value="${p.soluong}" />
							</p>
							<p class="card-text fw-bold">
								GIÁ:
								<fmt:setLocale value="en_US" />
								<fmt:formatNumber value="${p.gia}" />
								đ
							</p>
						</div>
						<div class="card-footer">
							<p class="card-text d-flex justify-content-between">
								<%-- <c:if test="${empty user }">
								<a href="/login">
									<button class="btn btn-outline-success">MUA HÀNG</button>
								</a>
							</c:if> --%>

								<a class="btn btn-outline-success" href="/add-to-cart/${p.id}">MUA
									HÀNG</a>

								<button class="btn btn-outline-primary ms-2">XEM CHI
									TIẾT</button>
							</p>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
</c:if>
<c:if test="${empty lists}">
	<h2 class="mt-3">SẢN PHẨM TRỐNG</h2>
	<a href="/cam/index"><button class="btn btn-dark">TRỞ VỀ
			TRANG CHỦ</button></a>
</c:if>