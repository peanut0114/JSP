<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>
	<table border='1'>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>비밀번호</th>
			</tr>
		</thead>
		<tbody id="list">
		</tbody>
	</table>
	<!-- Ajax(비동기방식 처리) -->
	<script>
		let i = 0;
		let xhtp = new XMLHttpRequest(); //비동기방식 처리
		xhtp.open('get', 'memberJson.do');
		xhtp.send();
		xhtp.onreadystatechange = callBackThree; //콜백함수 : 나중에 호출 (이벤트 발생시)
		
		//xhtp.open('get', 'memberJson.do');
		let fields = ['id','name','mail','pass'];
		function callBackThree(){
			if(this.readyState==4 && this.status ==200){
				let data = JSON.parse(this.responseText);
				console.log(data);
				let tbody = document.getElementById('list');
				for(let obj of data){
					//tr td,td,td,td
					let tr = document.createElement('tr');
					
					for(let field of fields){	//id,name,mail,pass
						let td = document.createElement('td');
						td.innerText = obj[field];
						tr.append(td);
					}
					tbody.append(tr);
				}
			}
		}
		
		//xhtp.open('get', 'dataList.txt');
		function callBackTwo(){
			if(this.readyState==4 && this.status ==200){
				let data = JSON.parse(this.responseText);
				console.log(data);
				
				let ul = document.createElement('ul');	//<ul></ul>
				for(let obj of data){
					//<li>Hong, 15</li>
					let li = document.createElement('li');
					li.innerHTML = obj.name +', '+obj.age;
					ul.append(li);	//<ul>태그 안에 넣음
				}
				console.log(ul);
				document.querySelector('body').append(ul);
			}
		}
		//xhtp.open('get', 'data.txt');
		function callBackOne(){
			if (this.readyState == 4 && this.status == 200) {
				//JSON -> object 파싱
				let data = JSON.parse(this.responseText);
				//페이지 정보를 읽겠다
				console.log(data);
				//<p>태그로 생성
				let name = document.createElement('p');
				name.innerText = data.name;
				let age = document.createElement('p');
				age.innerText = data.age;
				//body태그를 읽어 하위요소로 붙여넣기
				document.querySelector('body').append(name, age);
			}
		}
	</script>
</body>
</html>