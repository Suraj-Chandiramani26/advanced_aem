const section = document.querySelector('#mysection');
var pagenum = document.getElementById("url").innerHTML;
console.log(pagenum);

let requestURL = 'https://reqres.in/api/users?page='+pagenum;
let request = new XMLHttpRequest();
request.open('GET', requestURL);
request.responseType = 'json';
request.send();

request.onload = function() {
	const users = request.response;
	showUsers(users);
}

function showUsers(obj) {
const users = obj['data'];

for (let i = 0; i < users.length; i++) {

const myArticle = document.createElement('article');
const myH2 = document.createElement('p');
const myPara1 = document.createElement('p');
const myimg = document.createElement('img');

myH2.textContent = users[i].email;
myPara1.textContent = users[i].first_name+ " " + users[i].last_name;
myimg.src = users[i].avatar;

myArticle.className+="cardlist-container column";

myArticle.appendChild(myimg);
myArticle.appendChild(myH2);
myArticle.appendChild(myPara1);




section.appendChild(myArticle);
}
}