<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.menu.model.vo.Menu"%>

    <%
    ArrayList<Menu> list = (ArrayList<Menu>)request.getAttribute("list");
    int id = Integer.parseInt(request.getParameter("id"));
    Menu d = list.get(id-1);
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>CMS</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="resources/css/styles_detail.css" rel="stylesheet" />
    </head>
    <body>
        <%@ include file="../common/menubar.jsp"%>



        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..." /></div>
                    <div class="col-md-6">
                        <h1 class="display-5 fw-bolder"><%= d.getMenuName() %></h1>
                        <div class="fs-5 mb-5">
                            <span><%= d.getMenuPrice() %>원</span>
                        </div>
                        <p class="lead">뿌링뿌링! 세상에 없던 마법의 맛 뿌링클</p><br>
                        <div class="d-flex">
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                매장 찾기
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Related Chickens</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <% for(Menu m : list) { %>
                        <div class="col mb-5">
                          <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="resources/img/1.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                              <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder"><%= m.getMenuName() %></h5>
                                <!-- Product price-->
                                <%= m.getMenuPrice() %>원
                              </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="<%= contextPath %>/list.mn?
				id=<%= m.getMenuNo() %>">자세히 보기</a></div>
                            </div>
                          </div>
                        </div>
                        <% } %>
                      </div>
                    </div>
                  </section>


                  
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
