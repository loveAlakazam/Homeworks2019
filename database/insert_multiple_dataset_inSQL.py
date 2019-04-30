import cx_Oracle
import sys
dataset= open(sys.argv[1], 'r')  #읽기모드로 sys.argv[1]이 가리키는 파일을 오픈
data=dataset.readlines() #줄단위로 데이터를 읽는다.
data_len = len(data) #dataset의 라인수

# 컬럼별로 해당하는 데이터를 지정된 리스트에 저장한다.
date_data,voltage_data, amplitude_data, rms_data= [],[],[],[]

for row in data:
    # data의 한 줄에 속함, 그리고 , 를 구분으로 하나의 리스트에 저장
    fields=row.split(',')
    date_data.append(fields[0])
    voltage_data.append(float(fields[1].replace("\t\n","")))
    amplitude_data.append(float(fields[2].replace("\t\n","")))
    rms_data.append(float(fields[3].replace("\t\n","")))
    
#  oracle db에 접속 
connection= cx_Oracle.connect('scott/tiger@localhost/orcl')
cursor = connection.cursor()

#테이블 생성 명령어
# NUMBER( 숫자길이 , 소수점 아래 개수)
# voltage number(15,7) =  15개의 숫자길이를 가지며, 소수점 이후 7개의 숫자 길이를 갖는다.
cursor.execute('CREATE TABLE my_table( date_info varchar2(40) ,\
                                voltage_info NUMBER(15,7), amplitude_info NUMBER(15,7),\
                                rms_info NUMBER(15,7))' )

sql_insert= 'INSERT INTO my_table VALUES(:date_info, :voltage_info, :amplitude_info, :rms_info)'
#데이터셋에서 얻은 데이터들을 생성된 테이블에  insert into 명령어로  넣는다.
for i in range(data_len):
    cursor.execute(sql_insert,date_info= date_data[i], voltage_info=voltage_data[i],\
                   amplitude_info=amplitude_data[i], rms_info= rms_data[i])
    connection.commit()

print('my_table 테이블에 {}개 레코드 insert 완성'.format(data_len))
cursor.close()
connection.close
