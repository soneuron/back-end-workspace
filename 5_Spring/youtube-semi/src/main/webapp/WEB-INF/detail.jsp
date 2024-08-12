<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail.css"/>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
	<main class="detail">
		<div class="video-detail">
			<video src="${video.videoUrl }" controls></video>
			<h2>${video.videoTitle }</h2>
			<div class="video-detail-desc">
				<div class="deail-desc-left">
					<img alt="" src="${video.channel.chennelImg }">
					<div class="channel-desc">
						<h3>${video.channel.channelName }</h3>
						<p>구독자 #{count }명</p>
					</div>
					<c:if test="${empty sub }">
					<button>구독</button>
					</c:if>
					<c:if test="${not empty sub }">
					<button>구독 중</button>
					</c:if>
				</div>
				<c:if test="${empty like }">
				<button id = "like"><i class="fa-regular fa-thumbs-up"></i> 좋아요</button>
				</c:if>
				<c:if test="${not empty like }">
				<button id = "unlike"><i class="fa-regular fa-thumbs-up"></i> 좋아요 취소</button>
				</c:if>
			</div>
			<div class="video-detail-info"></div>
			${video.videoDesc }
		</div>
		<div class="video-list">
			<c:forEach items="${list }" var="video">
				<a href="/${video.videoCode }" class="video-list-card">
					<img src="${video.videoImg }"/>
					<div class="video-list-desc">
						<h4>${video.videoTitle }</h4>
						<p>${video.channel.channelName}</p>
						<p class="video-meta" data-video-date="${video.videoDate}">
							조회수 ${video.videoCount }ㆍ회 <span class="video-date"></span>
						</p>
					</div>
				</a>
			</c:forEach>
		</div>
	</main>
	<script>
		$("#like").click(()=>{
			$.ajax({
				type:"post"
				url:"/like",
				data: {
					code: ${video.videoCode}
				},
				success: function (){
					location.reload();
				},
				error: function(){
					alert("로그인 필요!")
				}
			})
		});

	</script>
	<c:if test="${not empty like }">
	<script>
	$("unlike").click(()=>{
		$.ajax({
			type:"post"
			url: "/unlike",
			data:{
				code: ${like.likeCode}
			},
			success: function(){
				location.reload();
			}
		})
	});
	</script>
	</c:if>
	<script src="${pageContext.request.contextPath }/js/script.js"></script>
</body>
</html>














