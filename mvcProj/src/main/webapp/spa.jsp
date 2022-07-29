<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
<link href="${pageContext.request.contextPath }/css/second.css"
	rel="stylesheet">
</head>
<body>
	<div id="container">
		<h3>회원등록</h3>
		<!-- 값을 DB에 저장 후 페이지를 넘어가지 않고 리스트를 띄울것임 : Ajacs 간편-->
		<form name="addFrm" action="addMemberAjax.do" method="post">
			<label>아이디</label><input type="text" name="id" autofocus required><br>
			<label>이름</label><input type="text" name="name" required><br>
			<label>비밀번호</label><input type="password" name="passwd" required><br>
			<label>이메일</label><input type="email" name="mail" required><br>
			<input type="submit" value="저장"><br>
		</form>

		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>비밀번호</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody id="list">
			</tbody>
		</table>
	</div>
	<!-- Ajax(비동기방식 처리) -->
	<script>
		
		let xhtp = new XMLHttpRequest(); //비동기방식 처리
		xhtp.open('get', 'memberJson.do');
		xhtp.send();
		xhtp.onreadystatechange = callBackThree; //콜백함수 : 나중에 호출 (이벤트 발생시)
		
		//출력할 필드를 배열에 지정
		let fields = ['id','name','mail','passwd'];
		
		//리스트 출력
		function callBackThree(){
			if(this.readyState==4 && this.status ==200){
				let data = JSON.parse(this.responseText);
				console.log(data);
				let tbody = document.getElementById('list');
				
				for(let obj of data){
					tr = makeTr(obj);	//함수호출
					tbody.append(tr);
				}
				
				
			}
		}
		
		//데이터 한 건 tr 생성
		function makeTr(obj){
			//tr td,td,td,td
			let tr = document.createElement('tr');
			
			//필드 갯수 반복
			for(let field of fields){	//id,name,mail,pass
				let td = document.createElement('td');
				td.innerText = obj[field];
				tr.append(td);
			}
			//삭제버튼
			let td = document.createElement('td');
			let btn = document.createElement('button');
			btn.innerText = '삭제';
			//클릭이벤트
			btn.addEventListener('click', deleteCallBack);
			td.append(btn);
			tr.append(td);
			return tr;
		}
		
		function deleteCallBack(e){
			console.log(this);	//event의 call함수(이베트 받는 대상)
			
			let delId = this.parentElement.parentElement.firstElementChild.innerText;
			
			let delAjx = new XMLHttpRequest();//send
			delAjx.open('post','removeMemberAjax.do');
			delAjx.setRequestHeader('Content-type','application/x-www-form-urlencoded');//key,value형식
			delAjx.send('id='+delId)
			delAjx.onload = function(){
				let result = JSON.parse(delAjx.responseText);	//넘겨줌
				if(result.retCode == 'Success')
					e.target.parentElement.parentElement.remove();
					//버튼의  	부모:td		 의 부모:tr		제거
				else
					alert('처리 중 에러 발생');
			}
			
			
		}
		
		//form 전송이벤트 실행 (콜백함수 : form 중 이름이 addFrm인 녀석의 submit 이벤트 발생시 실행)
		document.forms.addFrm.onsubmit = function(e){
			
			e.preventDefault();	//이벤트의 기본기능(페이지 전송) 차단
			
			let url = document.forms.addFrm.getAttribute("action");
			let id = document.forms.addFrm.id.value; 	//id의 value속성을 넣음
			let name = document.forms.addFrm.name.value;
			let pass = document.forms.addFrm.passwd.value;
			let mail = document.forms.addFrm.mail.value;
			
			let param = 'id='+id+'&name='+name+'&passwd='+pass+'&mail='+mail;
			console.log(param);
			
			let addAjx = new XMLHttpRequest();//send
			addAjx.open('post',url);//1.post/get
			addAjx.setRequestHeader('Content-type','application/x-www-form-urlencoded');//key,value형식
			addAjx.send(param);	//id=user1&passwd=1234&name=Hong&mail=email@com
			addAjx.onload = function(){
				console.log(addAjx.responseText);
				let data = JSON.parse(addAjx.responseText);	//json -> object
				//tbody태그의 id(list)
				document.getElementById('list').append(makeTr(data));
			}
			document.forms.addFrm.name.value="";
			document.forms.addFrm.id.value="";
			document.forms.addFrm.passwd.value="";
			document.forms.addFrm.mail.value="";
			document.forms.addFrm.id.focus();
		}
		
		
		
		
//====SJON 타입 테스트===========================================================================
		
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
		
	</script>
</body>
</html>