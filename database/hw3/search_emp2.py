from flask import Flask, redirect, url_for, request, render_template
import cx_Oracle

app=Flask(__name__)
connection =cx_Oracle.connect('scott/tiger@localhost/orcl')
cursor =connection.cursor()

@app.route('/') #루트디렉토리
def main(): #루트디렉토리에 도달하면, search_emp.html을 보여줌.
    return render_template('search_emp2.html')

#현재 위치가 /search 일때... POST방식으로 데이터를 전송했다면
#results.html 결과를 보여줌.
@app.route('/search', methods=['POST','GET'])
def search():
    if request.method=='POST': #post방식으로 입력 데이터를 서버에 전송한다.
        # name이 keyword인 form태그의  입력한  텍스트데이터를 keyword라는 변수에 저장한다.
        # name이 choice인 form태그에서 선택한 컬럼 데이터를 choice에 저장한다.
        keyword, choice = request.form['keyword'], request.form['choice']
        
        #어떤 radio(원)을 클릭했느냐에 따라서, choice가 달라지며, choice에 따라 수행되는 쿼리문이 달라진다.
        if choice =='empno':#Employee Number 선택
            #:(empno)는 사용자가 입력한 데이터를 넣는 매개변수 같은 것.
            select_query='SELECT * FROM emp WHERE empno=:empno'
            cursor.execute(select_query, empno=keyword)
            
        elif choice=='ename':#Employee Name 선택
            select_query='SELECT * FROM emp WHERE ename=:ename'
            cursor.execute(select_query, ename=keyword)
            
        else:#Department Number 선택     
            select_query='SELECT * FROM emp WHERE deptno=:deptno'
            cursor.execute(select_query, deptno=keyword)

        #results은 조회된 결과에 대한 레코드셋을 의미한다.
        results=cursor.fetchall()
        
        #컬럼들을 리스트로 나타냄
        columns=['EMPNO', 'ENAME', 'DEPTNO']
  
        #검색결과를 테이블로 나타낸 결과와 검색결과 레코드의 개수를 딕셔너리로 묶어서 results2.html 페이지로 전달.
        templateData={ 'results':  results,  'result_len': len(results),  'columns':columns     }
        return render_template('results2.html', **templateData)
            
if __name__ =='__main__':
    app.run(host='0.0.0.0', port=8888, debug=True)
