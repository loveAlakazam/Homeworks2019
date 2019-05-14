#author: https://www.github.com/loveAlakazam
#파일이름: request_insert_emp_data.py
from flask import Flask, redirect, url_for, request, render_template
import sys
import cx_Oracle
#오라클 SQL DBMS에 접속
connection= cx_Oracle.connect('scott/tiger@localhost/orcl')
cursor=connection.cursor() #현재 커서 위치

#현재파일을 플라스크 (웹)서버로 하겠다.
app=Flask(__name__)

#루트 디렉토리(/)에 접속
#루트 디렉토리에 접속하면 main()함수를 실행한다.
@app.route('/')
def main():
    # 루트디렉토리 접속 => enroll_emp.html 웹페이지로 연결.
    return render_template('enroll_emp.html')


#루트디렉토리의 하위디렉토리인 sucess_enroll 으로 접속(/success_enroll)
#success_enroll 에 접속하면 insert_record_completed() 함수를 실행한다.
@app.route('/success')
def  success():
    info='emp테이블에 데이터 등록 성공^^!<br>' 
    #데이터 등록 후 copied_emp테이블을 조회한 결과를 보여준다.
    now_copied_emp=cursor.execute('SELECT * FROM copied_emp')
    for ncs in now_copied_emp:
        info+=(str(ncs)+'<br>')
    cursor.close() #cursor 종료
    connection.close #conection 종료
    return  info


# 루트디렉토리의 하위디렉토리 enroll_emp 에 접속 (/enroll_emp)
# enroll_emp에 접속하면 enroll_data_into_empTable() 함수를 실행한다.
# action의 endpoint는 http://127.0.0.1:7711/enroll_emp 에서 데이터를 처리.
# 서버는 사용자(클라이언트)에서 입력한 데이터를 post방식으로 수신한다..
#데이터베이스에 입력받은 8개의 데이터들을 등록한다.
def insert_record_to_emp(empno_d, ename_d=None, job_d=None, mgr_d=None, \
                             hiredate_d=None, sal_d=None, comm_d=None, deptno_d=None):
    sql_insert='INSERT INTO copied_emp VALUES(:empno, :ename, :job, \
                                                                                            :mgr, :hiredate, :sal, :comm, :deptno)'
    cursor.execute(sql_insert,empno=empno_d, ename=ename_d, job=job_d,\
                                                       mgr=mgr_d , hiredate=hiredate_d , sal=sal_d , comm=comm_d, deptno=deptno_d)
    connection.commit()
    
@app.route('/enroll_emp', methods=['POST'])
def enroll_data_into_empTable():
    # 클라이언트가 서버한테 post방식으로 데이터를 전송한다.
    if request.method=='POST':
        #form에서 입력한  데이터를 post방식으로 저장한다.
        empno=request.form['empno']
        ename=request.form['ename']
        job=request.form['job']
        mgr=request.form['mgr']
        hiredate=request.form['hiredate']
        sal=request.form['sal']
        comm=request.form['comm']
        deptno=request.form['deptno']

        # copied_emp 테이블에 레코드들을  등록한다.
        insert_record_to_emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
        
        # 8개의 필드에 해당하는 데이터를 수신해서 데이터베이스의 emp테이블에
        # 레코드 등록 성공했음을 나타내는 디렉토리인 '/sucess_enroll' 로 이동.
        return redirect(url_for('success'))
    
    else:# 전송 방식이  POST가 아니면 종료한다.
        print('데이터 수신방식이 POST방식이 아닙니다!')
        sys.exit()

        
if __name__=='__main__':
    #플라스크 서버 run
    #포트번호 7711 로 임의 설정.
    app.run(host='0.0.0.0', port=7711, debug=True)
