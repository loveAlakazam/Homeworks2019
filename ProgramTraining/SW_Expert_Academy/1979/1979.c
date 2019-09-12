# include<stdio.h>
int find_by_row( int N, int (*arr)[15] , int k )
{ // 글자수가 K인 가로문제 개수를 카운트
    int row, col, result=0, cnt;
   	for(row=0; row<N; row++){
        cnt=0; //초기화
        for(col=0; col<N; col++){
            if(arr[row][col]==1)
                cnt++;
            else
            { //arr[row][col]==0
            	if(cnt==k)
                    result+=1;
                cnt=0;
            }        
        }//열끝
        if(cnt==k){
            result+=1;
        }
    }
return result;
}

int find_by_col( int N, int (* arr)[15], int k)
{// 글자수가 K인 세로 문제 개수를 카운트
    int row, col, result=0, cnt;
    for(col=0; col<N; col++){
        cnt=0;
    	for(row=0; row<N; row++){
        	if(arr[row][col]==1)
                cnt++;
            else{ // arr[row][col]==0
                if(cnt==k)
                    result+=1;
               cnt=0;
            }
        }//행끝
        if( cnt==k)
            result+=1;
    }
return result;
}

int main (){
    // 테스트 케이스 입력
    int t,T ;
    scanf("%d", &T);
    for(t=0; t<T; t++){
    	int N, K; scanf("%d %d",&N, &K);
    	int arr[15][15];
    	int result=0;
        int row, col;
    	// 입력하기
    	for(row=0;  row<N; row++)
    		for(col=0; col<N; col++)
        		scanf("%d", &arr[row][col]);
        result= find_by_row(N, arr, K) + find_by_col(N,arr,K);
        printf("#%d %d\n", t+1, result);
    }
}
