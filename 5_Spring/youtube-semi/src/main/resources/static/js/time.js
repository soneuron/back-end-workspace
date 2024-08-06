<p clas="video-meta" data-video-date="${video.videoDate}">
	조회수 ${video.videoCount}회 ㆍ <span class="video-date"></span>
</p>
	
const videoMeta = document.querySelectorAll('.video-meta');

videoMeta.forEach(meta =>{
	let date = meta.getAttribute("data-video-date");
	date = new Date(date);
	
	const videoDate = meta.querySelector(".video-date");
	videoDate.innerHTML = getTime(date);
});

function getTime(){
	const now = new Date();
	const diff = Math.floor((now - date) / 1000);
	
	const rtf = new Intl.RelativeTimeFormat('ko', { numeric:'auto'});
	
	if(diff < 60) {
		return rtf.format(-diff, 'seconds')
	} else if(diff < 3600) {
		return rtf.format(-Math.floor(diff / 60), 'minutes');
	} else if(diff < 86400) {
		return rtf.format(-Math.floor(diff / 3600), 'hours');
	} else if(diff < 604800) {
		return rtf.format(-Math.floor(diff / 86400), 'days');
	}
}