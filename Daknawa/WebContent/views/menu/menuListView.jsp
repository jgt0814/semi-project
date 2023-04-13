<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.menu.model.vo.Menu"%>

  <%
      ArrayList<Menu> list = (ArrayList<Menu>)request.getAttribute("list");
  
  %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>CMS</title>
    
    <!-- swiper.js 라이브러리추가 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/5.4.5/css/swiper.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/5.4.5/js/swiper.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/7.4.0/swiper-bundle.min.css" />
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="resources/css/styles.css" rel="stylesheet" />
  </head>
  <body>
    <%@ include file="../common/menubar.jsp"%>
    <div id="content_1">
      <!-- Slider main container -->
      <div class="swiper">
        <!-- Additional required wrapper -->
        <div class="swiper-wrapper">
          <!-- Slides -->
          <div class="swiper-slide"><img src="resources/img/1.png" style="display: block; margin: 0 auto;" /></div>
          <div class="swiper-slide"><img src="resources/img/2.png" style="display: block; margin: 0 auto;" /></div>
          <div class="swiper-slide"><img src="resources/img/3.png" style="display: block; margin: 0 auto;" /></div>
          <div class="swiper-slide"><img src="resources/img/4.png" style="display: block; margin: 0 auto;" /></div>
        </div>

        <!-- If we need pagination -->
        <div class="swiper-pagination"></div>
        <!-- If we need navigation buttons -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
        <!-- If we need scrollbar -->
        <div class="swiper-scrollbar"></div>
      </div>
    </div>

    <script>
      // 슬라이더 동작 정의
      const swiper = new Swiper(".swiper", {
        autoplay: {
          delay: 3000, // 3초마다 이미지 변경
        },
        loop: true, //반복 재생 여부
        slidesPerView: 1, // 이전, 이후 사진 미리보기 갯수
        pagination: {
          // 페이징 버튼 클릭 시 이미지 이동 가능
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          // 화살표 버튼 클릭 시 이미지 이동 가능
          prevEl: ".swiper-button-prev",
          nextEl: ".swiper-button-next",
        },
      });
    </script>
    <br>
    <div style="display:flex; justify-content:center;" class="navbar navbar-expand-lg navbar-light bg-light">
      <nav class="navbar">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">전체메뉴</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">치킨메뉴</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#"></a>
              </li>
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  id="navbarDropdown"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  사이드
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">감자튀김</a></li>
                  <li><a class="dropdown-item" href="#">떡볶이</a></li>
                  <li><hr class="dropdown-divider" /></li>
                  <li><a class="dropdown-item" href="#">기타</a></li>
                </ul>
              </li>
            </ul>
          </div>
          <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </nav>
    </div>


    <!-- Section-->
    <section class="py-5">
      <div class="container px-4 px-lg-5 mt-5">
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
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
  </body>
</html>
