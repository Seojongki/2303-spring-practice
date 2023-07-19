// 등록 버튼 이벤트 기능
var createBtn = document.getElementById('create-btn');

if (createBtn) {
    createBtn.addEventListener('click', evt => {
        fetch('/api/articles', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title1').value,
                content: document.getElementById('content1').value
            })
        }).then(data => {
            alert('등록 완료되었습니다.');
            location.replace('/articles');     // articles로 화면으로 이동
        })
    })
}


// 수정 기능
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title1').value,
                content: document.getElementById('content1').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/viewArticle/${id}`);
            });
    });
}


// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
            });
    });
}



